# 组织更新 #

在人员数据从用户系统同步到sophsight管理平台之前，需要先将人员组织信息同步过来。本章节主要介绍人员组织信息的同步接口。包括新建或编辑组织、删除组织接口。

##  1.1 接口介绍 ##

### 1.1.1 新建或编辑组织 ###

**URI**

/openapi/v1/syncdept/addOrEdit

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
name|String|是|组织名称
thirdId|String|是|组织在调用者系统的ID，长度不能超过100
thirdParentId|String|否|组织在调用者系统的父ID，为空表示没有父组织（比如挂在企业下面的组织），长度不能超过100

**请求示例**

    curl -d 
    '
    {
        "appkey":"xxx",
        "time": xxx,
    	"name": "hr部门",
    	"thirdId": "11",
    	"thirdParentId":"1"
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/syncdept/addOrEdit?token=xxx'

**返回参数**

参数|类型|说明
--  | -- |
id|string|我方系统组织ID

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0,
    	"data": {
        	"id": "11"
    	}
	}

### 1.1.2  删除组织 ###

**URI**

/openapi/v1/syncdept/delete

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
thirdIds|string数组	|是|要删除的组织在调用者系统的ID数组，最多支持删除50个组织

**请求示例**

    curl -d 
    '
    {
        "appkey":"xxx",
        "time": xxx,
    	"thirdIds": ["11"]
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/syncdept/delete?token=xxx'

**返回参数**

无

**返回示例**

    {
        "data": {
            "photoId": "xxx",      // 图片ID
                
        },
        "message": "SUCCESS",
        "status": 0
    }
