# 查询cpu使用 #

**功能描述**

获取SE主机cpu使用情况。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/cpu

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/cpu?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数 | 三级参数  | 类型   | 描述            |
| :------- | :------- | --------- | :----- | :-------------- |
| data     |          |           | list   |                 |
|          | cpu_rate |           | float  | cpu使用率,满值1 |
|          | info     |           | dict   | cpu附加信息     |
|          |          | cpu_freq  | string | cpu使用频率。   |
|          |          | cpu_count | string | cpu核数。       |
|          |          | cpu_type  | string | cpu型号。       |

请求成功示例：

```json
{
    "data": {
        "cpu_rate": 0.19,
        "info": {
            "cpu_count": "8",
            "cpu_freq": "2.3Ghz",
            "cpu_type": "A53"
        }
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

