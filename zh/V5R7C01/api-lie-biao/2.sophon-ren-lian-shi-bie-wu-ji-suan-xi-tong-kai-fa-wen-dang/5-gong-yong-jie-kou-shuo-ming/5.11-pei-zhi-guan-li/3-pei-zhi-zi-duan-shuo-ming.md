# 事件字段说明

| 配置名                    | 数据类型 | 默认值               | 有效值                                                       |
| :------------------------ | -------- | :------------------- | :----------------------------------------------------------- |
| DUPLICATE_REMOVAL_TIMEOUT | int      | 1000                 |                                                              |
| THRESHOLD                 | float    | 0.5                  | 0                                                            |
| PASSWORD                  | string   | 'admin'              | 1000                                                         |
| WORK_MODE                 | string   | 'mq'                 | 'mq'/'local'                                                 |
| THEME                     | sting    | ‘PARK’               | ‘PARK’/‘SCHOOL’                                              |
| SUPPORT_STRANGER_GROUP    | boolean  | false                | false/true                                                   |
| SUPPORT_MASK              | boolean  | false''              | false/true"1244354"                                          |
| INIT                      | string   | "0''                 | "0"/"1"                                                      |
| EVENTOPLAD_URL            | string   | ""                   |                                                              |
| BOX_USAGE                 | string   | 'normal'             | 'normal'/'fiqa'/'feature'                                    |
| PASSMODE                  | string   | 'normal'""           | 'normal'/'allpass'/'allforbidden'                            |
| APPLY_MODE                | string   | "recognize"          | "grab"/"recognize"                                           |
| GRAB_MIN_FACE             | int      | 30                   | 20~300                                                       |
| GRAB_TIME_PART1           | string   | "00:00:00,23:59:59"  | "00:00:00,23:59:59"                                          |
| GRAB_TIME_PART1_SWITCH    | bool     | false                | true/false                                                   |
| GRAB_TIME_PART2           | string   | "00:00:00,23:59:59"  | "00:00:00,23:59:59"                                          |
| GRAB_TIME_PART2_SWITCH    | bool     | false                | true/false                                                   |
| GRAB_THRESHOLD            | float    | 90                   | 0~100                                                        |
| GRAB_MODE                 | string   | "quality"            | "quality"/"speed"                                            |
| PHOTO_TYPE                | string   | "recognize_face"     | "recognize_face"/"spot_pic"/"all"                            |
| REG_MIN_FACE              | int      | 30                   | 20~300                                                       |
| REG_TIME_PART1            | string   | "00:00:00,23:59:59"  | "00:00:00,23:59:59"                                          |
| REG_TIME_PART1_SWITCH     | boolean  | false                | true/false                                                   |
| REG_TIME_PART2            | string   | "00:00:00,23:59:59"1 | "00:00:00,23:59:59"                                          |
| REG_TIME_PART2_SWITCH     | boolean  | false                | true/false                                                   |
| ATTRIBUTE_DETECT          | boolean  | false                | false/true                                                   |
| DEV_SNO                   | string   | ''                   |                                                              |
| LOGIN_STATUS              | dict     |                      | {"code": 0, "message": "login success","chinese_message":"登录成功"}{"code":600000,"message":"the auth code do not exists", "chinese_message":"请求的授权码不存在"}{"code": 600002, "message":"the auth code has been register","chinese_message":"请求的授权码已经注册"}{"code": 500001,"message": "set mq params error","chinese_message": "设置mq参数过程错误"} |
|                           |          |                      |                                                              |
| MQ_USERNAME               | string   | ''                   |                                                              |
| MQ_PASSWORD               | string   | ''                   |                                                              |
| MQ_SERVER_IP              | string   | ''                   |                                                              |
| MQ_SERVER_PORT            | int      | 5672                 |                                                              |
| CLOUD_SERVER_ADDRESS      | string   | ''                   |                                                              |
| LOGIN_URL                 | string   | ''                   |                                                              |
| EXCHANGE_NAME             | string   | "                    |                                                              |
| EXCHANGE_TYPE             | sting    | ''                   |                                                              |
| EXCHANGE_DURABLE          | boolean  | true                 | true/false                                                   |
| EXCHANGE_PASSIV           | string   | ''                   |                                                              |
| EXCHANGE_AUTO_DELETE      | string   | ''                   |                                                              |
| EXCHANGE_ARGUMENTS        | string   | ''                   |                                                              |
| DEFAULT_GROUP_SIZE        | int      | 100000               | 100000                                                       |
| STRANGER_GROUP_SIZE       | int      | 30000                | 30000                                                        |
| PRODUCT_TYPE              | string   | {}                   | 'docker'/'SE3'/'SE5'                                         |
| DEFAULT_GROUP_RANGE       | list     |                      | 产品为SE3模式下：[10000, 50000]其他模式下为：[10000, 100000, 200000, 300000, 400000, 500000] |
| STRANGER_GROUP_RANGE      | list     |                      | 产品为SE3模式下：[30000, 50000]其他模式下为：[30000, 50000, 100000] |
| EVENT_IMAGE_PATH          | string   | "local"              | 事件现场图存储的位置"local":/data/events"remote":/data2/events |
