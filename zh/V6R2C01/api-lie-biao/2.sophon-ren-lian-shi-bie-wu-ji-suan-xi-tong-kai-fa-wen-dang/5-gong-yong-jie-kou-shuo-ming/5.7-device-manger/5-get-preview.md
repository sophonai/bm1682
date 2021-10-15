# 查询设备预览信息/sophon/v2/face/getpreview（POST）

**版本**

2.0

**功能描述**

系统支持将算法实时分析处理的图像和分析结果，通过websocket通信传到应用平台，一般用于应用平台大屏实时展示面板。支持的特性如下：</br>
a. 支持选择多个设备同时预览 </br>
b. 支持单画面、四宫格、十六宫格等多种显示模式切换 </br>
c. 支持Web浏览器和HDMI输出多屏同步显示</br>

本API用于查询设备预览的配置信息。
参考UI界面如下如示：</br>

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getpreview

调用方法: POST

**请求参数**

无

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getpreview
请求方法：POST
请求body(JSON格式):
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

| Index | 错误码            | 描述                           |
| ----- | ----------------- | ------------------------------ |
| 1     | DEVICE_INIT_ERROR | 设备初始化中，无法读取设备信息 |
