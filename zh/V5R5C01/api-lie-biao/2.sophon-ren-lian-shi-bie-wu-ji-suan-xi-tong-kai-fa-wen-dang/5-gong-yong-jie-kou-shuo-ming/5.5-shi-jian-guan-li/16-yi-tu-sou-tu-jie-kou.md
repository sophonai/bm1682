# 以图搜图接口/SophonMatch/api/picturesearch(POST)

**功能描述**

输入一张人脸图，在历史记录里面进行搜索，找到匹配的记录(endtime-starttime必须小于一个月，不设置时间，默认搜索24小时以内的记录)

按照时间顺序返回，最多搜索5w条数据，1000个结果。

**调用URL**

调用方法: POST

**请求参数**

| 参数名称           | 二级参数 | 类型    | 默认值 | 选项 | 说明                                                         |
| :----------------- | :------- | :------ | :----- | :--- | :----------------------------------------------------------- |
| face_image_base64  |          | string  |        | 必选 | 现场人脸图jpg base64编码数据（取最大人脸）                   |
| fiqa_level         |          | string  |        | 可选 | 是否需要通过图像质量检测（'no'/'low'/'middle'/'high'),默认为no |
| with_debug_info    |          | boolean |        | 可选 | 是否需要debug的时间信息，默认为False                         |
| starttime          |          | time    |        | 可选 | 搜索的起始时间(不填默认为一天前的当前时间)                   |
| last_end_timestamp |          | time    |        | 可选 | 上一次搜索返回的时间点，如果为null就从starttime开始搜索      |
| threshold          |          | float   |        | 可选 | 相识度（默认为82）                                           |
| endtime            |          | time    |        | 可选 | 搜索的结束时间(不填默认为当前时间)                           |
| device_id_list     |          | list    |        | 可选 | 设备id列表（不填则搜索所有设备event）                        |
| reverse            |          | boolean |        | 可选 | 查询顺序，默认为True：倒序（从endtime开始查询）False：顺序（从starttime开始查询） |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonMatch/api/picturesearch
```

**返回信息：**

请求成功

| 字段         | 类型    | 说明                           |
| :----------- | :------ | :----------------------------- |
| retcode      | string  | “0”：失败“1”：成功             |
| have_more    | boolean | False:搜索完成True：未搜索完成 |
| total_time   | float   | 搜索所用的时间                 |
| endtimestamp | time    | 这次搜索结束的时间戳           |
| event_list   | list    | 比对结果的event的list          |

返回示例

```json
{
  "endtimestamp": 1598218558.7525,
  "event_list": [{
    "identity_name": "stranger", 
    "recognize_face_attr": {
      "mask": null, 
      "expression": null, 
      "point": [708, 790, 759, 728, 796, 335, 322, 378, 424, 414], 
      "hat": null, 
      "glasses": null, 
      "gender": null, 
      "box": [650, 217, 839, 463], 
      "age": null}, 
    "timestamp": 1598235461.8929, 
    "recognize_face_pic_id": "1598235465.0562618", 
    "identity_info": {}, 
    "spot_pic_id": "1598235465.0563743", 
    "score": 0.1, 
    "ep_info": {
      "ep_type": "rtsp", 
      "ep_ip": "192.168.1.100", 
      "ep_name": "2ran", 
      "device_id": "a05b7733-91cb-4075-a1f1-840556f426a2", 
      "ep_id": "0xe0a509001092__rtsp://192.168.1.100:8554/ch102"}, 
    "out_timestamp": 1598235465.056694, 
    "identity_id": "", 
    "compare_score": 0.9167486565892832, 
    "person_type": 4}],
  "ret_code": 1,
  "total_time": 107.0144555568695,
  "total_count": 1000
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

以图搜图event_list字段说明

|       参数名称        | 二级参数名称 | 类型   | 必须（Y/N） | 默认值                | 说明                                                         |
| :-------------------: | :----------- | :----- | :---------: | :-------------------- | :----------------------------------------------------------- |
|     compare_score     |              | float  |      Y      | 0                     |                                                              |
|       timestamp       |              | 时间戳 |      Y      | 系统生成              | event创建的时间                                              |
|     identity_name     |              | string |      Y      | stranger              | 比对到的人名，陌生人的情况下为“stranger” or 随机库出来的名字 |
|      identity_id      |              | string |      Y      | ""                    | 识别通过的情况下，为识别到的identity_id,否则为空字符串""     |
|     identity_info     |              | dict   |      Y      | {}                    | 人员注册的时候的信息，陌生人情况下，为空字典                 |
|                       | face_ids     | list   |      Y      | []                    | 当前identity_info face字段                                   |
|                       | image_id     | string |      Y      | ""                    | 比对到的人脸底库image_id，未比对通过的情况不存在             |
| recognize_face_pic_id |              | string |      Y      | ""                    | 比对到的现场扣脸图id                                         |
|      spot_pic_id      |              | string |      Y      | ""                    | 比对的现场背景图id                                           |
|      person_type      |              | int    |      Y      | 1                     | 1：员工（默认为员工，包括这个字段不存在的情况） 2：访客 3：黑名单 4：陌生人 5：VIP |
|         score         |              | float  |      Y      | 0.0                   | 比对的分数结果                                               |
|        ep_info        |              | dict   |      Y      | {}                    | 采集设备的详细信息                                           |
|                       | ep_id        | string |      Y      | ""                    | mq上传event的时候发送的设备id                                |
|                       | ep_type      | int    |      Y      | "photo"/'rtsp'/'card' | 'photo':闸机或者抓拍机'rtsp':码流'card':人证核验             |
|                       | ep_ip        | string |      Y      | ""                    | 产生event的设备ip                                            |
|                       | ep_name      | string |      Y      | ""                    | 产生event的设备name                                          |
|                       | device_id    |        |             |                       | 产生event的采集设备id                                        |
|  recognize_face_attr  |              | dict   |      Y      | {}                    |                                                              |
|                       | point        | list   |      Y      | []                    |                                                              |
|                       | box          | list   |      Y      | []                    | 人脸的box                                                    |
|                       | mask         | string |             |                       | 0/1/2                                                        |
|                       | gender       | string |             |                       | male / female                                                |
|                       | hat          | string |             |                       |                                                              |
|                       | age          | string |             |                       | child / juvenile / youth / middle-aged /aged                 |
|                       | glasses      | string |             |                       | yes / no                                                     |
|                       | feature      | [ ]    |             | []                    | 删除，太大                                                   |
|     out_timestamp     |              | time   |      N      | 无                    | 人员出去的时间                                               |