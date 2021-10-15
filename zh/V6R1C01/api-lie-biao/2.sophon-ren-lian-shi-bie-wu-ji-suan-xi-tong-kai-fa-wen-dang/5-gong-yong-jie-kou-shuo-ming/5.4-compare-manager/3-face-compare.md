# 人脸1:1比对相似度/sophon/v2/face/compare（POST）

**版本**

2.0

**功能描述**

1:1比对，比较两张给定的人脸图的相似度。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/compare

调用方法: POST

**请求参数:**

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
        <td>image_1_base64</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一 </td>
	    <td>图片1 jpg base64编码数据</td>
	    <td></td>
	</tr> 
	<tr>
        <td>image_1_path</td>
        <td>string</td>
        <td>无</td>
        <td>本地图片1路径</td>
        <td></td>
	</tr>
	<tr >
        <td>image_2_base64</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一 </td>
	    <td>图片2 jpg base64编码数据</td>
	    <td></td>
	</tr> 
	<tr>
        <td>image_2_path</td>
        <td>string</td>
        <td>无</td>
        <td>本地图片2路径</td>
        <td></td>
	</tr> 
	<tr >
        <td>fiqa_level</td>
        <td>string</td>
        <td>"no"</td>
        <td>可选</td>
	    <td>两张图片的图像质量检测标准质量检测：</br>
		high： 人脸size>112，侧脸角度加起来不超60，对遮挡，不完整，亮度都有要求，适合注册的场景</br>
		middle: 人脸size>80，侧脸角度加起来不超90，对不完整，亮度都有要求，适合比对图像质量比较好或者是注册人脸图比较差的场景</br>
		low: 人脸size>60，侧脸角度加起来不超120，适合比对场景下对视频流出来的人脸进行初步质量检测</br>
		no: 不做人脸质量检测</td>
	    <td></td>
	</tr>   
</table>



**请求示例：**

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/compare
请求方法：POST
请求body:
{
"image_1_base64":"/9j/***",
"image_2_base64":"/9j/***"
}
```

**返回信息**

**请求成功：**

| 参数  | 类型  | 描述                                                         |
| :---- | :---- | :----------------------------------------------------------- |
| score | float | 比对得分，表示是否为同一人的可能性：</br>score >= 82.0: 可能性很高</br>82>score>=60: 可能性一般</br>score < 60.0: 可能性低 |

**请求成功示例：**

```json
{
	"score": 84.53
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
| 1     | ID_NOT_FOUND               | 未找到的ID值   | ID未找到错误                                                 |
| 2     | IMAGE_DECODE_ERROR         |                | 图片解码失败                                                 |
| 3     | IMAGE_SIZE_TOO_LARGE_ERROR |                | 图片尺寸过大                                                 |
| 4     | INVALID_ARGUMENTS          | 无效参数的值   | 无效的参数。                                                 |
| 5     | INVALID_REQUEST_JSON       |                | 无效的JSON数据请求。                                         |
| 6     | LOW_QUALITY_ERROR          | 失败项目       | 图像质量不过关<br />headpose : 人脸角度过大<br />clarity : 清晰度不足<br />face_size :人脸大小不足<br />partial : 人脸不完整<br />face_color :光照不均匀<br />brightness :亮度不足<br />mask :口罩遮挡<br />occlusion :人脸有遮挡<br />建议：图像质量不过关(口罩遮挡，光照不均匀） |
| 7     | MISSING_ARGUMENTS          | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 8     | NO_FACE_ERROR              |                | 没有找到人脸                                                 |
| 9     | UNSUPPORT_CONTENT_TYPE     |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
