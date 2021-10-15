# 更新人员基础信息/sophon/v2/face/updateidenity (POST)

**版本**

2.0

**功能描述**

更新指定人员的基础信息，如名称、人员类型，权限组及人员的其他信息等。

注意:该api，同一个字段信息只会替换。建议更新人员之前，先通过getidentity获取到人员信息，然后基于获取结果选择性作信息更新；

**调用URL**

调用方法: POST

**请求参数（JSON格式）**

| 一级参数       | 类型   | 默认值     | 选择 | 描述                                                         | 举例         |
| :------------- | :----- | ---------- | :--- | :----------------------------------------------------------- | ------------ |
| identity_id    | string | 无         | 必选 | 人员编号，可为工号之类的                                     | ”001“        |
| identity_name  | string | "佚名"     | 可选 | 人员名称                                                     | “小王“       |
| user_type      | string | "employee" | 可选 | 人员类型<br />"employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP | 1            |
| permission_ids | list   | []         | 可选 | 该人员具备权限组， 此处为列表 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"]<br />权限组列表中的权限组应当事先创建完成。 | ["f4add9c0"] |
| ext_info       | dict   | {}         | 可选 | 该人员其他信息                                               |              |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/users
请求body:
	{
  "info":{"name":"小明","type":1,"aaa":1,"permission_ids":["f4add9c0-4212-4064-a045-					b6185cf00501","bb982244-ce4e-469d-ab5f-34314dd0c09a"]},
  "identity_id":"001",
  "reg_photo":""
	
}
```

**返回信息：**

**请求成功**

| 参数               | 类型   | 描述                                                         |
| :----------------- | :----- | :----------------------------------------------------------- |
| identity_id        | string | 人员编号，可为工号之类的                                     |
| identity_info      | dict   | 个人其他信息                                                 |
| identity_name      | string | 人员名称                                                     |
| user_type          | string | "employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP |
| permission_ids     | list   | 权限组id列表, 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"] |
| ext_info           | dict   | 其他的用户信息                                               |
| face_ids           | list   | 绑定到该人员的人脸id列表                                     |
| register_image_ids | list   | 绑定到该人员的注册照片id列表，注册照片和face_id_list中的人脸是一一对应的。 |

请求成功示例：

```json
{
    "identity": {
        "identity_id": "001",
        "image_id": "8f5d7b5a-d5da-4b3f-bf46-5830d412ba5e",
        "identity_info": {
            "description": "",
            "name": "小明",
            "permission_ids": [
                "f4add9c0-4212-4064-a045-b6185cf00501",
                "bb982244-ce4e-469d-ab5f-34314dd0c09a"
            ],
            "type": 1,
            "user_id": "001",
   
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
