# 开放API #
管理平台提供开放API给第三方系统调用。APi调用接口认证需要appKey和secret，在通行管理->SDK管理中生成，请参考管理平台功能介绍->通行管理章节。

## 1.公共说明 ##
### 1.1接口认证 ###
#### 1.1.1  接口认证方式 ####
<br><font color="#dd0000"><b>调用方</b></font>首先要向平台管理员获取appkey和secret；
<br>appkey：调用方唯一标识，方便HTTP-API统计与维护；
<br>secret：密钥，用于生成HTTP-API校验所需的token值；
<br><font color="#dd0000"><b>调用方</b></font>
遵照HTTP-OpenAPI约定规则生成token，并作为接口调用的请求参数传入<font color="#dd0000"><b>服务端</b></font>进行校验；
<br><font color="#dd0000"><b>服务端</b></font>对<font color="#dd0000"><b>调用方</b></font>传入的token参数值进行验证；

#### 1.1.2  获取AppKey和Secret ####
AppKey：调用方唯一标识，方便HTTP-OpenAPI统计与维护
Secret：密钥，用于生成HTTP-OpenAPI校验的token值

#### 1.1.3公共请求参数 ####
body中公共参数

    {
    
    "appkey": "xxx",
    
    "time": 1551196800000,//精确到ms
    
    }

拼在url后面的公共参数


  token | 认证参数 | String | 是 | 拼接在POST请求URL后面
  ----- | -------- | ------ | -- 
        |          |        |    | 

<br><font color=red><b>注：接口定义中公共参数忽略</b></font>

#### 1.1.4   生成token值 ####
Token值是将请求源串以及Secret通过MD5算法生成的，用来提高传输过程参数的防篡改性。

token值的生成共有2个步骤：**构造源串，生成token值**。详见下面的描述。

**Step1.构造源串**

