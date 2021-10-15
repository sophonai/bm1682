# 更换人员注册照片/sophon/v2/face/updateimage (POST)

**版本**

2.0

**功能描述**

更换人员的注册照片

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
    <tr >
        <td>fiqa_level</td>
        <td>string</td>
        <td>"high"</td>
        <td>可选</td>
	    <td>图片质量控制<br />no: 不进行控制<br />low: 较低的质量要求<br />normal: 一般的质量要求<br />high: 较高的质量要求<br />默认为: high<br />如果图片质量不满足要求，则返回结果中会提示图像质量检测失败。<br />调整该参数，降低入库图片的质量，将会导致识别精度下降，请优先通过提高入库图片的质量来解决无法正常入库注册问题。</td>
	    <td>”high“</td>
	</tr> 
    <tr>
        <td>register_image_id</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一<br/>若同时送，register_image_id有效</td>
        <td>需要被替换的注册照片id</td>
        <td></td>
    </tr>
	<tr>
        <td>face_id</td>
        <td>string</td>
        <td>无</td>
        <td>需要被替换的人脸id</td>
        <td></td>
    </tr>    
</table>



调用方法: POST

**请求参数（JSON格式）**

| 一级参数       | 类型   | 默认值     | 选择 | 描述                                                         | 举例         |
| :------------- | :----- | ---------- | :--- | :----------------------------------------------------------- | ------------ |
| identity_id    | string | 无         | 必选 | 人员编号，可为工号之类的                                     | ”001“        |
| identity_name  | string | "佚名"     | 可选 | 人员名称                                                     | “小王“       |
| user_type      | string | "employee" | 可选 | "employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP | 1            |
| permission_ids | list   | []         | 可选 | 该人员具备权限组， 此处为列表 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"]<br />权限组列表中的权限组应当事先创建完成。 | ["f4add9c0"] |
| ext_info       | dict   | {}         | 可选 | 该人员其他信息                                               |              |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/users
请求body:
	{
  "info":{"name":"小明","type":1,"aaa":1,"permission_ids":["f4add9c0-4212-4064-a045-					b6185cf00501","bb982244-ce4e-469d-ab5f-34314dd0c09a"]},
  "identity_id":"001",
  "reg_photo":""
	
}
```

**返回信息：**

**请求成功**

| 参数           | 类型   | 描述                                                         |
| :------------- | :----- | :----------------------------------------------------------- |
| identity_id    | string | 人员编号，可为工号之类的                                     |
| identity_info  | dict   | 个人其他信息                                                 |
| identity_name  | string | 人员名称                                                     |
| user_type      | string | "employee"： 员工<br />"visitor"：访客<br />"blacklist"：黑名单<br />"stranger":  陌生人<br />"vip"：VIP |
| permission_ids | list   | 权限组id列表, 如["f4add9c0-4212-4064-a045-b6185cf00501","abckd9c0-4212-4064-a045-b6185defw501"] |
| ext_info       | dict   | 其他的用户信息                                               |
| face_ids       | list   | 绑定到该人员的人脸id列表                                     |
| reg_pic_ids    | list   | 绑定到该人员的注册照片id列表，注册照片和face_id_list中的人脸是一一对应的。 |

请求成功示例：

```json
{
    "identity": {
        "identity_id": "001",
        "image_id": "8f5d7b5a-d5da-4b3f-bf46-5830d412ba5e",
        "identity_info": {
            "description": "",
            "name": "小明",
            "permission_ids": [
                "f4add9c0-4212-4064-a045-b6185cf00501",
                "bb982244-ce4e-469d-ab5f-34314dd0c09a"
            ],
            "type": 1,
            "user_id": "001",
   
        }
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
