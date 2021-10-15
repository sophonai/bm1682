# 查询主机ip地址信息 #

**功能描述**

获取SE主机ip地址状态。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/ip

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/ip?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数   | 类型   | 描述                         |
| :------- | :--------- | :----- | :--------------------------- |
| data     |            | list   |                              |
|          | device     | string | 网络接口， eth0/eth1         |
|          | dns        | string | DNS                          |
|          | ip         | string | 主机ip地址                   |
|          | netmask    | string | 子网掩码                     |
|          | status     | string | 地址类型，静态地址/动态地址  |
|          | bandwidth  | float  | 带宽, 单位Mb/s               |
|          | bandstatus | bool   | true/false, 是否满足默认输出 |

请求成功示例：

```json
{
    "data": [
        {
            "device": "eth0",
            "dns": "192.168.1.2",
            "gateway": "192.168.1.2",
            "ip": "192.168.1.64",
            "netmask": "255.255.240.0",
            "status": "static",
            "bandwidth":100.0,
            "bandwidthvarity":true
        },
        {
            "device": "eth1",
            "dns": "192.168.150.1",
            "ip": "192.168.150.1",
            "netmask": "255.255.255.0",
            "status": "static",
            "bandwidth":100.0,
            "bandwidthvarity":true
        }
    ]
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

​    
