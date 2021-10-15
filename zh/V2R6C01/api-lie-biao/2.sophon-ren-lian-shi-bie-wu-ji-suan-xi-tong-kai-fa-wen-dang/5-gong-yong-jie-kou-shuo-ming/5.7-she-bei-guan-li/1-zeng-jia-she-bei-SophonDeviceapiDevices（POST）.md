# 增加设备/SophonDevice/api/Devices（POST）

**功能描述**

增加一个或者多个新的Device。

**调用URL**

http://192.168.1.180:5555/SophonDevice/api/Devices

调用方法: POST

**请求参数（JSON格式）**

| 一级参数     | 二级参数      | 三级参数   | 四级参数     | 类型   | 选择 | 描述                   | 举例                                                         |
| :----------- | :------------ | :--------- | :----------- | :----- | :--- | :--------------------- | :----------------------------------------------------------- |
| devices_list |               |            |              | list   | 可选 | 设备列表               |                                                              |
|              | device_id     |            |              | str    | 可选 | 设备id号，为uuid4      |                                                              |
|              | device_name   |            |              | str    | 必选 | 设备名称               |                                                              |
|              | group_id      |            |              | str    | 必选 | 绑定的比对组id         |                                                              |
|              | permission_id |            |              | str    | 必选 | 绑定的权限组名称       |                                                              |
|              | device_key    |            |              | str    | 必选 | 设备的地址             | 闸机和抓拍机：设备ip视频流：视频url地址                      |
|              | device_type   |            |              | string | 必选 | 设备类型               | photo:闸机或者抓拍机, <br /><br />rtsp:视频流,<br />file:本地文件 |
|              | device_attr   |            |              | dict   | 可选 | 每个设备的添加字段     |                                                              |
|              |               | actions    |              | dict   | 可选 | 视频流模式下的控制字段 |                                                              |
|              |               |            | do_detect    | bool   |      | 是否做人脸检测         | 仅在视频流模式下使用                                         |
|              |               |            | do_feature   | bool   |      | 是否做人脸特征提取     | 仅在视频流模式下使用                                         |
|              |               |            | do_track     | bool   |      | 是否做追踪             | 仅在视频流模式下使用                                         |
|              |               |            | fast_mode    | bool   |      | 是否进入快速识别模式   | 仅在视频流模式下使用                                         |
|              |               |            | do_match     | bool   |      | 是否做人脸比对         | 仅在视频流模式下使用                                         |
|              |               |            | do_attribute | bool   |      | 是否做人脸属性检测     | 仅在视频流模式下使用                                         |
|              | netRelay      |            |              | dict   | 可选 | 网络继电器设备         |                                                              |
|              |               | ip         |              | str    |      | 网络继电器ip           |                                                              |
|              |               | net_port   |              | int    |      | 网络继电器通信端口号   |                                                              |
|              |               | door_port  |              | int    |      | 绑定的网络继电器端口号 |                                                              |
|              |               | delay_time |              | int    |      | 开门之后等待多久关门   |                                                              |
|              | is_start_rtmp |            |              | bool   |      | 是否开启rtmp码流       |                                                              |
|              | rtmp_address  |            |              | string |      | rtmp码流地址           |                                                              |

请求示例：

```json
{
    "devices_list": [
        {
            "device_id": "2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd", //可选，可不传
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
            "device_name": "bbb",
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

| 一级参数 | 二级参数        | 三级参数    | 类型   | 描述               |
| :------- | :-------------- | :---------- | :----- | :----------------- |
| data     |                 |             | dict   |                    |
|          | success_devices |             | list   | 添加成功的设备列表 |
|          |                 | device_id   | string | 添加成功的设备id   |
|          |                 | device_name | string | 添加成功的设备名   |

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
