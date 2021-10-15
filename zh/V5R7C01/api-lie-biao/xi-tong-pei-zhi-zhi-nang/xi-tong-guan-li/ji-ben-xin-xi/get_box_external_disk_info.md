# 查询存储情况 #

**功能描述**

获取SE主机存储使用情况。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/externalDiskInfo

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/externalDiskInfo?
```

**返回信息：**

请求成功

| 一级参数 | 二级参数                 | 类型   | 描述                                            |
| :------- | :----------------------- | :----- | :---------------------------------------------- |
| data     |                          | dict   |                                                 |
|          | external_hard_state      | string | "0":  没有挂载外接硬盘<br />"1"：挂载了外接硬盘 |
|          | external_hard_total_disk | string | 总存储大小,                                     |
|          | external_hard_free_disk  | string | 剩余存储                                        |
|          | external_hard_used_disk  | string | 已经使用的存储空间大小                          |
|          | external_hard_disk_rate  | float  | 存储使用率                                      |

请求成功示例：

```json
//值若小于1G，返回单位为M，大于1G，则单位为G
{
    "data": {
            "external_hard_state":"1",
            "external_hard_disk_rate":0.6,
            "external_hard_total_disk":"500G",
            "external_hard_free_disk":"200G",
            "external_hard_used_disk":"300G"

      }
}
//若无外接硬盘，则返回
{
 "data": {
    	"external_hard_state":"0",
    	"external_hard_disk_rate":0.0,
    	"external_hard_total_disk":"0G",
    	"external_hard_free_disk":"0G",
    	"external_hard_used_disk":"0G"
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

