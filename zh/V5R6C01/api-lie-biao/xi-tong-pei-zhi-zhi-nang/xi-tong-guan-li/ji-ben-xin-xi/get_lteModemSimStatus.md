# 查询4G模块sim卡状态 #

**功能描述**

获取SE主机4G模块sim卡状态。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/lteModemSimStatus

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/lteModemSimStatus?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数    | 类型   | 描述                            |
| :------- | :---------- | :----- | :------------------------------ |
| data     |             | dict   |                                 |
|          | simstatus   | bool   | true/false, sim卡连接状态       |
|          | description | string | "SIM CARD OK"/"SIM CARD FAILED" |

请求成功示例：

```json
{
    "data": {
        "simstatus": true,
        "description":"SIM CARD OK"
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

