## 异步上报识别记录

**功能描述**

如果应用平台对于比对记录无实时要求，可将SE AI计算盒事件上报配置为异步上报模式。与实时上报API相比，异步上报API接口虽然比实时上报API速度稍慢（实时上报API是豪秒级推送，异步上报API为秒级），但却会推送更加全面的数据比应用平台。比如在异步上报中，会将每次比对事件的三张图（现场大图，现场大图的人脸抠图和注册底库图）均做上报，而实时上报API则会从网络传输速度考量，仅上传人脸抠图和底库注册照片小图。具体差异，请对比两个API的字段描述。

注意：

此API定义的信息为AI计算盒发送，由客户应用平参参照如下字段定义按需接收。客户应用平台的接收url由客户平台定义并配置至SE AI计算盒。

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| **index** | **一级参数**  | **二级参数**    | 类型   | **选择** | **说明**                                                     |  举例                    |
| --------- | ------------- | -------------- | -------- | ------------------------------------------------------------ | ----------------------------------------------------- | --------- |
| 1 | api_version |  |  string | **必选** | 接口版本，用于区分历史版本与当前版本 | "1.0" |
| 2        | identity_id   |                |                string | **必选** | 本次识别到的用户的id                                                     | "13435454"                                            |
| 3         | identity_name |                |                string | **必选** | 本次识别到的用户的姓名                                                     | "Tom"                                                 |
| 4       | timestamp     |                |  int32  | **必选** | 本次识别事件的时间戳(ms)                                   | 1565771454932                                         |
| 5         | score         |                |float  | **必选** | 本次识别事件的比对得分                                                   | 0.23                                                  |
| 6 | post_action | |string | **必选** | 根据该字段判断需要进行的操作： </br>”0“：默认值， 不进行额外操作。 </br>”1001“：新的陌生人注册。 </br>”1002“：人脸注册底库更新。 | ”0“ |
| 7 | user_type           |     |string | **必选** | 人员类型</br>"employee": 员工</br>"visitor": 访客</br>"blacklist": 黑名单</br>"stranger"：陌生人</br>"vip": VIP |   "employee" |
| 8 | in_timestamp | | |  | **必选** | 目标人员进入画面的时间戳(ms) |  |
| 9 | out_timestamp |  |int | **必选** | 目标人员离开画面的时间戳(ms) |  |
| 10 | media_device_info |  |dict | **必选** | 前端图像采集设备的详细信息 | {} |
|  |  | media_device_id |string | **必选** | 采集设备的唯一标识 |  |
|  |  | media_device_type |string | **必选** | 采集设备类型：</br>"photo"</br>"rtsp"</br>"file" |     "rtsp"                                  |
|  | | media_device_ip |string | **必选** | 采集设备的IP |  |
|  | | media_device_name |string | **必选** | 采集设备的名称 |  |
| | | media_device_url | |  | **必选** | 采集设备的url | rtsp<br />file<br />ip<br /> |
| 11 | mq_license_key |         |string | **必选** | 边缘计算盒唯一标识码                          |                                                       |
| 12 | reg_image | |base64 | 可选 | 本次比对返回的注册底库照片(base64编码) | |
| 13 | spot_image | |base64 | 可选 | 本次比对返回的现场全景图(base64编码) | |
| 14 | ir_image | |base64 | 可选 | 本次比对返回的红外照片(base64编码) | |
| 15 | recognize_face_image | |base64 | 可选 | 本次比对返回的现场人脸抠图(base64编码) | |
| 16 | recognize_face_attr |  |  |  |  | |
|    |                     | point                 | list      | []       | 人脸关键点landmark                                            |                     |
|    |                     | box                   | list      | []       | 人脸位置                                                     |                     |
|  |                       | mask                  | string    | ""       | 口罩: 是否有戴口罩。 "yes", "no"                              |                     |
|  |                       | gender                | string    | ""       | 性别："male", "female"                                                |  "male"                 |
|  |                       | hat                   | string    | ""       | 帽子: 是否有帽子（算法未ready）                                    |                     |
|  |                       | age                   | string    | ""       | 年龄段："child","juvenile", "youth", "middle-aged" "aged"           | "child"                    |
|  |                       | glasses               | string    | ""       | 眼镜：是否有戴眼镜。"yes", "no"                                    | "yes"                |
|  |                       | feature_binary        | string    | ""       | 本次识别时提取的人脸特征值base64编码                                        |                     |


**返回信息：**

```json
{
    "api_version":"2.0",
    "identity_id":"01200002",
    "timestamp":1629080261881,
    "identity_name":"小明",
    "media_device_info":{
        "media_device_ip":"172.28.9.38",
        "media_device_type":"rtsp",
        "media_device_name":"前门设备",
        "media_device_id":"fb4eb129a3d64f0a81a04a00e36547b1"
    },
    "in_timestamp":1629080261881,
    "recognize_face_image":"/9j/2wBDAAUDBAQEAwUEBAQFBQUxxxx",
    "ir_image":"",
    "post_action":"0",
    "user_type":"employee",
    "spot_image":"/9j/2wBDAAUDBAQEAwUEBAQFBxxx",
    "out_timestamp":1629080265454,
    "score":94.8,
    "reg_image":"/9j/2wBDAAUDBAQEAwUEBAxxxx",
    "mq_license_key":"NAAXWN000120210813164813",
    "recognize_face_attr":{
        "gender":null,
        "hat":null,
        "box":[
            50,
            23,
            173,
            183
        ],
        "glasses":null,
        "feature_base64_str":"r6Y8Pa+mPL0AAAAABTBqvQMgHxxxxxxx",
        "mask":null,
        "expression":null,
        "age":null,
        "point":[
            81.970268,
            89.392395,
            139.55658,
            85.893242,
            114.693291,
            117.882332,
            92.841652,
            150.745514,
            138.496735,
            146.930984
        ]
    }
    
}
```
