# 设置ntp服务 #

**功能描述**

设置SE主机ntp服务设置。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/setntpconfig

**调用方法**

POST

**请求参数**

| 参数            | 类型   | 默认值 | 选择 | 描述                                                    | 举例                                                         |
| :-------------- | :----- | ------ | :--- | :------------------------------------------------------ | ------------------------------------------------------------ |
| ntp_server_list | string | 无     | 必选 | 设置的ntp服务地址                                       | "ntp1.aliyun.com ntp2.aliyun.com 0.cn.pool.ntp.org 1.cn.pool.ntp.org" |
| timezone        | int    | 无     | 必选 | 时区设置， “+”表示西区，“-”表示东区，所以以-8表示东八区 | -8                                                           |

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/setntpconfig?
请求body:
   {
     "ntp_server_list":"ntp1.aliyun.com ntp2.aliyun.com 0.cn.pool.ntp.org 1.cn.pool.ntp.org",
     "timezone":-8
   }
```

**返回信息：**

请求成功：

| 参数            | 类型   | 描述                   |
| :-------------- | :----- | :--------------------- |
| ntp_server_list | string | 设置的ntp服务地址      |
| timezone        | int    | 时区设置               |
| time            | int    | 系统时间戳，单位为毫秒 |

请求成功示例：

```json
{
     "ntp_server_list":"ntp1.aliyun.com ntp2.aliyun.com 0.cn.pool.ntp.org 1.cn.pool.ntp.org",
     "time":1605249313019,
     "timezone":-8
}
    	

```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |

​    

**错误码**

| Index | 错误码                 | message | 描述                                                      |
| :---- | :--------------------- | :------ | :-------------------------------------------------------- |
| 1     | UNSUPPORT_CONTENT_TYPE |         | http内容类型不支持。 目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |         | 无效的JSON数据请求。                                      |
| 3     | MISSING_ARGUMENTS      |         | 缺乏必要的参数。 : 缺失的参数在message字段中描述          |
| 4     | INVALID_ARGUMENTS      |         | 无效的参数。 : 参数信息在message字段中描述。              |
| 5     | INTERNAL_ERROR         |         | 服务器内部错误。                                          |