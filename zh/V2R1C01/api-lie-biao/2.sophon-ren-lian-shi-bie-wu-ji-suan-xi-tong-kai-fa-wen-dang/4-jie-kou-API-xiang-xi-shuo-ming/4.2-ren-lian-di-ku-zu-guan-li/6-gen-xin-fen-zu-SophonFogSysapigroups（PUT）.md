**更新分组/SophonFogSys/api/groups（PUT）**

**功能描述**

更新一个分组，组名具有唯一性。

**调用URL**

调用方法: PUT

**请求参数（JSON格式，form-data格式）**

| 参数        | 类型   | 选择 | 描述                                                         |
| :---------- | :----- | :--- | :----------------------------------------------------------- |
| group_name  | string | 必选 | 分组名称，不支持在字符串中间包含“,”，代码暂时不做校验。      |
| description | string | 必选 | 分组信息，可以为 “”                                          |
| info        | dict   | 可选 | 分组所有信息保存得字段，添加得时候，里面不可以有description字段 |

​        **返回信息：**

请求成功

| 一级参数 | 二级参数 | 三级参数    | 类型   | 描述                 |
| :------- | :------- | :---------- | :----- | :------------------- |
| data     |          |             | dict   |                      |
|          | info     |             | dict   |                      |
|          |          | name        | string | 分组名称             |
|          |          | description | string | 分组信息，内容可为‘’ |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

Postman 示例调用：

https://documenter.getpostman.com/view/3306589/RznFoxqf#e1bbd0ad-8275-6bd5-9c35-a977f9613ed7