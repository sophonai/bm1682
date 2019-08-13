#### 主动上报雾端状态

**功能描述**

上报设备状态给云平台。需要和监控服务器约定url，假设/MonitorServer/api/SophonFogStatus

**调用URL**

调用方法: POST

**请求参数（JSON格式，form-data格式）**

| 一级参数         | 二级参数    | 三级参数   | 类型   | 选择 | 描述                                                         |
| :--------------- | :---------- | :--------- | :----- | :--- | :----------------------------------------------------------- |
| gateway_ip       |             |            | string | 必选 | 小盒子ip                                                     |
| gateway_name     |             |            | string | 必选 | 别名                                                         |
| gateway_status   |             |            | string | 必选 | 小盒子状态                                                   |
| gateway_sn       |             |            | string | 必选 | SN编码                                                       |
| dev_sno          |             |            | string | 可选 | 小盒子注册id号, 授权码                                       |
| gateway_ext_data |             |            | dict   | 必选 | 额外信息字段                                                 |
|                  | sw_version: |            | string | 可选 | 中心节点版本信息                                             |
|                  | sdk_version |            | string | 可选 | 算法版本                                                     |
|                  | gateway_mac |            | string | 可选 | 小盒子的Mac地址                                              |
|                  | cpu_use     |            | float  | 可选 | cpu使用率                                                    |
|                  | memory_size |            | float  | 可选 | 内存大小，单位GB                                             |
|                  | memory_use  |            | float  | 可选 | 内存使用率                                                   |
|                  | disk_size   |            | float  | 可选 | 磁盘大小，单位GB                                             |
|                  | disk_use    |            | float  | 可选 | 磁盘使用率                                                   |
|                  | status      |            | string | 可选 | 设备状态 -1异常，0正常                                       |
|                  | status_desc |            | float  | 可选 | 设备状态描述                                                 |
| sub_devices      |             |            | list   | 必选 | 设备信息列表                                                 |
|                  | ep_id       |            | string | 必选 | 边缘节点ID，是指SE3 AI迷你机连接的采集设备的ID。ID：dev_sno和IP的组合，用双下划线做连接。举例：AKOPKKKKK__192.168.1.25 |
|                  | ep_name     |            | string | 可选 | 别名（目前IPC没有）                                          |
|                  | ep_ip       |            | string | 必选 | 边缘节点ip地址                                               |
|                  | ep_status   |            | string | 必选 | 边缘节点状态[online, offline]                                |
|                  | ep_location |            | string | 可选 | 边缘节点location id                                          |
|                  | ep_type     |            | string | 必选 | 0：闸机，<br />1：抓拍机<br />2：IPC 静态<br />3：IPC 动态<br />4：门禁 |
|                  | ep_ext_data |            | string | 必选 | 边缘节点其他信息                                             |
|                  |             | sw_version | string | 可选 | 软件版本                                                     |
|                  |             | group_name | string | 可选 | 比对的分组                                                   |

**返回信息：**

暂时不处理

**示例：**

可以使用小盒子附带的server来获取上传的事件。

假设小盒子的ip为：192.168.1.19，接收的resetful api为SophonFogStatus ，端口号为9528。

那webui或是配置/修改状态上报接收服务器地址SophonFogStatus，中填写的信息为：[http://192.168.1.19:9528/SophonFogStatus](http://192.168.1.19:9528/RealTimeEvent)

启动server方法：

$ sudo -i

\# cd /system/data/sophon_gate/script

\# python3 Event_Receive_server.py

```
* Serving Flask app "Event_Receive_server" (lazy loading)
* Environment: production
 WARNING: Do not use the development server in a production environment.
 Use a production WSGI server instead.
* Debug mode: off
* Running on http://0.0.0.0:9528/ (Press CTRL+C to quit)
```

