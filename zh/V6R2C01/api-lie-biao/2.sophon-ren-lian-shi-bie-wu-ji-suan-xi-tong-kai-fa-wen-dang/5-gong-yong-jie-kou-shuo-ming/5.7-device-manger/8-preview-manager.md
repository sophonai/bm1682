# 设备预览

**版本**

2.0

**功能描述**

提供码流设备的实时预览画面图片流，包括预览背景图，人脸框坐标，人脸属性检测结果等

**调用方法**: **WebSocket**

**对接方法：**

（1）websocket端口为：ws://<IP>:5678/preview

（2）应用端，利用[获取设备信息接口](2-get-device.md)获取当前已添加的设备id(media_device_id字段)

（3）应用端选择需要进行预览的设备id，并调用[设置预览信息接口](6-set-preview.md)完成预览画面的设置

（4）如果有多个预览应用，还需要建立**ws://<IP>:54547**的控制数据链路，用于实现多应用之间的设置同步

**8080/preview ws字段说明**

**返回字段为binary，需要转成str再转成json格式**

| 一级参数        | 二级参数      | 类型   | 默认值 | 选择     | 描述                                                         | 举例 |
| :-------------- | ------------- | :----- | ------ | :------- | :----------------------------------------------------------- | ---- |
| media_device_id |               | string |        | **必传** | 产生该帧信息的设备id                                         |      |
| preview_id      |               | string |        | **必传** | 预览显示第几路                                               | "0"  |
| frame_id        |               | int    |        | **必传** | 当前帧帧号                                                   |      |
| timestamp       |               | float  |        | **必传** | 时间戳                                                       |      |
| frame_img       |               | dict   | {}     | **必传** | 选择的预览设备列表（可选择多个                               |      |
|                 | width         | int    |        | **必传** | 当前码流的宽度                                               |      |
|                 | height        | int    |        | **必传** |                                                              |      |
|                 | data          | string |        | **必传** | 一帧码流图片的jpg的base64编码数据                            |      |
| preview_objs    |               | list   | []     | **必传** | 检测到的人脸框信息                                           |      |
|                 | track_id      | int    |        | 选传     | 人脸的跟踪id                                                 |      |
|                 | detect_box    | list   | []     | 选传     | 人脸坐标位置信息[x1, y1, x2, y2]，左上右下                   |      |
|                 | identity_name | string |        | 选传     | 识别到的人脸名字,陌生人名字为“stranger”                      |      |
|                 | mask          | string |        | 选传     | 是否戴口罩                                                   |      |
|                 | age           | string |        | 选传     | 年龄<br />"child"：儿童<br />"juvenile"：少年<br />"youth"：青年<br />"middle-aged"：中年<br />"aged"：长者 |      |
|                 | gender        | string |        | 选传     | 性别"female"/"male"                                          |      |
|                 | glasses       | string |        | 选传     | 眼镜"yes"/"no"                                               |      |
| roi             |               | list   |        | 必传     | 感兴趣区域[x1,y1,x2,y2]，无的话为[]，有的话则只在感兴趣区域对人员做跟踪和识别 |      |

返回示例：

```json
{
  	"media_device_id":
    "preview_objs": [{
        "track_id": 104,
        "detect_box": [13.33445, 32.4355, 198.2343, 334.49584],
        "name": str,
        "age": "child",
        "gender": "male" ,
        "glasses": "yes"
    }, { ...
    }],
    "frame_img": {
        "width": 1920,
        "height": 1080,
        "data": "/9j/...."
    }
}
```

**54547 ws字段说明**

广播当前预览的设备列表，当前预览的详细信息比如4宫格、页面，设置源等，及设备增、删、改等事件消息

| 一级参数             | 二级参数          | 类型   | 默认值 | 选择 | 描述                                                       | 举例 |
| :------------------- | ----------------- | :----- | ------ | :--- | :--------------------------------------------------------- | ---- |
| selected_device_list |                   | list   | []     | 必传 | 选择的预览设备列表（可选择多个）                           |      |
| preview_device_list  |                   | list   | []     | 必传 | 当前预览的设备列表                                         |      |
| preview_mode         |                   | int    | 4      | 必传 | 预览模式1/4/16<br />选择当前预览为1宫格，4宫格或者是16宫格 |      |
| last_set_name        |                   | string | ''     | 必传 | 最后更新预览信息的设备名"QT"/"WEBUI"                       |      |
| modify_media_device  |                   | dict   |        | 必传 | 修改设备信息                                               |      |
|                      | action            | string |        | 必传 | "add"/"delete"/"modify"                                    |      |
|                      | media_device_info | dict   |        | 必传 | 设备信息，字段参考[设备信息字段说明](2-get-device.md)      |      |

代码示例

```p y
import websocket
import json
s = websocket.WebSocket()
s.connect('ws://192.168.1.68:54547')
while True:
  info = s.recv_data(4096)
  data = json.loads(str(info[1], encoding='utf8'))
  print("{}".format(data))
```

返回示例：

```json
{
    "modify_media_device": {
        "action": "add",
        "media_device_info": {
            "media_device_url": "192.168.1.96",
            "addtime": 1587543999.1922684,
            "media_device_ip": "192.168.1.96",
            "net_relay": {},
            "permission_id": "c732adf3",
            "media_device_type": "photo",
            "media_device_attr": {
              "do_feature": true,
              "do_attribute": false,
              "do_detect": true,
              "do_fast_mode": false,
              "do_match": true
            },
            "media_device_name": "bbb",
            "media_device_id": "772e476f-726a-455b-a642-17a4e33fd314"
        }
    },
    "last_set_name": "BOX",
    "preview_device_list": [],
    "selected_device_list": [],
    "preview_mode": "1"
}
```

