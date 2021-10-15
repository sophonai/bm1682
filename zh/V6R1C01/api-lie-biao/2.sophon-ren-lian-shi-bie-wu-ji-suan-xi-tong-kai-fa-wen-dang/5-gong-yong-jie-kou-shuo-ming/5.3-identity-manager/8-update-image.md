# 更换人员注册照片/sophon/v2/face/replaceface (POST)

**版本**

2.0

**功能描述**

更换人员的注册照片

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/replaceface

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
	    <td>人员全局唯一标识<br /></td>
	    <td>"100000"</td>
	</tr> 
    <tr>
        <td>register_image_index</td>
        <td>int</td>
        <td></td>
        <td rowspan="3">必选，三选一</td>
        <td>需要替换第几张注册照片(0代表第1张照片)</td>
        <td>1</td>
    </tr>
     <tr>
        <td>register_image_id</td>
        <td>string</td>
        <td>无</td>
        <td>需要替换的注册照片存储id</td>
        <td>"d82c43e5-12a5-455a-9eca-1990248a7735"</td>
    </tr>
    <tr>
        <td>face_id</td>
        <td>string</td>
        <td>无</td>
        <td>需要替换的人脸特征值存储id</td>
        <td>"c015f57a-f003-46a9-bd0b-ba92a01c9c32"</td>
    </tr>  
    <tr >
        <td>register_feature</td>
        <td>float[512]</td>
        <td>无</td>
        <td rowspan="3">必选，三选一</br>优先：register_feature > register_image > register_image_path </td>
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
    <tr >
        <td>fiqa_level</td>
        <td>string</td>
        <td>"high"</td>
        <td>可选</td>
	    <td>注册照片质量检查标准<br />no: 直接注册，不检查<br />low: 以较低标准检查<br />normal: 以一般标准检查<br />high: 以严格标准检查<br />注意：降低注册照片质量检查标准，将会导致识别精度下降，请谨慎调整。</td>
	    <td>”high“</td>   
	</tr> 
</table>

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/replaceface
请求方法：POST
请求body:
{
    "identity_id":"100000",
    "face_id":"c8305074-ffc4-4f29-8044-de0bf52cb597",
    "register_image":"data:image/jpg;base64,/9j/4AAQSkZJRgABAQAAA......"
}
```

**返回信息：**

**请求成功**

| 参数               | 类型   | 描述                                                         |
| :----------------- | :----- | :----------------------------------------------------------- |
| identity_id | string | 人员编号                                                     |
| total_face_cnt    | int | 人员当前绑定的人脸总数量 |
| face_ids    | list   | 执行删除之后，当前绑定到该人员的人脸特征值id列表                           |
| register_image_ids | list   | 执行删除之后，当前绑定到该人员的注册照片id列表（顺序与face_id_list中的人脸特征值一一对应） |

请求成功示例：

```json
{
    "identity_id": ["100000"],
    "total_face_cnt": 2,
    "face_ids": ["11045712-0608-41e3-9612-f759ad564caf","c0202ce2-09e8-4f48-b8b6-3ec85b5ddbad"],
    "register_image_ids": ["69919728-f3c5-4c29-96de-681d9b21ddf4", "5d290f79-f07a-409d-8eea-92f3ef077c94"]
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述         |
| :------- | :------- | :----- | :----------- |
| error    | code     | string | 错误码       |
|          | message  | string | 错误描述信息 |

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
