# 现场图删除接口

# /SophonFace/api/event_images（DELETE）

**功能描述**

根据现场图片id删除现场图，图片id为event字段的spot_pic_id或者recognize_face_pic_id。

**调用URL**

调用方法: DELETE

**请求参数**

| 一级参数 | 类型   |   默认值   | 选择 | 描述                                                         |   举例   |
| :------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| datetime_list | string |  | 必选 | event的timestamp的list，多个timestamp之间用逗号隔开 | 1607062639.7013178 |
| image_id_list | string | | 必选 | event的id的list，多个之间用逗号隔开 | 1607062639.7370062 |

请求示例：

```json
请求url: http://192.168.8.182:5555/SophonFace/api/event_images?image_id_list=1618827081.3165026,1618827081.316388,1618827067.697513&datetime_list=1618827067.5706,1618827067.5706,1618827067.5706
```

**返回信息：**

请求成功

```json
{
    "data": {}
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |