package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dapeng on 16/1/15.
 */
public class AuthorizerInfo implements Serializable {

	private static final long serialVersionUID = 2319142769716917555L;

	@JSONField(name = "authorizer_info")
	private Info info;

	@JSONField(name = "authorization_info")
	private AuthInfo authInfo;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public AuthInfo getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}

	public class Info implements Serializable {

		private static final long serialVersionUID = -8801014467496760299L;

		@JSONField(name = "nick_name")
		private String nickname;

		@JSONField(name = "head_img")
		private String headImgUrl;

		@JSONField(name = "service_type_info")
		private Map<String, Integer> serviceTypeInfo;

		@JSONField(name = "verify_type_info")
		private Map<String, Integer> verifyTypeInfo;

		@JSONField(name = "user_name")
		private String username;

		@JSONField(name = "business_info")
		private String businessInfo;

		@JSONField(name = "alias")
		private String alias;

		@JSONField(name = "qrcode_url")
		private String qrcodeUrl;

		public String getQrcodeUrl() {
			return qrcodeUrl;
		}

		public void setQrcodeUrl(String qrcodeUrl) {
			this.qrcodeUrl = qrcodeUrl;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getHeadImgUrl() {
			return headImgUrl;
		}

		public void setHeadImgUrl(String headImgUrl) {
			this.headImgUrl = headImgUrl;
		}

		public Map<String, Integer> getServiceTypeInfo() {
			return serviceTypeInfo;
		}

		public void setServiceTypeInfo(Map<String, Integer> serviceTypeInfo) {
			this.serviceTypeInfo = serviceTypeInfo;
		}

		public Map<String, Integer> getVerifyTypeInfo() {
			return verifyTypeInfo;
		}

		public void setVerifyTypeInfo(Map<String, Integer> verifyTypeInfo) {
			this.verifyTypeInfo = verifyTypeInfo;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getBusinessInfo() {
			return businessInfo;
		}

		public void setBusinessInfo(String businessInfo) {
			this.businessInfo = businessInfo;
		}

		public String getAlias() {
			return alias;
		}

		public void setAlias(String alias) {
			this.alias = alias;
		}
	}

	public class AuthInfo implements Serializable {

		private static final long serialVersionUID = 2581414241398249413L;

		@JSONField(name = "appid")
		private String appid;

		@JSONField(name = "func_info")
		private List<Map<String, Map<String, Integer>>> funcInfoList = Lists.newArrayList();

		public String getAppid() {
			return appid;
		}

		public void setAppid(String appid) {
			this.appid = appid;
		}

		public List<Map<String, Map<String, Integer>>> getFuncInfoList() {
			return funcInfoList;
		}

		public void setFuncInfoList(List<Map<String, Map<String, Integer>>> funcInfoList) {
			this.funcInfoList = funcInfoList;
		}
	}
}
