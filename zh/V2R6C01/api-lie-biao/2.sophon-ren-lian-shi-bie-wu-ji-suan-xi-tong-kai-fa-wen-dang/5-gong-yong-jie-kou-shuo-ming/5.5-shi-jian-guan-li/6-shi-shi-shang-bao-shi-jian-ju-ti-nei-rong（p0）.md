# 实时事件上报内容

**功能描述：**

SE5 AI 迷你机会实时上报比对事件到管理平台指定的URL，参见 管理平台登录接口定义。

**调用方法**: **WebSocket**

**对接方法：**

（1）websocket端口为：ws://IP:5679

（2）连接成功之后不会发送任何东西，接下来需要对ws进行配置：

主要配置以下几个字段：

| 参数名        | 类型 | 默认值 | 描述                                                         | 举例                                                         |
| :------------ | :--- | :----- | :----------------------------------------------------------- | ------------------------------------------------------------ |
| need_face     | bool | False  | 是否要返回现场人脸图，数据类型为base64编码的jpg              |                                                              |
| need_register | bool | False  | 是否需要返回注册的底库图，比对通过的情况，数据类型为base64编码的jpg |                                                              |
| event_list    | list | [ ]    | 需要实时推送的设备id数组                                     | ['04f98265-1fad-47e5-9dda-66e191272055','f9f0768f-497c-45f3-9307-ae80a9d89390'] |

（3）ws有比对事件之后，会根据配置来决定是否需要进行推送

（4）获取设备id数组的方法，其中device_id即每个设备的id：

```json
请求url: http://192.168.1.180:5555/SophonDevice/api/Devices
请求成功返回:
{
    "data": {
        "devices_list": [
            {
                "device_id": "2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd",   //设备id
                "...":"..."    //其他字段该处不需要关注
                   
            }
        ]
    }
}
```

（5）通过上面获取到的device_id，将每个设备id添加到数组event_list中，组合最终的配置:

```json
{
    'need_face':True, 
    'need_register':True, 
    'event_list':["04f98265-1fad-47e5-9dda-66e191272055", "f9f0768f-497c-45f3-9307-ae80a9d89390", "804b1218-218e-4465-8e1f-c305a5981001", "9483034a-da64-4db0-b223-64e87d5567db"]
}
```

以下是python脚本模拟的websocket客户端，供参考：

```
import websocket
import json
s=websocket.WebSocket()
s.connect('ws://192.168.1.180:5679')
config = {'need_face':True, 'need_register':True, 'event_list':["04f98265-1fad-47e5-9dda-66e191272055", "f9f0768f-497c-45f3-9307-ae80a9d89390", "804b1218-218e-4465-8e1f-c305a5981001", "9483034a-da64-4db0-b223-64e87d5567db"]}
json_data = json.dumps(config)
s.send(json_data)
while True:
	info = s.recv_data(4096)
	event = json.loads(str(info[1], encoding='utf8'))
	print("{} {}".format(event['video_id'], event['event_id']))
```

**参数描述（JSON格式）：**

| **一级参数**  | **二级参数**   | **类型** | **选择** | **说明**                                                     |  举例  |
| ------------- | -------------- | -------- | -------- | ------------------------------------------------------------ | --------------------------------- |
| identity_id   |                | string   | **必选** | 用户编号                                                     | "12345565"                        |
| device_id | | string | **必选** | 产生event的设备id， 值为uuid |  |
| identity_info | | dict | **必选** | 比对通过的情况下，返回注册的信息，陌生人情况下为空{} |  |
| identity_name |                | string   | **必选** | 用户名称                                                     | "Tom"                             |
| group_name    |                | string   | **必选** | 比对的group name，如果没有group_name返回group_id             | "default_group"                   |
| reg_pic       |                | base64   | 可选     | 注册的人脸底库，默认上传，可配置去除                         | "/9j/6QAEAAD/2wBD..."             |
| timestamp     |                | int32    | **必选** | 事件发生的时间戳                                             | 1565771454932                     |
| score         |                | float    | **必选** | 比对的分数                                                   | 0.78                              |
| ext_data      |                | dict     | **必选** | 拓展数据字段，可迭代添加                                     |                                   |
|               | device_ip      | sting    | **必选** | 设备ip                                                       | "192.168.1.101"                   |
| | recognize_face | base | 可选 | 背景图中的人脸图,默认上传 | "/9j/6QAEAAD/2xxD..." |
|               | spot_pic       | base64   | 可选     | 现场照片，迎宾机模式下不传                                   | "/9j/6QAEAAD/2wBD..."             |
|               | person_type    | int      | **必选** | 1：员工（默认为员工，包括这个字段不存在的情况）<br />2：访客<br />3：黑名单<br />4：陌生人<br />5：VIP | 1                                 |
|               | device_type    | string   | **必选** | 0：闸机 <br />1：抓拍机 <br />3：IPC 动态 <br />4：门禁 | 0                                 |

**返回信息：**

```json
{
    "reg_pic":"",
    "ext_data":{
        "person_type":5,
        "device_ip":"192.168.1.243",
        "device_type":"0",
        "spot_pic":"/9j/6QAEAAD/2xxD...",
        "recognize_face":"/9j/6QAEAAD/2wBD..."
    },
    "identity_id":"666666",
    "device_id":"04f98265-1fad-47e5-9dda-66e191272055",
    "identity_info":{
        addTime: 1594111791, 
        image_id: "5282249a-044d-43a2-9a97-0e4fee3832f5", 
        name: "stranger", 
        type: 4,…},
    "score":0.6231614351272583,
    "timestamp":1566016554020,
    "group_name":"default_group",
    "identity_name":"小明"
}
```

