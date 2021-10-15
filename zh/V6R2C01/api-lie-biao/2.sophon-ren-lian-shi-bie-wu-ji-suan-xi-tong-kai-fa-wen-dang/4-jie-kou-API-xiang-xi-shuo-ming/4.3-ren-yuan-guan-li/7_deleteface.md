# 删除指定人员的人脸/sophon/v2/face/deleteface (POST)

**版本**

2.0

**功能描述**

删除指定人员的人脸

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
        <td>register_image_id</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一</br>若同时传，只register_image_id有效</td>
	    <td>注册照片在系统中的存储id。删除该注册照片对于的人脸信息<</td>
	    <td></td>
	</tr> 
   	<tr >
        <td>face_id</td>
        <td>string</td>
        <td>无</td>
	    <td>人脸在系统中的唯一标识。</td>
	    <td></td>
	</tr> 
</table>




请求示例：

```json
请求url: http://192.168.1.180:5555/SophonFogSys/api/users
请求body:
	{
  "info":{"name":"小明","type":1,"aaa":1,"permission_ids":["f4add9c0-4212-4064-a045-b6185cf00501","bb982244-ce4e-469d-ab5f-34314dd0c09a"]},
  "identity_id":"001",
  "reg_photo":""
	
}
```

**返回信息：**

**请求成功**

| 参数        | 类型   | 描述                                                         |
| :---------- | :----- | :----------------------------------------------------------- |
| identity_id | string | 人员编号                                                     |
| face_ids    | list   | 删除之后，绑定到该人员的人脸id列表                           |
| reg_pic_ids | list   | 删除之后，绑定到该人员的注册照片id列表<br />注册照片和face_id_list中的人脸是一一对应的。 |

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
