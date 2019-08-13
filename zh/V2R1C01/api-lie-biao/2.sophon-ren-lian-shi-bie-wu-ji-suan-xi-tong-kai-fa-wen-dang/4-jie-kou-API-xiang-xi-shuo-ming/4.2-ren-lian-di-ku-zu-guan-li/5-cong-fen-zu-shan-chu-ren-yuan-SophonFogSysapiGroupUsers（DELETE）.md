#### 从分组删除人员/SophonFogSys/api/GroupUsers（DELETE）

**功能描述**

一个分组中删除人员。

**调用URL**

调用方法: DELETE

**请求参数（JSON格式，form-data格式）**

| 参数             | 类型    | 选择 | 描述                                                         |
| :--------------- | :------ | :--- | :----------------------------------------------------------- |
| group_name       | string  | 必选 | 分组名称                                                     |
| identity_id      | list    | 必选 | 用户id列表[["123345","23455"](https://info.bitmain.vip:8443/pages/createpage.action?spaceKey=AIBOX&title="123345"%2C"23455"&linkCreation=true&fromPageId=59841178)] |
| with_identity_id | boolean | 可选 | 默认为false，不返回该组的identity_id如果为true，返回该组的identity_id |

**返回信息：**

请求成功

| 一级参数 | 二级参数    | 类型   | 描述                                                         |
| :------- | :---------- | :----- | :----------------------------------------------------------- |
| data     | group_name  | string | 分组名称                                                     |
| data     | message     | string | 返回信息                                                     |
| data     | identity_id | list   | 默认为false，不返回该组的identity_id如果为true，返回该组的identity_id |

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

Postman 示例调用：

https://documenter.getpostman.com/view/3306589/RznFoxqf#2fffeaf9-7b06-34b4-1adc-9a2ad35e92fd