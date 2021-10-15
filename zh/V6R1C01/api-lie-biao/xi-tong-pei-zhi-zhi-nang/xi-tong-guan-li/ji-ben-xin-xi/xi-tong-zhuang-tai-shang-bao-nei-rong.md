# 系统状态信息上报

**功能描述**

上报 SE AI迷你机系统状态信息。

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| 一级参数         | **二级参数**   | **三级参数** | **类型** | **选择** | **描述**                                                     |   举例                            |
| ---------------- | -------------- | ------------ | -------- | -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| gateway_ip       |                |              | string   | **必选** | 边缘计算盒的 IP 地址                          |                                                              |
| gateway_name     |                |              | string   | **必选** | 边缘计算盒的主机名                            |                                                              |
| gateway_status   |                |              | string   | **必选** | 边缘计算盒状态 <br />[online,offline]                 |                                                              |
| gateway_sn       |                |              | string   | **必选** | 边缘计算盒硬件SN编码                                  | "SZCCKQRAIJBAH0002"                                          |
| gateway_mac | | | string | **必选** | 边缘计算盒eth0 Mac地址 | 'e0:a5:09:00:0e:6d' |
| reporter_id |                |              | string   | **必选** | 用于标识边缘计算盒 | "ZKZCPI000120190807142601"                                   |
| gateway_ext_data |                |              | dict     | **必选** | 额外信息字段                                                 |                                                              |
|                  | cpu_info  |              | dict | **必选** | 边缘计算盒cpu信息，请参考下面cpu_info字段 |                                                           |
|                  | memory_info |              | dict | **必选** | 边缘计算盒内存信息，请参考下面memory_info字段   |                                                          |
|                  | disk_info  |              | dict | **必选** | 边缘计算盒存储信息，请参考下面disk_info字段 |                                                         |
| | external_hard_drives_info | | dict | **必选** | 外置硬盘信息，请参考下面external_hard_drives_info字段 | |
| | core_temperature | | float | **必选** | SE AI迷你机主板温度 | 37 |
| | board_temperature |  | float | **必选** | 主板温度 | 39 |
| | fan_speed |  | float | **必选** | 风扇转速, 若无风扇，则默认为0.0, 单位为r/min | 4400.0                     |
|                  | uptime |              | string | **必选** | 系统运行时间 |                            |
|                  | tpu_info |              | dict | **必选** | 边缘计算盒tpu信息，请参考下面tpu_info字段 |  |

cpu_info字段信息如下：

| 二级参数 | 三级参数      | 类型   | 选择     | 描述                                                         | 举例                   |
| -------- | ------------- | ------ | -------- | ------------------------------------------------------------ | ---------------------- |
| cpu_info |               |        | **必选** |                                                              |                        |
|          | cur_cpu_usage | float  | **必选** | 归一化之后的cpu使用率。<br />例如：8核cpu使用率满值为800%，会最终归一化为1.0 | 0.01，使用率为百分之一 |
|          | cpu_arch      | string | **必选** | cpu型号。                                                    | "A53"                  |
|          | cpu_freg      | string | **必选** | cpu使用频率。                                                | "2.3Ghz"               |
|          | cpu_cores     | string | **必选** | cpu核数。                                                    | "8"                    |

tpu_info字段信息如下：

| 二级参数 | 三级参数        | 类型   | 选择     | 描述                             | 举例                           |
| :------- | :-------------- | :----- | :------- | :------------------------------- | :----------------------------- |
| tpu_info |                 |        | **必选** |                                  |                                |
|          | tpu_usage       | float  | **必选** | tpu使用率，满值为1.0，代表百分百 | 0.01，使用率为百分之一         |
|          | tpu_description | string | **必选** | tpu基本信息                      | "INT8 17.6TOP;FP32 3.0 TFLOPS" |

memory_info字段信息如下：

