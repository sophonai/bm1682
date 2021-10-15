# 查询4G模块网络状态 #

**功能描述**

获取SE主机4G模块网络状态。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/getltemodemconnection

**调用方法**

POST

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/getltemodemconnection?
```

**返回信息：**

请求成功

| 参数       | 类型 | 描述                                                      |
| :--------- | :--- | :-------------------------------------------------------- |
| connected  | bool | true:4G模块网络链接成功。<br />false:4G模块网络连接失败。 |
| sim_status | bool | true/false,  sim卡状态                                    |

请求成功示例：

```json
{
    "connected": true,
    "sim_status": true

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