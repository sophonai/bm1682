# 获取系统状态上报配置 #

**功能描述**

获取SE主机系统状态上报配置。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/monitor

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/monitor?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数             | 类型   | 描述               |
| :------- | :------------------- | :----- | :----------------- |
| data     |                      | dict   |                    |
|          | monitor_address_list | list   | 上报状态地址列表   |
|          | report_period        | int    | 上报周期，单位秒   |
|          | dev_sno              | string | 授权码，用于鉴权等 |

请求成功示例：

```json
{
    "data": {
        "dev_sno": "AFVKQF000120210604151110",
        "monitor_address_list": [
            "http://xxx.com/xx"
        ],
        "report_period": 20
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
