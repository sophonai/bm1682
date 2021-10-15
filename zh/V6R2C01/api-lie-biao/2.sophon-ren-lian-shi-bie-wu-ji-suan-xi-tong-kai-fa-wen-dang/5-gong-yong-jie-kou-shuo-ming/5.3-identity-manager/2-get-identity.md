# 查询人员/sophon/v2/face/getidentity(POST)

**版本**

2.0

**功能描述**

查询单个人员信息。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getidentity

调用方法: POST

**请求参数**

| 参数        | 类型   |   默认值   | 选择 | 描述                                                         | 说明                                                         |  举例  |
| :---------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | :----------------------------------------------------------- | --------------------------------- |
| identity_id | string | 无                                  | 必选 | 查询人员信息。                       |  |                      |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getidentity
请求方法：POST
请求body(JSON格式):
{
    "identity_id":"100000"
}
```

**返回信息：**

**请求成功**

| 二级参数           | 类型   | 描述                                                         |
| :----------------- | :----- | :----------------------------------------------------------- |
| identity_id        | string | 人员唯一识别标识                                     |
| identity_name      | string | 人员姓名                                                     |
| user_type          | string | 人员类型:<br />"employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP |
| permission_ids     | list   | 人员所属权限组列表 |
| ext_user_info      | dict   | 人员扩展信息。参见createidentity API中的“人员扩展信息定义”表格                                               |
| face_ids           | list   | 绑定到该人员的人脸id列表                                     |
| register_image_ids | list   | 绑定到该人员的注册照片id列表（顺序与face_id_list一一对应） |

请求成功示例：

```json
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
