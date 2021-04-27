# 查询产品型号和硬件版本 #

**功能描述**

获取SE产品型号和硬件版本。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/hardwareInfo

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/hardwareInfo?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数        | 类型   | 描述         |
| :------- | :-------------- | :----- | :----------- |
| data     |                 | dict   |              |
|          | model           | string | 产品型号     |
|          | product_version | string | 硬件版本     |
|          | device_sn       | string | 主机序列号   |
|          | chip_sn         | string | 主芯片序列号 |
|          |                 |        |              |

请求成功示例：

```json
{
    "data": {
        "model": "SE5",
        "hardwareVersion": "SE50210"
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

