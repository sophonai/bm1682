# 获取现场图/sophon/v2/face/getspotimage（GET）

**版本**

2.0

**功能描述**

根据图片存储ID获取图片数据。

获取现场图片id的方法请参考[事件查询接口](12-event-query.md)和[事件字段说明](13-event-detail.md)，图片id为event字段的spot_image_id或者recognize_face_image_id。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getspotimage/**image_id_XXXX**?timestamp=**timestamp_XXXXX**

调用方法: GET

**请求参数**

| 一级参数 | 类型   |   默认值   | 选择 | 描述                                                         |   举例   |
| :------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| image_id | string |  | 必选 | 图片id为event字段的spot_image_id或者recognize_face_image_id |  |
| timestamp | float |  | 必选 | event的timestamp字段，需要根据event产生的时间来查询图片 | 1607062639.7013178 |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getspotimage/1607062639.7370062?timestamp=1607062639.7013178
请求方法：GET
```

**返回信息：**

**请求成功**

直接返回图片binary

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |