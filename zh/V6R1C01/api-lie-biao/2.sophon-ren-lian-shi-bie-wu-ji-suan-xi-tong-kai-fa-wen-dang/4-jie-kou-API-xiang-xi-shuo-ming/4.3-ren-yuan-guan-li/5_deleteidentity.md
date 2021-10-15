# 删除人员/sophon/v2/face/deleteidentities (POST)

**版本**

2.0

**功能描述**

删除多个人员;

注意:

a、该操作会将该人员从对应的权限组中解绑，同时，将该人员下面的人脸，注册照片删除。

b、输入多个人员的时候，

**调用URL**

调用方法: POST

**请求参数（JSON格式）**

| 参数        | 类型   |  默认值  | 选择 | 描述   |  举例  |
| :---------- | :----- | ----------------------------------- | :--- | :----- | --------------------------------- |
| identity_ids | list | 无                                  | 必选 | 人员ID | “888888”                          |

请求示例：

```json
请求url: http://192.168.1.66:5555/SophonFogSys/api/users
请求body:
	{
		"identity_id":"001"
	}
```

**返回信息：**

请求成功

| 参数                | 类型 | 描述                 |
| :------------------ | :--- | :------------------- |
| sucess_identity_ids | []   | 删除成功的人员id列表 |
| failed_identity_ids | []   | 删除失败的人员id列表 |

请求成功示例：

```json
{
        "group_name": [
            "default_group"
        ],
        "identity_id": "001",
        "message": "have remove from group success"
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

