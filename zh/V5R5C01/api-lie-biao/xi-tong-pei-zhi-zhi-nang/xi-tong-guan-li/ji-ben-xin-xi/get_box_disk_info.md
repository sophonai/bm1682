# 查询存储情况 #

**功能描述**

获取SE主机存储使用情况。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/diskInfo

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/diskInfo?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数            | 类型   | 描述                   |
| :------- | :------------------ | :----- | :--------------------- |
| data     |                     | dict   |                        |
|          | hardware_total_disk | string | 板载总存储大小         |
|          | disk_rate           | float  | 存储使用率             |
|          | total_disk          | string | 总存储大小             |
|          | free_disk           | string | 剩余存储               |
|          | used_disk           | string | 已经使用的存储空间大小 |

请求成功示例：

```json
{
    "data": {
        "disk_rate": 0.45,
        "free_disk": "16.84G",
        "hardware_total_disk": "32.0G",
        "total_disk": "30.54G",
        "used_disk": "13.7G"
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

