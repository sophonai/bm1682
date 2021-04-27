# 人脸相似度比较/SophonMatch/api/compare（POST）

**功能描述**

比较两张给定的人脸图的相似度。

**调用URL**

http://192.168.1.180:5555/SophonMatch/api/compare

调用方法: POST

**请求参数:**

| 一级参数          | 二级参数       | 类型    | 默认值 | 选项 | 描述                                                         | 举例 |
| :---------------- | :------------- | :------ | :----- | :--- | :----------------------------------------------------------- | ---- |
| card_image_base64 |                | string  | 无     | 必选 | 身份证 jpg base64编码数据                                    |      |
| compare_time      |                | time    | 无     | 可选 | event里面记录的比对时间，不送则使用当前时间（time.time()）   |      |
| face_image_base64 |                | string  | 无     | 必选 | 现场人脸图jpg base64编码数据                                 |      |
| fiqa_level        |                | string  | 无     | 可选 | 是否需要通过图像质量检测（'no'/'low'/'middle'/'high'）       |      |
| need_save         |                | boolean | 无     | 可选 | 是否需要记录event，默认为False                               |      |
| threshold         |                | string  | 无     | 可选 | 比对的阈值：'high'：0.275'middle':0.225'low':0.175默认为'middle' |      |
| with_debug_info   |                | boolean | 无     | 可选 | 是否需要debug的时间信息，默认为False                         |      |
| identity_info     |                | dict    | 无     | 可选 | 人员信息，默认为空字典，会记录到event里面                    |      |
|                   | user_idcard    | string  | 无     | 可选 | 人员身份证号                                                 |      |
|                   | user_name      | string  | 无     | 可选 | 人员姓名                                                     |      |
|                   | user_sex       | string  | 无     | 可选 | 人员性别                                                     |      |
|                   | user_nation    | string  | 无     | 可选 | 国籍                                                         |      |
|                   | user_address   | string  | 无     | 可选 | 人员地址                                                     |      |
|                   | user_issu      | string  | 无     | 可选 | 身份证签发机关                                               |      |
|                   | user_validtime | string  | 无     | 可选 | 身份证有效期限                                               |      |
|                   | card_type      | string  | 无     | 可选 | 卡片类型                                                     |      |

**请求示例：**

```json
Request Url:
http://192.168.1.180:5555/SophonMatch/api/compare
{
"face_image_base64":"/9j/***",
"card_image_base64":"/9j/***"
}
```

**返回信息**

**请求成功：**

| 参数    | 类型   | 描述                         |
| :------ | :----- | :--------------------------- |
| retcode | string | “0”：比对未通过“1”：比对通过 |
| score   | float  | 比对的分数结果               |

**请求成功示例：**

```json
{
	"retcode":"0",
	"identity_id":"",
	"name":"stranger",
	"score":0.45
}
```

**请求失败**

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

