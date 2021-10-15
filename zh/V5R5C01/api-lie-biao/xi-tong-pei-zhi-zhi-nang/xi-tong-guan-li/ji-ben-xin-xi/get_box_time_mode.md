# 获取时间模式 #

**功能描述**

获取SE主机时间模式。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/timeSelectMode

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/timeSelectMode?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数         | 类型   | 描述                                                |
| :------- | :--------------- | :----- | :-------------------------------------------------- |
| data     |                  | dict   |                                                     |
|          | time_select_mode | string | "0":ntp服务设置时间模式。<br />"1":手动设置时间模式 |

请求成功示例：

```json
{
    "data": {
        "time_select_mode":"0"
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

​    

