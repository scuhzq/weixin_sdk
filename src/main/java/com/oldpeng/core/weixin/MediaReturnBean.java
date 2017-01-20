package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dapeng on 2017/1/19.
 */
public class MediaReturnBean implements Serializable {

	private static final long serialVersionUID = -5691460990718977214L;

	private String type;

	@JSONField(name = "media_id")
	private String mediaId;

	@JSONField(name = "created_at")
	private Date createTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
