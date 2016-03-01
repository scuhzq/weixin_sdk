package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by dapeng on 16/1/14.
 */
@XStreamAlias("xml")
public class PreAuthCode {

	@XStreamAlias("pre_auth_code")
	@JSONField(name = "pre_auth_code")
	private String preAuthCode;

	@XStreamAlias("expires_in")
	@JSONField(name = "expires_in")
	private long expires;

	public String getPreAuthCode() {
		return preAuthCode;
	}

	public void setPreAuthCode(String preAuthCode) {
		this.preAuthCode = preAuthCode;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}
}
