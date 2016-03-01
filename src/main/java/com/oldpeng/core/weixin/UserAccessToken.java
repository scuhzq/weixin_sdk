package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/15.
 */
public class UserAccessToken implements Serializable {

	private static final long serialVersionUID = 3342979902755084813L;

	@JSONField(name = "access_token")
	private String accessToken;

	@JSONField(name = "expires_in")
	private long expires;

	@JSONField(name = "refresh_token")
	private String refreshToken;

	@JSONField(name = "openid")
	private String openid;

	@JSONField
	private String scope;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
