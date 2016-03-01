package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by dapeng on 16/1/20.
 */
public class MpJsapiTicket {

	private int errcode;

	private String errmsg;

	private String ticket;

	@JSONField(name = "expires_in")
	private long expires;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public long getExpires() {
		return expires;
	}

	public void setExpires(long expires) {
		this.expires = expires;
	}
}
