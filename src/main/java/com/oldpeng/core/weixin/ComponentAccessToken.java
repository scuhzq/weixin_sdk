package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by dapeng on 16/1/15.
 */
public class ComponentAccessToken {

	@JSONField(name = "component_access_token")
	private String componentAccessToken;

	@JSONField(name = "expires_in")
	private long expires;

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}

	public String getComponentAccessToken() {
		return componentAccessToken;
	}

	public void setComponentAccessToken(String componentAccessToken) {
		this.componentAccessToken = componentAccessToken;
	}
}
