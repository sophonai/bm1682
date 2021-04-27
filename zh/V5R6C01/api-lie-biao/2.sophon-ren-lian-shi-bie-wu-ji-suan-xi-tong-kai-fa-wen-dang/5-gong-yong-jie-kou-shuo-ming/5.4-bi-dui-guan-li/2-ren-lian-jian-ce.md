# 人脸检测/SophonFace/api/detect（POST）

**功能描述**

检测人脸边界框、属性和特征等。

**调用URL**

http://192.168.1.180:5555/SophonFace/api/detect

调用方法: POST

**请求参数（JSON格式）**

| 一级参数         | 类型   | 默认值 | 选择                     | 描述                                                         | 举例 |
| :--------------- | :----- | ------ | :----------------------- | :----------------------------------------------------------- | ---- |
| image_base64_str | string | 无     | 与image_url二选一        | 图片base64转换格式                                           |      |
| image_url        | string | 无     | 与image_base64_str二选一 | 带有图片的url                                                |      |
| with_feature     | bool   | false  | 可选                     | 返回值是否带[512d]feature                                    |      |
| with_attribute   | bool   | false  | 可选                     | 返回值是否带人脸属性，当前支持性别&年龄                      |      |
| with_headpose    | bool   | false  | 可选                     | 返回值是否带给定图片的头部角度                               |      |
| with_landmark    | bool   | false  | 可选                     | 返回值是否带给定图片的landmark，<br />[x1, x2, x3, x4, x5, y1, y2, y3, y4, y5]， |      |
| max_num_faces    | int    | 10     | 可选                     | 最大识别的人脸数，默认为10                                   |      |

**请求示例：**

```json
http://192.168.1.180:5555/SophonFace/api/detect
{
    "image_base64_str": "data:image/jpeg;base64,/9j/........",
    "with_feature": true,
    "with_attribute": true
}
```



**返回信息:**

**请求成功：**

| 字段      | 类型 | 描述                                     |
| :-------- | :--- | :--------------------------------------- |
| attribute | dict | 人脸属性(年龄，性别)                     |
| bbox      | list | [xmin, ymin, xmax, ymax]                 |
| landmark  | list | [x1, x2, x3, x4, x5, y1, y2, y3, y4, y5] |
| feature   | list | [512d]feature                            |

**请求成功示例：**

```json
{
    "data": [
        {
            "attribute": {
                "age": 27,
                "gender": "male"
            },
            "bbox": [
                168,
                160,
                457,
                554
            ],
            "feature": [
                0.529029130935669,
                0.14555488526821136,
                -0.14316116273403168,
                ...
            ]
        }
    ]

```

**请求失败：**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |