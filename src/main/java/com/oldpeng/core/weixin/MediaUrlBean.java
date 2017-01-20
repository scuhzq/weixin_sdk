package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by dapeng on 2017/1/19.
 */
public class MediaUrlBean {

	@JSONField(name = "video_url")
	private String videoUrl;

	@JSONField(name = "image_url")
	private String imageUrl;

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
