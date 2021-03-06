# 现场图获取接口

# /SophonFace/api/event_images/***（GET）

**功能描述**

根据现场图id获取图片数据，图片id为event字段的spot_pic_id或者recognize_face_pic_id。

**调用URL**

调用方法: GET

**请求参数**

| 一级参数 | 类型   |   默认值   | 选择 | 描述                                                         |   举例   |
| :------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| datetime | float |  | 必选 | event的timestamp字段，需要根据event产生的时间来查询图片 | 1607062639.7013178 |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFace/api/event_images/1607062639.7370062?datetime=1607062639.7013178
```

**返回信息：**

请求成功

直接返回图片binary

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |