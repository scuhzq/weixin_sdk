package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by dapeng on 2017/1/20.
 */
public class VideoInfoBean {

	@JSONField(name = "media_id")
	private String mediaId;

	@JSONField(name = "thumb_media_id")
	private String thumbMediaId;

	@JSONField(name = "title")
	private String title;

	@JSONField(name = "description")
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
