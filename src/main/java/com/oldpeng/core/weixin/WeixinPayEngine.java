package com.oldpeng.core.weixin;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.oldpeng.core.utils.ApiUtils;
import com.oldpeng.core.utils.Md5Utils;
import com.oldpeng.core.utils.Sha1Utils;
import com.oldpeng.core.utils.XmlUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by dapeng on 16/1/19.
 */
//@Component
public class WeixinPayEngine {

	private static Logger logger = LoggerFactory.getLogger(WeixinPayEngine.class);

//	@Value("${pay.weixin.key}")
	private String key;

//	@Value("${pay.weixin.appid}")
	private String appid;

//	@Value("${pay.weixin.app_secret}")
	private String appSecret;

//	@Value("${pay.weixin.mchid}")
	private String appMchid;

//	@Value("${pay.weixin.notify_uri}")
	private String notifyUrl;

//	@Value("${pay.weixin.authorize_redirect_uri}")
	private String authorizeRedirectUri;

//	@Value("${pay.weixin.cert_path}")
	private String certLocalPath;

//	@Value("${pay.weixin.cert_password}")
	private String certPassword;

	public String getAppid() {
		return appid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppMchid() {
		return appMchid;
	}

	public void setAppMchid(String appMchid) {
		this.appMchid = appMchid;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getAuthorizeRedirectUri() {
		return authorizeRedirectUri;
	}

	public void setAuthorizeRedirectUri(String authorizeRedirectUri) {
		this.authorizeRedirectUri = authorizeRedirectUri;
	}

	public String getCertLocalPath() {
		return certLocalPath;
	}

	public void setCertLocalPath(String certLocalPath) {
		this.certLocalPath = certLocalPath;
	}

	public String getCertPassword() {
		return certPassword;
	}

	public void setCertPassword(String certPassword) {
		this.certPassword = certPassword;
	}

	/**
	 * 统一下单接口
	 * @return
	 */
	public PaymentOrderReturnBean getUnifiedOrder(PaymentOrderBean paymentOrderBean, CertInfo certInfo){
		paymentOrderBean.setNotifyUrl(notifyUrl);

		if(certInfo == null){
			paymentOrderBean.setAppid(appid);
			paymentOrderBean.setMchid(appMchid);
			paymentOrderBean.setSign(getSign(paymentOrderBean.retrieveStringProp(), this.key));
		} else {
			paymentOrderBean.setAppid(certInfo.getAppId());
			paymentOrderBean.setMchid(certInfo.getMchId());
			paymentOrderBean.setSign(getSign(paymentOrderBean.retrieveStringProp(), certInfo.getKey()));
		}

		String returnXml = WeixinUtils.postXML(WeixinUtils.URL_PAY_UNIFIEDORDER, paymentOrderBean);

		logger.info("------ unified order : " + returnXml);

		XStream xStream = new XStream(new StaxDriver(new NoNameCoder()));
		xStream.autodetectAnnotations(true);
		xStream.processAnnotations(PaymentOrderReturnBean.class);

		PaymentOrderReturnBean paymentOrderReturnBean = new PaymentOrderReturnBean();
		xStream.fromXML(returnXml, paymentOrderReturnBean);
		return paymentOrderReturnBean;
	}

	public MpAccessToken getAccessToken(){
		Map<String, String> requestParams = Maps.newHashMap();
		requestParams.put("grant_type", "client_credential");
		requestParams.put("appid", appid);
		requestParams.put("secret", appSecret);

		String result = WeixinUtils.post(WeixinUtils.URL_API_MP_ACCESS_TOKEN, requestParams, null);
		logger.info("------- mp access token: " + result);
		return JSONObject.parseObject(result, MpAccessToken.class);
	}

	public String buildAuthorizationUrl(String scope, String state) {
		Map<String, String> requestParameters = Maps.newLinkedHashMap();
		requestParameters.put("appid", appid);
		requestParameters.put("redirect_uri", authorizeRedirectUri);
		requestParameters.put("response_type", "code");
		requestParameters.put("scope", scope);
		requestParameters.put("state", state);
		return WeixinUtils.buildUrl(WeixinUtils.URL_AUTHORIZE, requestParameters) + "#wechat_redirect";
	}

	public UserAccessToken getUserAccessToken(String code) {
		Map<String, String> requestParams = Maps.newHashMap();
		requestParams.put("appid", appid);
		requestParams.put("secret", appSecret);
		requestParams.put("code", code);
		requestParams.put("grant_type", "authorization_code");

		String result = WeixinUtils.post(WeixinUtils.URL_USER_ACCESS_TOKEN, requestParams, null);
		logger.info("------- host user access token: " + result);
		return JSONObject.parseObject(result, UserAccessToken.class);
	}

	public String getSign(Map<String, String> params, String key) {
		try {
			String paramStr = ApiUtils.buildParamStr(params, false, true) + "&key=" + key;
			logger.info("================= weixin callback pay sign: " + paramStr);
			return Md5Utils.md5(paramStr).toUpperCase();
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

	public String getSignature(Map<String, String> params){
		try {
			String paramStr = ApiUtils.buildParamStr(params, false, true);
			logger.info("------------------------------------weixin js signature: " + paramStr);
			return Sha1Utils.encode(paramStr);
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

	/**
	 * @param sendRedPackBean
	 * @return
	 */
	public SendRedPackReturnBean sendRedpack(SendRedPackBean sendRedPackBean, CertInfo certInfo){
		validCertInfo(certInfo);

		String returnXml;
		if(certInfo == null){
			sendRedPackBean.setWxappid(appid);
			sendRedPackBean.setMchId(appMchid);
			sendRedPackBean.setSign(getSign(sendRedPackBean.retrieveStringProp(), key));
			returnXml = WeixinUtils.postSslXML(this.certLocalPath, this.certPassword, WeixinUtils.URL_CASH_SEND_REDPACK, sendRedPackBean);
		} else {
			sendRedPackBean.setWxappid(certInfo.getAppId());
			sendRedPackBean.setMchId(certInfo.getMchId());
			sendRedPackBean.setSign(getSign(sendRedPackBean.retrieveStringProp(), certInfo.getKey()));
			returnXml = WeixinUtils.postSslXML(certInfo.getCertPath(), certInfo.getCertPassword(), WeixinUtils.URL_CASH_SEND_REDPACK, sendRedPackBean);
		}

		logger.info("----------- send redpack: " + returnXml);

		return XmlUtils.toBean(returnXml, SendRedPackReturnBean.class);
	}

	/**
	 * @param getRedpackInfo
	 * @return
	 */
	public GetRedpackReturnInfo getRedpackInfo(GetRedpackInfo getRedpackInfo, CertInfo certInfo){
		validCertInfo(certInfo);

		String returnXml;
		if(certInfo == null){
			getRedpackInfo.setAppid(appid);
			getRedpackInfo.setMchId(appMchid);
			getRedpackInfo.setSign(getSign(getRedpackInfo.retrieveStringProp(), this.key));
			returnXml = WeixinUtils.postSslXML(this.certLocalPath, this.certPassword, WeixinUtils.URL_CASH_GET_REDPACK_INFO, getRedpackInfo);
		} else {
			getRedpackInfo.setAppid(certInfo.getAppId());
			getRedpackInfo.setMchId(certInfo.getMchId());
			getRedpackInfo.setSign(getSign(getRedpackInfo.retrieveStringProp(), certInfo.getKey()));
			returnXml = WeixinUtils.postSslXML(certInfo.getCertPath(), certInfo.getCertPassword(), WeixinUtils.URL_CASH_GET_REDPACK_INFO, getRedpackInfo);
		}

		logger.info("----------- get redpack info: " + returnXml);

		return XmlUtils.toBean(returnXml, GetRedpackReturnInfo.class);
	}

	/**
	 * 使用付款给用户
	 * @param transferBean
	 * @return
	 */
	public TransferReturnBean payToUser(TransferBean transferBean, CertInfo certInfo){
		validCertInfo(certInfo);

		String returnXml;
		if(certInfo == null){
			transferBean.setAppid(appid);
			transferBean.setMchid(appMchid);
			transferBean.setSign(getSign(transferBean.retrieveStringProp(), this.key));
			returnXml = WeixinUtils.postSslXML(this.certLocalPath, this.certPassword, WeixinUtils.URL_CASH_TRANSFER, transferBean);
		} else {
			transferBean.setAppid(certInfo.getAppId());
			transferBean.setMchid(certInfo.getMchId());
			transferBean.setSign(getSign(transferBean.retrieveStringProp(), certInfo.getKey()));
			returnXml = WeixinUtils.postSslXML(certInfo.getCertPath(), certInfo.getCertPassword(), WeixinUtils.URL_CASH_TRANSFER, transferBean);
		}

		logger.info("---------------- pay to user transfer: " + returnXml);

		return XmlUtils.toBean(returnXml, TransferReturnBean.class);
	}

	/**
	 * 使用查看付款情况
	 * @param getTransferInfo
	 * @return
	 */
	public GetTransferReturnInfo getPayResult(GetTransferInfo getTransferInfo, CertInfo certInfo){

		validCertInfo(certInfo);

		String returnXml;
		if(certInfo == null){
			getTransferInfo.setAppid(appid);
			getTransferInfo.setMchid(appMchid);
			getTransferInfo.setSign(getSign(getTransferInfo.retrieveStringProp(), this.key));
			returnXml = WeixinUtils.postSslXML(this.certLocalPath, this.certPassword, WeixinUtils.URL_CASH_GET_TRANSFER_INFO, getTransferInfo);
		} else {
			getTransferInfo.setAppid(certInfo.getAppId());
			getTransferInfo.setMchid(certInfo.getMchId());
			getTransferInfo.setSign(getSign(getTransferInfo.retrieveStringProp(), certInfo.getKey()));
			returnXml = WeixinUtils.postSslXML(certInfo.getCertPath(), certInfo.getCertPassword(), WeixinUtils.URL_CASH_GET_TRANSFER_INFO, getTransferInfo);
		}

		logger.info("--------------- get pay result transfer: " + returnXml);

		return XmlUtils.toBean(returnXml, GetTransferReturnInfo.class);
	}

	private void validCertInfo(CertInfo certInfo){
		if(certInfo != null){
			if(StringUtils.isBlank(certInfo.getAppId()) || StringUtils.isBlank(certInfo.getMchId())
					|| StringUtils.isBlank(certInfo.getCertPath()) || StringUtils.isBlank(certInfo.getCertPassword())
					|| StringUtils.isBlank(certInfo.getKey())){
				throw new RuntimeException("this cert info error");
			}
		}
	}
}