package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by dapeng on 7/20/16.
 */
public class ShortUrlReturnBean implements Serializable {

	private static final long serialVersionUID = 2687845306581486431L;

	private Integer errcode;

	private String errmsg;

	@JSONField(name = "short_url")
	private String shortUrl;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
