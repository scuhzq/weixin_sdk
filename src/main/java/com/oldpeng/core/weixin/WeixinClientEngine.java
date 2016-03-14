package com.oldpeng.core.weixin;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by dapeng on 16/3/8.
 */
public class WeixinClientEngine {

	private static Logger logger = LoggerFactory.getLogger(WeixinClientEngine.class);

	private String appid;

	private String appSecret;

	private String authorizeRedirectUri;

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

	public MpAccessToken getAccessToken(){
		Map<String, String> requestParams = Maps.newHashMap();
		requestParams.put("grant_type", "client_credential");
		requestParams.put("appid", appid);
		requestParams.put("secret", appSecret);

		String result = WeixinUtils.post(WeixinUtils.URL_API_MP_ACCESS_TOKEN, requestParams, null);
		logger.info("------- mp access token: " + result);
		return JSONObject.parseObject(result, MpAccessToken.class);
	}

	public MpJsapiTicket getMpJsApiTicket(String accessToken){
		Map<String, String> requestParams = Maps.newHashMap();
		requestParams.put("access_token", accessToken);
		requestParams.put("type", "jsapi");
		String result = WeixinUtils.post(WeixinUtils.URL_API_MP_TICKET, requestParams, null);
		logger.info("------- mp ticket: " + result);
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

	public UserInfoBean getUserInfo(String accessToken, String openid) {
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("openid", openid);
		requestParameters.put("lang", "zh_CN");
		String result = WeixinUtils.post(WeixinUtils.URL_USER_INFO, requestParameters, null);
		logger.info("------- user info: " + result);
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

	public UserInfoListBean batchGetUserInfoList(String accessToken, OpenidListBatchGetBean openidListBatchGetBean){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		String result = WeixinUtils.postObject(WeixinUtils.URL_USER_INFO_BATCHGET, requestParameters, openidListBatchGetBean);
		logger.info("------- user info batchget: " + result);
		return JSONObject.parseObject(result, UserInfoListBean.class);
	}

	public OpenidListBean batchGetOpenidList(String accessToken, String nextOpenid){
		Map<String, String> requestParameters = Maps.newHashMap();
		requestParameters.put("access_token", accessToken);
		requestParameters.put("next_openid", nextOpenid);
		String result = WeixinUtils.postObject(WeixinUtils.URL_OPENID_BATCHGET, requestParameters, null);
		logger.info("----------- openid list batch: " + result);
		return JSONObject.parseObject(result, OpenidListBean.class);
	}
}
