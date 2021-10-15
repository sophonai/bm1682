# 删除设备/SophonDevice/api/Devices（DELETE）

**功能描述**

删除一个或者多个设备

**调用URL**

http://192.168.1.180:5555/SophonDevice/api/Devices

调用方法: DELETE

**请求参数（JSON格式）**

| 参数         | 一级参数  | 类型   | 默认值 | 选择           | 描述                                          | 举例 |
| :----------- | :-------- | :----- | :----- | :------------- | :-------------------------------------------- | :--- |
| clear_all    |           | bool   | false  | 必选           | 是否删除全部，当为true时， devices_list可为空 |      |
| devices_list |           | list   | 无     | 必选，可以为空 | 设备列表组                                    |      |
|              | device_id | string | 无     | 必选           | 设备id号，为uuid4                             |      |

请求示例：

```json
请求url: http://192.168.1.180:5555/SophonDevice/api/Devices?
请求body:
{   "clear_all":false,
    "devices_list":[
        {"device_id":"2c1a6a12-ecf4-4490-a2fc-8d7a5023bfcd"}
    ]
}
```

**返回信息：**

请求成功

| 一级参数 | 二级参数        | 类型 | 描述                   |
| :------- | :-------------- | ---- | :--------------------- |
| data     |                 | dict |                        |
|          | success_devices | list | 返回删除成功的设备列表 |

请求成功示例：

```json
{
    "data": {
            "success_devices":[
                 {"device_id":"","device_name":""}
            ]
        }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |
