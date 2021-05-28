# 查询人员/SophonFogSys/api/users（GET）

**功能描述**

查询一个分组分组的人员，或是小盒子上所有的人员

**调用URL**

http://192.168.1.180:5555/SophonFogSys/api/users

调用方法: GET

**请求参数**

| 参数        | 类型   |   默认值   | 选择 | 描述                                                         | 说明                                                         |  举例  |
| :---------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | :----------------------------------------------------------- | --------------------------------- |
| identity_id | string | 无                                  | 可选 | 查询人员编号                                              | 人员的唯一标识 |                                   |
| identity_name | string | 无 | 可选 | 查询人员名称 |  | |
| group_name  | string | 无                                  | 必选 | 查询组内的人员信息。按照分页查询的信息                       |  | default_group                     |
| limit       | int    | 10                                  | 可选 | 可不填，默认为10条。在人员查询组内人员信息的时候，单次返回人员的个数 |                                   | 10                                |
| skip_num    | int    | 0                                   | 可选 | 可不填，默认为0，表示第一页。                                |                                   | 0                                 |

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
|          |                 | group_name  |          | list   | 必选 | 该人员绑定的分组信息                                         |
|          |                 | info        |          | dict   | 必选 | 个人其他信息                                                 |
|          |                 |             | name     | string | 必选 | 人员名字                                                     |
|          |                 |             | type     | int    | 必选 | 1:员工（默认为员工，包括这个字段不存在的情况）<br />2: 访客<br />3: 黑名单<br />4：陌生人<br />5: VIP |
|          | pagination      |             | dict     |        |      | 分页数据                                                     |
|          |                 | skip_num    |          | int    | 必选 | 分页查询的起始点                                             |
|          |                 | limit       |          | int    | 必选 | 分页查询每一页的数量                                         |
|          |                 | num_pages   |          | int    | 必选 | 总共有多少页的数据                                           |
|          |                 | total_count |          | int    | 必选 | 数量总量                                                     |

请求成功示例：

```json
{
    "data": {
        "identities_list": [
            {
                "group_name": ["default_group"],
                "identity_id": "6666662",
                "info": {
                    "ext_info": {
                        "address": "",
                        "building_no": "",
                        "comeFrom": "",
                        "department": "",
                        "description": "",
                        "email": "",
                        "floor": "",
                        "gender": "",
                        "hasMore": false,
                        "idNumber": "",
                        "interviewee": "",
                        "jobNumber": "",
                        "message": "",
                        "mobile": "",
                        "purpose": "",
                        "room": "",
                        "title": "",
                        "visit_card_number": ""
                    },
                    "face_ids": [
                        "586f54e8-092b-4850-8d73-fc4fa3dd1072"
                    ],
                    "group_ids": [
                        "default_group"
                    ],
                    "image_id": "aaa4b182-8af2-4d66-9674-ab7b312343e7",
                    "image_ids": [
                        "aaa4b182-8af2-4d66-9674-ab7b312343e7"
                    ],
                    "name": "a3",
                    "permission_ids": [],
                    "permission_names": [],
                    "type": 1,
                    "user_id": "6666662"
                },
                "reg_photo": ""
            }
        ],
        "pagination": {
            "limit": 10,
            "num_pages": 1,
            "skip_num": 0,
            "total_count": 1
        }
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
