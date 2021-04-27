# 查询方式 #

用户系统调用sophonsight管理平台接口查询人员通行记录。包括员工明细、陌生人明细、访客明细三个接口。

##  1.1 接口介绍 ##

### 1.1.1  员工明细 ###

**URI**

/openapi/v1/cross/record/employee/getList

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
startTime|timestamp|否|开始时间
endTime|timestamp|否|结束时间
keyword|String|否|姓名
locationIds|list<String>	|否|闸机id
pageSize|int|否|查询返回行数,默认值20
index|int|否|查询页 从1开始，默认值1

**请求示例**

    curl -d 
    '
    {
    	"appkey": "32bacfc3",
    	"time": 1487301555980,
    	"locationIds":["18ab153935524556b3e1fb6f524426d","vbd1341bsfgg"],
    	"startTime":167668978091,//开始时间 时间戳
    	"endTime":167668998091,//结束时间 时间戳
    	"keyword":"张",//姓名
    	"pageSize": 20, //每页返回20条
    	"index": 1//查询第一页
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/cross/record/employee/getList'

**返回参数**

参数|类型|说明
--  | -- |
id|int|记录id
userId|int|用户id
thirdUserId|string|第三方用户id
name|string|姓名
jobNumber|string|工号
deptName|string|所属部门
nodeName|string|通过闸机
crossTime|long|通过时间（时间戳，毫秒）
fid|string|抓拍图片Id
phone|string|手机号
regFid|string|登记照片

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0,
    	"data": {
        	"employees": [
            	{
            		"id":1,//记录id
            		"userId":1,//用户id
            		"thirdUserId":"xxx"
            		"name":"张**",//姓名
            		"jobNumber":"11001101",//工号
            		"deptName":"appia研发部",//所属部门
            		"nodeName":"1层右1",//通过闸机
            		"crossTime":15888278733,
            		"fid":"xxxxxx.jpg",//通过时间
            		"phone":"13900000000",
            		"regFid":"xxxxx.jpg"
            	},
            	...
        	],
        	"totalCount": 100 //总行数
   		}
	}

### 1.1.2  陌生人明细 ###

**URI**

/openapi/v1/cross/record/stranger/getList

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
startTime|timestamp|否|开始时间
endTime|timestamp|否|结束时间
keyword|String|否|抓拍设备名称
locationIds|List<String>|否|闸机id
pageSize|int|否|查询返回行数，默认值20
index|int|否|查询页 从1开始，默认值1

**请求示例**

    curl -d 
    '
    {
    	"appkey": "32bacfc3",
    	"time": 1487301555980,
    	"locationIds":["18ab153935524556b3e1fb6f524426d","vbd1341bsfgg"],
    	"startTime":167668978091,//开始时间 时间戳
    	"endTime":167668998091,//结束时间 时间戳
    	"keyword":"东门进1",//抓拍设备名称
    	"pageSize": 20, //每页返回20条
    	"index": 1//查询第一页
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/cross/record/stranger/getList'

**返回参数**

参数|类型|说明
--  | -- |
fid|string|抓拍图片ID
nodeName|string|通过闸机
nodeType|int|设备类型（1-门禁，2-闸机，3-监控，4-访客机，5-抓拍机，6-半球摄像头）
crossTime|long|通过时间（时间戳，毫秒）

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0,
    	"data": {
        	"strangers": [
            	{
            	"fid":"",//抓拍照片
            	"nodeName":"1层右1",//通过闸机
            	"nodeType":3,//3摄像头，
            	"crossTime":15888278733//通过时间
            	},
            	...
        	],
        	"totalCount": 100 //总行数
    	}
	}

### 1.1.3 访客明细 ###

**URI**

/openapi/v1/cross/record/visitor/getList

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
startTime|timestamp|否|开始时间
endTime|timestamp|否|结束时间
keyword|String|否|姓名
locationIds|list<String>	|否|闸机id
pageSize|number|否|查询返回行数，默认值20
index|number|否|查询页 从1开始，默认值1

**请求示例**

    curl -d 
    '
    {
    	"appkey": "32bacfc3",
    	"time": 1487301555980,
    	"locationIds":["18ab153935524556b3e1fb6f524426d","vbd1341bsfgg"],
    	"startTime":167668978091,//开始时间 时间戳
    	"endTime":167668998091,//结束时间 时间戳
    	"keyword":"张三",//访客姓名
    	"pageSize": 20, //每页返回20条
    	"index": 1//查询第一页
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/cross/record/visitor/getList'

**返回参数**

参数|类型|说明
--  | -- |
id|int|通行记录id
visitorId|int|访客id
visitorName|string|访客姓名
nodeName|string|通过闸机
crossTime|long|通过时间（时间戳，毫秒）
fid|string|抓拍图片id
phone|string|手机号
regFid|string|登记照片
idCardNumber|string|身份证号

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0,
    	"data": {
        	"visitors": [
            	{
            	"id":1,//通行记录id
            	"visitorId":1,//访客id
            	"visitorName":"张**",//访客姓名
            	"nodeName":"1层右1",//通过闸机
            	"crossTime":15888278733,//通过时间
            	"fid":"xxxxx.jpg",
            	"phone":"13900000000",
            	"regFid":"xxxxx.jpg",
            	"idCardNumber":"824411199001010001"
            	},
            	...
        	],
        	"totalCount": 100 //总行数
    	}
	}
