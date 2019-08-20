# 获取状态上报接收服务器地址/SophonFogSys/api/MonitorServerUrl（GET）

**功能描述**

获取监控服务器的地址。

**调用URL**

调用方法: GET

**请求参数**

无

 **返回信息：**

请求成功



| 一级参数 | 二级参数           | 类型   | <font color="#dd0000">默认值</font> | 描述                                                         | <font color="#dd0000">举例</font> |
| :------- | :----------------- | :----- | ----------------------------------- | :----------------------------------------------------------- | --------------------------------- |
| data     |                    | string |                                     | 消息                                                         |                                   |
|          | monitor_server_url | string |                                     | 状态管理服务器地址，类似[http://192.168.1.100:9828/EventServer/api/](http://192.168.1.100:9828/EventServer/api/SophonFogRelEvent)SophonFogStatus |                                   |
|          | reported_peroid    | int    |                                     | 上报状态的周期                                               |                                   |

​       请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

