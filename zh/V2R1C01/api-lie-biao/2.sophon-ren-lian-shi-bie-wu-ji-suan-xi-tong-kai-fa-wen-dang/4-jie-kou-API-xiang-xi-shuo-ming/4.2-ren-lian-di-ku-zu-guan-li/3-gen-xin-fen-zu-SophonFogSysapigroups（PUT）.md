# 更新分组/SophonFogSys/api/groups（PUT）

**功能描述**

更新一个分组，组名具有唯一性。

**调用URL**

调用方法: PUT

**请求参数（JSON格式）**

| 参数        | 类型   | <font color="#dd0000">默认值</font> | 选择 | 描述                                                         | <font color="#dd0000">举例</font> |
| :---------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| group_name  | string | 无                                  | 必选 | 分组名称，不支持在字符串中间包含“,”，代码暂时不做校验。      | ”default_group“                   |
| description | string | 无                                  | 必选 | 分组信息，可以为 “”                                          | "默认比对用户组"                  |
| info        | dict   | 空                                  | 可选 | 分组所有信息保存得字段，添加得时候，里面不可以有description字段 |                                   |

请求示例:

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/groups?
请求body:
       {
            "group_name":"default_group",
            "description":"默认比对权限组"
        }
```

**返回信息：**

请求成功

| 一级参数 | 二级参数 | 三级参数    | 类型   | 描述                 |
| :------- | :------- | :---------- | :----- | :------------------- |
| data     |          |             | dict   |                      |
|          | info     |             | dict   |                      |
|          |          | name        | string | 分组名称             |
|          |          | description | string | 分组信息，内容可为‘’ |

请求成功示例:

```json
{
    "data": {
        "info": {
            "description": "默认比对权限组",
            "name": "default_group"
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
