# 创建人员SophonFogSys/api/users（POST）

**功能描述**

新建一个人员，人员编号具有唯一性。

**调用URL**

调用方法: POST

**请求参数（JSON格式）**

| 一级参数                  | 二级参数       | 类型      | <font color="#dd0000">默认值</font> | 选择 | 描述                                                         | <font color="#dd0000">举例</font>                            |
| :------------------------ | :------------- | :-------- | ----------------------------------- | :--- | :----------------------------------------------------------- | ------------------------------------------------------------ |
| identity_id               |                | string    | 无                                  | 必选 | 人员编号，可为工号之类的                                     | ”001“                                                        |
| reg_photo                 |                | base64    | 无                                  | 必选 | 完成人脸的创建                                               |                                                              |
| group_name                |                | string    | 无                                  | 必选 | 直接完成分组的绑定，可以支持多个分组同时绑定，分组名称之间以英文字符逗号分隔。 | ”default_group“                                              |
| `ignore_exist`            |                | `boolean` | false                               | 可选 | 默认为false，当这个identity_id已经存在的时候，会返回already exist的错误, 设置成true的话，会忽略已经存在错误，把这个人添加到group里面，并把当前信息update到该identity_id上 | false                                                        |
| create_no_exit_permission |                | boolean   | false                               | 可选 | 默认为False, 当创建的人员携带的权限组id即permisssion_ids不存在不会进行自动创建设置为True的话，填写的权限组id不存在就会自动创建权限组 | false                                                        |
| info                      |                | dict      |                                     | 必选 | 个人其他信息                                                 |                                                              |
|                           | name           | string    | 无                                  | 必选 | 人员名称                                                     | 小王                                                         |
|                           | type           | int       | 无                                  | 必选 | 1: 员工（默认为员工，包括这个字段不存在的情况）2: 访客3: 黑名单4：陌生人5:VIP | 1                                                            |
|                           | permission_ids | list      | 无                                  | 可选 | 权限组， 此处为列表（数组）, 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"] | ["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"] |
|                           | ....           | 自定义    |                                     | 可选 | 其他的用户信息                                               |                                                              |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/users
请求body:
        {
            "info":{"name":"小王","type":1,"permission_ids":["f4add9c0-4212-4064-a045-						b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"]},
            "group_name":"default_group",
            "identity_id":"001",
            "reg_photo":""  //base64格式图片内容
        }
```



**返回信息：**

请求成功

| 一级参数 | 二级参数    | 三级参数       | 类型   | 选择 | 描述                                                         |
| :------- | :---------- | :------------- | :----- | :--- | :----------------------------------------------------------- |
| data     |             |                | dict   |      |                                                              |
|          | identity_id |                | string | 必选 | 人员编号，可为工号之类的                                     |
|          | reg_photo   |                | base64 | 必选 | 完成人脸的创建                                               |
|          | group_name  |                | string | 必选 | 直接完成分组的绑定,                                          |
|          | info        |                | dict   | 必选 | 个人其他信息                                                 |
|          |             | name           | string | 必选 | 人员名称                                                     |
|          |             | type           | int    | 必选 | 1:员工（默认为员工，包括这个字段不存在的情况）2: 访客3: 黑名单4：陌生人5:VIP |
|          |             | permission_ids | list   | 必选 | 权限组，列表（数组）, 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"] |
|          |             | .......        | 自定义 | 可选 | 其他的用户信息                                               |

请求成功示例：

```json
{
    "data": {
        "group_name": "default_group",
        "identity_id": "001",
        "info": {
            "name": "小王",
            "permission_ids": ["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-								4064-a045-b6185defw501"],
            "type": 1,
            "user_id": "001"
        },
        "reg_photo": ""
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
