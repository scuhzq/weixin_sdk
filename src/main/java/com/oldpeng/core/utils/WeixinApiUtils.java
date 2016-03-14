package com.oldpeng.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by dapeng on 16/3/14.
 */
public class WeixinApiUtils {

	private static Logger logger = LoggerFactory.getLogger(WeixinApiUtils.class);

	public static String getSign(Map<String, String> params, String key) {
		try {
			String paramStr = ApiUtils.buildParamStr(params, false, true) + "&key=" + key;
			logger.info("================= weixin callback pay sign: " + paramStr);
			return Md5Utils.md5(paramStr).toUpperCase();
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

	public static String getSignature(Map<String, String> params){
		try {
			String paramStr = ApiUtils.buildParamStr(params, false, true);
			logger.info("------------------------------------weixin js signature: " + paramStr);
			return Sha1Utils.encode(paramStr);
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}
}
