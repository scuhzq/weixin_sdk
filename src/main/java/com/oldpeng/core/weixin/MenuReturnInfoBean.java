package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by dapeng on 2017/1/20.
 */
public class MenuReturnInfoBean {

	@JSONField(name = "menu")
	private MenuInfoBean menuInfoBean;

	public MenuInfoBean getMenuInfoBean() {
		return menuInfoBean;
	}

	public void setMenuInfoBean(MenuInfoBean menuInfoBean) {
		this.menuInfoBean = menuInfoBean;
	}
}
