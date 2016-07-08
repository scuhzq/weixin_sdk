package com.oldpeng.core.weixin;

import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * Created by dapeng on 16/1/22.
 */
public class CustomTrustOkHttpClient {

	private static Logger logger = LoggerFactory.getLogger(CustomTrustOkHttpClient.class);

	public static OkHttpClient build(String certPath, String password) {
		SSLContext sslContext = sslContextForTrustedCertificates(certPath, password);
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.sslSocketFactory(sslContext.getSocketFactory())
				.build();
		return okHttpClient;
	}

	private static SSLContext sslContextForTrustedCertificates(String certLocalPath, String certPassword) {
		try {
			// Put the certificates a key store.
			KeyStore keyStore = buildKeyStore(certLocalPath, certPassword);

			// Wrap it up in an SSL context.
			KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			keyManagerFactory.init(keyStore, certPassword.toCharArray());
			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(keyStore);
			SSLContext sslContext = SSLContext.getInstance("TLSv1");
			sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());

			return sslContext;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	private static KeyStore buildKeyStore(String certLocalPath, String certPassword) throws Exception {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream inputStream = new FileInputStream(new File(certLocalPath));
		keyStore.load(inputStream, certPassword.toCharArray());//设置证书密码
		inputStream.close();
		return keyStore;
	}
}
