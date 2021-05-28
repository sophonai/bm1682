# 查询分组/SophonFogSys/api/permissions（GET）

**功能描述**

查询一个权限组，或是放回所有的分组，组名具有唯一性。

**调用URL**

http://192.168.1.180:5555/SophonFogSys/api/permissions

调用方法: GET

**请求参数**

| 参数            | 类型   |  默认值  | 选择 | 描述                                               |  举例  |
| :-------------- | :----- | ----------------------------------- | :--- | :------------------------------------------------- | --------------------------------- |
| permission_name | string | 空                                  | 可选 | 权限组名称，如果该参数没有设置，则返回所有的分组。 | ”测试组“                          |
| skip_num | int | 0 | 可选 | 分页查询的起始点， 与当前页数的关系为页数减1，如果是第一页则为0， 查询第二页传1，以此类推 |  |
| limit | int | 10 | 可选 | 分页查询每一页的数量 |  |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/permissions?skip_num=0&limit=10
```



**返回信息：**

请求成功

| 一级参数 | 二级参数         | 三级参数      | 类型   | 描述                                                         |
| :------- | :--------------- | :------------ | :----- | :----------------------------------------------------------- |
| data     |                  |               | dict   |                                                              |
|          | permissions_list |               | list   | "permissions_list": [  {  "description": "负责系统软件开发", "name": "10391" },  {  "description": "负责系统软件开发", "name": "软件开发一部" }  ] |
|          |                  | name          | string | 权限组名称                                                   |
|          |                  | description   | string | 权限组信息，内容可为‘”“，即空字符串                          |
|          |                  | permission_id | string | 权限组的唯一标识                                             |
|          |                  | version       | string | 区分权限组历史版本                                           |
|          | pagination       |               |        |                                                              |
|          |                  | skip_num      | int    | 分页查询的起始点                                             |
|          |                  | limit         | int    | 分页查询每一页的数量                                         |
|          |                  | num_pages     | int    | 总共有多少页的数据                                           |
|          |                  | total_count   | int    | 数量总量                                                     |

请求成功示例：

```json
{
    "data": {
        "pagination": {
            "limit": 10,
            "num_pages": 2,
            "skip_num": 0,
            "total_count": 13
        },
        "permissions_list": [
            {
                "description": "222222",
                "name": "names",
                "permission_id": "7888eb40-802e-41e8-8368-0e55f5ba4a6b",
                "version": "V2"
            }
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
