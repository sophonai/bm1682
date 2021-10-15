# 查询内存情况 #

**功能描述**

获取SE主机内存使用情况。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/memoryInfo

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/memoryInfo?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数     | 类型   | 描述         |
| :------- | :----------- | :----- | :----------- |
| data     |              | dict   |              |
|          | total_memory | string | 总内存       |
|          | used_memory  | string | 已经使用内存 |

请求成功示例：

```json
{
    "data": {
        "total_memory": "12G",
        "used_memory":  "1.5G",
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
