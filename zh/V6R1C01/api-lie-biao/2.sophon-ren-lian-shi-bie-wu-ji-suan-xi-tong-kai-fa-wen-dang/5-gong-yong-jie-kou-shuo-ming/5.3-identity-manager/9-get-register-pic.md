# 获取底库图片/sophon/v2/face/getregisterimage（GET）

**版本**

2.0

**功能描述**

根据底库人员图片id获取对应底库图片。

请参考[人员信息详细列表](2-get-identity.md)，获取register_image_ids中image_id

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/getregisterimage/xxx_xxx(image_id)

调用方法: GET

**请求参数：**

无

**请求示例：**

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/getregisterimage/4ead3ae3-54ff-4eff-9673-87d01ff10244
请求方法：GET
```

**请求成功：**

返回图片数据，Content-Type: image/jpeg。

**请求失败**

返回空白图片
