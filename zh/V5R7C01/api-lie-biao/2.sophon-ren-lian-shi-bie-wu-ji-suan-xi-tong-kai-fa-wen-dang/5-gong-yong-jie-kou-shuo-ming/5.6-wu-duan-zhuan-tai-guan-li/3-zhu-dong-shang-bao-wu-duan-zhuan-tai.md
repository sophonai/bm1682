# 设备状态上报内容

**功能描述**

上报 SE5 AI迷你机状态和其连接的子节点设备给管理平台。

上报的URL是由管理下发，参见登录管理平台接口定义。

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| 一级参数         | **二级参数**   | **三级参数** | **类型** | **选择** | **描述**                                                     |   举例                            |
| ---------------- | -------------- | ------------ | -------- | -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| gateway_ip       |                |              | string   | **必选** | SE3 AI迷你机的 IP 地址                                       |                                                              |
| gateway_name     |                |              | string   | **必选** | SE3 AI迷你机初始化时的主机名                                 |                                                              |
| gateway_status   |                |              | string   | **必选** | SE3 AI迷你机状态 <br />[online,offline]                      |                                                              |
| gateway_sn       |                |              | string   | **必选** | SE3 AI迷你机硬件SN编码                                       | "SZCCKQRAIJBAH0002"                                          |
| dev_sno          |                |              | string   | **必选** | SE3 AI迷你机登录管理平台用的授权码（由管理平台生成）         | "ZKZCPI000120190807142601"                                   |
| gateway_port | | | int | **必选** | SE3 AI迷你机上应用程序对应的访问端口 | 80 |
| gateway_ext_data |                |              | dict     | **必选** | 额外信息字段                                                 |                                                              |
|                  | sw_version     |              | string   | **必选** | 中心节点版本信息                                             | 'build.date=2019年 08月 06日 星期二 17:42:49 CST\nBUILD TIME: 20190806_173257\nVERSION: V2R1C01\n' |
|                  | sdk_version    |              | string   | **必选** | 算法版本                                                     | '1.1.56d1e91'                                                |
|                  | gateway_mac    |              | string   | **必选** | SE AI迷你机Mac地址                                          | 'e0:a5:09:00:0e:6d'                                          |
|                  | cpu_info  |              | dict | **必选** | SE AI迷你机cpu信息，请参考下面cpu_info字段 |                                                           |
|                  | memory_info |              | dict | **必选** | SE AI迷你机内存信息，请参考下面memory_info字段        |                                                          |
|                  | disk_info  |              | dict | **必选** | SE AI迷你机存储信息，请参考下面disk_info字段 |                                                         |
| | temperature | | int | **必选** | SE3 AI迷你机主板温度 | 37 |
| sub_devices      |                |              | list     | **必选** | 设备信息列表                                                 |                                                              |
|                  | ep_id          |              | string   | **必选** | 边缘节点ID，是指SE3 AI迷你机连接的采集设备的ID。<br /> ID：dev_sno和IP的组合，用双下划线做连接。举例：AKOPKKKKK__192.168.1.25 | 'ZKZCPI000120190807142601__192.168.1.101'                    |
|                  | ep_name        |              | string   | 可选     | 添加前端采集设备时设置的设备描述字符串                       | 'aaa'                                                        |
|                  | ep_ip          |              | string   | **必选** | 边缘节点ip地址                                               | '192.168.1.101'                                              |
|                  | ep_status      |              | string   | **必选** | 边缘节点状态[online, offline]                                |                                                              |
|                  | ep_location    |              | string   | **必选** | 边缘节点绑定的location                                       | '95274d2c-0941-4d96-b032-ab200f81362c'                       |
|                  | ep_type        |              | string   | **必选** | 0：闸机， <br />1：抓拍机 <br />3：IPC 动态 <br />4：门禁 | '1'                                                          |
|                  | ep_url         |              | string   | 可选     | 在视频流模式下有效，视频流url地址                            | 'rtsp://192.168.1.101:554/ch2'                               |

cpu_info字段信息如下：

| 二级参数 | 三级参数 | 三级参数  | 类型   | 选择     | 描述                           | 举例                   |
| -------- | -------- | --------- | ------ | -------- | ------------------------------ | ---------------------- |
| cpu_info |          |           |        | **必选** |                                |                        |
|          | cpu_rate |           | float  | **必选** | cpu使用率，满值为1，代表百分百 | 0.01，使用率为百分之一 |
|          | info     |           | dict   | **必选** |                                |                        |
|          |          | cpu_type  | string | **必选** | cpu型号。                      | "A53"                  |
|          |          | cpu_freg  | string | **必选** | cpu使用频率。                  | "2.3Ghz"               |
|          |          | cpu_count | string | **必选** | cpu核数。                      | "8"                    |

