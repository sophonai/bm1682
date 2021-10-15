# 事件字段说明

| 一级参数   | 二级参数              | 三级参数  | 类型      | 默认值   | 描述                                                         | 举例                |
| :--------- | :-------------------- | --------- | --------- | :------- | :----------------------------------------------------------- | :------------------ |
| _id        |                       |           | string    | 系统生成 | event唯一标识                                                | "1607062639.737444" |
| timestamp  |                       |           | timestamp | 系统生成 | event创建的时间戳                                            | 0                   |
| common     |                       |           | dict      | {}       | Event字段的公共部分                                          | 1000                |
|            | identity_id           |           | string    | ""       | 识别通过的情况下，为识别到的identity_id,否则为空字符串""     | "aaa"               |
|            | identity_info         |           | dict      | {}       | 比对到的人员信息，未比对通过的情况下为空字典                 |                     |
|            |                       | face_ids  | list      |          | 跟人员绑定的人脸列表                                         |                     |
|            |                       | image_id  | string    | ''       | 比对到的人脸底库image_id，根据id获取底库图参考底库图获取接口 | "1244354"           |
|            | identity_name         |           | string    | ''       | 比对到的名字，未比对过情况下为""                             | "test_name"         |
|            | recognize_face_pic_id |           | string    | ""       | 比对到的现场人脸图id，根据id获取图片参考（现场图获取接口）   |                     |
|            | spot_pic_id           |           | string    | ""       | 比对到的现场大图，根据id获取图片参考（现场图获取接口）       |                     |
|            | group_id              |           | string    | ""       | 比对的组id号                                                 |                     |
|            | group_name            |           | string    | ""       | 比对的组名                                                   |                     |
|            | permission_id         |           | string    | ""       | 比对的权限组id                                               |                     |
|            | permission_name       |           | string    | ""       | 比对的权限组名                                               |                     |
|            | person_type           |           | int       | 1        | 1：员工（默认为员工，包括这个字段不存在的情况） 2：访客 3：黑名单 4：陌生人 5：VIP |                     |
|            | score                 |           | float     | 0.0      | 比对的分数结果                                               |                     |
|            | ep_info               |           | dict      | {}       | 采集设备的详细信息                                           |                     |
|            |                       | ep_id     | string    | ""       | mq上传event的时候发送的设备id                                |                     |
|            |                       | ep_type   | string    | ""       | "photo"/'rtsp'/'card'                                        |                     |
|            |                       | ep_ip     | string    | ""       | 产生event的设备ip                                            |                     |
|            |                       | ep_name   | string    | ""       | 产生event的设备name                                          |                     |
|            |                       | device_id | string    | ""       | 产生event的采集设备id                                        |                     |
|            | want_action           |           | string    | "0"      | 用来通知管理平台需要怎么处理该event                          |                     |
|            | frame_id              |           | int       | 1        | 人脸识别的帧号                                               |                     |
|            | recognize_face_attr   |           | dict      | {}       | 人脸属性                                                     |                     |
|            |                       | point     | list      | []       | 人脸检测的point点                                            |                     |
|            |                       | box       | list      | []       | 人脸位置                                                     |                     |
|            |                       | mask      | string    | ""       | 是否有口罩                                                   |                     |
|            |                       | gender    | string    | ""       | male / female                                                |                     |
|            |                       | hat       | string    | ""       | 是否有帽子（算法未ready）                                    |                     |
|            |                       | age       | string    | ""       | child / juvenile / youth / middle-aged /aged                 |                     |
|            |                       | glasses   | string    | ""       | yes / no                                                     |                     |
|            |                       | feature   | list      | []       | 提取的feature                                                |                     |
|            | is_send               |           | boolean   | 0        | 是否已经通过历史记录上传                                     |                     |
|            | card_id               |           | string    | ""       | 门禁卡卡号                                                   |                     |
| gate_data  |                       |           | dict      | {}       |                                                              |                     |
|            | ir_image_id           |           | string    | ""       | 红外图片id                                                   |                     |
|            | depth_image_id        |           | string    | ""       | 深度图片id                                                   |                     |
| grab_data  |                       |           | dict      | {}       |                                                              |                     |
|            | grap_fiqa_info        |           | dict      | {}       | 抓拍机送过来的人脸属性                                       |                     |
|            |                       | age       | string    | ""       |                                                              |                     |
|            |                       | sex       | string    | ""       |                                                              |                     |
| video_data |                       |           | dict      | {}       | 视频流模式下私有字段                                         |                     |
|            | track_id              |           | int       |          | 动态视频流的track id                                         |                     |
|            | video_shape           |           | list      |          | 码流原始帧图片大小                                           | [1920,1080,3]       |
|            | in_timestamp          |           | timestamp |          | 人员进入的时间                                               |                     |
|            | in_bg_pic_id          |           | string    |          | 人员进入的背景图                                             |                     |
|            | in_face_pic_id        |           | string    |          | 人员进入的人脸图                                             |                     |
|            | in_box                |           | list      |          | 进入背景图的bbox                                             |                     |
|            | recognition_timestamp |           | timestamp |          | 识别的时间                                                   |                     |
|            | pose_score            |           | float     |          | 人脸的姿态分数，根据此分数来决定是否需要入库（大于0.7才能入库） |                     |
|            | out_timestamp         |           | timestamp |          | 人员出去的时间                                               |                     |
|            | unknown_id            |           | int       |          | 陌生人的时候，显示头上的id                                   |                     |
