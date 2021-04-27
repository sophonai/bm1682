# 查询主机温度 #

**功能描述**

获取SE主机芯片结温。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/temperature

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/temperature?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数          | 类型   | 描述                          |
| :------- | :---------------- | :----- | :---------------------------- |
| data     |                   | list   |                               |
|          | core_temperature  | string | 主机芯片结温,单位：摄氏度’c。 |
|          | board_temperature | string | 主板温度                      |

请求成功示例：

```json
{
    "data": {
        "core_temperature": "44.0'C",
        "board_temperature":"46.0'C"
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

