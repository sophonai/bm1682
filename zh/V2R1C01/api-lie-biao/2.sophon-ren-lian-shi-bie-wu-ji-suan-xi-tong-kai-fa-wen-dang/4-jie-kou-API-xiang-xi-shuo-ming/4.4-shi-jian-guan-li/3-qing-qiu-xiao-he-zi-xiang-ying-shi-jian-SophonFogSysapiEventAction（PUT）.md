# 请求小盒子响应事件/SophonFogSys/api/EventAction（PUT）

**功能描述**

请求小盒子响应事件，暂时作用于网络继电器

**调用URL**

调用方法: PUT

**请求参数（JSON格式，form-data格式）目前只支持JSON格式**

| Index | 一级参数 | 二级参数        | 类型   | <font color="#dd0000">默认值</font> | 选择 | 描述                                                         | <font color="#dd0000">举例</font> |
| :---- | :------- | :-------------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| 1     | action   |                 | list   |                                     | 必选 | 对应每个终端设备的控制                                       |                                   |
|       |          | action_ip       | string |                                     | 必选 | edge 设备终端地址                                            |                                   |
|       |          | action_port     | string |                                     | 必选 | edge 设备终端控制端口号（eg：5555）                          |                                   |
|       |          | action_mode     | string |                                     | 必选 | [[opendoor, closedoor，alarm,...](https://info.bitmain.vip:8443/pages/createpage.action?spaceKey=AIBOX&title=opendoor%2Cclosedoor%2Calarm%2C...&linkCreation=true&fromPageId=59841178)] |                                   |
|       |          | action_duration | int    |                                     | 可选 | 表示动作的持续时间，目前只在Opendoor模式下面有效。默认为5，表示开门5s之后，关门。如果是255，表示长开。(长开功能目前不支持) |                                   |
|       |          | logic_port      | int    |                                     | 可选 | 网络继电器控制端口 默认为0，表示网络继电器的所有控制门全开。 |                                   |

**返回信息：**

请求成功

| 一级参数 | 二级参数    | 类型   | 描述           |
| :------- | :---------- | :----- | :------------- |
| data     | message     | string | 消息           |
|          | action_mode | string | 设置的动作模式 |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |