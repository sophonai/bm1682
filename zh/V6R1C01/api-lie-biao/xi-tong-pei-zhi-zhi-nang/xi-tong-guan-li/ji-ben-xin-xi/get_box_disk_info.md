# 查询存储情况 #

**功能描述**

获取SE主机存储使用情况。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/getstorage

**调用方法**

POST

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/getstorage
```

| 参数   | 类型   |                                                              |
| ------ | ------ | ------------------------------------------------------------ |
| device | string | "emmc": 查询板载emmc的存储情况<br />"hdd": 查询外接硬盘的存储情况<br /> |



返回信息：**

请求成功

| 参数             | 类型   | 描述                                |
| :--------------- | :----- | :---------------------------------- |
| mount_status     | bool   | true: 已经mount<br />false: 未mount |
| nominal_capacity | string | 标称存储大小                        |
| total_disk       | string | 总存储大小                          |
| used_disk        | string | 已经使用的存储空间大小              |
| free_disk        | string | 剩余存储                            |
| disk_usage       | float  | 存储使用率                          |

请求成功示例：

```json
 {
     "mount_status":true,
     "nominal_capacity": "32.0G",
     "total_disk": "30.54G",
     "used_disk": "13.7G",
     "free_disk": "16.84G",
     "disk_usage": 0.45
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