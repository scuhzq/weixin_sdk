package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by dapeng on 16/1/20.
 */
public class MpAccessToken {

	@JSONField(name = "access_token")
	private String accessToken;

	@JSONField(name = "expires_in")
	private long expires;

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
}
