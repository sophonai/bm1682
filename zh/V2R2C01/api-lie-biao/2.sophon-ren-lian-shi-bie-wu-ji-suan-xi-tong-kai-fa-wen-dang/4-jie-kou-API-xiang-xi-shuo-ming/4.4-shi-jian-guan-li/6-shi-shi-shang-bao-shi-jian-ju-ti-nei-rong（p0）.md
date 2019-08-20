# 实时事件上报内容

**功能描述：**

SE3 AI 迷你机会实时上报比对分数大于阈值的比对事件到管理平台指定的URL，参见 管理平台登录接口定义。

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| **一级参数**  | **二级参数**   | **类型** | **选择** | **说明**                                                     | <font color="#000000">举例</font> |
| ------------- | -------------- | -------- | -------- | ------------------------------------------------------------ | --------------------------------- |
| identity_id   |                | string   | **必选** | 用户编号                                                     | "12345565"                        |
| identity_name |                | string   | **必选** | 用户名称                                                     | "Tom"                             |
| group_name    |                | string   | **必选** | 比对的group name，如果没有group_name返回group_id             | "default_group"                   |
| reg_pic       |                | base64   | 可选     | 注册的人脸底库，默认上传，可配置去除                         | "/9j/6QAEAAD/2wBD..."             |
| timestamp     |                | int32    | **必选** | 事件发生的时间戳                                             | 1565771454932                     |
| score         |                | float    | **必选** | 比对的分数                                                   | 0.78                              |
| ext_data      |                | dict     | **必选** | 拓展数据字段，可迭代添加                                     |                                   |
|               | device_ip      | sting    | **必选** | 设备ip                                                       | "192.168.1.101"                   |
|               | spot_pic       | base64   | 可选     | 现场照片，迎宾机模式下不传                                   | "/9j/6QAEAAD/2wBD..."             |
|               | person_type    | int      | **必选** | 1：员工（默认为员工，包括这个字段不存在的情况）<br />2：访客<br />3：黑名单<br />4：陌生人<br />5：VIP | 1                                 |
|               | device_type    | string   | **必选** | 0：闸机 <br />1：抓拍机 <br />2：IPC 静态 <br />3：IPC 动态 <br />4：门禁 | 0                                 |
|               | grab_fiqa_info | dict     | **必选** | 其他设备模式内容为空（抓拍机模式下只有臻识抓拍机有效），返回抓拍机得人脸质量检测结果，详细请看示例 | {}                                |
|               | box_fiqa_info  | dict     | **必选** | 其他设备模式内容为空(抓拍机模式有值)，返回AI BOX得人脸质量检测结果，详细请看示例 | {}                                |

**返回信息：**

```json
{
    "reg_pic":"",
    "ext_data":{
        "person_type":5,
        "grab_fiqa_info":{

        },
        "device_ip":"192.168.1.243",
        "box_fiqa_info":{

        },
        "device_type":"0",
        "spot_pic":""
    },
    "identity_id":"666666",
    "score":0.6231614351272583,
    "timestamp":1566016554020,
    "group_name":"default_group",
    "identity_name":"小明"
}
```

可以使用小盒子附带的server来获取上传的事件。

假设小盒子的ip为：192.168.1.19，接收的resetful api为RealTimeEvent ，端口号为9528。

那webui或是配置/修改实时事件上报接收服务器地址为：[http://192.168.1.19:9528/RealTimeEvent](http://192.168.1.19:9528/RealTimeEvent)

启动server方法：

```shell
$ sudo -i
# cd /system/data/sophon_gate/script
# python3 Event_Receive_server.py

* Serving Flask app "Event_Receive_server" (lazy loading)
* Environment: production
WARNING: Do not use the development server in a production environment.
Use a production WSGI server instead.
* Debug mode: off
* Running on http://0.0.0.0:9528/ (Press CTRL+C to quit)
```

