# 查询内存情况 #

**功能描述**

获取SE主机内存利用率。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/getmemoryinfo

**调用方法**

POST

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/getmemoryinfo
```

**返回信息：**

请求成功

| 一级参数         | 二级参数     | 类型   | 描述                                               |
| :--------------- | ------------ | :----- | :------------------------------------------------- |
| total_memory     |              | string | 板载总内存                                         |
| svt_memory       |              | string | 系统、视频、tpu内存之和（SVT：system, video, tpu） |
| svt_free_memory  |              | string | SVT剩余总内存                                      |
| svt_used_memory  |              | string | SVT使用内存                                        |
| svt_memory_usage |              | float  | SVT内存使用率                                      |
| system           |              | dict   |                                                    |
|                  | system_scale | float  | system占总内存比例                                 |
|                  | total        | string | system总内存                                       |
|                  | free         | string | system剩余内存                                     |
|                  | used         | string | system使用内存                                     |
| tpu              |              | dict   |                                                    |
|                  | tpu_scale    | float  | tpu占总内存比例                                    |
|                  | total        | string | tpu总内存                                          |
|                  | free         | string | tpu剩余内存                                        |
|                  | used         | string | tpu使用内存                                        |
| video            |              | dict   |                                                    |
|                  | video_scale  | float  | video占总内存比例                                  |
|                  | total        | string | video总内存                                        |
|                  | free         | string | video剩余内存                                      |
|                  | used         | string | video使用内存                                      |
请求成功示例：

```json
 {
        "total_memory": "12.0G",
     	"svt_memory": "11.51G",
        "svt_free_memory": "10.57G",
        "svt_used_memory": "963.63M",
        "svt_memory_usage": 0.08,
        "system": {
            "free": "3.28G",
            "total": "3.71G",
            "used": "440.0M",
            "system_scale": 0.32,
        },
        "tpu": {
            "free": "3.41G",
            "total": "3.92G",
            "used": "523.49M",
            "tpu_scale": 0.34,
        },
        "video": {
            "free": "3.87G",
            "total": "3.88G",
            "used": "0.14M",
            "video_scale": 0.34
        }
   
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |

​    **错误码**

| Index | 错误码                 | message | 描述                                                      |
| :---- | :--------------------- | :------ | :-------------------------------------------------------- |
| 1     | UNSUPPORT_CONTENT_TYPE |         | http内容类型不支持。 目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |         | 无效的JSON数据请求。                                      |
| 3     | MISSING_ARGUMENTS      |         | 缺乏必要的参数。 : 缺失的参数在message字段中描述          |
| 4     | INVALID_ARGUMENTS      |         | 无效的参数。 : 参数信息在message字段中描述。              |
| 5     | INTERNAL_ERROR         |         | 服务器内部错误。                                          |