# 修改配置/SophonConfig/api/Configs（PUT）

**功能描述**

更新一个或者多个配置信息

**调用URL**

http://192.168.1.180:5555/SophonConfig/api/Configs

调用方法: PUT

**请求参数（JSON格式）**

| 一级参数    | 二级参数 | 三级参数 | 四级参数 | 类型 | 默认值 | 选择 | 描述     | 举例 |
| :---------- | :------- | :------- | :------- | :--- | :----- | :--- | :------- | :--- |
| config_dict |          |          |          | dict | 无     | 必选 | 配置列表 |      |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonConfig/api/Configs
请求body:
{
	"config_dict":
	{"EVENT_IMAGE_PATH": "local"
	}
} 
```

**返回信息：**

请求成功

| 一级参数 | 二级参数        | 类型 | 描述                   |
| :------- | :-------------- | ---- | :--------------------- |
| data     |                 | dict |                        |
|          | failed_configs  | list | 返回配置失败的参数列表 |
|          | success_configs | list | 返回配置成功的参数列表 |

请求成功示例：

```json
{
"data": {
"failed_configs": [],
"success_configs": [
"EVENTOPLAD_URL",
"DUPLICATE_REMOVAL_TIMEOUT",
"INIT"
]
}
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
