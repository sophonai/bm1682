# 配置查询/SophonConfig/api/Configs（GET）

**功能描述**

查询一个配置，或是返回所有的配置

**调用URL**

http://192.168.1.180:5555/SophonConfig/api/Configs/<Config_name>

http://192.168.1.180:5555/SophonConfig/api/Configs

调用方法: GET

**请求参数**

无

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonConfig/api/Configs
或者：http://192.168.1.180:5555/SophonConfig/api/Configs/DUPLICATE_REMOVAL_TIMEOUT
```



**返回信息：**

请求成功

| 一级参数 | 二级参数 | 三级参数 | 类型 | 描述 |
| :------- | :------- | :------- | :--- | :--- |
| data     |          |          | dict |      |

请求成功示例：

```json
{
    "data": {
        "AGE": false,
        "APPLY_MODE": "recognize",
        "ATTRIBUTE_DETECT": false,
        "BOX_MAC": "0xe0a50900426c",
        "BRIGHTNESS": 40,
        "CLARITY": 30,
        "DEFAULT_GROUP_RANGE": [
            10000,
            100000,
            200000,
            300000,
            400000,
            500000
        ],
        "DEFAULT_GROUP_SIZE": 100000,
        "DEVICE_LIST_INFO_UPLOAD_ADDR": "http://192.168.0.154:9061/box/device/sync",
        "DEVICE_MONITOR_ADDR": "",
        "DEV_SNO": "EEIGVB000120210629172137",
        "DUPLICATE_REMOVAL_TIMEOUT": 6,
        "EVENT_IMAGE_PATH": "local",
        "EVENT_WORK_MODE": "opendoor",
        "EXCHANGE_ARGUMENTS": "",
        "EXCHANGE_AUTO_DELETE": "False",
        "EXCHANGE_DURABLE": true,
        "EXCHANGE_NAME": "exchange-dev-EEIGVB000120210629172137",
        "EXCHANGE_PASSIVE": "False",
        "EXCHANGE_TYPE": "topic",
        "FIQA_LEVEL": "low",
        "FIRST_SCORE_FUNC_A": 149.09090909090907,
        "FIRST_SCORE_FUNC_B": 0,
        "GENDER": false,
        "GLASS": false,
        "GRAB_MIN_FACE": 40,
        "GRAB_MODE": "quality",
        "GRAB_THRESHOLD": 44,
        "GRAB_TIME_PART1": "00:00:00,23:59:59",
        "GRAB_TIME_PART1_SWITCH": false,
        "GRAB_TIME_PART2": "00:00:00,23:59:59",
        "GRAB_TIME_PART2_SWITCH": false,
        "HISROTY_EVENT_NEED_REG_PIC": "true",
        "HISTORY_CONTENT_TYPE": "json",
        "HISTORY_EVENT_NEED_RECOGNIZE_FACE": true,
        "HISTORY_EVENT_NEED_REG_PIC": true,
        "HISTORY_EVENT_NEED_SPOT_PIC": true,
        "HISTORY_UPLOAD_EVENT_URL": "http://192.168.0.154:9061/box/v2/cross/record/report,",
        "HISTORY_UPLOAD_NEED_INFO": true,
        "IMG_SERVER_ADDR": "",
        "INIT": "1",
        "IR_COLLECTION": true,
        "LIVENESS_FAIL_COLLECTION": false,
        "LOGIN_STATUS": {
            "chinese_message": "登录成功",
            "code": 0,
            "message": "login success"
        },
        "LOGIN_TOKEN": "7cbc8e8938c84243bf9880c5b12689ec",
        "LOGIN_URL": "http://192.168.0.154:9061/api/gateway/login",
        "MASK": false,
        "MONGO_IP": "127.0.0.1",
        "MQ_FIQA_DOWN_QUEUE": "topic.fiqa.download",
        "MQ_FIQA_UPLOAD_QUEUE": "topic.fiqa.upload",
        "MQ_PASSWORD": "337523cac8a3389345bf4ec6a702b2f0",
        "MQ_QUEUE": "queue-dev-EEIGVB000120210629172137",
        "MQ_SERVER_IP": "192.168.0.154",
        "MQ_SERVER_PORT": 5672,
        "MQ_UN_NEED_BIND_EXCHANGE": "True",
        "MQ_UPLOAD_QUEUE": "upload-queue",
        "MQ_UPLOAD_VHOST": "/upload",
        "MQ_USERNAME": "EEIGVB000120210629172137",
        "MQ_VHOST": "/EEIGVB000120210629172137",
        "OCCLUDE": 10,
        "PASSMODE": "normal",
        "PHOTO_TYPE": "recognize_face",
        "PITCH": 30,
        "POSE_THRESH": "high",
        "PRODUCT_TYPE": "SE5",
        "REG_MIN_FACE": 40,
        "REG_TIME_PART1": "00:00:00,23:59:59",
        "REG_TIME_PART1_SWITCH": false,
        "REG_TIME_PART2": "00:00:00,23:59:59",
        "REG_TIME_PART2_SWITCH": false,
        "REMOTE_SERVER_ADDR": "http://192.168.0.154:9061",
        "REPORTED_PEROID": 5,
        "SECOND_SCORE_FUNC_A": 40.00000000000001,
        "SECOND_SCORE_FUNC_B": 59.99999999999999,
        "STRANGER_GROUP_RANGE": [
            30000,
            50000,
            100000
        ],
        "STRANGER_GROUP_SIZE": 30000,
        "SUPPORT_MASK": false,
        "SUPPORT_STRANGER_GROUP": false,
        "THEME": "PARK",
        "THRESHOLD": 82,
        "THRESHOLD_RANGE": "0.0,82.0,100.0",
        "WEB_HEART_TIME": 20,
        "WEB_HEART_URL": "http://192.168.0.154:9061/box/monitor/device/status/report",
        "WORK_MODE": "mq",
        "YAW": 60
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
