# 获取识别记录的本地图片存储路径/sophon/v2/face/checkeventimagepath（POST）

**功能描述**

获取当前现场图存储路径，并同时返回是否为可用状态（存在并且可正常读写）。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/checkeventimagepath

调用方法: POST

**请求参数**

无

**返回信息：**

请求成功

| 一级参数         | 类型    | 描述                                                         |
| :--------------- | :------ | :----------------------------------------------------------- |
| event_image_path | string  | 图片存储路径                                                 |
| available        | boolean | false: 当前路径不可用 </br>true: 当前路径可用 |

请求成功示例：

```json
{
  "event_image_path" : "/data2/events",
  "available" : true
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

