#### 删除人员/SophonFogSys/api/users（DELETE）

**功能描述**

删除一个人员，同时删除该人的人脸信息，绑定的分组信息；

**调用URL**

调用方法: DELETE

**请求参数（JSON格式，form-data格式）**

| Index | 参数        | 类型   | 选择 | 描述   |
| :---- | :---------- | :----- | :--- | :----- |
| 1     | identity_id | string | 必选 | 人员ID |

​        **返回信息：**

请求成功

| 一级参数 | 二级参数    | 类型   | 描述                       |
| :------- | :---------- | :----- | :------------------------- |
| data     | identity_id | string | 用户id                     |
| data     | group_name  | list   | 从哪些之前绑定的分组中移除 |
| data     | message     | string | 消息                       |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

Postman 示例调用:

https://documenter.getpostman.com/view/3306589/RznFoxqf#b1d1d4eb-b09d-5408-78f3-c7c306867937

####  