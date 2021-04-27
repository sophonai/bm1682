# 查询4G模块状态 #

**功能描述**

获取SE主机4G模块状态。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/lteModem

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/lteModem?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数 | 类型   | 描述                                           |
| :------- | :------- | :----- | :--------------------------------------------- |
| data     |          | dict   |                                                |
|          | service  | string | active:4G模块开启。<br />inactive:4G模块关闭。 |

请求成功示例：

```json
{
    "data": {
        "service": "active"
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

