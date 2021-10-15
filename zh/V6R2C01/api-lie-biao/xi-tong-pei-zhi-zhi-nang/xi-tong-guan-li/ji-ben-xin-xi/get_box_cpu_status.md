# 查询cpu使用 #

**功能描述**

获取SE主机cpu使用情况。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/getcpuinfo

**调用方法**

POST

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/getcpuinfo
```

**返回信息：**

请求成功

| 参数          | 类型   | 描述                                                         |
| ------------- | :----- | :----------------------------------------------------------- |
| cpu_arch      | string | cpu型号。                                                    |
| cur_cpu_usage | float  | 归一化之后的cpu使用率。<br />例如：8核cpu使用率满值为800%，会最终归一化为1.0 |
| cpu_freq      | string | cpu标称频率。                                                |
| cpu_cores     | string | cpu核数。                                                    |

请求成功示例：

```json
{	
    "cpu_arch": "A53",
    "cur_cpu_usage": 0.19,
    "cpu_freq": "2.3Ghz",
    "cpu_cores": "8"    
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |

​    

**错误码**

| Index | 错误码                 | message | 描述                                                      |
| :---- | :--------------------- | :------ | :-------------------------------------------------------- |
| 1     | UNSUPPORT_CONTENT_TYPE |         | http内容类型不支持。 目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |         | 无效的JSON数据请求。                                      |
| 3     | MISSING_ARGUMENTS      |         | 缺乏必要的参数。 : 缺失的参数在message字段中描述          |
| 4     | INVALID_ARGUMENTS      |         | 无效的参数。 : 参数信息在message字段中描述。              |
| 5     | INTERNAL_ERROR         |         | 服务器内部错误。                                          |