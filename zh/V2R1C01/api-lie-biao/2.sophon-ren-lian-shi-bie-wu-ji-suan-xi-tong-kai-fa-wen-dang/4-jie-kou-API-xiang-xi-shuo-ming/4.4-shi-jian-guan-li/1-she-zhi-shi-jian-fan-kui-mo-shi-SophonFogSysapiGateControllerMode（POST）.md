#### 设置事件反馈模式/SophonFogSys/api/GateControllerMode（POST）

**功能描述**

配置事件反馈模式。

**调用URL**

调用方法: POST

**请求参数（JSON格式，form-data格式）**

| Index | 参数            | 类型   | 选择 | 描述                                             |
| :---- | :-------------- | :----- | :--- | :----------------------------------------------- |
| 1     | controller_mode | string | 必选 | “opendoor/alarm/avoid/...”, default is opendoor. |

​        **返回信息：**

请求成功

| 一级参数 | 二级参数        | 类型   | 描述       |
| :------- | :-------------- | :----- | :--------- |
| data     | controller_mode | string | 设置的信息 |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

Postman 示例调用：

https://documenter.getpostman.com/view/3306589/RznFoxqf#42f7a1d7-d5b1-e067-735a-69db67892ab1