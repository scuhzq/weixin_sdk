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
<dependency>
  <groupId>com.oldpeng.weixin</groupId>
  <artifactId>weixin_sdk</artifactId>
  <version>2.0.8</version>
  <type>pom</type>
</dependency>
```

gradle
```
compile 'com.oldpeng.weixin:weixin_sdk:2.0.8'
```
