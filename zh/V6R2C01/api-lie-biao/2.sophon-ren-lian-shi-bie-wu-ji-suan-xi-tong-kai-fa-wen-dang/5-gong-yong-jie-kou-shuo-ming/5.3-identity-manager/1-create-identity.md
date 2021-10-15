# 创建人员/sophon/v2/face/createidentity（POST）

**版本**

2.0

**功能描述**

人员标识(identity，以下简称人员)用于记录人脸比对应用中所需要的各种信息，包括ID、人脸数据、权限组、姓名、人员类型等各种信息。
本API是用于创建建一个新的人员标识，并会自动将所有信息注册到比人脸底库中，用于人脸比对识别。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/createidentity

调用方法: POST

**请求参数**

<table>
	<tr>
	    <th>参数</th>
	    <th>类型</th>
	    <th>默认值</th> 
        <th>选择</th>
        <th>描述</th>
        <th>举例</th>
	</tr >
    <tr >
        <td>register_feature</td>
        <td>float[512]</td>
        <td>无</td>
        <td rowspan="3">必选，三选一 </td>
	    <td>直接使用人脸特征值注册到底库</td>
	    <td></td>
	</tr> 
	<tr>
        <td>register_image</td>
        <td>base64</td>
        <td>无</td>
        <td>使用人脸照片注册（照片需要满足人脸注册要求；多张人脸时，自动选择最大人脸注册）</td>
        <td></td>
	</tr>
   	<tr >
        <td>register_image_path</td>
        <td>string</td>
        <td>无</td>
	    <td>根据本地图片路径注册人脸数据到底库</td>
	    <td>”/data/image/test.jpg“</td>
	</tr> 
    <tr>
        <td>identity_name</td>
        <td>string</td>
        <td>"佚名"</td>
        <td>可选</td>
        <td>人员姓名</td>
        <td>"小王"</td>
    </tr>
    <tr >
        <td>identity_id</td>
        <td>string</td>
        <td>无</td>
	    <td>可选</td>
	    <td>人员全局唯一标识<br/>
        非空字符串：系统使用此参数作为唯一标识<br/>
        空字串（或无）：系统会自动创建唯一标识<br/></td>
	    <td>”100000“</td>
	</tr> 
   	<tr >
        <td>user_type</td>
        <td>string</td>
        <td>"employee"</td>
        <td>可选</td>
	    <td>人员类型<br/>"employee": 员工<br />"visitor": 访客<br />"blacklist": 黑名单<br />"stranger"：陌生人<br />"vip": VIP<br /></td>
	    <td>”employee“</td>
	</tr> 
    <tr >
        <td>permission_ids</td>
        <td>list</td>
        <td>[]</td>
        <td>可选</td>
	    <td>将人员绑定至权限组列表</td>
	    <td>["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"]</td>
	</tr> 
    <tr >
        <td>ext_user_info</td>
        <td>{}</td>
        <td></td>
        <td>可选</td>
	    <td>人员扩展信息</td>
	    <td>参见下表“ext_user_info字段定义”</td>
	</tr>
    <tr >
        <td>fiqa_level</td>
        <td>string</td>
        <td>"high"</td>
        <td>可选</td>
	    <td>注册照片质量检查标准<br />no: 直接注册，不检查<br />low: 以较低标准检查<br />normal: 以一般标准检查<br />high: 以严格标准检查<br />注意：降低注册照片质量检查标准，将会导致识别精度下降，请谨慎调整。</td>
	    <td>”high“</td>
	</tr>
    <tr >
        <td>force_replace</td>
        <td>bool</td>
        <td>false</td>
        <td>可选</td>
	    <td>是否强制覆盖已有人员</br> true: 如果重复则覆盖 </br>false: 如果重复，返回出错信息</td>
	    <td></td>
	</tr> 
</table>

在计算盒管理界面对于ext_user_info字段，定义如下:

| Index | 字段名称          | 说明     | 备注     |
| ----- | ----------------- | -------- | -------- |
| 1     | mobile            | 手机号码 |          |
| 2     | email             | 电子邮箱 |          |
| 3     | id_card           | 证件号码 |          |
| 4     | gender            | 性别     |          |
| 5     | visit_card_number | 门禁卡号 |          |
| 6     | employee_number   | 工号     |          |
| 7     | title             | 职务     |          |
| 8     | entry_time        | 入职时间 |          |
| 9     | department        | 部门     |          |
| 10    | address           | 地址     |          |
| 11    | building_no       | 楼宇     |          |
| 12    | floor             | 楼层     |          |
| 13    | description       | 描述     |          |
| 14    | room              | 房间号   |          |
| 15    | start_time        | 来访时间 | 访客专用 |
| 16    | end_time          | 离开时间 | 访客专用 |
| 17    | interviewee       | 受访人   | 访客专用 |
| 18    | visitor_company   | 来访单位 | 访客专用 |
| 19    | purpose           | 来访目地 | 访客专用 |
| 20    | welcome_message   | 欢迎语   | 访客专用 |

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/createidentity
请求方法：POST
请求body(JSON格式):
请求body:
{
    "identity_id":"100000",
    "register_image":"data:image/jpg;base64,/9j/4AAQSkZ... "
}
```



**返回信息：**

**请求成功**

| 二级参数          | 类型   | 描述                                           |
| :---------------- | :----- | :--------------------------------------------- |
| identity_id       | string | 人员编号                                       |
| register_image_id | string | 注册照片在系统中的存储id                       |
| face_id           | string | 人脸特征值在系统中的存储id |

请求成功示例：

```json
{
    "face_id": "11045712-0608-41e3-9612-f759ad564caf",
    "identity_id": "100000",
    "register_image_id": "69919728-f3c5-4c29-96de-681d9b21ddf4"
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





