# 设备查询 #

sophonsight管理平台提供设备查询接口给用户系统调用。

##  1.1 接口介绍 ##

## 1.1.1 设备信息查询 ##

**URI**

/openapi/v1/cross/search

**Method**

POST

**请求参数**

字段|含义|类型|是否必填|说明
--  |--  | -- | ------ |
nodeDesc|名称|String|否| 
nodeType|类型|int|否|1-门禁，2-闸机，3-监控，4-访客机，5-抓拍机，6-半球摄像头
index|索引|int|否|查询页 从1开始，默认值1
pageSize|页数|int|否|默认值20 

**请求示例**

    curl -d 
    '
	{
		"appkey": "32bacfc3",
  		"time": 1487301555980,
  		"nodeDesc": "奥北科技园20号楼1号闸机",
  		"nodeType": "1",
  		"index":"2",
  		"pageSize":"10"
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/cross/search?token=xxx'

**返回参数**

参数|类型|说明
--  | -- |
totalSize|int|页数
locationId|string|设备Id
nodeType|int|设备类型（1-门禁，2-闸机，3-监控，4-访客机，5-抓拍机，6-半球摄像头）
nodeDesc|string|设备描述
createTime|long|生效时间（时间戳，毫秒级）

**返回示例**

    {
  		"data": {
    	"totalSize": 100,
    	"corssNodeOwnerships":[
        	{
            	"locationId":"1001",
            	"nodeType":"1",
            	"nodeDesc":"奥北科技园20号楼1号闸机",
            	"createTime":1787821291//时间戳
        	},
        	...
    	]
  	 	},
  		"message": "",
  		"status": 0
	}
