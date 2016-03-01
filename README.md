# 微信开放平台、微信公众平台（订阅号、服务号）和 微信支付 Java SDK
# weixin sdk

```java
//微信开放平台 / 微信公众平台
WeixinClientEngine weixinClientEngine = new WeixinClientEngine();
weixinClientEngine.setToken(...)
... ...

//微信支付
WeixinPayEngine weixinPayEngine = new WeixinPayEngine();
weixinPayEngine.setKey(...)
... ...
```

Maven
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd'
          xmlns='http://maven.apache.org/SETTINGS/1.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>

	<profiles>
		<profile>
			<repositories>
				<repository>
					<snapshots>
						<enabled>false</enabled>
					</snapshots>
					<id>central</id>
					<name>bintray</name>
					<url>http://jcenter.bintray.com</url>
				</repository>
			</repositories>
			<pluginRepositories>
				<pluginRepository>
					<snapshots>
						<enabled>false</enabled>
					</snapshots>
					<id>central</id>
					<name>bintray-plugins</name>
					<url>http://jcenter.bintray.com</url>
				</pluginRepository>
			</pluginRepositories>
			<id>bintray</id>
		</profile>
	</profiles>
	<activeProfiles>
		<activeProfile>bintray</activeProfile>
	</activeProfiles>
	
	<dependency>
      <groupId>com.oldpeng.weixin</groupId>
      <artifactId>weixin_sdk</artifactId>
      <version>1.0.7</version>
      <type>pom</type>
    </dependency>
</settings>
```

gradle
```gradle
repositories {
    maven {
        url  "http://jcenter.bintray.com" 
    }
}

compile 'com.oldpeng.weixin:weixin_sdk:1.0.7'
```
