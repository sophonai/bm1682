# 配置字段说明

| 配置名                             | 数据类型 | 默认值              | 有效值                                                       | 说明                                                         |
| :--------------------------------- | -------- | :------------------ | :----------------------------------------------------------- | ------------------------------------------------------------ |
| **历史记录相关配置**               |          |                     |                                                              |                                                              |
| HISTORY_EVENT_UPLOAD_URL           | string   | ''                  | 'http://192.168.0.12:80/test'                                | 历史事件上报url<br />设置后，历史记录会按照一定的时间间隔向该url上报相关记录信息 |
| HISTORY_REPORT_PEROID              | int      | 5                   |                                                              | 历史记录上报时间间隔，默认为5s                               |
| **设备信息上报相关配置**           |          |                     |                                                              |                                                              |
| MEDIA_DEVICE_MONITOR_URL           | string   | ''                  |                                                              | 设备信息上报url                                              |
| MEDIA_DEVICE_MONITOR_REPORT_PEROID | int      | 60                  |                                                              | 设备信息上报周期，默认为60s                                  |
| **Gate应用相关配置**               |          |                     |                                                              |                                                              |
| GATE_MONGO_IP                      | string   | "127.0.0.1"         |                                                              | Mongodb的访问地址，默认为小盒子本地<br />系统重启：是<br />清空数据库：是 |
| GATE_WORK_MODE                     | string   | 'local'             | 'mq'<br />'local'                                            | 工作模式<br />mq模式下，需要配套的mq服务器<br />系统重启：是<br />清空数据库：是 |
| GATE_DUPLICATE_REMOVAL_TIMEOUT     | int      | 6                   |                                                              | 图片流设备去重时间，默认为6s                                 |
| GATE_SUPPORT_STRANGER_GROUP        | boolean  | false               | false<br />true                                              | 是否支持陌生人识别<br />true:  新识别的陌生人将会自动建档。人脸识别顺序为：先正常人脸库识别，再陌生人库识别<br />false：不支持陌生人识别 |
| GATE_INIT                          | string   | "0''                | "0"<br />"1"                                                 | 盒子是否初已经始化<br />系统重启：是                         |
| GATE_EVENT_IMAGE_PATH              | string   | "local"             |                                                              | 事件现场图存储的位置<br />"local":/data/events<br />"remote":/data2/events<br />系统重启：是 |
| GATE_APPLY_MODE                    | string   | "recognize"         | "grab"<br />"recognize"                                      | 功能模式字段<br />“grab”：抓拍模式；<br />“recognize”：识别模式；<br />系统重启：是 |
| GATE_BOX_USAGE                     | string   | 'normal'            | 'normal'<br />'fiqa'<br />'feature'                          | 盒子的使用模式<br />'normal':普通模式<br />'fiqa'：图像质量检测<br />'feature'：特征值提取 |
| GATE_PASS_MODE                     | string   | 'normal'            | 'normal'<br />'allpass'<br />'allforbidden'                  | 闸机的控制模式<br />'normal'：正常模式，比对通过才开闸机<br />'allpass'：所有人都通过<br />'allforbidden'：所有人禁止通过 |
| GATE_DEFAULT_GROUP_SIZE            | int      | 100000              | 100000                                                       | 员工组最大容量，调高库容量导致识别耗时增加<br />系统重启：是<br />清空数据库：调小库容量会导致清空数据库 |
| GATE_STRANGER_GROUP_SIZE           | int      | 30000               | 30000                                                        | 陌生人组最大容量<br />系统重启：是<br />清空数据库：调小库容量会导致清空数据库 |
| GATE_PRODUCT_TYPE                  | string   | {}                  | 'docker'/'SE3'/'SE5'                                         | 盒子的工作模式<br />只提供获取借口                           |
| **比对阈值相关配置**               |          |                     |                                                              |                                                              |
| MATCH_THRESHOLD                    | float    | 82                  | 0～100                                                       | 比对的阈值，当比对到的分数大于82.0，则认为此次比对结果生效，比对通过 |
| **MQ相关配置**                     |          |                     |                                                              |                                                              |
| MQ_LOGIN_URL                       | string   | ''                  |                                                              | 获取MQ服务器信息返回的请求地址<br />系统重启：是             |
| MQ_LOGIN_STATUS                    | int      | 0                   | 0<br />600000<br />600002<br />500001                        | 0:登录成功<br />600000:请求的授权码不存在<br />600002:请求的授权码已经注册<br />500001:设置mq参数过程错误" |
| MQ_LICENSE_KEY                     | string   | ""                  |                                                              | MQ登录授权码<br />系统重启：是                               |
| MQ_USERNAME                        | string   | ''                  |                                                              | MQ服务器登录用户名                                           |
| MQ_PASSWORD                        | string   | ''                  |                                                              | MQ服务器连接密码                                             |
| MQ_SERVER_IP                       | string   | ''                  |                                                              | MQ服务器地址                                                 |
| MQ_SERVER_PORT                     | int      | 5672                |                                                              | MQ服务器连接端口                                             |
| MQ_EXCHANGE_NAME                   | string   | "                   |                                                              | 交换机名称                                                   |
| MQ_EXCHANGE_TYPE                   | sting    | ''                  |                                                              | 交换机类型                                                   |
| MQ_EXCHANGE_DURABLE                | boolean  | false               | true<br />false                                              | 队列持久化标志。<br />true：持久化队列<br />false:非持久化队列 |
| MQ_EXCHANGE_PASSIVE                | boolean  | false               |                                                              | 检查交换机是否存在，默认为false                              |
| MQ_EXCHANGE_AUTO_DELETE            | boolean  | false               |                                                              | 自动删除                                                     |
| MQ_EXCHANGE_ARGUMENTS              | dict     | {}                  |                                                              | 其他交换机配置参数，默认不需要传，值为{}                     |
| MQ_DOWN_QUEUE                      | string   | ''                  |                                                              | MQ消息下发队列                                               |
| MQ_UP_QUEUE                        | string   | ''                  |                                                              | MQ消息上传队列, 可以选择不通过MQ消息队列回传结果, 在uploadVHost虚拟主机下。默认是不支持MQ消息上传（即单向通信）。 |
| MQ_FIQA_DOWN_QUEUE                 | string   | ''                  |                                                              | 人脸图片质量检测(FIQA)命令下发队列。<br/> 注意：当把SE AI计算盒用作图片质量校验服务器时，需要下发此栏位。否则不支持通过MQ命令进行FIQA校验功能。 |
| MQ_FIQA_UP_QUEUE                   | string   | ''                  |                                                              | 人脸图片质量检测(FIQA)命令结果上传队列。<br/> 注意：当把SE AI计算盒用作图片质量校验服务器时，需要下发此栏位。否则不支持通过MQ命令进行FIQA校验功能。 |
| MQ_VHOST                           | string   | ''                  |                                                              | MQ服务器登录用户名及下发队列所在虚拟主机.如果不指定，默认为"/"。 |
| MQ_UPLOAD_VHOST                    | string   | ''                  |                                                              | MQ服务器上报队列所在虚拟主机。如果不指定，默认为"/"。        |
| MQ_UNNEED_BIND_EXCHANGE            | boolean  | false               |                                                              | 消息队列是否需要绑定到交换机， 默认为false， 即需要绑定到消息队列。 |
| MQ_LOGIN_TOKEN                     | string   | ''                  |                                                              | 请求云平台接口需要携带的参数                                 |
| MQ_REMOTE_SERVER_ADDR              | string   | ''                  |                                                              | 对接的管理平台地址                                           |
| MQ_IMG_SERVER_ADDR                 | string   | ''                  |                                                              | 图片服务器URL，用于获取用户照片。如果下发得图片中是相对路径，则需要填写此地址。 |
| **算法相关配置**                   |          |                     |                                                              |                                                              |
| ALG_ATTRIBUTE_DETECT               | boolean  | false               | false<br />true                                              | 是否打开属性检测<br />系统重启：是                           |
| ALG_SUPPORT_MASK                   | boolean  | false               | false<br />true                                              | 是否支持口罩检测<br />系统重启：是<br />清空数据库：是       |
| ALG_DEFAULT_GROUP_RANGE            | list     |                     | 产品为SE3模式下：<br />[10000, 50000]<br />其他模式下为：<br />[10000, 100000, 200000, 300000, 400000, 500000] | 员工组支持的size<br />只提供获取接口                         |
| ALG_STRANGER_GROUP_RANGE           | list     |                     | 产品为SE3模式下：<br />[30000, 50000]<br />其他模式下为：<br />[30000, 50000, 100000] | 陌生人组支持的size<br />只提供获取接口                       |
| **抓拍模式相关配置**               |          |                     |                                                              |                                                              |
| GRAB_MIN_FACE                      | int      | 40                  | 20~300                                                       | 抓拍模式下可以抓拍到的最小人脸<br />系统重启：是             |
| GRAB_TIME_PART1                    | string   | "00:00:00,23:59:59" | "00:00:00,23:59:59"                                          | 布防时间段一<br />系统重启：是                               |
| GRAB_TIME_PART1_SWITCH             | bool     | false               | true/false                                                   | 布防时间段一开关<br />系统重启：是                           |
| GRAB_TIME_PART2                    | string   | "00:00:00,23:59:59" | "00:00:00,23:59:59"                                          | 布防时间段二<br />系统重启：是                               |
| GRAB_TIME_PART2_SWITCH             | bool     | false               | true/false                                                   | 布防时间段二开关<br />系统重启：是                           |
| GRAB_THRESHOLD                     | float    | 44                  | 0~100                                                        | 抓拍阈值<br />系统重启：是                                   |
| GRAB_MODE                          | string   | "quality"           | "quality"/"speed"                                            | 抓拍模式选择：<br />quality：质量优先<br />speed：速度优先<br />系统重启：是 |
| GRAB_IMAGE_TYPE                    | string   | "recognize_face"    | "recognize_face"<br />"spot_image"<br />"all"                | 抓拍模式需要送出的图片：<br />"recognize_face"：现场人脸扣图<br />"spot_image"：现场大图<br />"all"：现场人脸扣图+现场大图<br />系统重启：是 |
| GRAB_POSE_THRESH                   | string   | 'high'              | "off"<br />"low"<br />"middle"<br />"high"                   | 在视频流人脸过滤标准<br />系统重启：是                       |
| GRAB_VIDEO_FIQA                    | boolean  | true                | true/false                                                   | true:打开视频流人脸质量过滤<br />false：关闭视频流人脸质量过滤<br />系统重启：是 |
| **识别模式相关配置**               |          |                     |                                                              |                                                              |
| REGN_MIN_FACE                      | int      | 40                  | 20~300                                                       | 识别模式能识别到的最小人脸<br />系统重启：是                 |
| REGN_TIME_PART1                    | string   | "00:00:00,23:59:59" | "00:00:00,23:59:59"                                          | 布防时间段一<br />系统重启：是                               |
| REGN_TIME_PART1_SWITCH             | boolean  | false               | true/false                                                   | 布防时间段一开关<br />系统重启：是                           |
| REGN_TIME_PART2                    | string   | "00:00:00,23:59:59" | "00:00:00,23:59:59"                                          | 布防时间段二<br />系统重启：是                               |
| REGN_TIME_PART2_SWITCH             | boolean  | false               | true/false                                                   | 布防时间段二开关<br />系统重启：是                           |
| REGN_POSE_THRESH                   | string   | 'high'              | "off"<br />"low"<br />"middle"<br />"high"                   | 在视频流人脸过滤标准<br />系统重启：是                       |
| REGN_VIDEO_FIQA                    | boolean  | true                | true/false                                                   | true:打开视频流人脸质量过滤<br />false：关闭视频流人脸质量过滤<br />系统重启：是 |
| REGN_IMAGE_TYPE                    | string   | "all"               | "recognize_face"<br />"spot_image"<br />"all"                | 抓拍模式需要送出的图片：<br />"recognize_face"：现场人脸扣图<br />"spot_image"：现场大图<br />"all"：现场人脸扣图+现场大图<br />系统重启：是 |
