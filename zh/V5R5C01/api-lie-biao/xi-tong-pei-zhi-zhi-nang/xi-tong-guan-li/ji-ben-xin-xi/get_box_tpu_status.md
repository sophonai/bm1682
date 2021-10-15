# 查询tpu使用 #

**功能描述**

获取SE主机tpu使用情况。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/tpu

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/tpu?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数 | 三级参数 | 类型   | 描述             |
| :------- | :------- | -------- | :----- | :--------------- |
| data     |          |          | list   |                  |
|          | tpu_rate |          | float  | tpu使用率，满值1 |
|          | info     |          | dict   |                  |
|          |          | detail   | string | tpu基本信息      |

请求成功示例：

```json
{
    "data": {
        "info": {
            "detail": "INT8 17.6TOP;FP32 2.2TFLOPS"
        },
        "tpu_rate": 0.15
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

