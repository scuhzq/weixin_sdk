package com.oldpeng.core.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dapeng on 16/1/23.
 */
@XStreamAlias("xml")
public class GetRedpackReturnInfo extends Bean2Map implements Serializable {

	private static final long serialVersionUID = -3513123395763771701L;

	@XStreamAlias("return_code")
	private String returnCode;

	@XStreamAlias("return_msg")
	private String returnMsg;

	private String sign;

	@XStreamAlias("result_code")
	private String resultCode;

	@XStreamAlias("err_code")
	private String errCode;

	@XStreamAlias("err_code_des")
	private String errCodeDes;

	@XStreamAlias("mch_billno")
	private String mchBillno;

	private String appid;

	@XStreamAlias("mch_id")
	private String mchId;

	private String openid;

	@XStreamAlias("detail_id")
	private String detailId;

	private String status;

	@XStreamAlias("send_type")
	private String sendType;

	@XStreamAlias("hb_type")
	private String hbType;

	@XStreamAlias("total_num")
	private String totalNum;

	@XStreamAlias("total_amount")
	private String totalAmount;

	private String reason;

	@XStreamAlias("send_time")
	private String sendTime;

	@XStreamAlias("refund_time")
	private String refundTime;

	@XStreamAlias("refund_amount")
	private String refundAmount;

	private String wishing;

	private String remark;

	@XStreamAlias("act_name")
	private String actName;

	private List<Hbinfo> hblist;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getHbType() {
		return hbType;
	}

	public void setHbType(String hbType) {
		this.hbType = hbType;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public List<Hbinfo> getHblist() {
		return hblist;
	}

	public void setHblist(List<Hbinfo> hblist) {
		this.hblist = hblist;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@XStreamAlias("hbinfo")
	public class Hbinfo implements Serializable {

		private static final long serialVersionUID = 2085781162854214302L;

		private String openid;

		private String amount;

		@XStreamAlias("rcv_time")
		private String rceiveTime;

		private String status;

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getRceiveTime() {
			return rceiveTime;
		}

		public void setRceiveTime(String rceiveTime) {
			this.rceiveTime = rceiveTime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
	}
}
