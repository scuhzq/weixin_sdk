package com.oldpeng.core.weixin;

import com.alibaba.fastjson.JSONObject;
import com.oldpeng.core.utils.ApiUtils;
import com.oldpeng.core.utils.HttpsRequest;
import com.oldpeng.core.utils.XmlUtils;
import com.squareup.okhttp.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by dapeng on 16/1/14.
 */
public class WeixinUtils {

	private static Logger logger = LoggerFactory.getLogger(WeixinUtils.class);

	public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("application/json; charset=utf-8");

	public static final MediaType MEDIA_TYPE_XML = MediaType.parse("text/xml; charset=utf-8");

	public static final okhttp3.MediaType MEDIA_OKHTTP3_TYPE_XML = okhttp3.MediaType.parse("text/xml; charset=utf-8");

	public static final String URL_API_COMPONENT_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";

	public static final String URL_API_PRE_AUTH_CODE = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode";

	public static final String URL_API_QUERY_AUTH = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth";

	public static final String URL_API_GET_ACCOUNT_INFO = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info";

	public static final String URL_AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize";

	public static final String URL_USER_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/component/access_token";

	public static final String URL_USER_INFO = "https://api.weixin.qq.com/sns/userinfo";

	public static final String URL_PAY_UNIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static final String URL_API_MP_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

	public static final String URL_API_MP_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

	public static final String URL_API_AUTHORIZER_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token";

	public static final String URL_API_SEND_TEMPLATE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/template/send";

	public static final String URL_SEND_KF_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

	public static final String URL_CASH_SEND_REDPACK = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

	public static final String URL_CASH_GET_REDPACK_INFO = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";

	public static final String URL_CASH_TRANSFER = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

	public static final String URL_CASH_GET_TRANSFER_INFO = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";

	public static final String URL_USER_INFO_BATCHGET = "https://api.weixin.qq.com/cgi-bin/user/info/batchget";

	public static final String URL_OPENID_BATCHGET = "https://api.weixin.qq.com/cgi-bin/user/get";

	public static final String URL_LOGIN_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";

	public static final String URL_LOGIN_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

	public static final String SCOPE_BASE = "snsapi_base";

	public static final String SCOPE_USER_INFO = "snsapi_userinfo";

	public static final String MSG_TEXT = "text";

	private static final OkHttpClient client = new OkHttpClient();

	public static String post(String baseUrl, Map<String, String> requestParameters, Map<String, String> requestBodyMap){
		return postMethod(baseUrl, requestParameters, JSONObject.toJSONString(requestBodyMap));
	}

	public static String postObject(String url, Map<String, String> requestParameters, Map<String, Object> requestBodyMap){
		return postMethod(url, requestParameters, JSONObject.toJSONString(requestBodyMap));
	}

	public static String postObject(String url, Map<String, String> requestParameters, Object object){
		return postMethod(url, requestParameters, JSONObject.toJSONString(object));
	}

	public static String postMethod(String baseUrl, Map<String, String> requestParameters, String requestBodyJson){
		try {
			String httpUrl = buildUrl(baseUrl, requestParameters);

			logger.info("");
			logger.info("okhttp url: " + httpUrl);
			logger.info("okhttp body: " + requestBodyJson);
			logger.info("");

			Request request = new Request.Builder()
					.url(httpUrl)
					.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, requestBodyJson))
					.build();

			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				return null;
			}

			return response.body().string();
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

	public static String buildUrl(String baseUrl, Map<String, String> requestParameters) {
		try {
			String httpUrl = baseUrl;
			String paramStr = ApiUtils.buildParamStr(requestParameters, true, false);
			if(StringUtils.isNotBlank(paramStr)){
				httpUrl += "?" + paramStr;
			}
			return httpUrl;
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

	public static String postXML(String baseUrl, Object content){
		try {
			String contentXml = XmlUtils.toXml(content);

			logger.info("");
			logger.info("okhttp xml url: " + baseUrl);
			logger.info("okhttp xml body: " + contentXml);
			logger.info("");

			Request request = new Request.Builder()
					.url(baseUrl)
					.post(RequestBody.create(MEDIA_TYPE_XML, contentXml))
					.build();

			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				return null;
			}

			return response.body().string();
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}

	public static String postSslXML(String certLocalPath, String certPassword, String baseUrl, Object content){
		try {
			String contentXml = XmlUtils.toXml(content);

			logger.info("");
			logger.info("okhttp xml url: " + baseUrl);
			logger.info("okhttp xml body: " + contentXml);
			logger.info("");

			return new HttpsRequest(certLocalPath, certPassword).sendPost(baseUrl, contentXml);
		} catch(Throwable t){
			logger.info(t.getMessage(), t);
			return null;
		}
	}
}
