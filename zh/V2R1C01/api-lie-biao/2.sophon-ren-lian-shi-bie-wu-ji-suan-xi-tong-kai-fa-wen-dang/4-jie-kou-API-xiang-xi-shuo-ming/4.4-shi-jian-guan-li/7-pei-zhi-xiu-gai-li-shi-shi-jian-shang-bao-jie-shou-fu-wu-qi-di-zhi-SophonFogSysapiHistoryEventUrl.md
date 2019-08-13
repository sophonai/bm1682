#### 配置/修改历史事件上报接收服务器地址/SophonFogSys/api/HistoryEventUrl

**功能描述**

配置历史事件服务器的地址。

**调用URL**

调用方法: POST

**请求参数（JSON格式，form-data格式）**

| 参数                     | 类型   | 选择 | 描述                                                         |
| :----------------------- | :----- | :--- | :----------------------------------------------------------- |
| history_upload_event_url | list   | 必选 | 历史[事件服务器地址列表，格式： [https/](http://192.168.1.100:9828/EventServer/api/SophonFogRelEvent)[http\]://ip:port/api](http://ipport/)[ 。举例：http://192.168.1.100:9828/EventServer/api/](http://192.168.1.100:9828/EventServer/api/SophonFogRelEvent)SophonFogHistoryEvent |
| history_need_reg_pic     | bool   | 可选 | 配置是否需要上传注册图片，默认为true，即需要上传注册图片     |
| content-type             | string | 必选 | 用来设置 requst 时以哪一种content type发送，参数为：[json,form-data] |
| reported_peroid          | int    | 必选 | 上报状态的周期                                               |

​        **返回信息：**

请求成功

| 一级参数 | 二级参数                 | 类型   | 描述                                                         |
| :------- | :----------------------- | :----- | :----------------------------------------------------------- |
| data     | message                  | string |                                                              |
|          | history_upload_event_url | list   | 历史[事件服务器地址列表，格式： [https/](http://192.168.1.100:9828/EventServer/api/SophonFogRelEvent)[http\]://ip:port/api](http://ipport/)[ 。举例：http://192.168.1.100:9828/EventServer/api/](http://192.168.1.100:9828/EventServer/api/SophonFogRelEvent)SophonFogHistoryEvent |
|          | history_need_reg_pic     | bool   | 是否需要上传注册照片                                         |
|          | content-type             | string | 用来设置 requst 时以哪一种content type发送，参数为：[json,form-data] |
|          | reported_peroid          | int    | 上报状态的周期                                               |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

Postman 示例调用：

https://documenter.getpostman.com/view/3306589/RznFoxqf#9e7a46d8-bee4-ec55-a79e-63bcf29785a0

