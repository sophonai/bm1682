# 主机登录 #

**功能描述**

SE主机登录接口。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/login

**调用方法**

POST

**请求参数**

| 参数     | 类型   | 默认值 | 选择 | 描述       | 举例 |
| :------- | :----- | ------ | :--- | :--------- | ---- |
| username | string | 无     | 必选 | 登录用户名 |      |
| password | string | 无     | 必选 | 登录密码   |      |

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/login
请求body:
	{
        "username":"admin",
        "password":"admin"
    }
```

**返回信息：**

请求成功：

| 一级参数 | 二级参数 | 类型 | 描述                     |
| :------- | :------- | :--- | :----------------------- |
| data     |          | dict |                          |
|          | success  | bool | 提示用户名和密码是否成功 |

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
