# 删除人员/sophon/v2/face/deleteidentities (POST)

**版本**

2.0

**功能描述**

删除多个人员。

注意:

该操作会将该人员从对应的权限组中解绑，同时，将该人员下面的人脸，注册照片删除。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/deleteidentities

调用方法: POST

**请求参数（JSON格式）**

| 参数        | 类型   |  默认值  | 选择 | 描述   |  举例  |
| :---------- | :----- | ----------------------------------- | :--- | :----- | --------------------------------- |
| identity_ids | list | 无                                  | 必选 | 人员ID | ["100000", "100001"]                          |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/deleteidentities
请求方法：POST
请求body(JSON格式):
	{
		"identity_ids":["100000", "100001"]
	}
```

**返回信息：**

**请求成功**

| 参数                 | 类型 | 描述                 |
| :------------------- | :--- | :------------------- |
| success_identity_ids | []   | 删除成功的人员id列表 |
| failed_identity_ids  | []   | 删除失败的人员id列表 |

请求成功示例：

```json
{
	"success_identity_ids":["100000", "100001"],
    "failed_identity_ids":[]
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                     | message        | 描述                                                         |
| ----- | -------------------------- | -------------- | ------------------------------------------------------------ |
| 1     | GROUP_LEN_ERROR            |                | 超过人员底库容量                                             |
| 2     | ID_NOT_FOUND               | 未找到的ID值   | ID未找到错误                                                 |
| 3     | ID_REPEAT_ERROR            | 重复的ID值     | ID重复错误                                                   |
| 4     | IMAGE_DECODE_ERROR         |                | 图片解码失败                                                 |
| 5     | IMAGE_SIZE_TOO_LARGE_ERROR |                | 图片尺寸过大                                                 |
| 6     | INVALID_ARGUMENTS          | 无效参数的值   | 无效的参数。                                                 |
| 7     | INVALID_REQUEST_JSON       |                | 无效的JSON数据请求。                                         |
| 8     | LOW_QUALITY_ERROR          | 失败项目       | 图像质量不过关<br />headpose : 人脸角度过大<br />clarity : 清晰度不足<br />face_size :人脸大小不足<br />partial : 人脸不完整<br />face_color :光照不均匀<br />brightness :亮度不足<br />mask :口罩遮挡<br />occlusion :人脸有遮挡<br />建议：图像质量不过关(口罩遮挡，光照不均匀） |
| 9     | MISSING_ARGUMENTS          | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 10    | NAME_REPEAT_ERROR          | 重复的名字     | 名字重复错误。                                               |
| 11    | NO_FACE_ERROR              |                | 没有找到人脸                                                 |
| 12    | UNSUPPORT_CONTENT_TYPE     |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
