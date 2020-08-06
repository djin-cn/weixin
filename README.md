# 微信接口库
集成所有微信开放接口, 对于常用功能封装门面简化调用

## 用户角色
通过研究微信开放平台接口, 可以得知微信共分为4类账号, A: 微信平台方; B: 第三方服务提供方(component); C: 服务使用方, 包括公众号/小程序(authorizer); D: C端用户;  
component接口一般为B类用户调用A的接口; authorizer表示B类用户调用C的接口

## 接收事件
共有3个接收事件, 需要设置接收通道及时接收微信推送的消息
1. 获取验证票据
2. 授权变更通知
3. 通过接口快速创建小程序时注册审核事件推送
4. 小程序名称审核结果事件推送

## 注意事项
1. 微信加解密用到了commons-codec, 微信官方提供的示例为1.9版本, 接口库用的1.12版本, 实际使用版本不要超过1.12, >1.12版本可能会提示IllegalArgumentException

##maven引用使用方式
1. 首先在gitlab或者github上搭建maven私库
2. 然后在settings.xml或者pom.xml引入repository, 两种方式分别如下:  

settings.xml

```xml
    <mirrors>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>central</mirrorOf>
            <name>阿里云公共仓库</name>
            <url>https://maven.aliyun.com/repository/public</url>
        </mirror>
    </mirrors>
    <profiles>
        <profile>
            <id>private</id>
            <repositories>
                <repository>
                    <id>gitlab</id>
                    <url>http://{domain}/{repos}/raw/master/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                        <updatePolicy>always</updatePolicy>
                    </snapshots>
                </repository>
            </repositories>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>private</activeProfile>  
    </activeProfiles>
</settings>
```

pom.xml

```xml
    <repositories>
        <repository>
            <id>gitlab</id>
            <name>gitlab</name>
            <url>http://{domain}/{repos}/raw/master/</url>
        </repository>
    </repositories>
```
