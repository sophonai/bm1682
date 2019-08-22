# 配置/修改实时事件上报接收服务器地址/SophonFogSys/api/EventServerUrl（POST）

**功能描述**

配置事件服务器的地址。根据列表中的顺序依次发送Event，请注意每个发送之间有0.5s的timeout请求延时。

**调用URL**

调用方法: POST

**请求参数（JSON格式，form-data格式）**

| 参数              | 类型   | <font color="#dd0000">默认值</font> | 选择 | 描述                                                         | <font color="#dd0000">举例</font> |
| :---------------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| event_server_url  | list   |                                     | 必选 | 列表，事件服务器地址列表，格式： [https/[http\]://ip:port/api](http://ipport/) 。举例： http://192.168.1.100:9828/EventServer/api/SophonFogRelEvent |                                   |
| real_need_reg_pic | bool   |                                     | 可选 | 配置是否需要上传注册的图片，默认为true,需要上传注册的图片    |                                   |
| content-type      | string |                                     | 必选 | 用来设置 requst 时以哪一种content type发送，参数为：[json,form-data] |                                   |

**返回信息：**

请求成功

| 一级参数 | 二级参数          | 类型   | 描述             |
| :------- | :---------------- | :----- | :--------------- |
| data     | event_server_url  | list   | 设置的地址       |
|          | real_need_reg_pic | bool   | 是否传送注册图片 |
|          | content-type      | string | 参数类型         |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
