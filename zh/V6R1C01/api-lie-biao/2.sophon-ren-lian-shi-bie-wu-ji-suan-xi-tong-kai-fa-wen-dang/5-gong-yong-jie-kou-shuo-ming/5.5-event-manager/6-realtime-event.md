# 实时上报识别记录

**版本**

2.0

**功能描述：**

SE系列AI计算盒会可以将当前实时比对记录上报给客户应用软件，以便客户应用可以根据比对结果，进行下一步的操作。

考虑到性能，实时上报接口以websocket的方式进行交互。具体的上报信息字段定义如下：


**调用方法**: **WebSocket**

**对接方法：**

（1）实时比对记录的websocket服务端口为：ws://IP:5679

（2）在连接成功后，服务器端不会发送任何信息。接下来需要客户端通过websocket对服务器进行配置：

主要配置以下几个字段：

| 参数名              | 类型 | 默认值 | 描述                                                         | 举例                                                         |
| :------------------ | :--- | :----- | :----------------------------------------------------------- | ------------------------------------------------------------ |
| with_face_image     | bool | false  | 是否要返回现场人脸图数据 ，类型为base64编码的jpg<br />true:返回现场人脸图 <br />false:不返回现场人脸图<br /> |                                                              |
| with_register_image | bool | false  | 是否需要返回注册的底库图，数据类型为base64编码的jpg<br />true:返回底库人脸图 <br />false:不返回底库人脸图<br /> |                                                              |
| media_device_ids    | list | [ ]    | 用于选择哪些设备需要推送event（可通过getmediadevices接口获取）                              | ['04f98265-1fad-47e5-9dda-66e191272055','f9f0768f-497c-45f3-9307-ae80a9d89390'] |

（3）当系统产生识别记录后，会实时将当前识别结果推送至客户端。
```json
{
    'with_face_image':True, 
    'with_register_image':True, 
    'media_device_ids':["04f98265-1fad-47e5-9dda-66e191272055", "f9f0768f-497c-45f3-9307-ae80a9d89390", "804b1218-218e-4465-8e1f-c305a5981001", "9483034a-da64-4db0-b223-64e87d5567db"]
}
```

websocket客户端参考代码(python)：

```
import websocket
import json
s=websocket.WebSocket()
s.connect('ws://192.168.1.180:5679')
config = {'with_face_image':True, 'with_register_image':True, 'media_device_ids':["04f98265-1fad-47e5-9dda-66e191272055", "f9f0768f-497c-45f3-9307-ae80a9d89390", "804b1218-218e-4465-8e1f-c305a5981001", "9483034a-da64-4db0-b223-64e87d5567db"]}
json_data = json.dumps(config)
s.send(json_data)
while True:
	info = s.recv_data(4096)
	event = json.loads(str(info[1], encoding='utf8'))
	print("{}".format(event))
```

**参数描述（JSON格式）：**

| **一级参数**  | **二级参数**   | **类型** | **选择** | **说明**                                                     |  举例  |
| ------------- | -------------- | -------- | -------- | ------------------------------------------------------------ | --------------------------------- |
| event_id |  | string | **必传** | event事件的唯一标识id |  |
| timestamp |  | int32 | **必传** | 本次事件时间戳（ms） | 1565771454932 |
| identity_id   |                | string   | **必传** | 本次识别到的用户的id                                        | "100000"                        |
| identity_name | | string | **必传** | 用户名称 | "小王" |
| user_type |              | string | **必传** | 人员类型<br />"employee": 员工<br />"visitor": 访客<br />"blacklist": 黑名单<br />"stranger"：陌生人<br />"vip": VIP | "employee" |
| score         |                | float    | **必传** | 本次比对的得分                                                   | 82.05                       |
| media_device_ip |  | sting | **必传** | 设备ip | "192.168.1.101" |
| media_device_id |  | string | **必传** | 本次事件产生的设备id， 值为uuid |  |
| media_device_type |     | string   | **必传** | "photo"<br />"rtsp"<br />"file"<br /> | "rtsp"                        |
| register_image |                | base64   | 选传   | 注册的人脸底库，默认上传，可配置去除                         | "data:image/jpeg;base64,/9j/6QAEAAD/2wBD..." |
| recognize_face_image |  | base | 选传 | 现场照片的人脸抠图 | "data:image/jpeg;base64,/9j/6QAEAAD/2xxD..." |
| recognize_face_attr |  | dict | 选传 | 人脸属性信息，包括性别，年龄，眼镜等信息 |  |

**实时推送信息举例：**

```json
{
    "reg_pic":"",
  	"media_device_ip":"192.168.1.243",
  	"media_device_type":"rtsp",
  	"recognize_face_image":"data:image/jpeg;base64,/9j/6QAEAAD/2xxD...",
    "identity_id":"666666",
    "media_device_id":"04f98265-1fad-47e5-9dda-66e191272055",
    "score":0.6231614351272583,
    "timestamp":1566016554020,
    "identity_name":"小明"
}
```