| 二级参数    | 三级参数         | 四级参数     | 类型   | 选择     | 描述                                               | 举例 |
| ----------- | ---------------- | ------------ | ------ | -------- | -------------------------------------------------- | ---- |
| memory_info |                  |              |        | **必选** |                                                    |      |
|             | total_memory     |              | string | **必选** | 板载总内存                                         |      |
|             | svt_memory       |              | string | **必选** | 系统、视频、tpu内存之和（SVT：system, video, tpu） |      |
|             | svt_free_memory  |              | string | **必选** | SVT剩余总内存                                      |      |
|             | svt_used_memory  |              | string | **必选** | SVT使用内存                                        |      |
|             | svt_memory_usage |              | float  | **必选** | SVT内存使用率                                      |      |
|             | system           |              |        | **必选** |                                                    |      |
|             |                  | system_scale | float  | **必选** | system占总内存比例                                 |      |
|             |                  | total        | string | **必选** | system总内存                                       |      |
|             |                  | free         | string | **必选** | system剩余内存                                     |      |
|             |                  | used         | string | **必选** | system使用内存                                     |      |
|             | tpu              |              |        | **必选** |                                                    |      |
|             |                  | tpu_scale    | float  | **必选** | tpu占总内存比例                                    |      |
|             |                  | total        | string | **必选** | tpu总内存                                          |      |
|             |                  | free         | string | **必选** | tpu剩余内存                                        |      |
|             |                  | used         | string | **必选** | tpu使用内存                                        |      |
|             | video            |              |        | **必选** |                                                    |      |
|             |                  | video_scale  | float  | **必选** | video占总内存比例                                  |      |
|             |                  | total        | string | **必选** | video总内存                                        |      |
|             |                  | free         | string | **必选** | video剩余内存                                      |      |
|             |                  | used         | string | **必选** | video使用内存                                      |      |

emmc字段信息如下:

| 二级参数 | 三级参数         | 类型   | 选择     | 描述                                | 举例 |
| -------- | ---------------- | ------ | -------- | ----------------------------------- | ---- |
| emmc     |                  |        |          |                                     |      |
|          | mount_status     | bool   | **必选** | true: 已经mount<br />false: 未mount |      |
|          | nominal_capacity | string | **必选** | 板载总存储大小                      |      |
|          | disk_usage       | float  | **必选** | 存储使用率                          |      |
|          | total_disk       | string | **必选** | 总存储大小                          |      |
|          | free_disk        | string | **必选** | 剩余存储                            |      |
|          | used_disk        | string | **必选** | 已经使用的存储空间大小              |      |

hdd字段信息如下:

| 二级参数 | 三级参数         | 类型   | 选择     | 描述                                | 举例 |
| :------- | :--------------- | :----- | :------- | :---------------------------------- | :--- |
| hdd      |                  |        |          |                                     |      |
|          | mount_status     | bool   | **必选** | true: 已经mount<br />false: 未mount |      |
|          | nominal_capacity | string | **必选** | 板载总存储大小                      |      |
|          | disk_usage       | float  | **必选** | 存储使用率                          |      |
|          | total_disk       | string | **必选** | 总存储大小                          |      |
|          | free_disk        | string | **必选** | 剩余存储                            |      |
|          | used_disk        | string | **必选** | 已经使用的存储空间大小              |      |

**返回信息：**

```json
{
    "gateway_ip": "192.168.1.180",
    "gateway_status": "online",
    "gateway_port": 80,
    "gateway_name": "yifan68",
    "gateway_sn": "HQDZKE5BJJFJH0042",
    "reporter_id": "AFVKQF000120210604151110",
    "gateway_mac": "e0:a5:09:00:31:0f",
    "gateway_ext_data": {
        "fan_speed": 0.0,
        "core_temperature": 45.0,
        "board_temperature": 47.0,
        "uptime": "2hours,40minutes",
        "cpu_info": {
            "cpu_freq": "2.3Ghz",
            "cpu_arch": "A53",
            "cur_cpu_usage": 0.37,
            "cpu_cores": "8"
        },
        "tpu_info": {
            "tpu_usage": 0.14,
            "tpu_description": "INT817.6TOP;FP323.0TFLOPS"
        },
        "memory_info": {
            "video": {
                "used": "522.93M",
                "total": "3.88G",
                "video_scale": 0.34,
                "free": "3.36G"
            },
            "svt_free_memory": "9.74G",
            "svt_memory_usage": 0.15,
            "svt_memory": "11.51G",
            "total_memory": "12.0G",
            "svt_used_memory": "1.77G",
            "system": {
                "used": "472.0M",
                "total": "3.71G",
                "system_scale": 0.32,
                "free": "3.25G"
            },
            "tpu": {
                "used": "814.86M",
                "total": "3.92G",
                "tpu_scale": 0.34,
                "free": "3.13G"
            }
        },
        
        "emmc": {
            "total_disk": "30.54G",
            "nominal_capacity": "32.0G",
            "free_disk": "13.32G",
            "used_disk": "17.22G",
            "mount_status": true,
            "disk_usage": 0.56
        },
        "hdd": {
            "total_disk": "229.7G",
            "nominal_capacity": "229.7G",
            "mount_status": true,
            "free_disk": "217.9G",
            "used_disk": "11.8G",
            "disk_usage": 0.05
        }
        
    }
    
}

```

