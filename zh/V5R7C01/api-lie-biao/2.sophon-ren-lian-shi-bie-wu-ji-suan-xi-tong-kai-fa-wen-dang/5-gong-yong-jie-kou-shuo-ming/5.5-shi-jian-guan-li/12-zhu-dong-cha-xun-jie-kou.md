# 主动查询接口/SophonFace/api/events（GET）

**功能描述**

查询盒子上event记录。

**调用URL**

调用方法: GET

**请求参数**

| 一级参数 | 类型   |   默认值   | 选择 | 描述                                                         |   举例   |
| :------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| per_page | int |  | 可选 | 每页返回的条数                 | 10 |
| page | int | | 可选 | 返回第几页 | 0 |
| top_k | int | | 可选 | 取前面多少个结果 | 1000 |
| datetime_gte | timestamp | | 可选 | 搜索大于等于这个时间戳的event（单位为秒） | 1607430334 |
| datetime_lte | timestamp | | 可选 | 搜索小于等于这个时间戳的event（单位为秒） | 1607430334 |
| name | string | | 可选 | 根据用户名来检索（模糊匹配） | "test1" |
| identity_id | string | | 可选 | 根据用户id来检索（精准匹配） | "1244354" |
| score_min | float | | 可选 | 根据用户分数来检索，大于等于这个分数 | 82 |
| score_max | float | | 可选 | 根据用户分数来检索，小于等于这个分数 | 83 |
| userType | int | | 可选 | 根据用户类型来检索（陌生人，VIP） | 1/2/4 |
| room | string | | 可选 | 根据房间号来检索 | "1004" |
| groups | list | | 可选 | 根据用户组id来检索 | ["id1","id2"] |
| streams | list | | 可选 | 根据设备id来检索 | ["device_id1","device_id2"] |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFace/api/events?per_page=10&page=0
```



**返回信息：**

请求成功

| 一级参数   | 二级参数    | 类型 | 描述                                        |
| :--------- | :---------- | :--- | :------------------------------------------ |
| data       |             | list | event列表（event字段详情参加event字段说明） |
| pagination |             | dict | page信息                                    |
|            | num_pages   | int  | 总页数                                      |
|            | page        | int  | 当前第几页                                  |
|            | per_page    | int  | 每页的数量                                  |
|            | total_count | int  | event的总数量                               |

请求成功示例：

```json
{
    "data": [
        {
            "_id": "1607062639.737444",
            "common": {
                "card_id": "",
                "ep_info": {
                    "device_id": "a853043e-c10a-4af3-96e5-f646748faed4",
                    "ep_id": "0xe0a509261422__192.168.1.96",
                    "ep_ip": "192.168.1.96",
                    "ep_name": "111",
                    "ep_type": "photo"
                },
                "frame_id": 0,
                "group_id": "",
                "group_name": "",
                "identity_id": "",
                "identity_info": {},
                "identity_name": "",
                "is_send": 0,
                "permission_id": "",
                "permission_name": "",
                "person_type": 4,
                "recognize_face_attr": {
                    "age": null,
                    "box": [
                        48.000728607177734,
                        15.041580200195312,
                        171.80174255371094,
                        189.5286102294922
                    ],
                    "expression": null,
                    "feature": [
                        ...
                        -0.012911844067275524,
                        -0.035866234451532364,
                        0.06599386781454086,
                        -0.004303948022425175
                    ],
                    "gender": null,
                    "glasses": null,
                    "hat": null,
                    "mask": null,
                    "point": []
                },
                "recognize_face_pic_id": "1607062639.7370062",
                "score": 10.15,
                "spot_pic_id": "1607062639.7370062",
                "want_action": "0"
            },
            "gate_data": {},
            "grab_data": {},
            "timestamp": 1607062639.7013178,
            "video_data": {}
        },
        ...
    ],
    "pagination": {
        "num_pages": 21017,
        "page": 0,
        "per_page": 5,
        "total_count": 105085
    }
}
```



请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |