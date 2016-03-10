package com.oldpeng.core.weixin;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by dapeng on 16/3/9.
 */
public class WeixinLoginEngine {

	private String appid;

	private String appSecret;

	private String redirectUri;

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

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String buildLoginUrl(String state){
		Map<String, String> requestParameters = Maps.newLinkedHashMap();
		requestParameters.put("appid", appid);
		requestParameters.put("redirect_uri", redirectUri);
		requestParameters.put("response_type", "code");
		requestParameters.put("scope", "snsapi_login,snsapi_base");
		requestParameters.put("state", state);
		return WeixinUtils.buildUrl(WeixinUtils.URL_LOGIN_AUTHORIZE, requestParameters) + "#wechat_redirect";
	}

	public LoginAccessTokenBean getAccessToken(String code){
		Map<String, String> requestParameters = Maps.newLinkedHashMap();
		requestParameters.put("appid", appid);
		requestParameters.put("secret", appSecret);
		requestParameters.put("code", code);
		requestParameters.put("grant_type", "authorization_code");
		return JSONObject.parseObject(WeixinUtils.post(WeixinUtils.URL_LOGIN_ACCESS_TOKEN, requestParameters, null), LoginAccessTokenBean.class);
	}


}
