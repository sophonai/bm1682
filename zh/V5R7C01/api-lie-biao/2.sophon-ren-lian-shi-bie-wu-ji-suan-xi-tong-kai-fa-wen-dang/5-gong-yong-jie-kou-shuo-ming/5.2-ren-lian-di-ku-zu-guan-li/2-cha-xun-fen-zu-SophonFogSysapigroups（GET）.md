# 查询分组/SophonFogSys/api/groups（GET）

**功能描述**

查询一个分组，或是放回所有的分组，组名具有唯一性。

**调用URL**

http://192.168.1.180:5555/SophonFogSys/api/groups

调用方法: GET

**请求参数**

| 参数       | 类型   |  默认值   | 选择 | 描述                                             |   举例  |
| :--------- | :----- | ----------------------------------- | :--- | :----------------------------------------------- | --------------------------------- |
| group_name | string | 空                                  | 可选 | 分组名称，如果该参数没有设置，则返回所有的分组。 |                                   |
| skip_num | string | 0 | 可选 | 可不填，默认为0，表示第一页。 | |
| limit | string | 10 | 可选 | 可不填，默认为10条。在人员查询组内人员信息的时候，单次返回人员的个数 | |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/groups?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数    | 三级参数    | 类型   | 描述                                                         |
| :------- | :---------- | :---------- | :----- | :----------------------------------------------------------- |
| data     |             |             | dict   |                                                              |
|          | groups_list |             | list   | "groups_list": [  {  "description": "负责系统软件开发", "name": "10391" },  {  "description": "负责系统软件开发", "name": "软件开发一部" }  ] |
|          |             | name        | string | 分组名称                                                     |
|          |             | description | string | 分组信息，内容可为‘’                                         |
|          | pagination  |             | dict   | 分页数据                                                     |
|          |             | skip_num    | int    | 分页查询的起始点                                             |
|          |             | limit       | int    | 分页查询每一页的数量                                         |
|          |             | num_pages   | int    | 总共有多少页的数据                                           |
|          |             | total_count | int    | 数量总量                                                     |

请求成功示例：

```json
{
    "data": {
        "groups_list": [
            {
                "group_id": "default_group",
                "groupname": "default_group",
                "name": "default_group",
                "version": "V2"
            }
        ],
        "pagination": {
            "limit": 10,
            "num_pages": 1,
            "skip_num": 0,
            "total_count": 3
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
