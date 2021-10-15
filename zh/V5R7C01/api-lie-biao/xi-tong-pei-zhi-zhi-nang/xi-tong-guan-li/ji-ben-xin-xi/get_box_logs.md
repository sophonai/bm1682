# 日志收集获取 #

**功能描述**

获取SE主机软件系统模式。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/logs

**调用方法**

GET

**请求参数：**

| 一级参数      | 类型   | 描述                             | 举例            |
| :------------ | :----- | :------------------------------- | --------------- |
| get_logs_type | string | “0”: 系统日志<br />“1”：用户日志 | get_logs_type=1 |

请求示例：

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/logs?get_logs_type=1
```

请求成功示例,直接返回文件：

```
system.tgz        //system.tgz系统日志，application.tgz为用户日志
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

​    

