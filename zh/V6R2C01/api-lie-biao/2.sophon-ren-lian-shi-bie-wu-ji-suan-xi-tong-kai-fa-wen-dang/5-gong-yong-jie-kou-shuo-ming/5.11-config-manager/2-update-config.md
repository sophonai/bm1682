# 修改配置/sophon/v2/face/setconfigs（POST）

**功能描述**

设置一个或者多个配置信息。
如果同时设置多个配置，只要其中有一个配置出错，则此次调用会返回错误码，但是成功的配置会生效

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/setconfigs

调用方法: POST

**请求参数（JSON格式）**

| 一级参数        | 二级参数   |类型   | 默认值 | 选择 | 描述                                           | 示例 |
| :---------- | :----- |:----- | ------ | :--- | :------------------------------------------- | ---- |
| config_dict |         | dict   | | 必选 |             |      |
|             | 配置变量 | string| | 必选 | 需要设置的变量的值             | "6.0"     |

请求示例：

```json
请求url: http://192.168.1.180:5555/sophon/v2/face/setconfigs
请求方法：POST
请求body:
{
	"config_dict":
	{
        "EVENT_IMAGE_PATH": "local"
	}
} 
```

**返回信息：**

**请求成功**

| 一级参数    | 类型   | 描述             |
| :---------- | ------ | :--------------- |
| config_name | string | 返回新的配置信息 |

请求成功示例：

```json
{
  "EVENT_IMAGE_PATH":"local"
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                 | message        | 描述                                                         |
| ----- | ---------------------- | -------------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |                | 无效的JSON数据请求。                                         |
| 3     | MISSING_ARGUMENTS      | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 4     | INVALID_ARGUMENTS      | 无效参数的值   | 无效的参数。                                                 |
| 5     | NAME_REPEAT_ERROR      | 重复的名字     | 名字重复错误。                                               |
