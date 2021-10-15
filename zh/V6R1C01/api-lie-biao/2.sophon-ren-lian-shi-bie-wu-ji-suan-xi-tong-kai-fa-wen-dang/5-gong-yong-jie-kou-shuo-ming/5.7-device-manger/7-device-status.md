# 采集端设备状态获取方式

系统支持将采集端设备信息，定期上报给应用管理平台。
通过/sophon/v2/face/setconfigs接口可以调协设备信息上报的接收URL(MEDIA_DEVICE_MONITOR_URL)和上报周期(MEDIA_DEVICE_MONITOR_REPORT_PEROID)。

### **配置采集端状态上报**

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/setconfigs
请求方法：POST
请求body:
{
	"config_dict":
	{
		"MEDIA_DEVICE_MONITOR_URL": "http://xxx",
		"MEDIA_DEVICE_MONITOR_REPORT_PEROID":5
	}
} 
```

### 上报的数据字段定义

| 一级参数         | **二级参数**   | **类型** | 选择 | **描述**                                                     |   举例                            |
| ---- | ----- | ---- | --------------------------------------------- | -------------- | ------------- |
| mq_license_key |                | string   | **必选** | SE AI迷你机登录管理平台用的授权码（由管理平台生成）         | "ZKZCPI000120190807142601"                                   |
| media_devices |                | list     | **必选** | 设备信息列表                                                 |                                                              |
|  | media_device_id | string | **必选** | 采集端设备唯一标识id号。 | '95274d2c-0941-4d96-b032-ab200f81362c' |
|  | media_device_name | string | **必选** | 采集端设备名称。 | 'aaa' |
|  | media_device_status | string   | **必选** | 采集端设备状态</br>online</br>offline           | "online" |
| | media_device_ip | string   | **必选** | 采集端设备ip地址                                          | "192.168.1.101"                                              |
| | permission_id | string | **必选** | 设备关联的权限组id |  |
| | media_device_type | string   | **必选** | 设备类型<br />"photo":图片流（送图片的设备）<br />"rtsp":视频流<br />"file":本地文件<br />"gb28181":国标视频流|            |
| | media_device_url | string   | **必选** | 设备的url地址，当前支持4种不同的类型,分别如右所示。 </br>注意：不支持相同url重复添加。 | "rtsp://192.168.1.100:554/main/av" </br>"192.168.1.22" </br> "/data/test.mp4"</br>"gb28281://xxxx" |




**返回信息：**

```json
{
    "mq_license_key":"AFVKQF000120210604151110",
    "sub_devices": [
        {
            "media_device_id": "2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd", //可选，可不传
            "media_device_url": "rtsp://192.168.1.100:554/ch2",
            "media_device_ip": "192.168.1.100",
            "media_device_name": "前门设备",
            "media_device_status":"online",
            "media_device_type": "rtsp",
            "permission_id": "820737ae-a6d3-4322-bf7c-46f48066fb64"
        }
    ], 
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

