# 更新人员基础信息/sophon/v2/face/updateidentity (POST)

**版本**

2.0

**功能描述**

更新单个人员的信息，如名称、人员类型，权限组等等。

注意:该api会对相应字段做强制更新覆盖。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/updateidentity

调用方法: POST

**请求参数（JSON格式）**

| 一级参数       | 类型   | 默认值     | 选择 | 描述                                                         | 举例         |
| :------------- | :----- | ---------- | :--- | :----------------------------------------------------------- | ------------ |
| identity_id    | string | 无         | 必选 | 人员唯一识别标识                                               | ”100000“        |
| identity_name  | string | "佚名"     | 可选 | 人员名称                                                     | “小王“       |
| user_type      | string | "employee" | 可选 | 人员类型<br />"employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP | 1            |
| permission_ids | list   | []         | 可选 | 人员所属权限组列表<br />列表中的权限组应当提前创建完成 | ["f4add9c0"] |
| ext_user_info  | dict   | {}         | 可选 | 人员扩展信息                                               |              |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/updateidentity
请求方法：POST
请求body(JSON格式):
{
    "identity_id":"100000",
    "identity_name":"小王",
    "permission_ids":["db4c5e0c-0135-4238-acc8-a273d4130a4a"]
}
```

**返回信息：**

**请求成功**

| 参数               | 类型   | 描述                                                         |
| :----------------- | :----- | :----------------------------------------------------------- |
| identity_id        | string | 人员唯一识别标识                                     |
| identity_name      | string | 人员姓名                                                     |
| user_type          | string | "employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP |
| permission_ids     | list   | 权限组id列表, 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"] |
| ext_user_info      | dict   | 人员扩展信息                                               |
| face_ids           | list   | 绑定到该人员的人脸id列表                                     |
| register_image_ids | list   | 绑定到该人员的注册照片id列表（顺序与face_id_list一一对应） |

请求成功示例：

```json
{
    "ext_user_info": {},
    "face_ids": [
        "df1fa172-1d4f-41ff-86da-3b7a575f2f41"
    ],
    "identity_id": "100000",
    "identity_name": "小王",
    "permission_ids": [
        "db4c5e0c-0135-4238-acc8-a273d4130a4a"
    ],
    "register_image_ids": [
        "19d0c455-cd0c-489d-b06e-e3c0eed09fe8"
    ],
    "user_type": "employee"
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
