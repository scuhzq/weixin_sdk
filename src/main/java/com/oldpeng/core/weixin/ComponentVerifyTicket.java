package com.oldpeng.core.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/14.
 */
@XStreamAlias("xml")
public class ComponentVerifyTicket implements Serializable {

	@XStreamAlias("AppId")
	private String appId;

	@XStreamAlias("CreateTime")
	private long createTimestamps;

	@XStreamAlias("InfoType")
	private String infoType;

	@XStreamAlias("ComponentVerifyTicket")
	private String componentVerifyTicket;

	@XStreamAlias("AuthorizerAppid")
	private String authorizerAppid;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public long getCreateTimestamps() {
		return createTimestamps;
	}

	public void setCreateTimestamps(long createTimestamps) {
		this.createTimestamps = createTimestamps;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}

	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
	}

	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

	public enum InfoType {

		TICKET("component_verify_ticket"),

		UNAUTHORIZED("unauthorized");

		private String value;

		InfoType(String value){
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}
