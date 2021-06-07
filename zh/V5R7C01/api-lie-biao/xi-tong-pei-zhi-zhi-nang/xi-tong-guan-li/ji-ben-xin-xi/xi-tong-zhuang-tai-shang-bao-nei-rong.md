# 系统状态信息上报

**功能描述**

上报 SE AI迷你机系统状态信息。

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
| gateway_port | | | int | **必选** | SE AI迷你机上应用程序对应的访问端口 | 80 |
| gateway_ext_data |                |              | dict     | **必选** | 额外信息字段                                                 |                                                              |
|                  | sw_version     |              | string   | **必选** | 中心节点版本信息                                             | 'build.date=2019年 08月 06日 星期二 17:42:49 CST\nBUILD TIME: 20190806_173257\nVERSION: V2R1C01\n' |
|                  | sdk_version    |              | string   | **必选** | 算法版本                                                     | '1.1.56d1e91'                                                |
|                  | gateway_mac    |              | string   | **必选** | SE AI迷你机Mac地址                                          | 'e0:a5:09:00:0e:6d'                                          |
|                  | cpu_info  |              | dict | **必选** | SE AI迷你机cpu信息，请参考下面cpu_info字段 |                                                           |
|                  | memory_info |              | dict | **必选** | SE AI迷你机内存信息，请参考下面memory_info字段        |                                                          |
|                  | disk_info  |              | dict | **必选** | SE AI迷你机存储信息，请参考下面disk_info字段 |                                                         |
| | external_hard_drives_info | | dict | **必选** | 外置硬盘信息，请参考下面external_hard_drives_info字段 | |
| | temperature | | int | **必选** | SE AI迷你机主板温度 | 37 |
| | board_temperature |  | int | **必选** | 主板温度 | 39 |
| | nnsdk_version |  | string | **必选** | 系统版本 |  |
| | fan_speed |  | string | **必选** | 风扇转速， 单位为r/min | 40r/min |
| | uptime |  | string | **必选** | SE系统运行时间, 例如“1 day, 9 hours”，用于直接展示 | 1 day, 9 hours |
| | tpu_info |  | dict | **必选** | tpu信息，请参考下面tpu_info字段 |  |

cpu_info字段信息如下：

| 二级参数 | 三级参数 | 三级参数  | 类型   | 选择     | 描述                           | 举例                   |
| -------- | -------- | --------- | ------ | -------- | ------------------------------ | ---------------------- |
| cpu_info |          |           |        | **必选** |                                |                        |
|          | cpu_rate |           | float  | **必选** | cpu使用率，满值为1，代表百分百 | 0.01，使用率为百分之一 |
|          | info     |           | dict   | **必选** |                                |                        |
|          |          | cpu_type  | string | **必选** | cpu型号。                      | "A53"                  |
|          |          | cpu_freg  | string | **必选** | cpu使用频率。                  | "2.3Ghz"               |
|          |          | cpu_count | string | **必选** | cpu核数。                      | "8"                    |

tpu_info字段信息如下：

| 二级参数 | 三级参数 | 三级参数 | 类型   | 选择     | 描述                           | 举例                           |
| :------- | :------- | :------- | :----- | :------- | :----------------------------- | :----------------------------- |
| tpu_info |          |          |        | **必选** |                                |                                |
|          | tpu_rate |          | float  | **必选** | tpu使用率，满值为1，代表百分百 | 0.01，使用率为百分之一         |
|          | info     |          | dict   | **必选** |                                |                                |
|          |          | detail   | string | **必选** | tpu基本信息                    | "INT8 17.6TOP;FP32 3.0 TFLOPS" |

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

external_hard_drives_info字段信息如下:

| 二级参数                  | 三级参数                 | 类型   | 选择     | 描述                                            | 举例 |
| :------------------------ | :----------------------- | :----- | :------- | :---------------------------------------------- | :--- |
| external_hard_drives_info |                          |        |          |                                                 |      |
|                           | external_hard_state      | string | **必选** | "0":  没有挂载外接硬盘<br />"1"：挂载了外接硬盘 |      |
|                           | external_hard_disk_rate  | float  | **必选** | 存储使用率                                      |      |
|                           | external_hard_total_disk | string | **必选** | 总存储大小                                      |      |
|                           | external_hard_free_disk  | string | **必选** | 剩余存储                                        |      |
|                           | external_hard_used_disk  | string | **必选** | 已经使用的存储空间大小                          |      |

**返回信息：**

```json
{
    "gateway_ip":"192.168.1.64 192.168.150.1",
    "gateway_port":80,
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
        "external_hard_drives_info":{
            "external_hard_state":"1",  
            "external_hard_disk_rate":0.6,
            "external_hard_total_disk":"500G",
            "external_hard_free_disk":"200G",
            "external_hard_used_disk":"300G"
           },
        "box_usage":null,
        "temperature":39,
        "board_temperature":39,
        "sw_version":"V5R5C01_6a2c62d",
        "nnsdk_version":"2.0.3_20200512_175058",
        "fan_speed":"0r/min",
        "uptime": "30 minutes",
        "tpu_info": {
                "info": {
                    "detail": "INT8 17.6TOP;FP32 2.2TFLOPS"
                 },
                "tpu_rate": 0.15
        }
                                                                  
    }
}

```

