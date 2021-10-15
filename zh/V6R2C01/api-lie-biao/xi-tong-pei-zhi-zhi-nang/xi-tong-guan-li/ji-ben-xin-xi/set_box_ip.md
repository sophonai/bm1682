# 设置主机ip地址 #

**功能描述**

设置SE主机IP地址。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/setip

**调用方法**

POST

**请求参数**

| 参数           | 类型   | 默认值 | 选择     | 描述                                                         | 举例           |
| :------------- | :----- | ------ | :------- | :----------------------------------------------------------- | -------------- |
| interface      | string | 无     | **必选** | 网络接口， eth0/eth1                                         | eth0           |
| mode           | string | 无     | **必选** | 静态地址/动态地址， static/dynamic                           |                |
| ip             | string | 无     | 可选     | 小盒子ip，如果ip是空，就是设置ip自动获取，静态地址修改时必选。 | "192.168.1.64" |
| netmask        | string | 无     | 可选     | 子网掩码，静态地址修改时必选。                               | 255.255.255.0  |
| gateway        | string | 无     | 可选     | 网关，静态地址修改时必选。                                   | 192.168.1.1    |
| dns            | string | 无     | 可选     | DNS，静态地址修改时必选。                                    | 8.8.8.8        |
| apply_imediate | bool   | 无     | 可选     | 是否立刻使网络配置生效，默认为true<br />true: 立即生效<br />false:系统重启后再生效 | true           |

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/setip
请求body:
静态地址修改：
	{
        "mode":"static",
        "interface":"eth0",
        "ip":"192.168.1.180",
        "netmask":"255.255.255.0",
        "gateway":"192.168.1.1",
        "dns":"192.168.1.1",
        "apply_imediate":true
    }
动态地址修改：
	{
    	"mode":"dynamic",
        "interface":"eth0",
		"apply_imediate":true
	}
```

**返回信息：**

请求成功：

| 参数 | 类型   | 描述           |
| :--- | :----- | :------------- |
| ip   | string | 修改后的盒子ip |

请求成功示例：

```json
{
   "ip": "192.168.1.64"
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