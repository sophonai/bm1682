# 查询阈值空间/SophonFogSys/api/PrettyScore（GET）

**功能描述**

查询配置分数阈值空间。

**调用URL**

调用方法: GET

请求示例：

```json
http://192.168.1.180:5555/SophonFogSys/api/PrettyScore?
```



**返回信息：**

请求成功

| 一级参数 | 二级参数        | 类型 | 描述         |
| :------- | :-------------- | :--- | :----------- |
| data     |                 |      |              |
|          | threshold_range | list | 阈值映射空间 |

请求成功示例：

```json
{
    "data": {
        "threshold_range": [
            0.0,
            80.0,
            100.0
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