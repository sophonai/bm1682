#### 删除分组/SophonFogSys/api/permissions（DELETE）

**功能描述**

删除一个权限组，组名具有唯一性。删除

**调用URL**

调用方法: DELETE

**请求参数（JSON格式，form-data格式）**

| 参数                  | 类型    | 选择 | 描述                                                         |
| :-------------------- | :------ | :--- | :----------------------------------------------------------- |
| permission_name       | string  | 必选 | 权限组名称                                                   |
| user_recursive_delete | boolean | 必选 | 默认为false，删除权限组，保留人员。如果为True，删除权限组的同时，把人员，人脸一起删除 |

​        **返回信息：**

请求成功

| 一级参数 | 二级参数   | 描述       |
| :------- | :--------- | :--------- |
| data     | group_name | 权限组名称 |
|          | message    | 返回信息   |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

Postman 示例调用:

https://documenter.getpostman.com/view/3306589/RznFoxqf#0db48488-2ea1-8dfb-c168-101bf5739df1