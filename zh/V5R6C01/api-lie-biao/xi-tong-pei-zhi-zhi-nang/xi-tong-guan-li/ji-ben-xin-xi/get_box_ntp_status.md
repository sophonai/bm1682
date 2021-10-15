# 查询ntp服务 #

**功能描述**

获取SE主机ntp服务情况。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/ntpConfig

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/ntpConfig?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数   | 类型   | 描述                                                    |
| :------- | :--------- | :----- | :------------------------------------------------------ |
| data     |            | dict   |                                                         |
|          | ntp_config | string | 设置的ntp服务地址,空格分隔                              |
|          | time       | int    | 系统时间戳，单位毫秒                                    |
|          | timezone   | int    | 时区设置， “+”表示西区，“-”表示东区，所以以-8表示东八区 |

请求成功示例：

```json
{
    "data": {
        "ntp_config": "ntp1.aliyun.com ntp2.aliyun.com 0.cn.pool.ntp.org 1.cn.pool.ntp.org",
        "time":1605249313019,
        "timezone":-8
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
