package com.oldpeng.core.alipay;

import com.oldpeng.core.weixin.Bean2Map;
import com.oldpeng.core.weixin.annotation.FieldExclude;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/8/18.
 */
public class AlipayPaymentBean extends Bean2Map implements Serializable {

	private static final long serialVersionUID = 7243265441907496410L;

	private String service = "create_direct_pay_by_user";

	private String partner;

	@XStreamAlias("_input_charset")
	private String inputCharset = "UTF-8";

	@XStreamAlias("sign_type")
	@FieldExclude
	private String signType = "MD5";

	@FieldExclude
	private String sign;

	@XStreamAlias("notify_url")
	private String notifyUrl;

	@XStreamAlias("return_url")
	private String returnUrl;

	@XStreamAlias("out_trade_no")
	private String outTradeNo;

	private String subject;

	@XStreamAlias("payment_type")
	private Integer paymentType;

	@XStreamAlias("total_fee")
	private double totalFee = 0;

	@XStreamAlias("seller_id")
	private String sellerId;

	@XStreamAlias("seller_email")
	private String sellerEmail;

	@XStreamAlias("seller_account_name")
	private String sellerAccountName;

	@XStreamAlias("buyer_id")
	private String buyerId;

	@XStreamAlias("buyer_email")
	private String buyerEmail;

	@XStreamAlias("buyer_account_name")
	private String buyerAccountName;

	private Double price;

	private Integer quantity;

	private String body;

	@XStreamAlias("show_url")
	private String showUrl;

	private String paymethod;

	@XStreamAlias("enable_paymethod")
	private String enablePaymethod;

	@XStreamAlias("anti_phishing_key")
	private String antiPhishingKey;

	@XStreamAlias("exter_invoke_ip")
	private String exterInvokeIp;

	@XStreamAlias("extra_common_param")
	private String extraCommonParam;

	@XStreamAlias("it_b_pay")
	private String itBPay;

	private String token;

	@XStreamAlias("qr_pay_mode")
	private String qrPayMode;

	@XStreamAlias("qrcode_width")
	private Integer qrcodeWidth;

	@XStreamAlias("need_buyer_realnamed")
	private String needBuyerRealnamed;

	@XStreamAlias("hb_fq_param")
	private String hbFqParam;

	@XStreamAlias("goods_type")
	private String goodsType;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getInputCharset() {
		return inputCharset;
	}

	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
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

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
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

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerAccountName() {
		return sellerAccountName;
	}

	public void setSellerAccountName(String sellerAccountName) {
		this.sellerAccountName = sellerAccountName;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerAccountName() {
		return buyerAccountName;
	}

	public void setBuyerAccountName(String buyerAccountName) {
		this.buyerAccountName = buyerAccountName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getShowUrl() {
		return showUrl;
	}

	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getEnablePaymethod() {
		return enablePaymethod;
	}

	public void setEnablePaymethod(String enablePaymethod) {
		this.enablePaymethod = enablePaymethod;
	}

	public String getAntiPhishingKey() {
		return antiPhishingKey;
	}

	public void setAntiPhishingKey(String antiPhishingKey) {
		this.antiPhishingKey = antiPhishingKey;
	}

	public String getExterInvokeIp() {
		return exterInvokeIp;
	}

	public void setExterInvokeIp(String exterInvokeIp) {
		this.exterInvokeIp = exterInvokeIp;
	}

	public String getExtraCommonParam() {
		return extraCommonParam;
	}

	public void setExtraCommonParam(String extraCommonParam) {
		this.extraCommonParam = extraCommonParam;
	}

	public String getItBPay() {
		return itBPay;
	}

	public void setItBPay(String itBPay) {
		this.itBPay = itBPay;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getQrPayMode() {
		return qrPayMode;
	}

	public void setQrPayMode(String qrPayMode) {
		this.qrPayMode = qrPayMode;
	}

	public Integer getQrcodeWidth() {
		return qrcodeWidth;
	}

	public void setQrcodeWidth(Integer qrcodeWidth) {
		this.qrcodeWidth = qrcodeWidth;
	}

	public String getNeedBuyerRealnamed() {
		return needBuyerRealnamed;
	}

	public void setNeedBuyerRealnamed(String needBuyerRealnamed) {
		this.needBuyerRealnamed = needBuyerRealnamed;
	}

	public String getHbFqParam() {
		return hbFqParam;
	}

	public void setHbFqParam(String hbFqParam) {
		this.hbFqParam = hbFqParam;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
}
