# 查询内存情况 #

**功能描述**

获取SE主机内存利用率。

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

| 一级参数 | 二级参数              | 三级参数     | 类型   | 描述               |
| :------- | :-------------------- | ------------ | :----- | :----------------- |
| data     |                       |              | dict   |                    |
|          | hardware_total_memory |              | string | 板载总内存         |
|          | total_memory          |              | string | 总内存             |
|          | total_free_memory     |              | string | 剩余总内存         |
|          | total_used_memory     |              | string | 已经使用内存       |
|          | system                |              | dict   |                    |
|          |                       | system_scale | float  | system占总内存比例 |
|          |                       | total        | string | system总内存       |
|          |                       | free         | string | system剩余内存     |
|          |                       | used         | string | system使用内存     |
|          | tpu                   |              | dict   |                    |
|          |                       | tpu_scale    | float  | tpu占总内存比例    |
|          |                       | total        | string | tpu总内存          |
|          |                       | free         | string | tpu剩余内存        |
|          |                       | used         | string | tpu使用内存        |
|          | video                 |              | dict   |                    |
|          |                       | video_scale  | float  | video占总内存比例  |
|          |                       | total        | string | video总内存        |
|          |                       | free         | string | video剩余内存      |
|          |                       | used         | string | video使用内存      |
请求成功示例：

```json
{
    "data": {
        "hardware_total_memory": "12.0G",
        "system": {
            "free": "3.28G",
            "system_scale": 0.32,
            "total": "3.71G",
            "used": "440.0M"
        },
        "total_free_memory": "10.57G",
        "total_memory": "11.51G",
        "total_used_memory": "963.63M",
        "tpu": {
            "free": "3.41G",
            "total": "3.92G",
            "tpu_scale": 0.34,
            "used": "523.49M"
        },
        "video": {
            "free": "3.87G",
            "total": "3.88G",
            "used": "0.14M",
            "video_scale": 0.34
        }
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
