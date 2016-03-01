package com.oldpeng.core.weixin;

import com.oldpeng.core.utils.UuidUtils;
import com.oldpeng.core.weixin.annotation.FieldExclude;
import com.oldpeng.core.xstream.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/22.
 */
@XStreamAlias("xml")
public class SendRedPackBean extends Bean2Map implements Serializable {

	private static final long serialVersionUID = -668324033801657732L;

	@XStreamAlias("nonce_str")
	@XStreamCDATA
	private String nonceStr = UuidUtils.generate();

	@FieldExclude
	@XStreamCDATA
	private String sign;

	@XStreamAlias("mch_billno")
	@XStreamCDATA
	private String mchBillno;

	@XStreamAlias("mch_id")
	@XStreamCDATA
	private String mchId;

	@XStreamCDATA
	private String wxappid;

	@XStreamAlias("send_name")
	@XStreamCDATA
	private String sendName = "香格里拉";

	@XStreamAlias("re_openid")
	@XStreamCDATA
	private String reOpenid = "ohHlwuKRibAjb03GHgOiPdjptHH4";

	@XStreamAlias("total_amount")
	@XStreamCDATA
	private String totalAmount = "100";

	@XStreamAlias("total_num")
	@XStreamCDATA
	private String totalNum = "1";

	@XStreamAlias("wishing")
	@XStreamCDATA
	private String wishing = "恭喜发财";

	@XStreamAlias("client_ip")
	@XStreamCDATA
	private String clientIp = "210.73.212.120";

	@XStreamAlias("act_name")
	@XStreamCDATA
	private String actName = "积分兑换红包";

	@XStreamCDATA
	private String remark = "分享得积分";

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

	public String getWxappid() {
		return wxappid;
	}

	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getReOpenid() {
		return reOpenid;
	}

	public void setReOpenid(String reOpenid) {
		this.reOpenid = reOpenid;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
