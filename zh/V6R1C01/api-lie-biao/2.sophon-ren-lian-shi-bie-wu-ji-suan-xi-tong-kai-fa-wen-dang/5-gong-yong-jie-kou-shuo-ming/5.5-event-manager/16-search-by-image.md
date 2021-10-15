# 以图搜图/sophon/v2/face/searchbyimage(POST)

**版本**

2.0

**功能描述**

使用输入的人脸图片，在历史记录数据库里进行搜索，并返回匹配的识别记录。

注意：

   a. 搜索结果按照时间顺序返回。一般我们最关心最近的结果，所以为提升搜索效率，一次搜索最多搜索5万条记录，并且返回不超过1000个结果。

   b. 如果想要搜索全部结果并且数据库超过5万条时，可进行多次迭代搜索。在下一次搜索时，将endtimestamp设置为起始时间，如此迭代，则可完成全量搜索。

**调用URL**

http://192.168.150.1:5555/sophon/v2/face/searchbyimage

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
        <td>face_image_base64</td>
        <td>string</td>
        <td>无</td>
        <td rowspan="2">必选，二选一 </td>
	    <td>现场人脸图jpg base64编码数据</td>
	    <td></td>
	</tr> 
	<tr>
        <td>face_image_path</td>
        <td>string</td>
        <td>无</td>
        <td>本地图片路径</td>
        <td>"/data/test.jpg"</td>
	</tr>
    <tr>
        <td>fiqa_level</td>
        <td>string</td>
        <td>"low"</td>
        <td>可选</td>
        <td>图像质量检测的等级（'no'/'low'/'middle'/'high')<br />high：  人脸size>112，侧脸角度加起来不超60，对遮挡，不完整，亮度都有要求，适合注册的场景<br />middle: 人脸size>80，侧脸角度加起来不超90，对不完整，亮度都有要求，适合比对图像质量比较好或者是注册人脸图比较差的场景<br />low:       人脸size>60，侧脸角度加起来不超120，适合比对场景下对视频流出来的人脸进行初步质量检测<br />no:         不过人脸质量检测</td>
        <td></td>
    </tr>
    <tr>
        <td>starttime</td>
        <td>time</td>
        <td></td>
        <td>可选</td>
        <td>搜索的起始时间(不填默认为一天前的当前时间)（单位为毫秒） </td>
        <td></td>
    </tr>
    <tr>
        <td>last_end_timestamp</td>
        <td>time</td>
        <td></td>
        <td>可选</td>
        <td>上一次搜索返回的时间点，如果为null就从starttime开始搜索（单位为毫秒）</td>
        <td></td>
    </tr>
    <tr>
        <td>endtime</td>
        <td>time</td>
        <td></td>
        <td>可选</td>
        <td>搜索的结束时间(不填默认为当前时间)（单位为毫秒）</td>
        <td></td>
    </tr>
    <tr>
        <td>threshold</td>
        <td>float</td>
        <td>82.0</td>
        <td>可选</td>
        <td>相似度阈值</td>
        <td></td>
    </tr>
    <tr>
        <td>media_device_ids</td>
        <td>list</td>
        <td></td>
        <td>可选</td>
        <td>设备id列表（不填则搜索所有设备event）</td>
        <td></td>
    </tr>
    <tr>
        <td>reverse</td>
        <td>bool</td>
        <td>True</td>
        <td>可选</td>
        <td>查询顺序。</br>True：倒序（从endtime开始查询）</br>False：顺序（从starttime开始查询）</td>
        <td></td>
    </tr>
    
</table>

请求示例：

```json
请求url: http://192.168.150.1:5555/sophon/v2/face/searchbyimage
请求方法：POST
请求body:
{
    "face_image_base64":""
}
```

**返回信息：**

请求成功

| 字段         | 类型    | 说明                                 |
| :----------- | :------ | :----------------------------------- |
| events       | list    | 比对结果的event的list                |
| have_more    | boolean | false:搜索完成<br />true：未搜索完成 |
| total_time   | float   | 搜索所用的时间                       |
| endtimestamp | time    | 这次搜索结束的时间戳（单位为毫秒）   |

返回示例

