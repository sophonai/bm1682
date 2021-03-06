# 设置主机名 #

**功能描述**

设置SE主机名称。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/hostname

**调用方法**

POST

**请求参数**

| 参数     | 类型   | 默认值 | 选择 | 描述       | 举例         |
| :------- | :----- | ------ | :--- | :--------- | ------------ |
| hostname | string | 无     | 必选 | 主机名称。 | “BM1684-180” |

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/hostname?
请求body:
	{
        "hostname":"BM1684-180"
    }
```

**返回信息：**

请求成功：

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| data     |          | dict   |            |
|          | hostname | string | 主机名称。 |

请求成功示例：

```json
{
    "data": {
        "hostname": "BM1684-180"
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
