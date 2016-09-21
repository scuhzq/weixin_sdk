package com.oldpeng.core.alipay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/8/18.
 */
public class AlipayPayNotifyBean implements Serializable {

	private static final long serialVersionUID = 6507853074345356504L;

	@XStreamAlias("notify_time")
	private String notifyTime;

	@XStreamAlias("notify_type")
	private String notifyType;

	@XStreamAlias("notify_id")
	private String notifyId;

	@XStreamAlias("sign_type")
	private String signType;

	private String sign;

	@XStreamAlias("out_trade_no")
	private String outTradeNo;

	private String subject;

	@XStreamAlias("payment_type")
	private Integer paymentType;

	@XStreamAlias("trade_no")
	private String tradeNo;

	@XStreamAlias("trade_status")
	private String tradeStatus;

	@XStreamAlias("gmt_create")
	private String gmtCreate;

	@XStreamAlias("gmt_payment")
	private String gmtPayment;

	@XStreamAlias("gmt_close")
	private String gmtClose;

	@XStreamAlias("refund_status")
	private String refundStatus;

	@XStreamAlias("gmt_refund")
	private String gmtRefund;

	@XStreamAlias("seller_email")
	private String sellerEmail;

	@XStreamAlias("buyer_email")
	private String buyerEmail;

	@XStreamAlias("seller_id")
	private String sellerId;

	@XStreamAlias("buyer_id")
	private String buyerId;

	private Double price;

	@XStreamAlias("total_fee")
	private Double totalFee;

	private Integer quantity;

	private String body;

	private Double discount;

	@XStreamAlias("is_total_fee_adjust")
	private String isTotalFeeAdjust;

	@XStreamAlias("use_coupon")
	private String useCoupon;

	@XStreamAlias("extra_common_param")
	private String extraCommonParam;

	@XStreamAlias("business_scene")
	private String businessScene;

	public String getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(String notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getGmtPayment() {
		return gmtPayment;
	}

	public void setGmtPayment(String gmtPayment) {
		this.gmtPayment = gmtPayment;
	}

	public String getGmtClose() {
		return gmtClose;
	}

	public void setGmtClose(String gmtClose) {
		this.gmtClose = gmtClose;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getGmtRefund() {
		return gmtRefund;
	}

	public void setGmtRefund(String gmtRefund) {
		this.gmtRefund = gmtRefund;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getIsTotalFeeAdjust() {
		return isTotalFeeAdjust;
	}

	public void setIsTotalFeeAdjust(String isTotalFeeAdjust) {
		this.isTotalFeeAdjust = isTotalFeeAdjust;
	}

	public String getUseCoupon() {
		return useCoupon;
	}

	public void setUseCoupon(String useCoupon) {
		this.useCoupon = useCoupon;
	}

	public String getExtraCommonParam() {
		return extraCommonParam;
	}

	public void setExtraCommonParam(String extraCommonParam) {
		this.extraCommonParam = extraCommonParam;
	}

	public String getBusinessScene() {
		return businessScene;
	}

	public void setBusinessScene(String businessScene) {
		this.businessScene = businessScene;
	}
}
