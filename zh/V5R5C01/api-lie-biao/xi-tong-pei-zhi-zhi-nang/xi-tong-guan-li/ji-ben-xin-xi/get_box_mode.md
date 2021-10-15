# 获取软件系统模式 #

**功能描述**

获取SE主机软件系统模式。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/systemMode

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/systemMode?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数   | 类型   | 描述                                       |
| :------- | :--------- | :----- | :----------------------------------------- |
| data     |            | dict   |                                            |
|          | systemMode | string | “0”: 裸系统版本<br />“1”：内置人脸应用系统 |

请求成功示例：

```json
{
    "data":{
        "systemMode":"0"
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

