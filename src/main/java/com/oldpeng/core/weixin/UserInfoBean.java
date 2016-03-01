package com.oldpeng.core.weixin;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by dapeng on 16/1/15.
 */
public class UserInfoBean implements Serializable {

	private static final long serialVersionUID = 6907308110622397688L;

	private String openid;

	private String nickname;

	private int sex;

	private String province;

	private String city;

	private String country;

	private String language;

	@JSONField(name = "headimgurl")
	private String headImgUrl;

	private String privilege;

	@JSONField(name = "subscribe_time")
	private long subscribeTimes;

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public long getSubscribeTimes() {
		return subscribeTimes;
	}

	public void setSubscribeTimes(long subscribeTimes) {
		this.subscribeTimes = subscribeTimes;
	}
}
