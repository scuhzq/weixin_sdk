package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dapeng on 16/1/15.
 */
public class AuthorizationInfo implements Serializable {

	private static final long serialVersionUID = -2543350467345459197L;

	@JSONField(name = "authorization_info")
	private Info info;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public class Info implements Serializable {

		private static final long serialVersionUID = -2184505303194319589L;

		@JSONField(name = "authorizer_appid")
		private String authorizerAppid;

		@JSONField(name = "authorizer_access_token")
		private String authorizerAccessToken;

		@JSONField(name = "expires_in")
		private long expires;

		@JSONField(name = "authorizer_refresh_token")
		private String authorizerRefreshToken;

		@JSONField(name = "func_info")
		private List<Map<String, Map<String, Integer>>> funcInfoList = Lists.newArrayList();

		public String getAuthorizerAppid() {
			return authorizerAppid;
		}

		public void setAuthorizerAppid(String authorizerAppid) {
			this.authorizerAppid = authorizerAppid;
		}

		public String getAuthorizerAccessToken() {
			return authorizerAccessToken;
		}

		public void setAuthorizerAccessToken(String authorizerAccessToken) {
			this.authorizerAccessToken = authorizerAccessToken;
		}

		public long getExpires() {
			return expires;
		}

		public void setExpires(long expires) {
			this.expires = expires;
		}

		public String getAuthorizerRefreshToken() {
			return authorizerRefreshToken;
		}

		public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
			this.authorizerRefreshToken = authorizerRefreshToken;
		}

		public List<Map<String, Map<String, Integer>>> getFuncInfoList() {
			return funcInfoList;
		}

		public void setFuncInfoList(List<Map<String, Map<String, Integer>>> funcInfoList) {
			this.funcInfoList = funcInfoList;
		}
	}
}
