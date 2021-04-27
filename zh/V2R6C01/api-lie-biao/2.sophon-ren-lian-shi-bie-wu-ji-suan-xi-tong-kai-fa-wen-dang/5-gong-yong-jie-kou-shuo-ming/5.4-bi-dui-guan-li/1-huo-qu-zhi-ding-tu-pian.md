# 获取指定图片/SophonFace/api/images/<image_id>（GET）

**功能描述**

获取指定图片id的图片数据。

**调用URL**

http://192.168.1.180:5555/SophonFace/api/images/<image_id>

调用方法: GET

**请求参数：**

无

**请求示例：**

```json
Request Url:
http://192.168.1.180:5555/SophonFace/api/images/4ead3ae3-54ff-4eff-9673-87d01ff10244
```

**请求成功：**

返回图片数据，Content-Type: image/jpeg。



**请求失败：**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |