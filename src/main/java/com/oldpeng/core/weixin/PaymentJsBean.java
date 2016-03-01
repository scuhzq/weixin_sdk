package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;
import com.oldpeng.core.weixin.annotation.FieldExclude;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dapeng on 16/1/20.
 */
public class PaymentJsBean extends Bean2Map implements Serializable {

	private static final long serialVersionUID = -1934353910376579410L;

	private String appId;

	private String timeStamp;

	private String nonceStr;

	@JSONField(name = "package")
	@XStreamAlias("package")
	private String packagePrepayId;

	private String signType = "MD5";

	@FieldExclude
	private String paySign;

	public PaymentJsBean(){
		timeStamp = Long.toString(new Date().getTime() / 1000);
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPackagePrepayId() {
		return packagePrepayId;
	}

	public void setPackagePrepayId(String packagePrepayId) {
		this.packagePrepayId = packagePrepayId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
}
