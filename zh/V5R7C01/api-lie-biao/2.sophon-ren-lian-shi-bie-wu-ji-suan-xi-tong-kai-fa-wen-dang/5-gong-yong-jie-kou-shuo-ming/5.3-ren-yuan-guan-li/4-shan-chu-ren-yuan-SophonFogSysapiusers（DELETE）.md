

# 删除人员/SophonFogSys/api/users（DELETE）

**功能描述**

删除一个人员，同时删除该人的人脸信息，绑定的分组信息；

**调用URL**

http://192.168.1.180:5555/SophonFogSys/api/users

调用方法: DELETE

**请求参数（JSON格式）**

| 参数        | 类型   |  默认值  | 选择 | 描述   |  举例  |
| :---------- | :----- | ----------------------------------- | :--- | :----- | --------------------------------- |
| identity_id | string | 无                                  | 可选,二选一 | 人员ID | “888888”                          |
| identity_ids | list | 无 | 可选,二选一 | 人员ID列表 | ["666666","777777"] |

请求示例：

```json
请求url: http://192.168.1.66:5555/SophonFogSys/api/users
//删除单个人
请求body:
	{
		"identity_id":"001"
	}
//删除多个人
请求body:
    {
		"identity_ids":["666666","777777"]
    }
```

**返回信息：**

请求成功

| 一级参数 | 二级参数    | 类型   | 描述                       |
| :------- | :---------- | :----- | :------------------------- |
| data     | identity_id | string | 用户id                     |
|          | group_name  | list   | 从哪些之前绑定的分组中移除 |
|          | message     | string | 消息                       |

请求成功示例：

```json
//删除单个人
{
    "data": {
        "group_name": [
            "default_group"
        ],
        "identity_id": "001",
        "message": "have remove from group success"
    }
}
//删除多个人
{
    "data": {
        "group_name": [
            "default_group"
        ],
        "identity_ids":["666666","777777"],
        "message": "have remove from group success"
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

删除失败示例：

```
//部分人员删除失败
{
    "error": {
        "chinese_message": "部分用户删除失败",
        "code": 400091,
        "message": "delete some users failed",
        "status": "DELETE_USERS_FAILED"
    }
}

```

