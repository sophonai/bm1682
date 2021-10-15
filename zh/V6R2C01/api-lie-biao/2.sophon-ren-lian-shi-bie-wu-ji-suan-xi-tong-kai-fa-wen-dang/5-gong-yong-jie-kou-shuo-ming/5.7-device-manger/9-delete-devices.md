# 删除所有设备/sophon/v2/face/deletemediadevices（POST）

**版本**

2.0

**功能描述**

本API用于删除全部的设备。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/deletemediadevices

调用方法: POST

**请求参数（JSON格式）**

无

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/deletemediadevices
```

**返回信息：**

**请求成功**

| 一级参数             | 类型 | 描述               |
| :------------------- | ---- | :----------------- |
| media_device_list    | list | 删除成功的设备id   |
| deleted_device_count | int  | 删除成功的设备数量 |
| total_device_count   | int  | 设备总数           |

请求成功示例：

```json
{
  "media_device_list":["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"],
  "deleted_device_count":1,
  "total_device_count": 1
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                 | 描述                                                         |
| ----- | ---------------------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | MISSING_ARGUMENTS      | 缺乏必要的参数。缺失的参数在message字段中描述                |
| 3     | INVALID_ARGUMENTS      | 无效的参数。参数信息在message字段中描述。                    |
| 5     | DEVICE_ID_NOT_FOUND    | 设备id未找到                                                 |
