# 底库图获取接口

# /SophonFace/api/images/***（GET）

**功能描述**

根据底库id获取图片数据，图片id为event字段的identity_info下面的image_id字段。

**调用URL**

调用方法: GET

**请求参数**

无

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFace/api/images/d471e264-1518-48f5-b5c9-15a0cb2eab33
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