memory_info字段信息如下：

| 二级参数    | 三级参数              | 四级参数     | 类型   | 选择     | 描述               | 举例 |
| ----------- | --------------------- | ------------ | ------ | -------- | ------------------ | ---- |
| memory_info |                       |              |        | **必选** |                    |      |
|             | hardware_total_memory |              | string | **必选** | 板载总内存         |      |
|             | total_memory          |              | string | **必选** | 总内存             |      |
|             | total_free_memory     |              | string | **必选** | 剩余总内存         |      |
|             | total_used_memory     |              | string | **必选** | 已经使用内存       |      |
|             | total_memory_scale    |              | float  | **必选** | 总内存使用率       |      |
|             | system                |              |        | **必选** |                    |      |
|             |                       | system_scale | float  | **必选** | system占总内存比例 |      |
|             |                       | total        | string | **必选** | system总内存       |      |
|             |                       | free         | string | **必选** | system剩余内存     |      |
|             |                       | used         | string | **必选** | system使用内存     |      |
|             | tpu                   |              |        | **必选** |                    |      |
|             |                       | tpu_scale    | float  | **必选** | tpu占总内存比例    |      |
|             |                       | total        | string | **必选** | tpu总内存          |      |
|             |                       | free         | string | **必选** | tpu剩余内存        |      |
|             |                       | used         | string | **必选** | tpu使用内存        |      |
|             | video                 |              |        | **必选** |                    |      |
|             |                       | video_scale  | float  | **必选** | video占总内存比例  |      |
|             |                       | total        | string | **必选** | video总内存        |      |
|             |                       | free         | string | **必选** | video剩余内存      |      |
|             |                       | used         | string | **必选** | video使用内存      |      |

disk_info字段信息如下:

| 二级参数  | 三级参数            | 类型   | 选择     | 描述                   | 举例 |
| --------- | ------------------- | ------ | -------- | ---------------------- | ---- |
| disk_info |                     |        |          |                        |      |
|           | hardware_total_disk | string | **必选** | 板载总存储大小         |      |
|           | disk_rate           | float  | **必选** | 存储使用率             |      |
|           | total_disk          | string | **必选** | 总存储大小             |      |
|           | free_disk           | string | **必选** | 剩余存储               |      |
|           | used_disk           | string | **必选** | 已经使用的存储空间大小 |      |



**返回信息：**

```json
{
    "gateway_ip":"192.168.1.64 192.168.150.1",
    "gateway_port":80,
    "sub_devices": [{'ep_status': 'online', 
                   'ep_location': '95274d2c-0941-4d96-b032-ab200f81362c', 
                   'ep_url': 'rtsp://192.168.1.101:554/ch2', 
                   'ep_type': '2', 
                   'ep_name': '', 
                   'ep_id': 'ZKZCPI000120190807142601__192.168.1.101', 
                   'ep_ip': '192.168.1.101'}], 
    "gateway_name":"hyf64",
    "gateway_sn":"HQDZKE5BJJFJH0047",
    "gateway_status":"online",
    "dev_sno":"AAAZKE5xxJFJH0047",
    "gateway_ext_data":{
        "gateway_mac":"e0:a5:09:00:32:31",
        "cpu_info":{
            "info":{
                "cpu_type":"A53",
                "cpu_freq":"2.3Ghz",
                "cpu_count":"8"
            },
            "cpu_rate":0.01
        },
        "sdk_version":" V5R5C01_30ee591",
        "memory_info":{
            "total_free_memory":"10.46G",
            "system":{
                "system_scale":0.32,
                "used":"549.0M",
                "total":"3.71G",
                "free":"3.17G"
            },
            "video":{
                "video_scale":0.34,
                "used":"0.14M",
                "total":"3.88G",
                "free":"3.87G"
            },
            "total_memory":"11.51G",
            "total_used_memory":"1.05G",
            "hardware_total_memory":"12.0G",
            "total_memory_scale":0.09,
            "tpu":{
                "total":"3.92G",
                "used":"523.49M",
                "tpu_scale":0.34,
                "free":"3.41G"
            }
        },
        "disk_info":{
            "disk_rate":0.55,
            "used_disk":"16.68G",
            "free_disk":"13.86G",
            "total_disk":"30.54G",
            "hardware_total_disk":"32.0G"
        },
        "box_usage":null,
        "temperature":39,
        "sw_version":" V5R5C01_6a2c62d"
    }
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

