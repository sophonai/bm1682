# 查询人员/SophonFogSys/api/users（GET）

**功能描述**

查询一个分组分组的人员，或是小盒子上所有的人员

**调用URL**

调用方法: GET

**请求参数**

| 参数        | 类型   | <font color="#dd0000">默认值</font> | 选择 | 描述                                                         | 说明                                                         | <font color="#dd0000">举例</font> |
| :---------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | :----------------------------------------------------------- | --------------------------------- |
| identity_id | string | 无                                  | 必选 | 查询人员编号。.                                              | 这两个参数是二选一，然后传递的参数中，包含着两个参数，默认查询identity_id对应的人员信息。 |                                   |
| group_name  | string | 无                                  | 必选 | 查询组内的人员信息。按照分页查询的信息                       | 这两个参数是二选一，然后传递的参数中，包含着两个参数，默认查询identity_id对应的人员信息。 | default_group                     |
| limit       | int    | 10                                  | 可选 | 可不填，默认为10条。在人员查询组内人员信息的时候，单次返回人员的个数 | 只在group_name不为"时有效。                                  | 10                                |
| skip_num    | int    | 0                                   | 可选 | 可不填，默认为0，表示第一页。                                | 只在group_name不为"时有效。                                  | 0                                 |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/users?group_name=default_group&skip_num=0&limit=10
```

**返回信息：**

请求成功

| 一级参数 | 二级参数        | 三级参数    | 四级参数 | 类型   | 选择 | 描述                                                         |
| :------- | :-------------- | :---------- | :------- | :----- | :--- | :----------------------------------------------------------- |
| data     |                 |             |          | dict   | 必选 |                                                              |
|          | identities_list |             |          | list   | 必选 | 人员信息列表，如果identity_id请求参数存在，该列表只有一条数据。 |
|          |                 | identity_id |          | string | 必选 | 人员编号，可为工号之类的                                     |
|          |                 | reg_photo   |          | base64 | 必选 | 人脸照片                                                     |
|          |                 | group_name  |          | string | 必选 | 该人员绑定的分组信息                                         |
|          |                 | info        |          | dict   | 必选 | 个人其他信息                                                 |
|          |                 |             | name     | string | 必选 | 人员名字                                                     |
|          |                 |             | type     | int    | 必选 | 1:员工（默认为员工，包括这个字段不存在的情况）<br />2: 访客<br />3: 黑名单<br />4：陌生人<br />5: VIP |

请求成功示例：

```json
{
    "data": {
        "identities_list": [
            {
                "group_name": [
                    "default_group"
                ],
                "identity_id": "888888",
                "info": {
                    "description": "",
                    "image_id": "8f5d7b5a-d5da-4b3f-bf46-5830d412ba5e",
                    "name": "小明",
                    "permission_ids": [
                        "31d637be-032e-4a68-89f6-dff91ef2cd6d"
                    ],
                    "type": 5,
                    "user_id": "888888",
                    "visit_card_number": ""
                },
                "reg_photo": ""  //base64图片数据
            },
            {
                "group_name": [
                    "default_group"
                ],
                "identity_id": "001",
                "info": {
                    "image_id": "e690d158-f41f-4eaf-a055-4ca28952aea2",
                    "name": "小王",
                    "permission_ids": [
                        "f4add9c0-4212-4064-a045-																b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"
                    ],
                    "type": 1,
                    "user_id": "001"
                },
                "reg_photo": "" //base64图片数据
            }
        ]
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
