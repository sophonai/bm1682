# 查询网络选择模式 #

**功能描述**

获取SE主机网络选择模式。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/lteModemSelection

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/lteModemSelection?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数  | 类型   | 描述                                            |
| :------- | :-------- | :----- | :---------------------------------------------- |
| data     |           | dict   |                                                 |
|          | selection | string | ltefirst:lte优先。<br />wanfirst:本地网口优先。 |

请求成功示例：

```json
{
    "data": {
        "selection": "ltefirst"
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

