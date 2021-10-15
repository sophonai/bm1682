# 查询系统运行时间 #

**功能描述**

获取SE主机系统运行时间。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/uptime

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/uptime?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数 | 类型   | 描述                                                   |
| :------- | :------- | :----- | :----------------------------------------------------- |
| data     |          | dict   |                                                        |
|          | uptime   | string | 系统运行时间, 直接返回linux uptime命令格式化后的字符串 |

请求成功示例：

```json
{
    "data": {
        "uptime": "3 hours, 57 minutes"
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
