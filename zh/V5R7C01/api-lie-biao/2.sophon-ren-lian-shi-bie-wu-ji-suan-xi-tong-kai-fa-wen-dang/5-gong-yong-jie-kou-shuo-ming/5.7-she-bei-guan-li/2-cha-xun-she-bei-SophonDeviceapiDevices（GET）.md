# 查询设备/SophonDevice/api/Devices（GET）

**功能描述**

查询一个设备，或是返回所有的设备

**调用URL**

http://192.168.1.180:5555/SophonDevice/api/Devices

调用方法: GET

**请求参数**

| 参数            | 类型   |  默认值  | 选择 | 描述                                               |  举例  |
| :-------------- | :----- | ----------------------------------- | :--- | :------------------------------------------------- | --------------------------------- |
| device_id | string | 空                                  | 可选 | 根据设备id来查询设备，没有则返回所有设备 |                           |
| need_preview_list | boolean | False | 可选 | 是否返回预览列表，为True则返回预览列表 |  |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonDevice/api/Devices?need_preview_list=true
```



**返回信息：**

请求成功

| 一级参数 | 二级参数     | 三级参数 | 类型 | 描述     |
| :------- | :----------- | :------- | :--- | :------- |
| data     |              |          | dict |          |
|          | devices_list |          | list | 设备列表 |

请求成功示例：

```json
{
    "data": {
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
                "device_ip": "192.168.1.100",
                "device_key": "rtsp://192.168.1.100:554/ch2",
                "device_name": "ddd",
                "device_type":"rtsp",
                "group_id": "139e03c6-ab31-4af8-bcf6-24aa000dfdab",
                "netRelay": {},
                "permission_id": "820737ae-a6d3-4322-bf7c-46f48066fb64"
            }
        ]
        "preview_list":{
            "preview_list":["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"],
            "current_preview_list":["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"],
            "preview_mode":"1",
            "last_set_name":"WEBUI"
        }
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
