# 增加设备/sophon/v2/face/addmediadevice（POST）

**版本**

2.0

**功能描述**

在做人脸识别应用时，通常是从前端视频媒体设备中获取图像输入，送给算法做分析处理。本API是用于增加一个前端媒体输入设备。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/addmediadevice

调用方法: POST

**请求参数（JSON格式）**

| 一级参数          | 二级参数     | 类型   | 默认值    |选择     | 描述          | 示例 |
| :---------------  | :---------- | :---- |:------- | :------- | :----------------------------------------------------------- |-------- |       
| media_device_name |              | str    |         | **必选** | 设备名称                                                     | "前门摄像头" |
| media_device_type |              | string |         | **必选** | 设备类型<br />"rtsp": 视频流<br />"photo": 图片流<br />"file": 本地视频文件<br />"gb28181": 国标视频流 | "rtsp" |
| media_device_url  |              | str    |         | **必选** | 设备的url地址，当前支持4种不同的类型,分别如右所示。 </br>注意：不支持相同url重复添加。 | "rtsp://192.168.1.100:554/main/av" </br>"192.168.1.22" </br> "/data/test.mp4"</br>"gb28281://xxxx" |
| media_device_id   |              | str    |         | 可选     | 设备唯一标识id号。<br />如果API调用时不指定，则系统会自动生成。 | |
| permission_id     |              | str    |         | 可选     | 绑定权限组id到此设备                                               | |
| net_relay         |              | dict   |         | 可选     | 网络继电器配置。</br>如果配置继电器，则每次此设备有人员识别通过时，系统会自动往继电器发送一次开关门脉冲信号。 | |
|                   | ip           | str    |         |          | 网络继电器ip                                                 | |
|                   | port         | int    |         |          | 网络继电器通信端口号                                         | |
|                   | channel      | int    |         |          | 控制的网络继电器的通道号                                     | |
|                   | delay_time   | int    |         |          | 继电器闭合之后的延迟时间                                     | |
| do_rtmp_forward   |              | bool   |         | 可选     | true:开启rtmp码流转发<br />false：关闭rtmp码流转发           | |
| rtmp_address      |              | string |         | 可选     | rtmp码流地址                                                 | |
| roi_area          |              | list   |   []      | 可选     | 感兴趣识别区域设置(人员只有进入感兴趣区域才会进行跟踪和识别)。</br>坐标[x1,y1,x2,y2]（x1，y1为左上坐标，x2，y2为右下坐标）<br />仅在视频流模式下有效; | [0,0,1920,1080]|

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/addmediadevice
请求方法：POST
请求body(JSON格式):
{
  "media_device_id": "2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd", 
  "media_device_url": "rtsp://192.168.1.100:554/ch2",
  "media_device_name": "bbb",
  "media_device_type": "rtsp",
  "net_relay": {},
  "permission_id": "820737ae-a6d3-4322-bf7c-46f48066fb64"
}
```

**返回信息：**

**请求成功**

| 一级参数          | 类型   | 描述             |
| :---------------- | :----- | :--------------- |
| media_device_id   | string | 添加成功的设备id |
| media_device_name | string | 添加成功的设备名 |

请求成功示例：

```json
{
    "media_device_id":"2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd",
    "media_device_name":"bbb"
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                              | 描述                                                         |
| ----- | ----------------------------------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE              | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | MISSING_ARGUMENTS                   | 缺乏必要的参数。缺失的参数在message字段中描述                |
| 3     | INVALID_ARGUMENTS                   | 无效的参数。参数信息在message字段中描述。                    |
| 4     | DEVICE_RTMP_ADDRESS_DUPLICATE_ERROR | rtmp推流地址重复                                             |
| 5     | DEVICE_MAX_NUM_ERROR                | 设备超出最大添加数量                                         |
| 6     | DEVICE_ADDRESS_DUPLICATE_ERROR      | device_url地址重复                                           |
