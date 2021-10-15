# 查询产品型号和硬件版本 #

**功能描述**

获取SE产品型号和硬件版本。

**调用URL**

http://192.168.150.1:8888/sophon/v2/system/gethardwareinfo

**调用方法**

POST

**请求示例：**

```json
请求url: http://192.168.150.1:8888/sophon/v2/system/gethardwareinfo
```

**返回信息：**

请求成功

| 参数            | 类型   | 描述                          |
| :-------------- | :----- | :---------------------------- |
| model           | string | 产品型号                      |
| product_version | string | 硬件版本                      |
| device_sn       | string | 主机序列号                    |
| chip_sn         | string | 主芯片序列号                  |
| mcu_version     | string | mcu固件版本号，以十六进制显示 |

请求成功示例：

```json
{
    "model": "SE50221",
    "product_version": "V1.2",
    "device_sn": "HQDZKE6BJAABF0499",
    "chip_sn": "HQDZKM6BJAABF0485",
    "mcu_version": "0x34"
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |

​    

**错误码**

| Index | 错误码                 | message | 描述                                                      |
| :---- | :--------------------- | :------ | :-------------------------------------------------------- |
| 1     | UNSUPPORT_CONTENT_TYPE |         | http内容类型不支持。 目前所有的请求支持：application/json |
| 2     | INVALID_REQUEST_JSON   |         | 无效的JSON数据请求。                                      |
| 3     | MISSING_ARGUMENTS      |         | 缺乏必要的参数。 : 缺失的参数在message字段中描述          |
| 4     | INVALID_ARGUMENTS      |         | 无效的参数。 : 参数信息在message字段中描述。              |
| 5     | INTERNAL_ERROR         |         | 服务器内部错误。                                          |