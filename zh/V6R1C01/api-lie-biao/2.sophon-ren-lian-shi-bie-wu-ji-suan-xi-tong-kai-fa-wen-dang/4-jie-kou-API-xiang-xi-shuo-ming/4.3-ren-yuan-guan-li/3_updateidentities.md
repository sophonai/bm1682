# 查询人员列表/sophon/v2/face/getidentities(POST)

**版本**

2.0

**功能描述**

查询一个分组的人员，或是小盒子上所有的人员

**调用URL**

调用方法: POST

**请求参数**

| 一级参数 | 二级参数      | 类型   |   默认值   | 选择 | 描述                                                         | 说明                                                         |  举例  |
| :---------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | :----------------------------------------------------------- | --------------------------------- | ----------- |
| filters |  | dict |  | 可选 | 如果为空，返回所有的人员信息。 |  |  |
|  | permission_id_list | []<br />array of string | 无                                  | 可选 | 查询组内的人员信息。按照分页查询的信息                       | 如果该参数为空，则返回所有的人员信息 |                      |
|  | identity_name | string | 无 | 可选 | 根据姓名作模糊查询 |  | |
|  | identity_id | string | 无 | 可选 | 人员唯一标识 |  | |
| page_limit |        | int    | 10                                  | 可选 | 可不填，默认为10条。在人员查询组内人员信息的时候，单次返回人员的个数 | 只在group_name不为"时有效。                                  | 10                                |
| page_index |                    | int    | 0                                   | 可选 | 可不填，默认为0，表示第一页。                                | 只在group_name不为"时有效。                                  | 0                                 |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/users?group_name=default_group&skip_num=0&limit=10
```

**返回信息：**

请求成功

| 参数       | 类型                      | 描述     |
| :--------- | :------------------------ | :------- |
| identities | []<br />array of identity | 人员列表 |

人员identity字典结构:

| 项目               | 类型   | 描述                                                         |
| :----------------- | :----- | :----------------------------------------------------------- |
| identity_id        | string | 人员编号，可为工号之类的                                     |
| identity_name      | string | 人员名称                                                     |
| user_type          | string | "employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP |
| permission_ids     | list   | 权限组id列表, 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"] |
| ext_info           | dict   | 其他的用户信息                                               |
| face_ids           | list   | 绑定到该人员的人脸id列表                                     |
| register_image_ids | list   | 绑定到该人员的注册照片id列表，注册照片和face_id_list中的人脸是一一对应的。 |

请求成功示例：

```json
{
        "identities": [
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
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
