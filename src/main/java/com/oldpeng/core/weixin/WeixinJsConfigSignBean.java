package com.oldpeng.core.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/20.
 */
public class WeixinJsConfigSignBean extends Bean2Map implements Serializable {

	private static final long serialVersionUID = 4689583877870535312L;

	private String noncestr;

	private String url;

	@XStreamAlias("jsapi_ticket")
	private String jsapiTicket;

	private String timestamp;

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getJsapiTicket() {
		return jsapiTicket;
	}

	public void setJsapiTicket(String jsapiTicket) {
		this.jsapiTicket = jsapiTicket;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