```json
{
  "total_time": 0.0299224853515625, 
  "have_more": false, 
  "events": [
    {
      "recognize_face_attr": {
        "point": [], 
        "hat": null, 
        "glasses": null, 
        "box": [169.91207885742188, 256.9922180175781, 487.3203430175781, 671.7279663085938], 
        "mask": null, 
        "expression": null, 
        "age": null, 
        "gender": null
      }, 
      "spot_image_id": "001628066406.650539", 
      "identity_id": "", 
      "register_image_id": "a39d7d74-f392-403f-a1a5-6470cb7f83ca", 
      "out_timestamp": 1628066406.608026, 
      "compare_score": 100.0, 
      "recognize_face_image_id": "001628066406.650539", 
      "timestamp": 1628066406.608026, 
      "media_device_info": {
        "media_device_id": "", 
        "media_device_name": "", 
        "media_device_ip": "", 
        "media_device_type": ""
      }, 
      "identity_name": "", 
      "user_type": "employee"
    }
  ], 
  "endtimestamp": 1628066406.608026
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | string    | 错误码 |
|          | message  | string | 错误描述信息   |

错误码：

| Index | 错误码                               | message    | 描述                                                         |
| ----- | ------------------------------------ | ---------- | ------------------------------------------------------------ |
| 1     | UNSUPPORT_CONTENT_TYPE               |            | http内容类型不支持。<br/>目前所有的请求支持：application/json |
| 2     | IMAGE_NOT_OPENED                     |            | 图片路径无法打开                                             |
| 3     | MISSING_ARGUMENTS                    | <key_name> | 缺乏必要的参数。<br /><key_name> :  缺失的参数在message字段中描述 |
| 4     | INVALID_ARGUMENTS                    | <key_name> | 无效的参数。<br /><key_name> : 参数信息在message字段中描述。 |
| 5     | NOT_SUPPORT_IN_GRAB_MODE             |            | 在抓拍模式下不支持                                           |
| 6     | ANOTHER_PICTURE_SEARCH_RUNNING_ERROR |            | 另外一个以图搜图正在运行                                     |
| 7     | NO_FACE_ERROR                        |            | 没有找到人脸                                                 |
| 10    | LOW_QUALITY_ERROR                    |            | 人脸图像质量不合格                                           |

以图搜图event_list字段说明

|        参数名称         | 二级参数名称      | 类型   | 必须（Y/N） | 默认值                | 说明                                                         |
| :---------------------: | :---------------- | :----- | :---------: | :-------------------- | :----------------------------------------------------------- |
|      compare_score      |                   | float  |      Y      | 0.0                   |                                                              |
|        timestamp        |                   | 时间戳 |      Y      | 系统生成              | event创建的时间                                              |
|      identity_name      |                   | string |      Y      | stranger              | 比对到的人名，陌生人的情况下为“stranger” or 随机库出来的名字 |
|       identity_id       |                   | string |      Y      | ""                    | 识别通过的情况下，为识别到的identity_id,否则为空字符串""     |
|    register_image_id    |                   | string |      Y      | ''                    | 注册底库图片id                                               |
| recognize_face_image_id |                   | string |      Y      | ""                    | 比对到的现场扣脸图id                                         |
|      spot_image_id      |                   | string |      Y      | ""                    | 比对的现场背景图id                                           |
|        user_type        |                   | string |      Y      | "employee"            | 人员类型<br />"employee": 员工<br />"visitor": 访客<br />"blacklist": 黑名单<br />"stranger"：陌生人<br />"vip": VIP |
|    media_device_info    |                   | dict   |      Y      | {}                    | 采集设备的详细信息                                           |
|                         | media_device_type | string |      Y      | "photo"/'rtsp'/'file' | 'photo':闸机或者抓拍机<br />'rtsp':码流<br />'file':文件     |
|                         | media_device_ip   | string |      Y      | ""                    | 产生event的设备ip                                            |
|                         | media_device_name | string |      Y      | ""                    | 产生event的设备name                                          |
|                         | media_device_id   |        |             |                       | 产生event的采集设备id                                        |
|   recognize_face_attr   |                   | dict   |      Y      | {}                    |                                                              |
|                         | point             | list   |      Y      | []                    |                                                              |
|                         | box               | list   |      Y      | []                    | 人脸的box                                                    |
|                         | mask              | string |             |                       | 0/1/2                                                        |
|                         | gender            | string |             |                       | male / female                                                |
|                         | hat               | string |             |                       |                                                              |
|                         | age               | string |             |                       | child / juvenile / youth / middle-aged /aged                 |
|                         | glasses           | string |             |                       | yes / no                                                     |
|      out_timestamp      |                   | time   |      N      | 无                    | 人员出去的时间                                               |