# 图像质量检测/SophonFace/api/FIQA（POST）

**功能描述**

人脸图像质量检测。

**调用URL**

http://192.168.1.180:5555/SophonFace/api/FIQA

调用方法: POST

**请求参数：**

| 参数             | 类型   | 默认值 | 选项         | 描述                                                      | 举例 |
| :--------------- | :----- | ------ | :----------- | :-------------------------------------------------------- | ---- |
| image_base64_str | string | 无     |              | 图片base64转换格式                                        |      |
| fiqa_level       | string | high   | 可选，可为空 | 质量检测级别，共high，middle，low，no 4个级别，默认为high |      |

**请求示例：**

```json
Request Url:
http://192.168.1.180:5555/SophonFace/api/FIQA
{
    "image_base64_str":"data:image/jpeg;base64,/9j/...
}
```



**返回信息：**

请求成功

| 参数        | 类型  | 描述                     |
| :---------- | :---- | :----------------------- |
| bbox        | list  | [xmin, ymin, xmax, ymax] |
| fails       | list  | 质量评估不合格的类别     |
| fiqa_result | bool  | 质量评估结果是否合格     |
| info        | dict  | 质量评估类别             |
| score       | float | 人脸质量分数             |
| success     | list  | 质量评估合格的类别       |

请求成功返回：

```json
{
    "data": [
        {
            "bbox": [
                95,
                61,
                529,
                652
            ],
            "fails": [],
            "fiqa_result": true,
            "info": {
                "clarity": 1.7304892992152823,
                "face_angle": [
                    7.167378813028336,
                    -1.192113496363163,
                    0.7817673683166504
                ],
                "face_color": 0.5837053571428571,
                "face_location": false,
                "face_size": 289,
                "image_quality": 1
            },
            "score": 1,
            "success": [
                "face_size",
                "image_quality",
                "face_location",
                "face_angle",
                "clarity",
                "face_color"
            ]
        }
    ]
}
```

请求失败:

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |