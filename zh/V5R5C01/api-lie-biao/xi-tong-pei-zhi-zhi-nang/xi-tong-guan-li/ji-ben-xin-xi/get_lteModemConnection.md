# 查询4G模块网络状态 #

**功能描述**

获取SE主机4G模块网络状态。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/lteModemConnection

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/lteModemConnection?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数  | 类型 | 描述                                                      |
| :------- | :-------- | :--- | :-------------------------------------------------------- |
| data     |           | dict |                                                           |
|          | connected | bool | true:4G模块网络链接成功。<br />false:4G模块网络连接失败。 |

请求成功示例：

```json
{
    "data": {
        "connected": true
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

