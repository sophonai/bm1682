# 创建人员/sophon/v2/face/createidentity（POST）

**版本**

2.0

**功能描述**

新建一个人员标识(identity)，以下简称人员。

如果参数中带有人脸图片，则会自动创建人脸并完成人脸和人员绑定。

如果参数中带有权限组信息，则会依据配置，将人员添加到权限组中。

**调用URL**

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
        <td>identity_id</td>
        <td>string</td>
        <td>无</td>
	    <td>必选</td>
	    <td>人员全局唯一标识，如果调用时指定，则系统此参数作为唯一标识(如果此ID已经存在，会返回错误)；如果不传或是空字符串，则系统会自动创建。<br /></td>
	    <td>”001“</td>
	</tr> 
    <tr >
        <td>register_image</td>
        <td>base64</td>
        <td>无</td>
	    <td rowspan="2">必选，二选一</td>
	    <td>人脸注册照片。<br />Note: <br />a、人脸需要满足FIQA人脸图像检测。<br />b、如果照片中含有多张人脸，系统自动选择最大人脸注册。</td>
	    <td></td>
	</tr> 
   	<tr >
        <td>register_image_path</td>
        <td>string</td>
        <td>无</td>
	    <td>图片在计算盒上面的位置。</td>
	    <td>”/data/image/test.jpg“</td>
	</tr> 
    <tr>
        <td>identity_name</td>
        <td>string</td>
        <td>"佚名"</td>
        <td>可选</td>
        <td>人员名称</td>
        <td>"小王"</td>
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
	    <td>需要添加该人员的权限组列表， 此处为列表 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"]</td>
	    <td>["f4add9c0-4212-4064-a045-b6185cf00501"]</td>
	</tr> 
    <tr >
        <td>ext_user_info</td>
        <td>{}</td>
        <td></td>
        <td>可选</td>
	    <td>该人员的其他信息</td>
	    <td></td>
	</tr>
    <tr >
        <td>fiqa_level</td>
        <td>string</td>
        <td>"high"</td>
        <td>可选</td>
	    <td>图片质量控制<br />no: 不进行控制<br />low: 较低的质量要求<br />normal: 一般的质量要求<br />high: 较高的质量要求<br />默认为: high<br />如果图片质量不满足要求，则返回结果中会提示图像质量检测失败。<br />调整该参数，降低入库图片的质量，将会导致识别精度下降，请优先通过提高入库图片的质量来解决无法正常入库注册问题。</td>
	    <td>”high“</td>
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
请求url: http://192.168.1.180:5555/SophonFogSys/api/users
请求body:
        {
            "info":{"name":"小王","type":1,"permission_ids":["f4add9c0-4212-4064-a045-						b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"]},
            "group_name":"default_group",
            "identity_id":"001",
            "reg_photo":""  //base64格式图片内容
        }
```



**返回信息：**

请求成功

| 二级参数          | 类型   | 描述                                           |
| :---------------- | :----- | :--------------------------------------------- |
| identity_id       | string | 人员编号                                       |
| register_image_id | string | 注册照片在系统中的存储id                       |
| face_id           | string | 分析注册照片得到的数据对象，在系统中的唯一标识 |

请求成功示例：

```json
{


}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
