# 添加人员到分组/SophonFogSys/api/GroupUsers（PUT）

**功能描述**

添加一个人员到一个分组。

**调用URL**

调用方法: PUT

**请求参数（JSON格式）**

| 参数             | 类型    |  默认值  | 选择 | 描述                                                         |  举例  |
| :--------------- | :------ | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| group_name       | string  | 无                                  | 必选 | 分组名称                                                     | "default_group"                   |
| identity_id      | list    | 无                                  | 必选 | 用户id列表[["user_id1","user_id2"](https://info.bitmain.vip:8443/pages/createpage.action?spaceKey=AIBOX&title="123345"%2C"23455"&linkCreation=true&fromPageId=59841178)] | ["001","002"]                     |
| with_identity_id | boolean | false                               | 可选 | 默认为false，如果为true，把该组的identity_id全部返回         |                                   |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/GroupUsers?
请求body:
        {
            "group_name":"测试组",
            "identity_id":["001","002"],
            "with_identity_id":true

        }
```

**返回信息：**

请求成功

| 一级参数 | 二级参数    | 类型   | 描述                                                         |
| :------- | :---------- | :----- | :----------------------------------------------------------- |
| data     | group_name  | string | 分组名称                                                     |
|          | identity_id | list   | 默认为false，不返回该组的identity_id如果为true，返回该组的identity_id |

请求成功示例：

```json
{
    "data": {
        "group_name": "测试组",
        "identity_id": [
            "001","002"
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
