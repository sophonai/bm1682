# 配置查询/sophon/v2/face/getconfigs（POST）

**版本**

2.0

**功能描述**

查询单个或者多个系统配置信息。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getconfigs

调用方法: POST

**请求参数**

| 参数        | 类型   | 默认值 | 选择 | 描述                                           | 示例 |
| :---------- | :----- | ------ | :--- | :------------------------------------------- | ---- |
| config_name | string |        | 可选 | 需要查询的配置名称，不送的话返回所有的配置信息 | "GATE_DUPLICATE_REMOVAL_TIMEOUT"     |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getconfigs
请求方法：POST
请求body:
{
  "config_name":"GATE_DUPLICATE_REMOVAL_TIMEOUT"
}
```

**返回信息：**

**请求成功**

| 一级参数    | 类型 | 描述           |
| :---------- | :--- | :------------- |
| config_item | dict | 配置项详细信息 |

请求成功示例：

```json
{
    "GATE_DUPLICATE_REMOVAL_TIMEOUT": 6.0
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                 | message    | 描述                                                         |
| ----- | ---------------------- | ---------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE |            | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |            | 无效的JSON数据请求。                                         |
| 3     | MISSING_ARGUMENTS      | <key_name> | 缺乏必要的参数。<br /><key_name> :  缺失的参数在message字段中描述 |
| 4     | INVALID_ARGUMENTS      | <key_name> | 无效的参数。<br /><key_name> : 参数信息在message字段中描述。 |
