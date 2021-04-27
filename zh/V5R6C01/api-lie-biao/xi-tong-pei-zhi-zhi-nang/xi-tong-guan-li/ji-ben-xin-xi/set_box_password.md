# 密码更改 #

**功能描述**

设置SE密码更改。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/password

**调用方法**

POST

**请求参数**

| 参数         | 类型   | 默认值 | 选择 | 描述       | 举例 |
| :----------- | :----- | ------ | :--- | :--------- | ---- |
| username     | string | 无     | 必选 | 用户名     |      |
| old_password | string | 无     | 必选 | 登录旧密码 |      |
| new_password | string | 无     | 必选 | 登录新密码 |      |

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/password?
请求body:
	{
        "username":"linaro",
        "old_password":"linaro",
        "new_password":"linaro123456"
    }
```

**返回信息：**

请求成功：

| 一级参数 | 二级参数 | 类型 | 描述             |
| :------- | :------- | :--- | :--------------- |
| data     |          | dict |                  |
|          | success  | bool | 返回密码修改结果 |

请求成功示例：

```json
{
    "data":{
        "success":true
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

​    
