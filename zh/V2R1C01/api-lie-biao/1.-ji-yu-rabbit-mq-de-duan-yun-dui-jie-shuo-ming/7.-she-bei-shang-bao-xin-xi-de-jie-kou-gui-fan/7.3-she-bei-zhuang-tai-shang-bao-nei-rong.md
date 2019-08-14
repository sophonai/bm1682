# 设备状态上报内容

**功能描述**

上报 SE3 AI迷你机状态和其连接的子节点设备给管理平台。

上报的URL是由管理下发，参见登录管理平台接口定义。

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| 一级参数         | **二级参数**   | **三级参数** | **类型** | **选择** | **描述**                                                     | <font color="#000000">举例</font>                            |
| ---------------- | -------------- | ------------ | -------- | -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| gateway_ip       |                |              | string   | **必选** | SE3 AI迷你机的 IP 地址                                       |                                                              |
| gateway_name     |                |              | string   | **必选** | SE3 AI迷你机初始化时的主机名                                 |                                                              |
| gateway_status   |                |              | string   | **必选** | SE3 AI迷你机状态 <br />[online,offline]                      |                                                              |
| gateway_sn       |                |              | string   | **必选** | SE3 AI迷你机硬件SN编码                                       | "SZCCKQRAIJBAH0002"                                          |
| dev_sno          |                |              | string   | **必选** | SE3 AI迷你机登录管理平台用的授权码（由管理平台生成）         | "ZKZCPI000120190807142601"                                   |
| gateway_ext_data |                |              | dict     | **必选** | 额外信息字段                                                 |                                                              |
|                  | sw_version     |              | string   | **必选** | 中心节点版本信息                                             | 'build.date=2019年 08月 06日 星期二 17:42:49 CST\nBUILD TIME: 20190806_173257\nVERSION: V2R1C01\n' |
|                  | sdk_version    |              | string   | 可选     | 算法版本                                                     | '1.1.56d1e91'                                                |
|                  | gateway_mac    |              | string   | 可选     | SE3 AI迷你机Mac地址                                          | 'e0:a5:09:00:0e:6d'                                          |
|                  | cpu_usage      |              | float    | 可选     | CPU使用率（百分比）                                          | 1.3                                                          |
|                  | memory_size    |              | float    | 可选     | 内存大小，单位GB                                             | 1.55                                                         |
|                  | memory_usage   |              | float    | 可选     | 内存使用率                                                   | 0.87                                                         |
|                  | disk_size      |              | float    | 可选     | 磁盘大小，单位GB(/data分区)                                  | 10.39                                                        |
|                  | disk_free_size |              | float    | 可选     | 磁盘数据分区剩余可用空间，单位为GB(/data分区)                | 9.39                                                         |
| sub_devices      |                |              | list     | **必选** | 设备信息列表                                                 |                                                              |
|                  | ep_id          |              | string   | **必选** | 边缘节点ID，是指SE3 AI迷你机连接的采集设备的ID。<br /> ID：dev_sno和IP的组合，用双下划线做连接。举例：AKOPKKKKK__192.168.1.25 | 'ZKZCPI000120190807142601__192.168.1.101'                    |
|                  | ep_name        |              | string   | 可选     | 添加前端采集设备时设置的设备描述字符串                       | 'aaa'                                                        |
|                  | ep_ip          |              | string   | **必选** | 边缘节点ip地址                                               | '192.168.1.101'                                              |
|                  | ep_status      |              | string   | **必选** | 边缘节点状态[online, offline]                                |                                                              |
|                  | ep_location    |              | string   | **必选** | 边缘节点绑定的location                                       | '95274d2c-0941-4d96-b032-ab200f81362c'                       |
|                  | ep_type        |              | string   | **必选** | 0：闸机， <br />1：抓拍机 <br />2：IPC 静态 <br />3：IPC 动态 <br />4：门禁 | '1'                                                          |
|                  | ep_url         |              | string   | 可选     | 在视频流模式下有效，视频流url地址                            | 'rtsp://192.168.1.101:554/ch2'                               |



**返回信息：**

```json
{
  'dev_sno': 'ZKZCPI000120190807142601', 
  'gateway_ext_data': {'sdk_version': '1.1.56d1e91', 
                       'cpu_usage': 6.5, 
                       'disk_free_size': 9.41, 
                       'sw_version': 'build.date=2019年 08月 06日 星期二 17:42:49 CST\nBUILD TIME: 20190806_173257\nVERSION: V2R1C01\n', 
                       'memory_usage': 0.77, 
                       'memory_size': 1.55, 
                       'disk_size': 10.39, 
                       'gateway_mac': 'e0:a5:09:00:0e:6d'}, 
	'gateway_sn': 'SZCCKQRAIJBAH0002', 
	'sub_devices': [{'ep_status': 'online', 
                   'ep_location': '95274d2c-0941-4d96-b032-ab200f81362c', 
                   'ep_url': 'rtsp://192.168.1.101:554/ch2', 
                   'ep_type': '2', 
                   'ep_name': '', 
                   'ep_id': 'ZKZCPI000120190807142601__192.168.1.101', 
                   'ep_ip': '192.168.1.101'}], 
  'gateway_name': 'bm1682landy93', 
  'gateway_status': 'online', 
  'gateway_ip': '192.168.1.251 '
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

