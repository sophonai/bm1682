# 人脸1:N比对/sophon/v2/face/search（POST）

**版本**

2.0

**功能描述**

1:N比对，把送进来的人脸图片与人脸底库进行比对，并返回比对结果。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/search

调用方法: POST

**请求参数：**

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
        <td>rgb_image_path</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一 </td>
	    <td>图片本地存储路径</td>
	    <td></td>
	</tr> 
	<tr>
        <td>rgb_image_base64</td>
        <td>string</td>
        <td>无</td>
        <td>rgb图片jpg base64编码数据</td>
        <td></td>
	</tr>
	<tr >
        <td>ir_image_path</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">可选，二选一 </td>
	    <td>ir图片jpg base64编码数据</td>
	    <td></td>
	</tr> 
	<tr>
        <td>ir_image_base64</td>
        <td>string</td>
        <td>无</td>
        <td>ir图片jpg base64编码数据</td>
        <td></td>
	</tr> 
	<tr >
        <td>permission_name</td>
        <td>string</td>
        <td></td>
        <td>可选</td>
	    <td>比对权限组名</td>
	    <td></td>
	</tr>
    <tr >
        <td>media_device_ip</td>
        <td>string</td>
        <td></td>
        <td>可选</td>
	    <td>通常添加设备时，会绑定权限组，所以直接送media_device_ip，盒子会根据绑定关系自动查找权限组，所以不需要送permission_name</td>
	    <td></td>
	</tr>
    <tr >
        <td>min_face_size</td>
        <td>int</td>
        <td></td>
        <td>可选</td>
	    <td>能够识别的最小人脸size</td>
	    <td></td>
	</tr>
    <tr >
        <td>with_register_photo</td>
        <td>bool</td>
        <td>false</td>
        <td>可选</td>
	    <td>true：返回注册的底库图<br />false：不送底库图  </td>
	    <td></td>
	</tr>
    <tr >
        <td>with_liveness_check</td>
        <td>string</td>
        <td>"liveness_off"</td>
        <td>可选</td>
	    <td>活体检测模式：<br />"liveness_off":不做活体检测<br />"liveness_rgb":rgb活体检测<br />"liveness_rgb_ir":红外活体检测（需要送入ir_image_base64，不然会报错）</td>
	    <td></td>
	</tr>
    <tr >
        <td>with_result_modification</td>
        <td>bool</td>
        <td>true</td>
        <td>可选</td>
	    <td>true：比对之后，在结果中屏蔽低于阈值的的人员照片，避免UI显示不正确的人员造成误解</td>
	    <td></td>
	</tr>
	</tr>
    <tr >
        <td>with_default_group_only</td>
        <td>bool</td>
        <td>false</td>
        <td>可选</td>
	    <td>true：仅仅只比对默认组,不比对陌生人组<br />false：根据是否打开陌生人入库决定是否比对陌生人组</td>
	    <td></td>
	</tr>
    <tr >
        <td>with_attribute</td>
        <td>bool</td>
        <td>false</td>
        <td>可选</td>
	    <td>true：对送入的图片进行人员属性比对<br />false：不进行属性比对</td>
	    <td></td>
	</tr>
    <tr >
        <td>with_debug_info</td>
        <td>bool</td>
        <td>true</td>
        <td>可选</td>
	    <td>true：返回比对花费的时间信息<br />false：不返回 </td>
	    <td></td>
	</tr>
</table>

**请求示例：**

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/search
请求方法：POST
请求body:
{
    "rgb_image_path":"/data/test.jpg",
    "media_device_ip":"192.168.1.22"
}
```

**返回信息：**

| 一级参数       | 二级        | 类型    | 描述                                                         |
| :------------- | ----------- | :------ | :----------------------------------------------------------- |
| result         |             | boolean | false：比对未通过 true：比对通过                             |
| score          |             | float   | 比对的分数结果(0.0~100)                                               |
| identity_id    |             | string  | 比对的identity_id                                            |
| identity_info  |             | {}      | 比对到的人员信息（[字段参考](../5.3-identity-manager/2-get-identity.md)） |
| register_image |             | string  | 在need_register_photo为True的情况下，返回人脸底库图的base64编码数据 |
| debug_info     |             | {}      | 在with_debug_info为True的情况下，返回debug信息               |
|                | comparetime | float     | 比对所花费的时间（ms）                                       |
|                | totaltime   | float     | resful接口所消耗的总时间(ms)                                 |

**请求成功返回：**

```json
{
    "debug_info": {
        "comparetime": 30,
        "totaltime": 38
    },
    "identity_id": "1dd23",
    "identity_info": {
        "ext_user_info": {},
        "face_ids": [
            "5f7b4cd3-479b-4628-b4b9-c32630498052"
        ],
        "identity_id": "1dd23",
        "identity_name": "unknow",
        "permission_ids": [
            "dddd"
        ],
        "register_image_ids": [
            "a39d7d74-f392-403f-a1a5-6470cb7f83ca"
        ],
        "user_type": "employee"
    },
    "result": false,
    "score": 27.693189090909087
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
| 1     | DEVICE_ID_NOT_FOUND        |                | 设备id未找到                                                 |
| 2     | EMPTY_GROUP_ERROR          |                | 比对组为空                                                   |
| 3     | ID_NOT_FOUND               | 未找到的ID值   | ID未找到错误                                                 |
| 4     | IMAGE_DECODE_ERROR         |                | 图片解码失败                                                 |
| 5     | IMAGE_NOT_OPENED           |                | 图片路径无法打开                                             |
| 6     | IMAGE_SIZE_TOO_LARGE_ERROR |                | 图片尺寸过大                                                 |
| 7     | INVALID_ARGUMENTS          | 无效参数的值   | 无效的参数。                                                 |
| 8     | INVALID_REQUEST_JSON       |                | 无效的JSON数据请求。                                         |
| 9     | LIVENESS_DETECT_FAIL       | <key_name>     | 活体检测失败                                                 |
| 10    | LOW_QUALITY_ERROR          | 失败项目       | 图像质量不过关<br />headpose : 人脸角度过大<br />clarity : 清晰度不足<br />face_size :人脸大小不足<br />partial : 人脸不完整<br />face_color :光照不均匀<br />brightness :亮度不足<br />mask :口罩遮挡<br />occlusion :人脸有遮挡<br />建议：图像质量不过关(口罩遮挡，光照不均匀） |
| 11    | MATCH_FAIL                 |                | 比对失败                                                     |
| 12    | MISSING_ARGUMENTS          | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 13    | NO_FACE_ERROR              |                | 没有找到人脸                                                 |
| 14    | NOT_IN_PASS_TIME           |                | 非布防时间                                                   |
| 15    | NOT_SUPPORT_IR_LIVENESS    |                | 无法支持红外活体                                             |
| 16    | UNSUPPORT_CONTENT_TYPE     |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |
