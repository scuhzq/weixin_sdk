package com.oldpeng.core.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by dapeng on 16/1/18.
 */
public class RoomUrlUtils {

	public static String retrieveRoomId(String uri){
		if(StringUtils.isBlank(uri) || (!uri.startsWith("/course/") && !uri.startsWith("/data/course/") && !uri.startsWith("/data/"))){
			return null;
		}

		String temp = uri;
		if(uri.contains("/course/")){
			temp = uri.substring(uri.indexOf("/course/") + 8);
		}

		if(temp.contains("/data/")){
			temp = uri.substring(uri.indexOf("/data/") + 6);
		}

		if(temp.contains("/")){
			temp = temp.substring(0, temp.indexOf("/"));
		}

		if(temp.contains("?")){
			temp = temp.substring(0, temp.indexOf("?"));
		}

		if(temp.contains(";")){
			temp = temp.substring(0, temp.indexOf(";"));
		}

		if(temp.length() != 34 || !temp.startsWith("jz")){
			return null;
		}

		return temp;
	}
}
