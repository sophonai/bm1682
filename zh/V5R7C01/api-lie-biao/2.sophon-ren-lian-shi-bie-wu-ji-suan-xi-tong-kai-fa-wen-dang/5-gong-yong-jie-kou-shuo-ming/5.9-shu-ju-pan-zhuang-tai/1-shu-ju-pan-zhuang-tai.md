# 图片存储路径状态查询/SophonFogSys/api/ImagePathStatusQuery（POST）

**功能描述**

查询当前图片存储路径是否有用（文件路径存在并且可写）

**调用URL**

http://192.168.1.180:5555/SophonFogSys/api/ImagePathStatusQuery

调用方法: POST

**请求参数**

无

**返回信息：**

请求成功

| 一级参数 | 二级参数        | 类型   | 描述                     |
| :------- | :-------------- | :----- | :----------------------- |
| data     |                 | dict   |                          |
|          | image_path      | string | 图片存储路径             |
|          | available       | bool   | 是否有用                 |
|          | message         | string | 告警信息，无的话为""     |
|          | english_message | sting  | 英文告警信息，无的话为"" |

请求成功示例：

```json
{
    "data": {
        "image_path" : "/data2/events",
      	"available" : true,
      	"message"  : "",
      	"english_message" : ""
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

