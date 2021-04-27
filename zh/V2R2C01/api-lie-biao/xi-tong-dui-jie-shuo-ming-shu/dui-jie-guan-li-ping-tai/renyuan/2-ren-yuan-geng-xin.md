# 人员更新 #

本章节主要介绍人员信息从用户系统同步到sophonsight管理平台相关的接口。包括图片上传、图片下载、新建或编辑员工、删除员工接口。

人员信息有照片更新时，先调用图片上传接口上传照片至sophonsight管理平台，若成功返回照片Id，调用新建或编辑员工接口将照片Id填在对应传入参数即可更新人员照片。

##  1.1 接口介绍 ##

### 1.1.1 图片上传 ###

**URI**

/openapi/v1/pic/upload

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
photoName|String|是|图片名称
photoByteStr|String|是|图片base64转码

**请求示例**

    curl -d
    '
    {
        "appkey": "7ea24d0a",
        "time": 1551196800000,
        "photoName":"xxxxx.jpg",
        "photoByteStr":"/9j......=="
    }
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/pic/upload?token=xxx'

**返回参数**

参数|类型|说明
--  | -- |
photoId|string|图片ID

**返回示例**

    {
        "data": {
            "photoId": "xxx",      // 图片ID
                
        },
        "message": "SUCCESS",
        "status": 0
    }

## 1.1.2 图片下载 ##

**URI**

/openapi/v1/pic/download

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
photoId|String|是|图片id

**请求示例**

    curl -d 
    '
    {
    	"appkey": "12345",
    	"time": 1551196800000,
    	"photoId":"0f486473e08f42db9dd86aaffc485933.jpg"
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/pic/download?token=xxx'

**返回参数**

图片文件流

**返回示例**

    {
        "data": {
            "photoId": "xxx",      // 图片ID
                
        },
        "message": "SUCCESS",
        "status": 0
    }

### 1.1.3  新建或编辑员工 ###

**URI**

/openapi/v1/syncuser/addOrEdit

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
name|String|是|员工姓名
thirdId|String|是|员工在调用者系统的ID，长度不能超过100
jobNumber|String|否|员工编号
mail|String|否|员工邮箱
phone|String|否|员工手机号
thirdDeptId|String|是|员工所属组织在调用者系统的ID
facePicture|String|否|员工照片Id，值为调用2.1图片上传接口生成的照片Id，为空编辑时表示删除照片、新加时表示暂不设置照片

**请求示例**

    curl -d
    '
    {   
        "appkey":"xxx",
        "time": xxx,
        "name": "张三",
  		"thirdId": "1",
  		"jobNumber":"001"，
  		"mail":"zhangsan@company.com",
  		"phone":"13800138000",
  		"thirdDeptId":"1",
  		"facePicture":"xxx"
	}
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://ip:9061/openapi/v1/syncuser/addOrEdit?token=xxx'

**返回参数**

参数|类型|说明
--  | -- |
id|string|我方系统员工ID
thirdid|string|员工在调用者系统的ID

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0,
    	"data": {
        	"id":"1",
        	"thirdid" :"1"
    	}
	}

### 1.1.4  删除员工 ###

**URI**

/openapi/v1/syncuser/delete

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
thirdIds|string数组|是|要删除的员工在调用者系统的ID数组，最多支持删除50个员工

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
    'http://ip:9061/openapi/v1/syncuser/delete?token=xxx'

**返回参数**

无

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0
	}
