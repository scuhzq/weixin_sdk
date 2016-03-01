package com.oldpeng.core.weixin;

import com.oldpeng.core.utils.UuidUtils;
import com.oldpeng.core.weixin.annotation.FieldExclude;
import com.oldpeng.core.xstream.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/23.
 */
@XStreamAlias("xml")
public class GetRedpackInfo extends Bean2Map implements Serializable {

	private static final long serialVersionUID = 1885537682545904815L;

	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr = UuidUtils.generate();

	@XStreamCDATA
	@FieldExclude
	private String sign;

	@XStreamAlias("mch_billno")
	@XStreamCDATA
	private String mchBillno;

	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;

	@XStreamCDATA
	private String appid;

	@XStreamAlias("bill_type")
	@XStreamCDATA
	private String billType = "MCHT";

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMchBillno() {
		return mchBillno;
	}

	public void setMchBillno(String mchBillno) {
		this.mchBillno = mchBillno;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}
}
