# 获取多个识别记录/sophon/v2/face/getevents（POST）

**版本**

2.0

**功能描述**

模糊搜索多个识别记录的详细信息。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getevents

调用方法: POST

**请求参数**

| 一级参数 | 二级参数 | 类型   |   默认值   | 选择 | 描述                                                         |   举例   |
| :------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- | -------- |
| filters |  | dict | | 可选 | 查询event的过滤条件 |  |
|  | datetime_gte | timestamp | | 可选 | 搜索大于等于这个时间戳的event（单位为ms） | 1607430334 |
|  | datetime_lte | timestamp | | 可选 | 搜索小于等于这个时间戳的event（单位为ms） | 1607430334 |
|  | identity_name | string | | 可选 | 根据用户名来检索（模糊匹配） | "test1" |
|  | identity_id | string | | 可选 | 根据用户id来检索（精准匹配） | "1244354" |
|  | score_min | float | | 可选 | 根据用户分数来检索，大于等于这个分数 | 82 |
|  | score_max | float | | 可选 | 根据用户分数来检索，小于等于这个分数 | 83 |
|  | user_type | string | | 可选 | 根据用户类型来检索（employee，VIP，stranger） | employee |
|  | media_device_ids | list | | 可选 | 根据设备id来检索 | ["device_id1","device_id2"] |
| page_limit |  | int | 10 | 可选 | 每页返回的条数                 | 10 |
| page_index |  | int | 0 | 可选 | 返回第几页 | 0 |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getevents
请求方法：POST
请求body:
{
  "page_limit":10,
  "page_index":0
}
```



**返回信息：**

请求成功

| 一级参数   | 二级参数    | 类型 | 描述                                                         |
| :--------- | :---------- | :--- | :----------------------------------------------------------- |
| events     |             | list | event列表（event字段详情参加[event字段说明](13-event-detail.md)） |
| pagination |             | dict | page信息                                                     |
|            | page_index  | int  | 当前第几页                                                   |
|            | page_limit  | int  | 每页的数量                                                   |
|            | total_count | int  | event的总数量                                                |

请求成功示例：

```json
{
    "events": [
        {
            "event_id": "1628066406652506",
            "ext_data": {
                "in_timestamp": 1628066406.608026,
                "recognition_timestamp": 1628066406.608026
            },
            "frame_id": 0,
            "identity_id": "",
            "identity_name": "",
            "media_device_info": {
                "media_device_id": "",
                "media_device_ip": "",
                "media_device_name": "",
                "media_device_type": ""
            },
            "permission_id": "",
            "permission_name": "",
            "post_action": "0",
            "recognize_face_attr": {
                "age": null,
                "box": [
                    169.91207885742188,
                    256.9922180175781,
                    487.3203430175781,
                    671.7279663085938
                ],
                "expression": null,
                "feature_binary": "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",
                "gender": null,
                "glasses": null,
                "hat": null,
                "mask": null,
                "point": []
            },
            "recognize_face_image_id": "001628066406.650539",
            "register_image_id": "",
            "score": 27.69,
            "spot_image_id": "001628066406.650539",
            "timestamp": 1628066406.608026,
            "user_type": "stranger"
        }
    ],
    "pagination": {
        "page_index": 0,
        "page_limit": 10,
        "total_count": 1
    }
}
```



**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码            | message    | 描述                                                         |
| ----- | ----------------- | ---------- | ------------------------------------------------------------ |
| 1     | INVALID_ARGUMENTS | <key_name> | 无效的参数。<br /><key_name> : 参数信息在message字段中描述。 |

