# 日志收集获取 #

**功能描述**

获取SE主机软件系统模式。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/getlogs

**调用方法**

GET

**请求参数：**

| 一级参数      | 类型   | 描述                                                         | 举例                |
| :------------ | :----- | :----------------------------------------------------------- | ------------------- |
| get_logs_type | string | “sys”:   系统日志<br />“app”：应用日志，/data/log下日志统一打包。 | get_logs_type="sys" |

请求示例：

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/getlogs?get_logs_type=sys
```

请求成功示例,直接返回文件：

```
system.tgz        //system.tgz系统日志，application.tgz为用户日志
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