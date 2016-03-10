package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by dapeng on 16/3/10.
 */
public class OpenidListBean {

	private long total;

	private long count;

	private OpenidList data;

	@JSONField(name = "next_openid")
	private String nextOpenid;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public OpenidList getData() {
		return data;
	}

	public void setData(OpenidList data) {
		this.data = data;
	}

	public String getNextOpenid() {
		return nextOpenid;
	}

	public void setNextOpenid(String nextOpenid) {
		this.nextOpenid = nextOpenid;
	}

	public class OpenidList {

		private List<String> openid;

		public List<String> getOpenid() {
			return openid;
		}

		public void setOpenid(List<String> openid) {
			this.openid = openid;
		}
	}
}
