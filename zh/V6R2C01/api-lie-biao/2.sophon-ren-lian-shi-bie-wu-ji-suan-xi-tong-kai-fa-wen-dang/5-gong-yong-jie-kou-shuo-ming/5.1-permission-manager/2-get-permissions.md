# 查询权限组列表/sophon/v2/face/getpermissions（POST）

**版本**

2.0

**功能描述**

同时获取多个权限组信息。它支持模糊查询，并提供分页功能。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getpermissions

调用方法: POST

**请求参数**

| 参数            | 类型   |  默认值  | 选择 | 描述                                               |  举例  |
| :-------------- | :----- | ----------------------------------- | :--- | :------------------------------------------------- | --------------------------------- |
| permission_name |  |  | 可选 | 要查询的权限组名称(支持模糊查询)<br />如果不送此参数，返回所有的权限组列表 |  |
| page_limit | int |  | 可选 | 每页返回的条数 |  |
| page_index | int |  | 可选 | 返回第几页。第0页为起始页 |  |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getpermissions
请求方法：POST
请求body(JSON格式):  
{
    "permission_name": "测试组"
}
```

**返回信息：**

**请求成功**

| 一级参数    | 二级参数       | 类型   | 描述                                           |
| :---------- | -------------- | :----- | :--------------------------------------------- |
| permissions |                | []     | 权限组列表                                     |
|             | permssion_name | string | 权限组名称                                     |
|             | permission_id  | string | 全局唯一的权限组标识 |
|             | description    |        |                                                |
| pagination  |                | dict   | 分页信息                                       |
|             | page_limit     | int    | 每页返回的条数                                 |
|             | page_index     | int    | 当前返回的页                                     |
|             | total_count    | int    | 权限组总数量                                 |

请求成功示例：

```json
{
    "pagination": {
        "page_index": 0,
        "page_limit": 10,
        "total_count": 3
    },
    "permissions": [
        {
            "description": "this is a first test permission",
            "permission_id": "test_id1231",
            "permission_name": "testPermission1"
        },
        {
            "description": "this is a first test permission",
            "permission_id": "test_id121",
            "permission_name": "testPermission2"
        },
        {
            "description": "this is a first test permission",
            "permission_id": "test_id1212",
            "permission_name": "testPermission22"
        }
    ]
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                 | message        | 描述                                                         |
| ----- | ---------------------- | -------------- | ------------------------------------------------------------ |
| 1     | ID_NOT_FOUND           | 未找到的ID值   | ID未找到错误                                                 |
| 2     | ID_REPEAT_ERROR        | 重复的ID值     | ID重复错误                                                   |
| 3     | INVALID_ARGUMENTS      | 无效参数的值   | 无效的参数。                                                 |
| 4     | INVALID_REQUEST_JSON   |                | 无效的JSON数据请求。                                         |
| 5     | MISSING_ARGUMENTS      | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 6     | NAME_REPEAT_ERROR      | 重复的名字     | 名字重复错误。                                               |
| 7     | UNSUPPORT_CONTENT_TYPE |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
