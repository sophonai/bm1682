# 识别记录的字段定义

**版本**

2.0

| 一级参数                | 二级参数              | 类型      | 默认值   | 描述                                                         | 举例                |
| :---------------------- | :-------------------- | --------- | :------- | :----------------------------------------------------------- | :------------------ |
| event_id                |                       | string    | 系统生成 | event唯一标识                                                | "1607062639.737444" |
| timestamp               |                       | timestamp | 系统生成 | event创建的时间戳（ms）                                      | 0                   |
| identity_id             |                       | string    | ""       | 本次比对成功时，返回人员的唯一识别ID（失败时返回空字符串""）     | "100000"      |
| identity_name           |                       | string    | ""       | 本次比对成功时，返回人员的姓名（失败时返回空字符串""）        | "小王"         |
| register_image_id       |                       | string    | ""       | 本次比对成功时，返回人员的人脸底库图ID（失败时返回空字符串""）<br />获取图片请使用[/sophon/v2/face/getregisterimage](../5.3-identity-manager/9-get-register-pic.md) |                     |
| recognize_face_image_id |                       | string    | ""       | 本次比对返回的现场人脸抠图存储ID(根据id获取图片, 参考现场图获取接口）<br />获取图片请使用[/sophon/v2/face/getspotimage](./17-get-spot-pic.md) |                     |
| spot_image_id           |                       | string    | ""       | 本次比对返回的现场全景图存储ID(根据id获取图片, 参考（现场图获取接口）<br />获取图片请使用[/sophon/v2/face/getspotimage](./17-get-spot-pic.md) |                     |
| permission_id           |                       | string    | ""       | 本次比对使用的权限组ID                                             |                     |
| permission_name         |                       | string    | ""       | 本次比对使用的权限组名称                                               |                     |
| user_type               |                       | string    |          | 人员类型<br />"employee": 员工<br />"visitor": 访客<br />"blacklist": 黑名单<br />"stranger"：陌生人<br />"vip": VIP<br />"car":车辆 |                     |
| score                   |                       | float     | 0.0      | 本次比对的得分                                               |                     |
| post_action             |                       | string    | "0"      | 用来通知管理平台需要怎么处理该event                          |                     |
| frame_id                |                       | int       | 1        | 人脸识别的帧号                                               |                     |
| is_send                 |                       | int       | 0        | 是否已经通过历史记录上传                                     |                     |
| media_device_info       |                       | dict      | {}       | 前端图像采集设备的详细信息                                           |                     |
|                         | media_device_type     | string    | ""       | 采集设备类型：</br>"photo"</br>"rtsp"</br>"file"            |  "rtsp"              |
|                         | media_device_ip       | string    | ""       | 采集设备的IP地址                                            |                     |
|                         | media_device_name     | string    | ""       | 采集设备的名称                                          |                     |
|                         | media_device_id       | string    | ""       | 采集设备的ID                                        |                     |
| recognize_face_attr     |                       | dict      | {}       | 本次比对返回的人脸属性                                                     |                     |
|                         | point                 | list      | []       | 人脸检测的point点                                            |                     |
|                         | box                   | list      | []       | 人脸位置                                                     |                     |
|                         | mask                  | string    | ""       | 口罩: 是否有戴口罩。 "yes", "no"                              |                     |
|                         | gender                | string    | ""       | 性别："male", "female"                                                |  "male"                 |
|                         | hat                   | string    | ""       | 帽子: 是否有帽子（算法未ready）                                    |                     |
|                         | age                   | string    | ""       | 年龄段："child","juvenile", "youth", "middle-aged" "aged"           | "child"                    |
|                         | glasses               | string    | ""       | 眼镜：是否有戴眼镜。"yes", "no"                                    | "yes"                |
|                         | feature_binary        | string    | ""       | 本次识别时提取的人脸特征值base64编码                                        |                     |
| ext_data                |                       | dict      | {}       |                                                              |                     |
|                         | ir_image_id           | string    | ""       | 红外图片存储ID                                                   |                     |
|                         | depth_image_id        | string    | ""       | 深度图片存储ID                                                   |                     |
|                         | track_id              | int       |          | 动态视频流的track ID                                         |                     |
|                         | video_shape           | list      |          | 码流原始帧图片分辨率信息                                      | [1920,1080,3]       |
|                         | in_timestamp          | timestamp |          | 目标人员进入画面的时间戳                                               |                     |
|                         | recognition_timestamp | timestamp |          | 目标人员进行人脸比对时的时间戳                                                   |                     |
|                         | out_timestamp         | timestamp |          | 目标人员离开画面的时间戳                                      |                     |
|                         | pose_score            | float     |          | 人脸的姿态分数，根据此分数来决定是否需要入库（大于0.7才能入库） |                     |
|                         | unknown_id            | int       |          | 陌生人的时候，显示头上的id                                   |                     |
