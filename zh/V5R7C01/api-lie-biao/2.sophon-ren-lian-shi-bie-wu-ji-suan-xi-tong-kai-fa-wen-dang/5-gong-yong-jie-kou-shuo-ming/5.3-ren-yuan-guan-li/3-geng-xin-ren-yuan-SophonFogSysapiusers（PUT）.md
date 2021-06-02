# 更新人员/SophonFogSys/api/users（PUT）

**功能描述**

更新一个人员，人员编号具有唯一性。

**调用URL**

http://192.168.1.180:5555/SophonFogSys/api/users

调用方法: PUT

**请求参数（JSON格式）**

| 一级参数    | 二级参数       | 类型   |  默认值  | 选择           | 描述                                                         |  举例                             |
| :---------- | :------------- | :----- | ----------------------------------- | :------------- | :----------------------------------------------------------- | ------------------------------------------------------------ |
| identity_id |                | string | 无                                  | 必选           | 人员编号，可为工号之类的                                     | "888888"                                                     |
| reg_photo   |                | base64 | 空                                  | 可选           | 完成人脸的创建                                               |                                                              |
| create_no_exit_permission | | bool | false | 可选 | 是否自动创建不存在得权限组 | |
| info        |                | dict   | 空                                  | 必选，可为空。 | 个人其他信息, 禁止进行员工工号的编辑                         |                                                              |
|             | name           | string | 空                                  | 可选           | 人员名称                                                     | "小明"                                                       |
|             | type           | int    | 空                                  | 可选           | 1:员工（默认为员工，包括这个字段不存在的情况）2: 访客3: 黑名单4: 陌生人5: VIP | 1                                                            |
|             | permission_ids | list   | 空                                  | 必选          | 权限组列表（数组），如： ["f4add9c0-4212-4064-a045-					b6185cf00501","bb982244-ce4e-469d-ab5f-34314dd0c09a"] | ["f4add9c0-4212-4064-a045-					b6185cf00501","bb982244-ce4e-469d-ab5f-34314dd0c09a"] |

注意，如果想要和SE5 边缘计算盒中的LiteOS 中人员信息（更多配置）同步，info字段部分需要按照下面的要求进行：

| 一级参数 | 二级参数 | 三级参数          | 类型   | 默认值 | 选择 | 描述（展示文案）   |
| -------- | -------- | ----------------- | ------ | ------ | ---- | ------------------ |
| info     |          |                   | dict   | {}     | 必选 |                    |
|          | name     |                   | string | 无     | 必选 | 姓名               |
|          | user_id  |                   | string | 无     | 必选 | 用户ID             |
|          | ext_info |                   | dict   | {}     | 可选 |                    |
|          |          | mobile            | string | 无     | 可选 | 手机号             |
|          |          | email             | string | 无     | 可选 | 电子邮箱           |
|          |          | idNumber          | string | 无     | 可选 | 证件号码           |
|          |          | gender            | string | 无     | 可选 | 性别               |
|          |          | visit_card_number | string | 无     | 可选 | 门禁卡号           |
|          |          | jobNumber         | string | 无     | 可选 | 工号               |
|          |          | department        | string | 无     | 可选 | 部门               |
|          |          | entryTime         | string | 无     | 可选 | 入职时间           |
|          |          | title             | string | 无     | 可选 | 职位               |
|          |          | address           | string | 无     | 可选 | 地址               |
|          |          | floor             | string | 无     | 可选 | 楼层               |
|          |          | building_no       | string | 无     | 可选 | 楼栋               |
|          |          | room              | string | 无     | 可选 | 房间号             |
|          |          | descriptor        | string | 无     | 可选 | 人员描述           |
|          |          | startTime         | string | 无     | 可选 | 访客有效，来访时间 |
|          |          | endTime           | string | 无     | 可选 | 访客有效，离开时间 |
|          |          | purpose           | string | 无     | 可选 | 访客有效，来访目的 |
|          |          | Interviewee       | string | 无     | 可选 | 访客有效，受访人   |
|          |          | comeFrom          | string | 无     | 可选 | 访客有效，受访单位 |
|          |          | message           | string | 无     | 可选 | 访客有效，欢迎语   |

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

请求成功        

| 一级参数 | 二级参数    | 三级参数            | 类型   | 描述                                                         |
| :------- | :---------- | :------------------ | :----- | :----------------------------------------------------------- |
| data     |             |                     | dict   |                                                              |
|          | identity_id |                     | string | 人员编号，可为工号之类的                                     |
|          | image_id    |                     | string | 完成人脸的创建后返回的数据库id                               |
|          | group_name  |                     | list   | 该人员绑定的分组信息,可能绑定多个组                          |
|          | info        |                     | dict   | 个人其他信息                                                 |
|          |             | name                | string | 人员名称                                                     |
|          |             | type                | int    | 1:员工（默认为员工，包括这个字段不存在的情况）2: 访客3: 黑名单4: 陌生人5: VIP |
|          |             | permission_ids      | list   | 权限组列表（数组），如： ["1","2"]， 若不填默认为["0"]       |
|          |             | ................... | 自定义 | 其他用户信息                                                 |

请求成功示例：

```json
{
    "data": {
        "group_name": [
            "default_group"
        ],
        "identity_id": "001",
        "image_id": "8f5d7b5a-d5da-4b3f-bf46-5830d412ba5e",
        "info": {
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
