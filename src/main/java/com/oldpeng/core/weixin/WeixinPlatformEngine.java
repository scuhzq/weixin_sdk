package com.oldpeng.core.weixin;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.oldpeng.core.utils.XmlUtils;
import com.oldpeng.core.weixin.aes.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by dapeng on 16/1/12.
 */
//@Component
public class WeixinPlatformEngine {

	private static Logger logger = LoggerFactory.getLogger(WeixinPlatformEngine.class);

//	@Value("${open.weixin.token}")
	private String token;

//	@Value("${open.weixin.aes_key}")
	private String encodingAesKey;

//	@Value("${open.weixin.app.id}")
	private String appId;

//	@Value("${open.weixin.app.secret}")
	private String appSecret;

//	@Value("${open.weixin.login_redirect_uri}")
	private String loginRedirectUri;

//	@Value("${open.weixin.authorize_redirect_uri}")
	private String authorizeRedirectUri;

//	@Value("${pay.weixin.authorize_redirect_uri}")
	private String hostAuthorizeRedirectUri;

	public String getToken() {
		return token;
	}

	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public String getLoginRedirectUri() {
		return loginRedirectUri;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public void setLoginRedirectUri(String loginRedirectUri) {
		this.loginRedirectUri = loginRedirectUri;
	}

	public String getAuthorizeRedirectUri() {
		return authorizeRedirectUri;
	}

	public void setAuthorizeRedirectUri(String authorizeRedirectUri) {
		this.authorizeRedirectUri = authorizeRedirectUri;
	}

	public String getHostAuthorizeRedirectUri() {
		return hostAuthorizeRedirectUri;
	}

	public void setHostAuthorizeRedirectUri(String hostAuthorizeRedirectUri) {
		this.hostAuthorizeRedirectUri = hostAuthorizeRedirectUri;
	}

	public String processPlainText(InputStream inputStream, String timestamp, String nonce, String msgSignature) {
		try {
			String fromXml = IOUtils.toString(inputStream, "UTF-8");
			return processPlainTextFromXml(fromXml, timestamp, nonce, msgSignature);
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return "error";
		}
	}

	public String processPlainTextFromXml(String fromXml, String timestamp, String nonce, String msgSignature) {
		try {
			logger.info("加密数据: " + fromXml);
			logger.info("token: " + token + "\tencodingAesKey: " + encodingAesKey + "\tappId: " + appId);
			logger.info("msgSignature: " + msgSignature + "\ttimestamp: " + timestamp + "\tnonce: " + nonce);
			WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
			String plainText = wxBizMsgCrypt.decryptMsg(msgSignature, timestamp, nonce, fromXml);
			logger.info("解密后明文: " + plainText);
			return plainText;
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return "error";
		}
	}


	public ComponentVerifyTicket processComponentVerifyTicketMessage(InputStream inputStream, String timestamp, String nonce, String msgSignature) {
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		xStream.processAnnotations(ComponentVerifyTicket.class);

		ComponentVerifyTicket ticket = new ComponentVerifyTicket();
		xStream.fromXML(processPlainText(inputStream, timestamp, nonce, msgSignature), ticket);
		return ticket;
	}

	public ComponentAccessToken getComponentAccessToken(String componentVerifyTicket) {
		Map<String, String> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("component_appid", appId);
		requestBodyMap.put("component_appsecret", appSecret);
		requestBodyMap.put("component_verify_ticket", componentVerifyTicket);
		String result = WeixinUtils.post(WeixinUtils.URL_API_COMPONENT_TOKEN, null, requestBodyMap);
		logger.info("--------- component token: " + result);
		return JSONObject.parseObject(result, ComponentAccessToken.class);
	}

	public PreAuthCode getPreAuthCode(String componentAccessToken){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("component_access_token", componentAccessToken);
		Map<String, String> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("component_appid", appId);
		String result = WeixinUtils.post(WeixinUtils.URL_API_PRE_AUTH_CODE, requestParameters, requestBodyMap);
		logger.info("--------- pre auth code: " + result);
		return JSONObject.parseObject(result, PreAuthCode.class);
	}

	public AuthorizationInfo getAuthorizationInfo(String componentAccessToken, String authorizationCode) {
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("component_access_token", componentAccessToken);
		Map<String, String> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("component_appid", appId);
		requestBodyMap.put("authorization_code", authorizationCode);
		String result = WeixinUtils.post(WeixinUtils.URL_API_QUERY_AUTH, requestParameters, requestBodyMap);
		logger.info("-------- authorization info: " + result);
		return JSONObject.parseObject(result, AuthorizationInfo.class);
	}

	public AuthorizerInfo getAuthorizerInfo(String componentAccessToken, String authorizerAppid){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("component_access_token", componentAccessToken);
		Map<String, String> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("component_appid", appId);
		requestBodyMap.put("authorizer_appid", authorizerAppid);
		String result = WeixinUtils.post(WeixinUtils.URL_API_GET_ACCOUNT_INFO, requestParameters, requestBodyMap);
		logger.info("------- authorizer info: " + result);
		return JSONObject.parseObject(result, AuthorizerInfo.class);
	}

	public AuthorizerTokenInfo getAuthorizerToken(String componentAccessToken, String authorizerAppid, String authorizerRefreshToken){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("component_access_token", componentAccessToken);
		Map<String, String> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("authorizer_appid", authorizerAppid);
		requestBodyMap.put("authorizer_refresh_token", authorizerRefreshToken);
		requestBodyMap.put("component_appid", appId);
		String result = WeixinUtils.post(WeixinUtils.URL_API_AUTHORIZER_TOKEN, requestParameters, requestBodyMap);
		logger.info("------------------- authorizer token: " + result);
		return JSONObject.parseObject(result, AuthorizerTokenInfo.class);
	}

	public MpJsapiTicket getMpJsApiTicket(String accessToken){
		Map<String, String> requestParams = Maps.newHashMap();
		requestParams.put("access_token", accessToken);
		requestParams.put("type", "jsapi");
		String result = WeixinUtils.post(WeixinUtils.URL_API_MP_TICKET, requestParams, null);
		logger.info("------- mp ticket: " + result);
		return JSONObject.parseObject(result, MpJsapiTicket.class);
	}

	public String buildAuthorizationUrl(String authorizerAppId, String scope, String state) {
		return buildAuthUrl(authorizerAppId, scope, state, authorizeRedirectUri);
	}

	public String buildHostAuthorizationUrl(String authorizerAppId, String scope, String state) {
		return buildAuthUrl(authorizerAppId, scope, state, hostAuthorizeRedirectUri);
	}

	//使用微信客户端打开以下链接（严格按照以下格式，包括顺序和大小写，并请将参数替换为实际内容）：
	public String buildAuthUrl(String authorizerAppId, String scope, String state, String authorizeRedirectUri) {
		Map<String, String> requestParameters = Maps.newLinkedHashMap();
		requestParameters.put("appid", authorizerAppId);
		requestParameters.put("redirect_uri", authorizeRedirectUri);
		requestParameters.put("response_type", "code");
		requestParameters.put("scope", scope);
		requestParameters.put("state", state);
		requestParameters.put("component_appid", appId);
		return WeixinUtils.buildUrl(WeixinUtils.URL_AUTHORIZE, requestParameters) + "#wechat_redirect";
	}

	public UserAccessToken getUserAccessToken(String authorizerAppId, String code, String componentAccessToken){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("appid", authorizerAppId);
		requestParameters.put("code", code);
		requestParameters.put("grant_type", "authorization_code");
		requestParameters.put("component_appid", appId);
		requestParameters.put("component_access_token", componentAccessToken);
		String result = WeixinUtils.post(WeixinUtils.URL_USER_ACCESS_TOKEN, requestParameters, null);
		logger.info("------- user access token: " + result);
		return JSONObject.parseObject(result, UserAccessToken.class);
	}

	public UserInfoBean getUserInfo(String accessToken, String openid) {
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("openid", openid);
		requestParameters.put("lang", "zh_CN");
		String result = WeixinUtils.post(WeixinUtils.URL_USER_INFO, requestParameters, null);
		logger.info("------- user info: " + result);
		return JSONObject.parseObject(result, UserInfoBean.class);
	}

	public InMessageBean getInMessageBean(String fromXml, String timestamp, String nonce, String msgSignature) throws Exception {
		return XmlUtils.toBean(decryptMessage(fromXml, timestamp, nonce, msgSignature), InMessageBean.class);
	}

	public String decryptMessage(String fromXml, String timestamp, String nonce, String msgSignature) throws Exception {
		logger.info("====== weixin receive message 加密: " + fromXml);
		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
		String xmlContent = wxBizMsgCrypt.decryptMsg(msgSignature, timestamp, nonce, fromXml);
		logger.info("====== weixin receive message 解密: " + xmlContent);
		return xmlContent;
	}

	public String encodeReplyMessage(String fromXml, String timestamp, String nonce) throws Exception {
		logger.info("====== weixin reply message 解密: " + fromXml);
		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
		String xmlContent = wxBizMsgCrypt.encryptMsg(fromXml, timestamp, nonce);
		logger.info("====== weixin reply message 加密: " + xmlContent);
		return xmlContent;
	}

	public String sendKefuTextMessage(String accessToken, String openId, String content){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("touser", openId);
		requestBodyMap.put("msgtype", "text");
		Map<String, String> contentMap = Maps.newHashMap();
		contentMap.put("content", content);
		requestBodyMap.put("text", contentMap);
		return WeixinUtils.postObject(WeixinUtils.URL_SEND_KF_MESSAGE, requestParameters, requestBodyMap);
	}

	public String sendTemplateMessage(String accessToken, TemplateMessage templateMessage){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		return WeixinUtils.postObject(WeixinUtils.URL_API_SEND_TEMPLATE_MESSAGE, requestParameters, templateMessage);
	}
}
