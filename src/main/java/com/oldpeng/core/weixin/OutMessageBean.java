package com.oldpeng.core.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/22.
 */
@XStreamAlias("xml")
public class OutMessageBean implements Serializable {

	private static final long serialVersionUID = 3186165909603962992L;

	@XStreamAlias("ToUserName")
	private String toUserName;

	@XStreamAlias("FromUserName")
	private String fromUserName;

	@XStreamAlias("CreateTime")
	private String createTime;

	@XStreamAlias("MsgType")
	private String msgType;

	@XStreamAlias("Content")
	private String content;

	@XStreamAlias("FuncFlag")
	private String funcFlag;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(String funcFlag) {
		this.funcFlag = funcFlag;
	}
}
