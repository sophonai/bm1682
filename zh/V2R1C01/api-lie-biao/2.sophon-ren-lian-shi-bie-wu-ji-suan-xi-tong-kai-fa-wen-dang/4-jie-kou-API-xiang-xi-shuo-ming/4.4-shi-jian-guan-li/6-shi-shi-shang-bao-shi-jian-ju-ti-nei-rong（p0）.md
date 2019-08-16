# 实时上报事件具体内容（p0）

**功能描述**

上报SophonFog的事件（选定必须字段）给私有云。只上传score >= threshold的Event。需要和监控服务器约定url，假设/EventServer/api/SophonFogRelEvent。

**调用URL**

调用方法: POST

**请求参数（JSON格式，form-data格式）**

| 一级参数      | 二级参数    | 类型   | <font color="#dd0000">默认值</font> | 选择 | 说明                                                         | <font color="#dd0000">举例</font> |
| :------------ | :---------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| identity_id   |             | string |                                     | 必选 | 用户编号                                                     |                                   |
| identity_name |             | string |                                     | 必选 | 用户名称                                                     |                                   |
| group_name    |             | string |                                     | 必选 | 比对的group name，如果没有group_name返回group_id             |                                   |
| reg_pic       |             | base64 |                                     | 必选 | 注册的人脸底库                                               |                                   |
| timestamp     |             | int32  |                                     | 必选 | 事件发生的时间戳                                             |                                   |
| score         |             | float  |                                     | 必选 | 比对的分数                                                   |                                   |
| ext_data      |             | dict   |                                     | 必选 | 拓展数据字段，可迭代添加                                     |                                   |
|               | device_ip   | string |                                     | 可选 | 设备ip                                                       |                                   |
|               | spot_pic    | base64 |                                     | 可选 | 现场照片                                                     |                                   |
|               | person_type | int    |                                     | 可选 | 1:员工（默认为员工，包括这个字段不存在的情况）<br />2: 访客<br />3: 黑名单<br />4：陌生人<br />5: VIP |                                   |
|               | device_type | string |                                     | 可选 | 0：闸机，<br />1：抓拍机<br />2：IPC 静态<br />3：IPC 动态<br />4：门禁 |                                   |

 **返回信息：**

暂时不处理

**示例：**

可以使用小盒子附带的server来获取上传的事件。

假设小盒子的ip为：192.168.1.19，接收的resetful api为RealTimeEvent ，端口号为9528。

那webui或是配置/修改实时事件上报接收服务器地址/SophonFogSys/api/EventServerUrl为：http://192.168.1.19:9528/RealTimeEvent 

启动server方法：

```shell
$ sudo -i
\# cd /system/data/sophon_gate/script
\# python3 Event_Receive_server.py
* Serving Flask app "Event_Receive_server" (lazy loading)
* Environment: production
WARNING: Do not use the development server in a production environment.
Use a production WSGI server instead.
* Debug mode: off
* Running on http://0.0.0.0:9528/ (Press CTRL+C to quit)
```









