# 设置事件反馈模式/SophonFogSys/api/GateControllerMode（POST）

**功能描述**

配置事件反馈模式。

**调用URL**

调用方法: POST

**请求参数（JSON格式，form-data格式）**

| Index | 参数            | 类型   | <font color="#dd0000">默认值</font> | 选择 | 描述                                             | <font color="#dd0000">举例</font> |
| :---- | :-------------- | :----- | ----------------------------------- | :--- | :----------------------------------------------- | --------------------------------- |
| 1     | controller_mode | string |                                     | 必选 | “opendoor/alarm/avoid/...”, default is opendoor. |                                   |

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
