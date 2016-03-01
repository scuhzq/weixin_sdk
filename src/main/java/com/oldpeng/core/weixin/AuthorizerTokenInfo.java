package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/21.
 */
public class AuthorizerTokenInfo implements Serializable {

	private static final long serialVersionUID = 1203453210889337429L;

	@JSONField(name = "authorizer_refresh_token")
	private String authorizerRefreshToken;

	@JSONField(name = "expires_in")
	private long expiresIn;

	@JSONField(name = "authorizer_access_token")
	private String authorizerAccessToken;

	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}

	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}

	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}
}
