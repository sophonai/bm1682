# 更新设备/SophonDevice/api/Devices（PUT）

**功能描述**

更新一个或者多个设备信息

**调用URL**

http://192.168.1.180:5555/SophonDevice/api/Devices

调用方法: PUT

**请求参数（JSON格式）**

| 一级参数     | 二级参数             | 三级参数   | 四级参数     | 类型   | 默认值 | 选择 | 描述                                                         | 举例                                    |
| :----------- | :------------------- | :--------- | :----------- | :----- | :----- | :--- | :----------------------------------------------------------- | :-------------------------------------- |
| devices_list |                      |            |              | list   | 无     | 必选 | 设备列表，与preview_list无法一同设置                         |                                         |
|              | device_id            |            |              | str    | Y      | 必选 | 设备id号，为uuid4                                            |                                         |
|              | device_name          |            |              | str    | Y      | 必选 | 设备名称                                                     |                                         |
|              | group_id             |            |              | str    | Y      | 必选 | 比对组id                                                     |                                         |
|              | permission_id        |            |              | str    | N      | 必选 | 绑定的权限组名称                                             |                                         |
|              | device_key           |            |              | str    | N      | 必选 | 设备的地址                                                   | 闸机和抓拍机：设备ip视频流：视频url地址 |
|              | is_start_rtmp        |            |              | bool   |        | 可选 | 是否开启rtmp码流                                             |                                         |
|              | rtmp_address         |            |              | string |        | 可选 | rtmp码流地址                                                 |                                         |
|              | device_type          |            |              | string | Y      | 必选 | 设备类型,<br />photo:闸机或者抓拍机, <br /><br />rtsp:视频流,<br />file:本地文件<br />gb28181:国标视频流 | 0:闸机或者抓拍机3:视频流                |
|              | device_attr          |            |              | dict   | Y      | 可选 | 每个设备的添加字段                                           |                                         |
|              |                      | actions    |              | dict   | N      | {}   | 视频流模式下的控制字段                                       |                                         |
|              |                      |            | do_detect    | bool   |        |      | 是否做人脸检测                                               | 仅在视频流模式下使用                    |
|              |                      |            | do_feature   | bool   |        |      | 是否做人脸特征提取                                           | 仅在视频流模式下使用                    |
|              |                      |            | do_track     | bool   |        |      | 是否做追踪                                                   | 仅在视频流模式下使用                    |
|              |                      |            | fast_mode    | bool   |        |      | 是否进入快速识别模式                                         | 仅在视频流模式下使用                    |
|              |                      |            | do_match     | bool   |        |      | 是否做人脸比对                                               | 仅在视频流模式下使用                    |
|              |                      |            | do_attribute | bool   |        |      | 是否做人脸属性检测                                           | 仅在视频流模式下使用                    |
|              | netRelay             |            |              | dict   |        | 可选 | 网络继电器设备                                               |                                         |
|              |                      | ip         |              | str    |        |      | 网络继电器ip                                                 |                                         |
|              |                      | net_port   |              | int    |        |      | 网络继电器通信端口号                                         |                                         |
|              |                      | door_port  |              | int    |        |      | 绑定的网络继电器端口号                                       |                                         |
|              |                      | delay_time |              | int    |        |      | 开门之后等待多久关门                                         |                                         |
| preview_list |                      |            |              | dict   | 无     | 可选 | 预览设置，设置该参数时，device_list无效                      |                                         |
|              | preview_list         |            |              | list   | 无     | 必选 | 预览列表,可以下一页切换的列表                                |                                         |
|              | current_preview_list |            |              | list   | 无     | 必选 | 真正的预览列表，送给底层开启预览的                           |                                         |
|              | preview_mode         |            |              | string | 无     | 必选 | 1/4/16预览模式是1宫格 or 4宫格 or 16宫格                     |                                         |
|              | last_set_name        |            |              | string | 无     | 必选 | 'WEBUI'/'QT'                                                 |                                         |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonDevice/api/Devices?
请求body:
{
    "devices_list": [
        {
            "device_id": "2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd",
            "device_attr": {
                "actions": {
                    "do_attribute": false,
                    "do_detect": true,
                    "do_feature": true,
                    "do_match": true,
                    "do_track": true,
                    "fast_mode": false,
                    "paint_bbox": false,
                    "paint_landmark": false
                }
            },
            "device_key": "rtsp://192.168.1.100:554/ch2",
            "device_name": "ddd",
            "device_type": "rtsp",
            "group_id": "139e03c6-ab31-4af8-bcf6-24aa000dfdab",
            "netRelay": {},
            "permission_id": "820737ae-a6d3-4322-bf7c-46f48066fb64"
        }
    ]
} 
```

**返回信息：**

请求成功

| 一级参数 | 二级参数        | 类型 | 描述                   |
| :------- | :-------------- | ---- | :--------------------- |
| data     |                 | dict |                        |
|          | success_devices | list | 返回删除成功的设备列表 |

请求成功示例：

```json
{
    "data": {
            "success_devices":[
                 {"device_id":"","device_name":""}
            ]
        }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
