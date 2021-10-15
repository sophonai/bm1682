# 清理数据/SophonFogSys/api/WipeData（POST）

**功能描述**

清空注册的人员数据和分组数据以及产生的事件等。

**调用URL**

http://192.168.1.180:5555/SophonFogSys/api/WipeData

调用方法: POST

**请求参数（JSON格式）**

| 一级参数     | 二级参数 | 类型 | 选择 | 描述                                                         | 举例 |
| :----------- | :------- | :--- | :--- | :----------------------------------------------------------- | :--- |
| wipe_options |          | dict | 必选 |                                                              |      |
|              | users    | bool | 必选 | 是否删除人员底库信息<br />true: 删除人员信息<br />false: 不删除人员信息 |      |
|              | events   | bool | 必选 | 是否删除人员识别记录事件<br />true: 删除事件<br />false: 不删除事件 |      |

请求示例：

```json
{
	"wipe_options":{
		"users":true,   //true为删除用户
		"events":true   //true为清空事件
	}
	
}
```

**返回信息：**

请求成功

| 一级参数 | 二级参数     | 三级参数 | 类型 | 描述                     |
| :------- | :----------- | :------- | :--- | :----------------------- |
| data     |              |          | dict |                          |
|          | wipe_options |          | dict |                          |
|          |              | users    | bool | 是否删除人员底库信息     |
|          |              | events   | bool | 是否删除人员识别记录事件 |

请求成功示例：

```json
{
    "data": {
        "wipe_options": {
            "events": true,
            "users": true
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

