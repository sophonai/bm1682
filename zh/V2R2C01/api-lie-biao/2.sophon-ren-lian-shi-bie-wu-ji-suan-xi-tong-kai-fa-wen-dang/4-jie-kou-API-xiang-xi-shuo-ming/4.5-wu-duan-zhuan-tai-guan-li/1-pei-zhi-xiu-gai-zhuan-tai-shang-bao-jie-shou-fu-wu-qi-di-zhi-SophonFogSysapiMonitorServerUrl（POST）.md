# 配置/修改状态上报接收服务器地址/SophonFogSys/api/MonitorServerUrl（POST）

**功能描述**

配置监控服务器的地址。

**调用URL**

调用方法: POST

**请求参数（JSON格式，form-data格式）**

| 参数               | 类型   | <font color="#dd0000">默认值</font> | 选择 | 描述                                                         | <font color="#dd0000">举例</font> |
| :----------------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| monitor_server_url | string |                                     | 必选 | 状态管理服务器地址，类似[http://192.168.1.100:9828/EventServer/api/](http://192.168.1.100:9828/EventServer/api/SophonFogRelEvent)SophonFogStatus |                                   |
| content-type       | string |                                     | 必选 | 用来设置 requst 时以哪一种content type发送，参数为：[json,form-data]。(目前只支持json格式) |                                   |
| reported_peroid    | int    |                                     | 必选 | 上报状态的周期                                               |                                   |

**返回信息：**

请求成功

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| data     |          | string | 消息（ok） |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
