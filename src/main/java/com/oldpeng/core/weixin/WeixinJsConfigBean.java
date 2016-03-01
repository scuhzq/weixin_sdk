package com.oldpeng.core.weixin;

import com.google.common.collect.Lists;
import com.oldpeng.core.utils.UuidUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by dapeng on 16/1/20.
 */
public class WeixinJsConfigBean implements Serializable {

	private static final long serialVersionUID = 472320667411820051L;

	private boolean debug = false;

	private String appId;

	private String timestamp = Long.toString(new Date().getTime() / 1000);

	private String nonceStr = UuidUtils.generate();

	private String signature;

	private List<String> jsApiList = Lists.newArrayList("onMenuShareTimeline", "onMenuShareAppMessage");

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<String> getJsApiList() {
		return jsApiList;
	}

	public void setJsApiList(List<String> jsApiList) {
		this.jsApiList = jsApiList;
	}
}
