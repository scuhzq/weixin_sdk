package com.oldpeng.core.weixin;

/**
 * Created by dapeng on 16/2/5.
 */
public enum WeixinPayServiceType {

	DEFAULT(0),

	SELF(1);

	private int id;

	WeixinPayServiceType(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
