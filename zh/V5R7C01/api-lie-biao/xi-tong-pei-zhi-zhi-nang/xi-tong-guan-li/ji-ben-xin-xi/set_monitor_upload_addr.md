# 配置系统状态上报 #

**功能描述**

设置SE主机系统状态上报地址和周期等配置。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/monitor

**调用方法**

POST

**请求参数**

| 参数                 | 类型   | 默认值 | 选择 | 描述                     | 举例                            |
| :------------------- | :----- | ------ | :--- | :----------------------- | ------------------------------- |
| monitor_address_list | list   | 无     | 必选 | 上报状态地址列表         | ["http://ip/xx","http://ip/xx"] |
| report_period        | int    | 无     | 必选 | 上报状态周期，单位秒     |                                 |
| dev_sno              | string | 无     | 可选 | 上报的授权码，用于鉴权等 | "AFVKQF000120210604151110"      |

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/monitor?
请求body:
	
      {
            "monitor_address_list":["http://xxx.com/xx"],
            "report_period":20,
			"dev_sno":"AFVKQF000120210604151110"
      }
    
```

**返回信息：**

请求成功：

| 一级参数 | 二级参数             | 类型   | 描述                     |
| :------- | :------------------- | :----- | :----------------------- |
| data     |                      | dict   |                          |
|          | monitor_address_list | list   | 上报状态地址列表         |
|          | report_period        | int    | 上报状态周期，单位秒     |
|          | dev_sno              | string | 上报的授权码，用于鉴权等 |

请求成功示例：

```json
{
    "data":{
            "monitor_address_list":["http://xxx.com/xx"],
            "report_period":20,
			"dev_sno":"AFVKQF000120210604151110"
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
