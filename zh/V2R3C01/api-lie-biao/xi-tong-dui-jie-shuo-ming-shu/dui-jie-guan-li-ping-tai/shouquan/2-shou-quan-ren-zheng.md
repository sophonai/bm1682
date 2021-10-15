# 授权认证介绍 #

本章节介绍用户系统如何使用授权参数生成授权认证信息，以便调用sophonsight开放API接口。

## 1.1 介绍 ##

#### 1.1.1  接口认证方式 ####
<br><font color="#dd0000"><b>调用方</b></font>首先要向平台管理员获取appkey和secret；
<br>appkey：调用方唯一标识，方便HTTP-API统计与维护；
<br>secret：密钥，用于生成HTTP-API校验所需的token值；
<br><font color="#dd0000"><b>调用方</b></font>
遵照HTTP-OpenAPI约定规则生成token，并作为接口调用的请求参数传入<font color="#dd0000"><b>服务端</b></font>进行校验；
<br><font color="#dd0000"><b>服务端</b></font>对<font color="#dd0000"><b>调用方</b></font>传入的token参数值进行验证；

#### 1.1.2  获取AppKey和Secret ####
AppKey：调用方唯一标识，方便HTTP-OpenAPI统计与维护

Secret：密钥，用于生成HTTP-OpenAPI校验的token值

#### 1.1.3公共请求参数 ####
body中公共参数

    {
    
    "appkey": "xxx",
    
    "time": 1551196800000,//精确到ms
    
    }

拼在url后面的公共参数


  token | 认证参数 | String | 是 | 拼接在POST请求URL后面
  ----- | -------- | ------ | -- 
        |          |        |    | 

<br><font color=red><b>注：接口定义中公共参数忽略</b></font>

#### 1.1.4   生成token值 ####
Token值是将请求源串以及Secret通过MD5算法生成的，用来提高传输过程参数的防篡改性。

token值的生成共有2个步骤：**构造源串，生成token值**。详见下面的描述。

**Step1.构造源串**

a.获取要请求URI(统一资源标识符，即域名后面的地址串，示例：/openapi/v1/cross/node/search）；

b.将输入参数（公共参数和业务参数）生成JSON串；：{"appkey":"1234qwe","time":1551196800000,pageNo":"2","pageSize":"10"}

c.将a中URI和b中得到的字符串和secrect拼接起来得到源串。/openapi/v1/cross/node/search{"appkey":"1234qwe","time":1551196800000,pageNo":"2","pageSize":"10"}secret

**Step2.生成token值**

使用MD5算法对Step1中得到的源串进行运算，得到token值（大写）

md5(/openapi/v1/cross/node/search{"appkey":"1234qwe","time":1551196800000,pageNo":"2","pageSize":"10"}secret)

**Step3.将token参数和值拼接到POST请求URL后面**

**Step4.发起请求**

<font color=red>**注：生成token的请求参数顺序与请求URL中的参数顺序保持一致**</font>



