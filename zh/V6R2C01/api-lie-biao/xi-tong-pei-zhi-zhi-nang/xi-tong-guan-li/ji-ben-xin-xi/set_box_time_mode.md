# 设置时间模式 #

**功能描述**

设置SE主机系统时间之前，需要调用API关闭ntp服务器设置模式。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/settimesettingmode

**调用方法**

POST

**请求参数**

| 参数 | 类型   | 默认值 | 选择 | 描述 | 举例 |
| :--- | :----- | ------ | :--- | :--- | ---- |
| mode | string | 无     | 必选 |      |      |

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/settimesettingmode
请求body:
	{
        "mode":"ntp"
  }
```

**返回信息：**

请求成功：

| 参数 | 类型   | 描述                                                         |
| :--- | :----- | :----------------------------------------------------------- |
| mode | string | "ntp":ntp服务设置时间模式。<br />"manual":手动设置时间模式。 |

请求成功示例：

```json
{
    "mode":"ntp"
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |

​    **错误码**

| Index | 错误码                 | message | 描述                                                      |
| :---- | :--------------------- | :------ | :-------------------------------------------------------- |
| 1     | UNSUPPORT_CONTENT_TYPE |         | http内容类型不支持。 目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |         | 无效的JSON数据请求。                                      |
| 3     | MISSING_ARGUMENTS      |         | 缺乏必要的参数。 : 缺失的参数在message字段中描述          |
| 4     | INVALID_ARGUMENTS      |         | 无效的参数。 : 参数信息在message字段中描述。              |
| 5     | INTERNAL_ERROR         |         | 服务器内部错误。                                          |