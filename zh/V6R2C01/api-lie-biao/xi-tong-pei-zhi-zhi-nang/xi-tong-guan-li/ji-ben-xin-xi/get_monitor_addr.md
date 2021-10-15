# 获取系统状态上报配置 #

**功能描述**

获取SE主机系统状态上报配置。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/getsystemmonitorconfig

**调用方法**

POST

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/getsystemmonitorconfig?
```

**返回信息：**

请求成功

| 参数                         | 类型   | 描述                                                         |
| :--------------------------- | :----- | :----------------------------------------------------------- |
| device_monitor_url           | string | 上报状态地址得url列表，每个url之间以逗号分隔。如："http://xxx.com/getMonitorRecord, http://xxx.com/getBackupRecord" |
| device_monitor_report_period | int    | 上报周期，单位秒                                             |
| reporter_id                  | string | 可选配置的上报id，如果用户设置该id，则数据上报中会携带该id，可用于平台的数据汇总 |

请求成功示例：

```json
{
    "reporter_id": "AFVKQF000120210604151110",
    "device_monitor_url": "http://xxx.com/xx",
    "device_monitor_report_period": 20
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