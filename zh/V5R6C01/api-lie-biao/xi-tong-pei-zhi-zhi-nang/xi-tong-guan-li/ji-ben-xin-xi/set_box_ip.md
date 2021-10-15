# 设置主机ip地址 #

**功能描述**

设置SE主机名称。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/ip

**调用方法**

POST

**请求参数**

| 参数     | 类型   | 默认值 | 选择     | 描述                                                         | 举例           |
| :------- | :----- | ------ | :------- | :----------------------------------------------------------- | -------------- |
| status   | string | 无     | **必选** | 静态地址/动态地址， static/dynamic                           |                |
| device   | string | 无     | **必选** | 网络接口， eth0/eth1                                         | eth0           |
| new_ip   | string | 无     | 可选     | 小盒子ip，如果new_ip是空，就是设置ip自动获取，静态地址修改时必选。 | "192.168.1.64" |
| netmask  | string | 无     | 可选     | 子网掩码，静态地址修改时必选。                               | 255.255.255.0  |
| gateway  | string | 无     | 可选     | 网关，静态地址修改时必选。                                   | 192.168.1.1    |
| dns      | string | 无     | 可选     | DNS，静态地址修改时必选。                                    | 8.8.8.8        |
| isreboot | bool   | 无     | **可选** | 是否立刻重启生效ip， true或者false，默认为false              | false          |

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/ip?
请求body:
静态地址修改：
	{
        "status":"static",
        "device":"eth0",
        "new_ip":"192.168.1.180",
        "netmask":"255.255.255.0",
        "gateway":"192.168.1.1",
        "dns":"192.168.1.1",
        "isreboot":true
    }
动态地址修改：
	{
    	"status":"dynamic",
        "device":"eth0",
		"isreboot":true
	}
```

**返回信息：**

请求成功：

| 一级参数 | 二级参数 | 类型   | 描述           |
| :------- | :------- | :----- | :------------- |
| data     |          | dict   |                |
|          | ip       | string | 修改后的盒子ip |

请求成功示例：

```json
{
     "data": {
        "ip": "192.168.1.64"
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

​    
