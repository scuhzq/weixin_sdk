package com.oldpeng.core.weixin;

/**
 * 发红包/公众号转账相关的信息
 * Created by dapeng on 16/2/5.
 */
public class CertInfo {

	private String certPath;

	private String certPassword;

	private String key;

	private String appId;

	private String mchId;

	public String getCertPath() {
		return certPath;
	}

	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}

	public String getCertPassword() {
		return certPassword;
	}

	public void setCertPassword(String certPassword) {
		this.certPassword = certPassword;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
}
