# 创建权限组/sophon/v2/face/createpermission（POST）

**版本**

2.0

**功能描述**

权限组是具有特定通行权限的人员的集合。本API用于创建一个新的权限组。

在实际使用中，前端视频输入设备一般会绑定到特定权限组，这样，系统会将此设备的图像输出与对应的权限组人员集合进行比对。当对分数大于阈值时，才能识别通过，否则即为陌生人。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/createpermission

调用方法: POST

**请求参数（JSON格式）**

| 参数            | 类型   |  默认值  | 选择 | 描述                                                         |  举例  |
| :-------------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| permission_name | string | 无                                  | 必选 | 权限组名称（支持中文）；<br />此字段需为全局唯一值，不可重复，不可为空。<br /> | ”测试组“                          |
| permission_id | string | 无 | 可选 | 权限组标识ID，用来管理权限组对象。<br />如果API调用时指定该id，则系统使用此ID创建权限组；如果该参数为空，则会由系统自动生成权限组标识ID。<br />推荐使用短UUID。 |  |
| description     | string | 无                                  | 可选 | 权限组描述。 |                                   |



请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/createpermission
请求方法：POST
请求body(JSON格式):
{
    "permission_id":"270ec5e6",
    "permission_name":"测试组",
    "description":"this is a first test permission"
}
```

**返回信息：**

**请求成功**

| 参数            | 类型   | 描述                                           |
| :-------------- | :----- | :--------------------------------------------- |
| permission_name | string | 权限组名称                                     |
| permission_id   | string | 全局唯一的权限组标识 |
| description     | string | 返回API调用传进来的description字段   |

请求成功示例：

```json
{
    "description": "this is a first test permission",
    "permission_id": "270ec5e6",
    "permission_name": "测试组"
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

**错误码**

| Index | 错误码                 | message        | 描述                                                         |
| ----- | ---------------------- | -------------- | ------------------------------------------------------------ |
| 1     | ID_NOT_FOUND           | 未找到的ID值   | ID未找到错误                                                 |
| 2     | ID_REPEAT_ERROR        | 重复的ID值     | ID重复错误                                                   |
| 3     | INVALID_ARGUMENTS      | 无效参数的值   | 无效的参数。                                                 |
| 4     | INVALID_REQUEST_JSON   |                | 无效的JSON数据请求。                                         |
| 5     | MISSING_ARGUMENTS      | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 6     | NAME_REPEAT_ERROR      | 重复的名字     | 名字重复错误。                                               |
| 7     | UNSUPPORT_CONTENT_TYPE |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
