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
@XStreamCDATA
public class TransferBean extends Bean2Map implements Serializable {

	private static final long serialVersionUID = -2889991076981899323L;

	@XStreamAlias("mch_appid")
	private String appid;

	private String mchid;

	@XStreamAlias("device_info")
	private String deviceInfo;

	@XStreamAlias("nonce_str")
	private String nonceStr = UuidUtils.generate();

	@FieldExclude
	private String sign;

	@XStreamAlias("partner_trade_no")
	private String partnerTradeNo;

	private String openid = "ohHlwuKRibAjb03GHgOiPdjptHH4";

	@XStreamAlias("check_name")
	private String checkName = "FORCE_CHECK";

	@XStreamAlias("re_user_name")
	private String realName = "王俊朋";

	private String amount = "100";

	private String desc = "积分兑换";

	@XStreamAlias("spbill_create_ip")
	private String spbillCreateIp = "210.73.212.120";

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}
}
