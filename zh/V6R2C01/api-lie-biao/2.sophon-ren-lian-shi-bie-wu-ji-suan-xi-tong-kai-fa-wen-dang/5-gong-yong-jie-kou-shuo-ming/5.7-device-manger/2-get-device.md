# 查询设备/sophon/v2/face/getmediadevices（POST）

**版本**

2.0

**功能描述**

查询单个或者多个设备详细信息。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getmediadevices

调用方法: POST

**请求参数**

| 参数            | 类型   |  默认值  | 选择 | 描述                                               |  举例  |
| :-------------- | :----- | ----------------------------------- | :--- | :------------------------------------------------- | --------------------------------- |
| media_device_id | string | 空                                  | 可选 | 根据设备id来查询设备，没有传该值返回所有设备信息 |                           |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getmediadevices
请求方法：POST
请求body(JSON格式):
{}
```



**返回信息：**

**请求成功**

| 一级参数 | 二级参数 | 类型 | 描述     |
| :------- | :------- | :--- | :------- |
| devices  |          | list | 设备列表 |

请求成功示例：

```json
{
    "devices": [
      {
        "media_device_id": "2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd",
        "media_device_ip": "192.168.1.100",
        "media_device_url": "rtsp://192.168.1.100:554/ch2",
        "media_device_name": "ddd",
        "media_device_type":"rtsp",
        "net_relay": {},
        "permission_id": "820737ae-a6d3-4322-bf7c-46f48066fb64"
      }
    ]
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码            | 描述                 |
| ----- | ----------------- | -------------------- |
| 1     | DEVICE_INIT_ERROR | 设备初始化中，请稍候 |
