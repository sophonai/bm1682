# 查询人员列表/sophon/v2/face/getidentities(POST)

**版本**

2.0

**功能描述**

模糊查询多个人员信息。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getidentities

调用方法: POST

**请求参数**

| 一级参数 | 二级参数      | 类型   |   默认值   | 选择 | 描述                                                         | 说明                                                         |  举例  |
| :---------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | :----------------------------------------------------------- | --------------------------------- | ----------- |
| filters |  | dict |  | 可选 | 如果为空，返回所有的人员信息。 |  |  |
|  | permission_id_list | list | 无                                  | 可选 | 限定的权限组列表                       | 如为空，则在所有权限组中查询 |                      |
|  | identity_name | string | 无 | 可选 | 根据姓名作模糊查询 |  | |
|  | identity_id | string | 无 | 可选 | 根据人员唯一标识查询 |  | |
| page_limit |        | int    | 10                                  | 可选 | 单次查询返回人员的个数，默认为10条。 |                                   | 10                                |
| page_index |                    | int    | 0                                   | 可选 | 默认为0，表示从第一页返回。                                |                                   | 0                                 |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getidentities
请求方法：POST
请求body(JSON格式):
{
}
```

**返回信息：**

**请求成功**

| 参数       | 二级参数    | 类型                      | 描述                      |
| :--------- | ----------- | :------------------------ | :------------------------ |
| identities |             | list                      | 人员信息列表                  |
| pagination |             | dict                      | 分页信息                  |
|            | page_index  | int                       | 返回第几页。第0页为起始页 |
|            | page_limit  | int                       | 每页人员数量              |
|            | total_count | int                       | 全部人员数量              |

人员identity字典结构:

| 项目               | 类型   | 描述                                                         |
| :----------------- | :----- | :----------------------------------------------------------- |
| identity_id        | string | 人员唯一识别标识                                     |
| identity_name      | string | 人员姓名                                                     |
| user_type          | string | "employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP |
| permission_ids     | list   | 权限组id列表 |
| ext_user_info      | dict   | 人员扩展信息                                               |
| face_ids           | list   | 绑定到该人员的人脸id列表                                     |
| register_image_ids | list   | 绑定到该人员的注册照片id列表（顺序与face_id_list一一对应）  |

请求成功示例：

```json
{
    "identities": [
        {
            "ext_user_info": {},
            "face_ids": [
                "912ce1a6-f4e6-4604-b492-ca1c0443ead4"
            ],
            "identity_id": "100000",
            "identity_name": "小王",
            "permission_ids": [],
            "register_image_ids": [
                "1e644cc0-1631-4248-b518-c8701d3c7a91"
            ],
            "user_type": "employee"
        },
        {
            "ext_user_info": {},
            "face_ids": [
                "db4c5e0c-0135-4238-acc8-a273d4130a4a"
            ],
            "identity_id": "100001",
            "identity_name": "小张",
            "permission_ids": [],
            "register_image_ids": [
                "4a697e92-f0d6-4733-ae03-10eff5987abf"
            ],
            "user_type": "employee"
        },
        {
            "ext_user_info": {},
            "face_ids": [
                "08aebfc8-cabf-49c6-881f-c64cdd4d49a8"
            ],
            "identity_id": "100002",
            "identity_name": "小李",
            "permission_ids": [],
            "register_image_ids": [
                "c7d78dac-2dd1-4a51-8f78-c617bfc841a7"
            ],
            "user_type": "employee"
        },
        ... ...
    ],
    "pagination": {
        "page_index": 0,
        "page_limit": 10,
        "total_count": 13
    }
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
| 2     | INVALID_ARGUMENTS      | 无效参数的值   | 无效的参数。                                                 |
| 3     | INVALID_REQUEST_JSON   |                | 无效的JSON数据请求。                                         |
| 4     | MISSING_ARGUMENTS      | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 5     | UNSUPPORT_CONTENT_TYPE |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
