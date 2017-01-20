package com.oldpeng.core.weixin;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.oldpeng.core.utils.XmlUtils;
import com.oldpeng.core.weixin.aes.WXBizMsgCrypt;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by dapeng on 16/3/8.
 */
public class WeixinClientEngine {

	private static Logger logger = LoggerFactory.getLogger(WeixinClientEngine.class);

	private String appid;

	private String appSecret;

	private String authorizeRedirectUri;

	private String token;

	private String encodingAesKey;

	public String getAppid() {
		return appid;
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

	public String getAuthorizeRedirectUri() {
		return authorizeRedirectUri;
	}

	public void setAuthorizeRedirectUri(String authorizeRedirectUri) {
		this.authorizeRedirectUri = authorizeRedirectUri;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}

	public MpAccessToken getAccessToken(){
		Map<String, String> requestParams = Maps.newHashMap();
		requestParams.put("grant_type", "client_credential");
		requestParams.put("appid", appid);
		requestParams.put("secret", appSecret);

		String result = WeixinUtils.post(WeixinUtils.URL_API_MP_ACCESS_TOKEN, requestParams, null);
		logger.debug("------- mp access token: " + result);
		return JSONObject.parseObject(result, MpAccessToken.class);
	}

	public MpJsapiTicket getMpJsApiTicket(String accessToken){
		Map<String, String> requestParams = Maps.newHashMap();
		requestParams.put("access_token", accessToken);
		requestParams.put("type", "jsapi");
		String result = WeixinUtils.post(WeixinUtils.URL_API_MP_TICKET, requestParams, null);
		logger.debug("------- mp ticket: " + result);
		return JSONObject.parseObject(result, MpJsapiTicket.class);
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

	public UserAccessToken getWebpageUserAccessToken(String code){
		//https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
		Map<String, String> requestParams = Maps.newHashMap();
		requestParams.put("appid", appid);
		requestParams.put("secret", appSecret);
		requestParams.put("code", code);
		requestParams.put("grant_type", "authorization_code");

		String result = WeixinUtils.post(WeixinUtils.URL_WEB_PAGE_USER_ACCESS_TOKEN, requestParams, null);
		logger.debug("------- host user access token: " + result);
		return JSONObject.parseObject(result, UserAccessToken.class);
	}

	public UserInfoBean getUserInfoByWebAuth(String accessToken, String openid) {
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("openid", openid);
		requestParameters.put("lang", "zh_CN");
		String result = WeixinUtils.post(WeixinUtils.URL_USER_INFO_BY_WEB_AUTH, requestParameters, null);
		logger.debug("------- web auth user info: " + result);
		return JSONObject.parseObject(result, UserInfoBean.class);
	}

	//TODO 不确定
	public UserInfoBean getUserInfoByUnionid(String accessToken, String unionid) {
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("unionid", unionid);
		requestParameters.put("lang", "zh_CN");
		String result = WeixinUtils.post(WeixinUtils.URL_USER_INFO, requestParameters, null);
		logger.debug("------- web auth user info: " + result);
		return JSONObject.parseObject(result, UserInfoBean.class);
	}

	public String sendTemplateMessage(String accessToken, TemplateMessage templateMessage){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		return WeixinUtils.postObject(WeixinUtils.URL_API_SEND_TEMPLATE_MESSAGE, requestParameters, templateMessage);
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

	public String sendKefuImageMessage(String accessToken, String openId, String mediaId){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("touser", openId);
		requestBodyMap.put("msgtype", "image");
		Map<String, String> contentMap = Maps.newHashMap();
		contentMap.put("media_id", mediaId);
		requestBodyMap.put("image", contentMap);
		return WeixinUtils.postObject(WeixinUtils.URL_SEND_KF_MESSAGE, requestParameters, requestBodyMap);
	}

	public String sendKefuVoiceMessage(String accessToken, String openId, String mediaId){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("touser", openId);
		requestBodyMap.put("msgtype", "voice");
		Map<String, String> contentMap = Maps.newHashMap();
		contentMap.put("media_id", mediaId);
		requestBodyMap.put("voice", contentMap);
		return WeixinUtils.postObject(WeixinUtils.URL_SEND_KF_MESSAGE, requestParameters, requestBodyMap);
	}

	public String sendKefuMpNewsMessage(String accessToken, String openId, String mediaId){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("touser", openId);
		requestBodyMap.put("msgtype", "mpnews");
		Map<String, String> contentMap = Maps.newHashMap();
		contentMap.put("media_id", mediaId);
		requestBodyMap.put("mpnews", contentMap);
		return WeixinUtils.postObject(WeixinUtils.URL_SEND_KF_MESSAGE, requestParameters, requestBodyMap);
	}

	public String sendKefuMpCardMessage(String accessToken, String openId, String cardId){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("touser", openId);
		requestBodyMap.put("msgtype", "wxcard");
		Map<String, String> contentMap = Maps.newHashMap();
		contentMap.put("card_id", cardId);
		requestBodyMap.put("wxcard", contentMap);
		return WeixinUtils.postObject(WeixinUtils.URL_SEND_KF_MESSAGE, requestParameters, requestBodyMap);
	}

	public String sendKefuVideoMessage(String accessToken, String openId, VideoInfoBean videoInfoBean){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("touser", openId);
		requestBodyMap.put("msgtype", "video");
		requestBodyMap.put("video", videoInfoBean);
		return WeixinUtils.postObject(WeixinUtils.URL_SEND_KF_MESSAGE, requestParameters, requestBodyMap);
	}

	public String sendKefuMusicMessage(String accessToken, String openId, MusicInfoBean musicInfoBean){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("touser", openId);
		requestBodyMap.put("msgtype", "music");
		requestBodyMap.put("music", musicInfoBean);
		return WeixinUtils.postObject(WeixinUtils.URL_SEND_KF_MESSAGE, requestParameters, requestBodyMap);
	}

	public String sendKefuNewsMessage(String accessToken, String openId, List<ArticleInfoBean> articleInfoBeanList){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("touser", openId);
		requestBodyMap.put("msgtype", "news");
		Map<String, Object> newsMap = Maps.newHashMap();
		newsMap.put("articles", articleInfoBeanList);
		requestBodyMap.put("news", newsMap);
		return WeixinUtils.postObject(WeixinUtils.URL_SEND_KF_MESSAGE, requestParameters, requestBodyMap);
	}

	public UserInfoListBean batchGetUserInfoList(String accessToken, OpenidListBatchGetBean openidListBatchGetBean){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		String result = WeixinUtils.postObject(WeixinUtils.URL_USER_INFO_BATCHGET, requestParameters, openidListBatchGetBean);
		logger.debug("------- user info batchget: " + result);
		return JSONObject.parseObject(result, UserInfoListBean.class);
	}

	public UserInfoBean getUserInfo(String accessToken, String openid){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("openid", openid);
		requestParameters.put("lang", "zh_CN");
		String result = WeixinUtils.postObject(WeixinUtils.URL_USER_INFO, requestParameters, null);
		logger.debug("------- user info get: " + result);
		return JSONObject.parseObject(result, UserInfoBean.class);
	}

	public OpenidListBean batchGetOpenidList(String accessToken, String nextOpenid){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("next_openid", nextOpenid);
		String result = WeixinUtils.postObject(WeixinUtils.URL_OPENID_BATCHGET, requestParameters, null);
		logger.debug("----------- openid list batch: " + result);
		return JSONObject.parseObject(result, OpenidListBean.class);
	}

	public ShortUrlReturnBean generateShorturl(String accessToken, String longUrl){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		Map<String, Object> requestBodyMap = Maps.newHashMap();
		requestBodyMap.put("long_url", longUrl);
		requestBodyMap.put("action", "long2short");
		String result = WeixinUtils.postObject(WeixinUtils.URL_SHORTURL, requestParameters, requestBodyMap);
		logger.debug("----------- long 2 short url: " + result);
		return JSONObject.parseObject(result, ShortUrlReturnBean.class);
	}

	/**
	 * 上传临时素材
	 * @param accessToken
	 * @param type
	 * @param mediaFile
	 * @return
	 */
	public MediaReturnBean uploadMedia(String accessToken, String type, File mediaFile){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("type", type);

		String result = WeixinUtils.uploadFile(WeixinUtils.URL_MEDIA_UPLOAD, requestParameters, "media", mediaFile);
		logger.debug("----------- upload file: " + result);
		return JSONObject.parseObject(result, MediaReturnBean.class);
	}

	/**
	 * 获取临时素材的url
	 * @param accessToken
	 * @param mediaId
	 * @return
	 */
	public String getMediaUrl(String accessToken, String mediaId){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("media_id", mediaId);
		return WeixinUtils.buildUrl(WeixinUtils.URL_MEDIA_GET, requestParameters);
	}

	/**
	 * 创建菜单
	 * @param accessToken
	 * @param menuInfoBean
	 * @return
	 */
	public String createMenu(String accessToken, MenuInfoBean menuInfoBean){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		String result = WeixinUtils.postObject(WeixinUtils.URL_MENU_CREATE, requestParameters, menuInfoBean);
		logger.debug("----------- menu create: " + result);
		return result;
	}

	/**
	 * 获取菜单信息
	 * @param accessToken
	 * @return
	 */
	public MenuReturnInfoBean getMenu(String accessToken){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		String result = WeixinUtils.getMethod(WeixinUtils.URL_MENU_GET, requestParameters);
		logger.debug("----------- menu get: " + result);
		return JSONObject.parseObject(result, MenuReturnInfoBean.class);
	}

	public String processPlainText(InputStream inputStream, String timestamp, String nonce, String msgSignature) {
		try {
			String fromXml = IOUtils.toString(inputStream, "UTF-8");
			return processPlainTextFromXml(fromXml, timestamp, nonce, msgSignature);
		} catch(Throwable t){
			logger.error(t.getMessage(), t);
			return "error";
		}
	}

	public String processPlainTextFromXml(String fromXml, String timestamp, String nonce, String msgSignature) {
		try {
			logger.debug("加密数据: " + fromXml);
			logger.debug("token: " + token + "\tencodingAesKey: " + encodingAesKey + "\tappId: " + appid);
			logger.debug("msgSignature: " + msgSignature + "\ttimestamp: " + timestamp + "\tnonce: " + nonce);
			WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appid);
			String plainText = wxBizMsgCrypt.decryptMsg(msgSignature, timestamp, nonce, fromXml);
			logger.debug("解密后明文: " + plainText);
			return plainText;
		} catch(Throwable t){
			logger.error(t.getMessage(), t);
			return "error";
		}
	}

	public InMessageBean getInMessageBean(String fromXml, String timestamp, String nonce, String msgSignature) throws Exception {
		return XmlUtils.toBean(decryptMessage(fromXml, timestamp, nonce, msgSignature), InMessageBean.class);
	}

	public String decryptMessage(String fromXml, String timestamp, String nonce, String msgSignature) throws Exception {
		logger.debug("====== weixin receive message 加密: " + fromXml);
		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appid);
		String xmlContent = wxBizMsgCrypt.decryptMsg(msgSignature, timestamp, nonce, fromXml);
		logger.debug("====== weixin receive message 解密: " + xmlContent);
		return xmlContent;
	}

	public String encodeReplyMessage(String fromXml, String timestamp, String nonce) throws Exception {
		logger.debug("====== weixin reply message 解密: " + fromXml);
		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appid);
		String xmlContent = wxBizMsgCrypt.encryptMsg(fromXml, timestamp, nonce);
		logger.debug("====== weixin reply message 加密: " + xmlContent);
		return xmlContent;
	}
}
