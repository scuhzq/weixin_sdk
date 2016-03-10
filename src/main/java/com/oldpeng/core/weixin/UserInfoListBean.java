package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by dapeng on 16/3/9.
 */
public class UserInfoListBean {

	@JSONField(name = "user_info_list")
	private List<UserInfoBean> openidInfoList;

	public List<UserInfoBean> getOpenidInfoList() {
		return openidInfoList;
	}

	public void setOpenidInfoList(List<UserInfoBean> openidInfoList) {
		this.openidInfoList = openidInfoList;
	}

}
