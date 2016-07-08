package com.oldpeng.core.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/22.
 */
@XStreamAlias("xml")
public class InMessageBean implements Serializable {

	private static final long serialVersionUID = 6281519038912914605L;

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

	@XStreamAlias("MsgId")
	private String msgId;

	@XStreamAlias("Event")
	private String event;

	@XStreamAlias("Latitude")
	private String latitude;

	@XStreamAlias("Longitude")
	private String longitude;

	@XStreamAlias("Precision")
	private String precision;

	@XStreamAlias("MediaId")
	private String mediaId;

	@XStreamAlias("PicUrl")
	private String picUrl;

	@XStreamAlias("EventKey")
	private String eventKey;

	@XStreamAlias("Ticket")
	private String ticket;

	@XStreamAlias("Format")
	private String format;

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

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
