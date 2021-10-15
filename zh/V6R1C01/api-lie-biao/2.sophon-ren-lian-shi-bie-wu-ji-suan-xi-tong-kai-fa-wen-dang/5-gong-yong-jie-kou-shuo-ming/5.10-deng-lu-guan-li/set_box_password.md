# 密码更改/sophon/v2/face/changepassword(POST) #

**功能描述**

更改用户密码。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/changepassword

**调用方法**

POST

**请求参数**

| 参数         | 类型   | 默认值 | 选择 | 描述       | 示例 |
| :----------- | :----- | ------ | :--- | :--------- | ---- |
| username     | string | 无     | 必选 | 用户名     |      |
| old_password | string | 无     | 必选 | 登录旧密码 |      |
| new_password | string | 无     | 必选 | 登录新密码 |      |

**请求示例：**

```json
请求url: http://192.68.150.1:5555/sophon/v2/face/changepassword
请求方法：POST
请求body(JSON格式):
{
    "username":"admin",
    "old_password":"admin",
    "new_password":"aTIfaSHA"
}
```

**返回信息：**

请求成功：
| 参数     |类型| 默认值  | 选择 | 描述                                                         | 示例 |
| :----------- | :--- | :--- |:--- | :----------------------------------------------------------- | :--- |
| result    | bool |  |必选 | true: 密码更改成功<br />false: 密码更改失败 |  true    |


请求成功示例：

```json
{
    "result":true
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                 | message        | 描述                                                         |
| ----- | ---------------------- | -------------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |                | 无效的JSON数据请求。                                         |
| 3     | MISSING_ARGUMENTS      | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 4     | INVALID_ARGUMENTS      | 无效参数的值   | 无效的参数。                                                 |
| 5     | PASSWORD_ERROR         |                | 密码错误                                                     |
| 6     | INTERNAL_ERROR         |                | 服务器内部错误，当此类错误发生时请再次请求，如果持续出现此类错误，请及时联系技术支持团队 |

​    
