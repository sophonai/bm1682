#### 获取事件反馈模式/SophonFogSys/api/GateControllerMode（GET）

**功能描述**

获取事件反馈模式。

**调用URL**

调用方法: GET

**请求参数**

无

**返回信息：**

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

https://documenter.getpostman.com/view/3306589/RznFoxqf#70e98169-d445-707f-f607-fe184bb7bb41