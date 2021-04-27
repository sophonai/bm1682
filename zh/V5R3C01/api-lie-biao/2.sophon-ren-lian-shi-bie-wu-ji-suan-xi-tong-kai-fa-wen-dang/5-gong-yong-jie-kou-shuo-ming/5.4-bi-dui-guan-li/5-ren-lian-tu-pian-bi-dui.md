# 人脸图片比对/SophonMatch/api/PictureMatch（POST）

**功能描述**

人脸图片比对。

**调用URL**

http://192.168.1.180:5555/SophonMatch/api/PictureMatch

调用方法: POST

**请求参数：**

| 一级参数            | 二级参数 | 类型    | 默认值 | 选项 | 描述                                                       | 举例 |
| :------------------ | :------- | :------ | :----- | :--- | :--------------------------------------------------------- | ---- |
| image_file_path     |          | string  |        | 可选 | 图片存放路径（与rgb_image_base64并存时，使用path下面的图） |      |
| rgb_image_base64    |          | string  |        | 可选 | rgb图片jpg base64编码数据(与image_file_path必须二选一)     |      |
| ir_image_base64     |          | string  |        | 可选 | ir图片jpg base64编码数据，送该图时，会进行活体检测         |      |
| grab_fiqa_info      |          | dict    |        | 可选 | 抓拍机送过来的人脸属性数据                                 |      |
| device_ip           |          | string  |        | 必选 | 发送比对请求的IP地址                                       |      |
| compare_time        |          | time    |        | 可选 | event里面记录的比对时间，不送则使用当前时间（time.time()） |      |
| need_register_photo |          | boolean |        | 可选 | 是否需要注册的底库图，默认为False：不送                    |      |

**请求示例：**

```json
Request Url:
http://192.168.1.180:5555/SophonMatch/api/PictureMatch
{
"image_file_path":"/data/****",

"device_ip":"192.168.1.22",

"need_register_photo":false

}
```

**返回信息：**

| 参数          | 类型   | 描述                                                         |
| :------------ | :----- | :----------------------------------------------------------- |
| retcode       | string | “0”：比对未通过“1”：比对通过                                 |
| score         | float  | 比对的分数结果                                               |
| identity_id   | string | 比对的identity_id                                            |
| identity_info | {}     | 比对到的人员信息                                             |
| reg_pic       | string | 在need_register_photo为True的情况下，返回人脸底库图的base64编码数据 |

**请求成功返回：**

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