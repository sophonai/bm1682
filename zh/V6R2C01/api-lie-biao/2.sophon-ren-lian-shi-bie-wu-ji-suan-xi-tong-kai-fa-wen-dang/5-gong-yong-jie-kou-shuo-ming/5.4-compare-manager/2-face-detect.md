# 人脸检测/sophon/v2/face/detect（POST）

**版本**

2.0

**功能描述**

检测人脸边界框、属性和特征等。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/detect

调用方法: POST

**请求参数（JSON格式）**

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
        <td>image_base64_str</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一 </td>
	    <td>图片base64转换格式</td>
	    <td></td>
	</tr> 
	<tr>
        <td>image_path</td>
        <td>string</td>
        <td>无</td>
        <td>本地图片路径</td>
        <td></td>
	</tr>
    <tr>
        <td>with_feature</td>
        <td>bool</td>
        <td>false</td>
        <td>可选</td>
        <td>返回值是否带[512x1]的人脸特征值</td>
        <td></td>
    </tr>
    <tr>
        <td>with_attribute</td>
        <td>bool</td>
        <td>false</td>
        <td>可选</td>
        <td>返回值是否带人脸属性，当前支持性别&年龄</td>
        <td></td>
    </tr>
    <tr>
        <td>with_headpose</td>
        <td>bool</td>
        <td>false</td>
        <td>可选</td>
        <td>返回值是否带给定图片的头部角度</td>
        <td></td>
    </tr>
    <tr>
        <td>with_landmark</td>
        <td>bool</td>
        <td>false</td>
        <td>可选</td>
        <td>返回值是否带给定图片的landmark，<br />[x1, x2, x3, x4, x5, y1, y2, y3, y4, y5]，</td>
        <td></td>
    </tr>
    <tr>
        <td>max_num_faces</td>
        <td>int</td>
        <td>10</td>
        <td>可选</td>
        <td>最大识别的人脸数</td>
        <td></td>
    </tr>
    
</table>

**请求示例：**

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/detect
请求方法：POST
请求body:
{
    "image_base64_str": "data:image/jpeg;base64,/9j/........",
    "with_feature": true,
    "with_attribute": true
}
```

**返回信息:**

**请求成功：**

| 一级字段 | 二级字段           | 类型   | 描述                                           |
| -------- | :----------------- | :----- | :--------------------------------------------- |
| faces    |                    | list   | 检测到的人脸列表                               |
|          | attribute          | dict   | 人脸属性(年龄，性别)                           |
|          | bbox               | list   | 人脸坐标位置，左上右下[xmin, ymin, xmax, ymax] |
|          | landmark           | list   | [x1, x2, x3, x4, x5, y1, y2, y3, y4, y5]       |
|          | feature_base64_str | string | [512d]feature,base64编码之后的数据             |

**请求成功示例：**

```json
{
    "faces": [
        {
            "attribute": {
                "age": "youth",
                "gender": "male",
                "glasses": "no"
            },
            "bbox": [
                169.91207885742188,
                256.9922180175781,
                487.3203430175781,
                671.7279663085938
            ],
            "feature_base64_str": "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"
        }
    ]
}
```

**请求失败：**

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
