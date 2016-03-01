package com.oldpeng.core.weixin;

import com.oldpeng.core.xstream.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by dapeng on 16/1/20.
 */
@XStreamAlias("xml")
public class PaymentReturnBean {

	@XStreamAlias("return_code")
	@XStreamCDATA
	private String returnCode;

	@XStreamAlias("return_msg")
	@XStreamCDATA
	private String returnMsg;

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

	public enum Code {

		SUCCESS, FAIL;
	}
}
