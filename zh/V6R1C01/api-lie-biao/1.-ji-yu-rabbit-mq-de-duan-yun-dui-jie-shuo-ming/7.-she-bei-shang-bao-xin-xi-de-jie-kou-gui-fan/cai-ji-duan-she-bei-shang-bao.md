# 采集端设备状态信息上报

**功能描述**

上报 SE AI迷你机状态和其连接的子节点设备给管理平台。

上报的URL是由管理下发，参见登录管理平台接口定义。

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| 一级参数         | **二级参数**   | **类型** | 选择 | **描述**                                                     |   举例                            |
| ---------------- | -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| mq_license_key |                | string   | **必选** | SE AI迷你机登录管理平台用的授权码（由管理平台生成）         | "ZKZCPI000120190807142601"                                   |
| media_devices |                | list     | **必选** | 设备信息列表                                                 |                                                              |
|  | media_device_id | string | **必选** | 采集端设备唯一标识id号。 | '95274d2c-0941-4d96-b032-ab200f81362c' |
|  | media_device_name | string | **必选** | 采集端设备名称。 | 'aaa' |
|                  | media_device_url | string   | **必选** | 设备的url地址，当前支持4种不同的类型<br />图片流：192.168.1.22<br />视频流：rtsp://192.168.1.100:554/main/av_main<br />本地视频文件: /data/test.mp4<br />国标流: gb28281://xxxx<br />Note：系统会检查该参数的唯一性，如果重复则会返回失败。 | “rtsp://192.168.1.100:8554/ch101” |
|                  | media_device_ip | string   | **必选** | 采集端设备ip地址                                          | '192.168.1.101'                                              |
|                  | media_device_status | string   | **必选** | 采集端设备状态[online, offline]                           |                                                              |
|                  | media_device_type | string   | **必选** | 设备类型<br />"photo":图片流（送图片的设备）<br />"rtsp":视频流<br />"file":本地文件<br />"gb28181":国标视频流 |                                                           |
| | permission_id | string | **必选** | 设备关联的权限组id |  |

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

### **配置采集端状态上报**

```json
请求url: http://192.168.1.180:5555/sophon/v2/face/setconfigs
请求body:
{
	"config_dict":
	{
		"WEB_HEART_URL": "http://xxx",
		"WEB_HEART_TIME":5
	}
} 
```



### **获取采集端状态上报配置**

```
请求url: http://192.168.1.180:5555/sophon/v2/face/getconfigs
{
	
    "WEB_HEART_URL": "http://xxx",
    "WEB_HEART_TIME":5
	...   //其他配置项
}
```

