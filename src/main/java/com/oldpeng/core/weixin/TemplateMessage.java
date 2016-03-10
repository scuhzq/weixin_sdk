package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by dapeng on 16/1/24.
 */
public class TemplateMessage implements Serializable {

	@JSONField(name = "touser")
	private String toUser;

	@JSONField(name = "template_id")
	private String templateId;

	private String url;

	private Map<String, KeyValue> data = Maps.newHashMap();

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, KeyValue> getData() {
		return data;
	}

	public void setData(Map<String, KeyValue> data) {
		this.data = data;
	}

	public class KeyValue {

		private String value;

		private String color = "#000000";

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
