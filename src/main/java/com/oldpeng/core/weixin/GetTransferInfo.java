package com.oldpeng.core.weixin;

import com.oldpeng.core.utils.UuidUtils;
import com.oldpeng.core.weixin.annotation.FieldExclude;
import com.oldpeng.core.xstream.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/24.
 */
@XStreamAlias("xml")
@XStreamCDATA
public class GetTransferInfo extends Bean2Map implements Serializable {

	private static final long serialVersionUID = -2346929202151076439L;

	@XStreamAlias("nonce_str")
	private String nonceStr = UuidUtils.generate();

	@FieldExclude
	private String sign;

	@XStreamAlias("partner_trade_no")
	private String partnerTradeNo;

	@XStreamAlias("mch_id")
	private String mchid;

	private String appid;

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

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
}
