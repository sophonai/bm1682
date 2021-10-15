# 访客登记 #

sophonsight管理平台提供访客登记接口给用户系统调用。访客登记指访客拜访前进行在线登记，sophonsight管理员审核通过后（有参数控制是否需要审核），可刷脸通行对应闸机或门禁。

##  1.1 接口介绍 ##

## 1.1.1 访客登记 ##

**URI**

/openapi/v1/visitor/add

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
name|String|是|访客姓名
startTime|long|是|到访开始时间(时间戳，毫秒级)
endTime|long|是|到访结束时间(时间戳，毫秒级)
photoId|string|是|图片ID
isNeedAudit|boolean|否|默认true，即需要审核

**请求示例**

    curl -d 
    '
    {
    	"appkey": "32bacfc3",
    	"time": 1487301555980,
    	"name": "张三",
    	"startTime": "35135235123",
    	"endTime": "6435435345",
    	"photoId": "xxxx",
    	"isNeedAudit": false
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/visitor/add?token=xxx'


**返回示例**

    {
    	"status": 0,
    	"message": "success"
	}
