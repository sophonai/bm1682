# 查询主机SN #

**功能描述**

获取SE主机SN号。

**调用URL**

http://192.168.1.180:8888/sophon/v2/system/getdevicesn

**调用方法**

POST

**请求示例：**

```json
请求url: http://192.168.1.180:8888/sophon/v2/system/getdevicesn?
```

**返回信息：**

请求成功

| 参数      | 类型   | 描述           |
| :-------- | :----- | :------------- |
| device_sn | string | 主机系统SN号。 |

请求成功示例：

```json
{
    "device_sn": "HQDZKE5BJJFJH0047"
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

​    

