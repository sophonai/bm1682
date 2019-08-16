#### 清空数据/SophonFogSys/api/WipeData（POST）

**功能描述**

清空注册的人员数据和分组数据以及产生的事件等，并重启SE3

**调用URL**

调用方法: POST

**请求参数（JSON格式）**

| 一级参数     | 二级参数 | 类型 | <font color="#dd0000">默认值</font> | 选择 | 说明                                                        | <font color="#dd0000">举例</font> |
| :----------- | :------- | :--- | ----------------------------------- | :--- | :---------------------------------------------------------- | --------------------------------- |
| wipe_options |          | dict | 无                                  | 必选 | 需要清除的数据选项                                          |                                   |
|              | users    | bool | 无                                  | 必选 | 是否删除人员底库信息<br />true：删除<br />false：不删除     | true                              |
|              | events   | bool | 无                                  | 必选 | 是否删除人员识别记录事件<br />true：删除<br />false：不删除 | true                              |

请求示例：

```json
请求url: 
请求body:
	{
		"wipe_options":{
            "users":true,
            "events":true
		}
	}
```

 **返回信息：**

| 一级参数 | 二级参数     | 三级参数 | 类型 | 描述                     |
| :------- | :----------- | :------- | :--- | :----------------------- |
| data     |              |          | dict | 消息                     |
|          | wipe_options |          | dict | 需要清除的数据选项       |
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

