# 删除设备/sophon/v2/face/deletemediadevice（POST）

**版本**

2.0

**功能描述**

删除指定设备。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/deletemediadevice

调用方法: POST

**请求参数（JSON格式）**

| 一级参数        | 类型   | 默认值 | 选择 | 描述                          | 举例 |
| :-------------- | :----- | :----- | :--- | :---------------------------- | :--- |
| media_device_id | string | 无     | 必选 | 指定删除设备的ID               |"2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"     |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/deletemediadevice
请求方法：POST
请求body(JSON格式):
{
  "media_device_id":"2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"
}
```

**返回信息：**

**请求成功**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

请求成功示例：

```json
{
  "media_device_id":"2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd",
  "media_device_name":"ddd"
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述         |
| :------- | :------- | :----- | :----------- |
| error    | code     | int    | 请求错误码   |
|          | message  | string | 错误信息提示 |

**错误码**

| Index | 错误码                 | 描述                                                         |
| ----- | ---------------------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | MISSING_ARGUMENTS      | 缺乏必要的参数。缺失的参数在message字段中描述                |
| 3     | INVALID_ARGUMENTS      | 无效的参数。参数信息在message字段中描述。                    |
| 5     | DEVICE_ID_NOT_FOUND    | 设备id未找到                                                 |
