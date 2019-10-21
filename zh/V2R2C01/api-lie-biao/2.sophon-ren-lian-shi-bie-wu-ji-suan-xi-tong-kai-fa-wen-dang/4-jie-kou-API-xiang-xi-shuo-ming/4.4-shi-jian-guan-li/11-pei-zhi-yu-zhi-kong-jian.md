# 配置阈值空间/SophonFogSys/api/PrettyScore（PUT）

**功能描述**

配置分数阈值空间，将匹配分数进行转化。

**调用URL**

调用方法: PUT

**请求参数（JSON格式，form-data格式）目前只支持JSON格式**

| 一级参数 | 类型   |   默认值   | 选择 | 描述                                                         |   举例   |
| :------- | :----- | ----------------------------------- | :--- | :----------------------------------------------------------- | --------------------------------- |
| pretty_start_score | float |                                     | 必选 | 阈值起始值                              | 0.0 |
| pretty_best_score | float |                                     | 必选 | 阈值最佳配置值                                     | 82.0 |
| pretty_max_score | float |                                     | 必选 | 阈值最大值                     | 100.0 |

请求示例：

```json
{
    "pretty_best_score": 83.0,
    "pretty_max_score": 100.0,
    "pretty_start_score": 0.0
}
```



**返回信息：**

请求成功

| 一级参数 | 二级参数           | 类型  | 描述           |
| :------- | :----------------- | :---- | :------------- |
| data     |                    |       |                |
|          | pretty_start_score | float | 阈值起始值     |
|          | pretty_best_score  | float | 阈值最佳配置值 |
|          | pretty_max_score   | float | 阈值最大值     |

请求成功示例：

```json
{
    "data": {
        "pretty_start_score": 83.0,
        "pretty_best_score": 0.0,
        "pretty_max_score": 100.0
    }
}
```



请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |