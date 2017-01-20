package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dapeng on 2017/1/20.
 */
public class MenuInfoBean implements Serializable {

	private static final long serialVersionUID = 4279821638200547799L;

	@JSONField(name = "button")
	private List<MenuButtonBean> buttonList = Lists.newArrayList();

	public List<MenuButtonBean> getButtonList() {
		return buttonList;
	}

	public void setButtonList(List<MenuButtonBean> buttonList) {
		this.buttonList = buttonList;
	}

	public static class MenuButtonBean implements Serializable {

		private static final long serialVersionUID = -7195335541937695543L;

		private String name;

		private String type;

		private String key;

		private String url;

		@JSONField(name = "media_id")
		private String mediaId;

		@JSONField(name = "sub_button")
		private List<MenuButtonBean> subButtonList = Lists.newArrayList();

		public MenuButtonBean(){

		}

		public MenuButtonBean(String name){
			this.name = name;
		}

		public MenuButtonBean(String name, String key){
			this.name = name;
			this.key = key;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		public List<MenuButtonBean> getSubButtonList() {
			return subButtonList;
		}

		public void setSubButtonList(List<MenuButtonBean> subButtonList) {
			this.subButtonList = subButtonList;
		}
	}

	/**
	 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141241&token=&lang=zh_CN">微信文档</a>
	 */
	public enum Type {

		click,

		view,

		scancode_push,

		scancode_waitmsg,

		pic_sysphoto,

		pic_photo_or_album,

		pic_weixin,

		location_select,

		media_id,

		view_limited;

	}
}
