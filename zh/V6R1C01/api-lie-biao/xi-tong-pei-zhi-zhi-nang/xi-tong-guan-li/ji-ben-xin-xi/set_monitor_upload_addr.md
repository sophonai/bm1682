# 配置系统状态上报 #

**功能描述**

设置SE主机系统状态上报地址和周期等配置。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/setsystemmonitorconfig

**调用方法**

POST

**请求参数**

| 参数                         | 类型   | 默认值 | 选择 | 描述                                                         | 举例                                                         |
| :--------------------------- | :----- | ------ | :--- | :----------------------------------------------------------- | ------------------------------------------------------------ |
| device_monitor_url           | string | 无     | 必选 | 上报状态地址得url列表，每个url之间以逗号分隔。               | "http://xxx.com/getMonitorRecord, http://xxx.com/getBackupRecord" |
| device_monitor_report_period | int    | 无     | 必选 | 上报状态周期，单位秒                                         | 20                                                           |
| reporter_id                  | string | 无     | 可选 | 可选配置的上报id，如果用户设置该id，则数据上报中会携带该id，可用于平台的数据汇总 | "AFVKQF000120210604151110"                                   |

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/setsystemmonitorconfig
请求body:
	
      {
            "device_monitor_url":"http://xxx.com/xx",
            "device_monitor_report_period":20,
			"reporter_id":"AFVKQF000120210604151110"
      }
    
```

**返回信息：**

请求成功：

| 参数                         | 类型   | 描述                     |
| :--------------------------- | :----- | :----------------------- |
| device_monitor_url           | list   | 上报状态地址列表         |
| device_monitor_report_period | int    | 上报状态周期，单位秒     |
| reporter_id                  | string | 上报的授权码，用于鉴权等 |

请求成功示例：

```json
{
    "monitor_address_list":["http://xxx.com/xx"],
    "report_period":20,
    "reporter_id":"AFVKQF000120210604151110"	
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