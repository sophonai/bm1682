# 采集端设备状态信息上报

**功能描述**

上报 SE AI迷你机状态和其连接的子节点设备给管理平台。

上报的URL是由管理下发，参见登录管理平台接口定义。

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| 一级参数         | **二级参数**   | **三级参数** | **类型** | **选择** | **描述**                                                     |   举例                            |
| ---------------- | -------------- | ------------ | -------- | -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| dev_sno          |                |              | string   | **必选** | SE AI迷你机登录管理平台用的授权码（由管理平台生成）         | "ZKZCPI000120190807142601"                                   |
| sub_devices      |                |              | list     | **必选** | 设备信息列表                                                 |                                                              |
|                  | ep_id          |              | string   | **必选** | 边缘节点ID，是指SE3 AI迷你机连接的采集设备的ID。<br /> ID：dev_sno和ip或者rtsp码流的组合，用双下划线做连接。举例：AKOPKKKKK__192.168.1.25 | 'ZKZCPI000120190807142601__192.168.1.101'                    |
|                  | ep_ip          |              | string   | **必选** | 边缘节点ip地址                                               | '192.168.1.101'                                              |
|                  | ep_status      |              | string   | **必选** | 边缘节点状态[online, offline]                                |                                                              |
|                  | ep_location    |              | string   | **必选** | 边缘节点绑定的location                                       | '95274d2c-0941-4d96-b032-ab200f81362c'                       |
|                  | ep_type        |              | string   | **必选** | photo:闸机或者抓拍机, <br /><br />rtsp:视频流,<br />file:本地文件<br />gb28181:国标视频流 | 'rtsp'                                                       |
| | ep_name | | string | 可选 | 添加前端采集设备时设置的设备描述字符串 | 'aaa' |



**返回信息：**

```json
{
    "dev_sno":"AFVKQF000120210604151110",
    "sub_devices": [{'ep_status': 'online', 
                   'ep_location': '95274d2c-0941-4d96-b032-ab200f81362c',  
                   'ep_type': 'rtsp', 
                   'ep_name': '', 
                   'ep_id': 'ZKZCPI000120190807142601__192.168.1.101', 
                   'ep_ip': '192.168.1.101'}], 
    
}

```

**示例：**

可以使用小盒子附带的server来获取上传的事件。

假设小盒子的ip为：192.168.1.19，接收的resetful api为DeviceStatus，端口号为9528。

那webui或是配置/修改状态上报接收服务器地址填写的信息为：[http://192.168.1.19:9528/DeviceStatus](http://192.168.1.19:9528/RealTimeEvent) 

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