a.获取要请求URI(统一资源标识符，即域名后面的地址串，示例：/openapi/v1/cross/node/search）；

b.将输入参数（公共参数和业务参数）生成JSON串；：{"appkey":"1234qwe","time":1551196800000,pageNo":"2","pageSize":"10"}

c.将a中URI和b中得到的字符串和secrect拼接起来得到源串。/openapi/v1/cross/node/search{"appkey":"1234qwe","time":1551196800000,pageNo":"2","pageSize":"10"}secret

**Step2.生成token值**

使用MD5算法对Step1中得到的源串进行运算，得到token值（大写）

md5(/openapi/v1/cross/node/search{"appkey":"1234qwe","time":1551196800000,pageNo":"2","pageSize":"10"}secret)

**Step3.将token参数和值拼接到POST请求URL后面**

**Step4.发起请求**

<font color=red>**注：生成token的请求参数顺序与请求URL中的参数顺序保持一致**</font>
## 2.接口列表 ##

### 2.1图片上传 ###

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

    {
        "appkey": "7ea24d0a",
        "time": 1551196800000,
        "photoName":"xxxxx.jpg",
        "photoByteStr":"/9j......=="
    }

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

## 2.2 图片下载 ##

**URI**

/openapi/v1/pic/download

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
photoId|String|是|图片id

**请求示例**

    {
    	"appkey": "12345",
    	"time": 1551196800000,
    	"photoId":"0f486473e08f42db9dd86aaffc485933.jpg"
	}

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

## 2.3访客登记 ##

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

    {
    	"appkey": "32bacfc3",
    	"time": 1487301555980,
    	"name": "张三",
    	"startTime": "35135235123",
    	"endTime": "6435435345",
    	"photoId": "xxxx",
    	"isNeedAudit": false
	}


**返回示例**

    {
    	"status": 0,
    	"message": "success"
	}

## 2.4设备信息查询 ##

**URI**

/openapi/v1/cross/search

**Method**

POST

**请求参数**

字段|含义|类型|是否必填|说明
--  |--  | -- | ------ |
nodeDesc|名称|String|否| 
nodeType|类型|int|否|1-门禁，2-闸机，3-监控，4-访客机，5-抓拍机，6-半球摄像头
index|索引|int|是|查询页 从1开始
pageSize|页数|int|是| 

**请求示例**

	{
		"appkey": "32bacfc3",
  		"time": 1487301555980,
  		"nodeDesc": "奥北科技园20号楼1号闸机",
  		"nodeType": "1",
  		"index":"2",
  		"pageSize":"10"
	}

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

## 2.5 人员通行记录信息 ##
### 2.5.1  员工明细 ###

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
pageSize|int|是|查询返回行数
index|int|是|查询页 从1开始

**请求示例**

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

### 2.5.2  陌生人明细 ###

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
pageSize|int|是|查询返回行数
index|int|是|查询页 从1开始

**请求示例**

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

### 2.5.3 访客明细 ###

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
pageSize|number|是|查询返回行数
index|number|是|查询页 从1开始

**请求示例**

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

## 2.6 人员组织数据同步 ##

### 2.6.1  新建或编辑组织 ###

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

    {
    	"name": "hr部门",
    	"thirdId": "11",
    	"thirdParentId":"1"
	}

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

### 2.6.2  删除组织 ###

**URI**

/openapi/v1/syncdept/delete

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
thirdIds|string数组	|是|要删除的组织在调用者系统的ID数组，最多支持删除50个组织

**请求示例**

    {
    	"thirdIds": ["11"]
	}

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

### 2.6.3  新建或编辑员工 ###

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

    {   
  		"name": "张三",
  		"thirdId": "1",
  		"jobNumber":"001"，
  		"mail":"zhangsan@company.com",
  		"phone":"13800138000",
  		"thirdDeptId":"1",
  		"facePicture":"xxx"
	}

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

### 2.6.4  删除员工 ###

**URI**

/openapi/v1/syncuser/delete

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
thirdIds|string数组|是|要删除的员工在调用者系统的ID数组，最多支持删除50个员工

**请求示例**

    {
    	"thirdIds": ["11"]
	}

**返回参数**

无

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0
	}

## 3.上报接口列表 ##

上报接口由第三方实现，在事件发生时调用第三方接口，给对方上报对应事件

### 3.1设备状态上报 ###

AI盒子向管理系统上报设备状态时，管理平台上报设备状态给第三方系统。

**URI**

第三方给出，在管理系统配置上

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
deviceId|String|是|盒子Id
deviceStatus|String|是|盒子状态，0：在线 1：离线 -1：未知
deviceMac|String|是|盒子mac地址
deviceName|String|是|盒子名称
deviceSN|String|是|盒子sn
cameraNum|String|是|采集端设备数量
cameraInfo[index].cameraId|String|是|采集端设备Id
cameraInfo[index].state|String|是|采集端设备状态，0：在线 1：离线 -1：未知
cameraInfo[index].Ip|String|是|采集端设备Ip
cameraInfo[index].Name|String|是|采集端设备名称
timeStamp|String|是|上报时间，时间戳，到ms。
swVersion|String|否|中心节点版本信息
sdkVersion|String|否|算法版本
cpuUsage|String|否|CPU使用率
memorySize|String|否|内存大小，单位GB
memoryUsage|String|否|内存使用率
diskSize|String|否|磁盘大小，单位GB(/data分区)
diskFreeSize|String|否|磁盘数据分区剩余可用空间，单位为GB(/data分区)

**请求示例**

    {
  		"cameraInfo": [
    		{
      			"cameraId": "epid001",
      			"ip": "192.168.1.2",
      			"name": "摄像头1",
      			"state": 1
    		}
  		],
  		"cameraNum": 1,
  		"cpuUsage": 0.1,
  		"deviceId": "DK000120190624154652 ",
  		"deviceMac": "mac001",
  		"deviceName": "hlqtest",
  		"deviceSN": "sn0001",
  		"deviceStatus": 0,
  		"diskFreeSize": 3.0,
  		"diskSize": 4.0,
  		"memorySize": 50.0,
  		"memoryUsage": 0.2,
  		"sdkVersion": "1.0.0",
  		"swVersion": "1.0.0",
  		"timeStamp": 1562148250381
	}

**返回参数**

无

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0
	}

### 3.2人员通行记录上报 ###

AI盒子向管理系统上报通行记录时，管理平台上报通行记录给第三方系统。

**URI**

第三方给出，在管理系统配置上

**Method**

POST

**请求参数**

参数|类型|是否必填|说明
--  | -- | ------ |
userId|String|是|人员Id
userName|String|是|人员名称
userType|String|是|人员类型；MEMBER：员工、VIP：vip、VISITOR：访客、BLACKLIST：黑名单人员，STRANGER：陌生人
matchScore|String|是|盒人脸匹配分值,取值0-1
photoId|String|是|抓怕人脸照片
crossTime|String|是|事件上报时间
deviceId|String|是|盒子Id
cameraId|String|是|采集端设备Id
cameraIp|String|否|采集端设备Ip
cameraType|String|否|采集端设备类型 0：闸机，1：抓拍机 2：IPC 静态 3：IPC 动态 4：门禁

**请求示例**

    {
  		"cameraId": "epid001",
  		"crossTime": 1562083200000,
  		"deviceId": "sn_hlq",
  		"matchScore": 0.5699999928474426,
  		"photoId": "946f61b94a7b48519b706e126ed28623.jpg",
  		"userId": "200005",
  		"userName": "hlq14",
  		"userType": "VIP"
	}

**返回参数**

无

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0
	}
