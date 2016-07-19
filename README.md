# 微信开放平台、微信公众平台（订阅号、服务号）和 微信支付 Java SDK
# weixin sdk

```java
//微信开放平台
WeixinPlatformEngine weixinPlatformEngine = new WeixinPlatformEngine();
weixinPlatformEngine.setToken(...)
... ...

//微信公众平台
WeixinClientEngine weixinClientEngine = new WeixinClientEngine();
WeixinClientEngine.setAppid(...)
... ...

//微信支付
WeixinPayEngine weixinPayEngine = new WeixinPayEngine();
weixinPayEngine.setKey(...)
... ...
```


Maven
```xml
<repositories>
    <repository>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
        <id>bintray-usydapeng-maven</id>
        <name>bintray</name>
        <url>http://dl.bintray.com/usydapeng/maven</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>com.oldpeng.weixin</groupId>
        <artifactId>weixin_sdk</artifactId>
        <version>2.3.0</version>
        <type>pom</type>
    </dependency>
</dependencies>
```

gradle
```gradle
repositories {
    jcenter()
}
dependencies {
    compile 'com.oldpeng.weixin:weixin_sdk:2.3.0'
}
```



>微信支付、微信网页授权demo

>[https://github.com/usydapeng/weixin_sdk_demo](https://github.com/usydapeng/weixin_sdk_demo)
