# 删除分组/SophonFogSys/api/permissions（DELETE）

**功能描述**

删除一个权限组，组名具有唯一性。删除

**调用URL**

http://192.168.1.180:5555/SophonFogSys/api/permissions

调用方法: DELETE

**请求参数（JSON格式）**

| 参数                  | 类型    |   默认值   | 选择 | 描述                                                         |   举例   |
| :-------------------- | :------ | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| permission_name       | string  | 无                                  | 必选 | 权限组名称                                                   | ”测试组“                          |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/permissions?
请求body:
	{
        "permission_name":"测试组"
	}
```



**返回信息：**

请求成功

| 一级参数 | 二级参数        | 描述       |
| :------- | :-------------- | :--------- |
| data     | permission_name | 权限组名称 |
|          | message         | 返回信息   |

请求成功示例：

```json
{
    "data": {
        "message": "delete the permission info and the user in the permission",
        "permission_name": "测试组"
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
