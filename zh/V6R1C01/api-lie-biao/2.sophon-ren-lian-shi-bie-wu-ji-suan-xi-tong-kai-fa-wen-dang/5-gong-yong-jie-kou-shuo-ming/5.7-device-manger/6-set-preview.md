# 更新设备预览信息/sophon/v2/face/updatepreview（POST）

**版本**

2.0

**功能描述**

本API用于设置设备预览的配置信息。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/updatepreview

调用方法: POST

**请求参数（JSON格式）**

| 参数                 | 类型   | 默认值 | 选择 | 描述                                                       | 举例 |
| :------------------- | :----- | ------ | :--- | :--------------------------------------------------------- | ---- |
| selected_device_list | list   | []     | 可选 | 选择的预览设备ID列表 |  ["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"]     |
| preview_device_list  | list   | []     | 可选 | 当前预览的设备ID列表 |["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"]  |
| preview_mode         | int    | 4      | 可选 | 预览模式1/4/16<br />选择当前预览为1宫格，4宫格或者是16宫格 |   4   |
| last_set_name        | string | ''     | 可选 | 最后更改配置信息的设备名。</br>"QT"/"WEBUI"| "QT"      |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/updatepreview
请求方法：POST
请求body(JSON格式):
{
  "selected_device_list":["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"],
  "preview_device_list":["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"],
  "preview_mode":"1",
  "last_set_name":"WEBUI"
}
```

**返回信息：**

**请求成功**

| 参数                 | 类型   | 默认值 | 选择 | 描述                                                       | 举例 |
| :------------------- | :----- | ------ | :--- | :--------------------------------------------------------- | ---- |
| selected_device_list | list   | []     | 必传 | 选择的预览设备ID列表 |  ["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"]     |
| preview_device_list  | list   | []     | 必传 | 当前预览的设备ID列表 |["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"]  |
| preview_mode         | int    | 4      | 必传 | 预览模式1/4/16<br />选择当前预览为1宫格，4宫格或者是16宫格 |   4   |
| last_set_name        | string | ''     | 必传 | 最后更改配置信息的设备名。</br>"QT"/"WEBUI"| "QT"      |

请求成功示例：

```json
{
  "selected_device_list":["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"],
  "preview_device_list":["2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"],
  "preview_mode":"1",
  "last_set_name":"WEBUI"
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                      | 描述                                                         |
| ----- | --------------------------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE      | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | DEVICE_INIT_ERROR           | 设备初始化中，无法读取设备信息                               |
| 3     | DEVICE_PERVIEW_ID_NOT_EXIST | 在设备列表里面无法找到该预览设备id                           |
