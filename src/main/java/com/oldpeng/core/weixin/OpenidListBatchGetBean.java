package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by dapeng on 16/3/10.
 */
public class OpenidListBatchGetBean {

	@JSONField(name = "user_list")
	private List<OpenidInfo> userList;

	public List<OpenidInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<OpenidInfo> userList) {
		this.userList = userList;
	}

	public class OpenidInfo {

		private String openid;

		private String lang = "zh_CN";

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getLang() {
			return lang;
		}

		public void setLang(String lang) {
			this.lang = lang;
		}
	}
}
