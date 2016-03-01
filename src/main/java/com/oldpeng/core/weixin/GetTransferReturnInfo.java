package com.oldpeng.core.weixin;

import com.oldpeng.core.xstream.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/24.
 */
@XStreamAlias("xml")
@XStreamCDATA
public class GetTransferReturnInfo extends Bean2Map implements Serializable {

	private static final long serialVersionUID = 5952955309974067833L;

	@XStreamAlias("return_code")
	private String returnCode;

	@XStreamAlias("return_msg")
	private String returnMsg;

	@XStreamAlias("result_code")
	private String resultCode;

	@XStreamAlias("err_code")
	private String errCode;

	@XStreamAlias("err_code_des")
	private String errCodeDes;

	@XStreamAlias("partner_trade_no")
	private String partnerTradeNo;

	@XStreamAlias("mch_id")
	private String mchid;

	@XStreamAlias("detail_id")
	private String detailId;

	private String status;

	private String reason;

	private String openid;

	@XStreamAlias("transfer_name")
	private String transferName;

	@XStreamAlias("payment_amount")
	private String paymentAmount;

	@XStreamAlias("transfer_time")
	private String transferTime;

	private String desc;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
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

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTransferName() {
		return transferName;
	}

	public void setTransferName(String transferName) {
		this.transferName = transferName;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(String transferTime) {
		this.transferTime = transferTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
