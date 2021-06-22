# 异步上报事件具体内容

**功能描述**

上报所有事件（数据库保存所有Event字段）给云平台。需要和监控服务器约定url，假设/EventServer/api/HistoryEvent

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| **index** | **一级参数**  | **二级参数**   | 三级参数 | 类型   | **选择** | **说明**                                                     |  举例                    |
| --------- | ------------- | -------------- | ------ | -------- | ------------------------------------------------------------ | ----------------------------------------------------- | --------- |
| 1         | identity_id   |                |                | string | **必选** | 用户编号                                                     | "13435454"                                            |
| 2         | identity_name |                |                | string | **必选** | 用户名称                                                     | "Tom"                                                 |
| 3 | identity_info | | | dict | **必选** | 人员注册的时候的信息，陌生人情况下，为空{} |  |
|  |  | face_ids | | list | **必选** | 当前的人脸ids | [] |
|  |  | image_id | | string | **必选** | 比对到的人脸底库image_id，未比对通过的情况不存在 |  |
| 4         | timestamp     |                |                | int32  | **必选** | 事件发生的时间戳                                             | 1565771454932                                         |
| 5         | score         |                |                | float  | **必选** | 比对的分数                                                   | 0.23                                                  |
| 6 | want_action | | | string | **必选** | 根据该字段判断需要进行的操作： ”0“：默认值， 不进行额外操作。 ”1001“：新的陌生人注册。 ”1002“：人脸注册底库更新。 | ”0“ |
| 7 | reg_pic | | | base64 | 可选 | 注册底库图 |  |
| 8 | spot_pic |        |        | base64 | 可选 | 现场照片                                   |                                                       |
| 9 | ir_pic |  | | base64 | 可选 | 每张人脸的红外照片 | |
| 10 | recognize_face |  |  | base | 可选 | 背景图中的每张人脸图 | |
| 11 | person_type |     |     | int    | **必选** | 1:员工（默认为员工，包括这个字段不存在的情况）<br />2: 访客<br />3: 黑名单<br />4：陌生人<br />5：VIP | 1                                                     |
| 12 | out_timestamp |  | | int | **必选** | 人员出去的时间, 单位为毫秒 |  |
| 13 | ep_info |  | | dict | **必选** | 采集设备的详细信息 | {} |
|  |  | ep_id | | string | **必选** | mq上传event的时候发送的设备id |  |
|  |               | ep_type |     | string | **必选** | 'photo':闸机或者抓拍机，<br />'rtsp':码流<br />'card':人证核验 |                                                      |
|  | | ep_ip | | string | **必选** | 产生event的设备ip |  |
|  | | ep_name | | string | **必选** | 产生event的设备name |  |
| | | device_id | | string | **必选** | 产生event的采集设备id | |
| 14 | dev_sno |         |         | string | **必选** | SE3 AI迷你机唯一标识授权码                                   |                                                       |
| 15 | recognize_face_attr |  | |  |  |  | |
|  |  | point | | list | 可选 | 人脸关键点landmark |  |
| | | age |       | string | 可选 | 年龄,  child / juvenile / youth / middle-aged /aged          | 0   <   age < 6:   儿童，child<br />6 <=  age < 18 : 少年，juvenile****<br />18 <= age < 40: 青年，youth<br /><br />40 <= age < 65: 中年，middle-aged<br /><br />65 <= age       :  老年，aged**** |
| | | mask |  | string | 可选 | 0/1/2，遮挡 |  |
| | | gender |    | string | 可选 | male/female | |
| | | glasses |   | string | 可选 | yes/no | |
| | | feature |  | list | 可选 | 提取的人脸特征值数组 | |
| | | box |  | list | 可选 | 人脸的box | |
| | | hat |  | string | 可选 | 目前暂无该算法 | |
| 16 | api_version |  | | string | 必选 | 接口版本，用于区分历史版本与当前版本 | 例: 1.0 |



**返回信息：**

```json
{
    "recognize_face_attr":{
        "gender":null,
        "point":[
            1293,
            1343,
            1318,
            1296,
            1339,
            82,
            84,
            114,
            140,
            141
        ],
        "glasses":null,
        "feature":[],
        "hat":null,
        "age":null,
        "mask":null,
        "box":[
            1261,
            31,
            1375,
            176
        ],
        "expression":null
    },
    "spot_pic":"",
    "score":6.58,
    "reg_pic":"",
    "out_timestamp":1602612038610,
    "identity_id":"1602612036.3828533",
    "timestamp":1602612036150,
    "identity_name":"stranger",
    "want_action":"0",
    "identity_info":{

    },
    "ep_info":{
        "ep_type":"rtsp",
        "ep_name":"3ran",
        "device_id":"3f09148d-b736-48fb-a29f-95bb9d23ff51",
        "ep_ip":"192.168.1.100",
        "ep_id":"0xe0a509261422__rtsp://192.168.1.100:8554/ch103"
    },
    "recognize_face":"",
    "dev_sno":"",
    "person_type":4,
    "api_version":"1.0"
}
```

**示例：**

可以使用小盒子附带的server来获取上传的事件。

假设小盒子的ip为：192.168.1.19，接收的resetful api为HistoryEvent ，端口号为9528。

那webui或是配置/修改历史事件上报接收服务器地址信息为：[http://192.168.1.19:9528/HistoryEvent](http://192.168.1.19:9528/RealTimeEvent)

启动server方法：

```shell
$ sudo -i
\# cd /system/data/sophon_gate/script
\# python3 Event_Receive_server.py
* Serving Flask app "Event_Receive_server" (lazy loading)
* Environment: production
WARNING: Do not use the development server in a production environment.
Use a production WSGI server instead.
* Debug mode: off
* Running on http://0.0.0.0:9528/ (Press CTRL+C to quit)
```

