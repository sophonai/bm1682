#### 创建分组/SophonFogSys/api/groups（POST）

**功能描述**

新建一个分组，组名具有唯一性。

**调用URL**

调用方法: POST

**请求参数（JSON格式，form-data格式）**

| 参数        | 类型   | 选择 | 描述                                                         |
| :---------- | :----- | :--- | :----------------------------------------------------------- |
| group_name  | string | 必选 | 分组名称，内容不可为‘’,可支持中文，不支持在字符串中间包含“,”，代码暂时不做校验。 |
| description | string | 必选 | 分组信息，内容可为‘’                                         |
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

https://documenter.getpostman.com/view/3306589/RznFoxqf#711ec4ce-4a46-84ba-90f5-c98f63e1adbe