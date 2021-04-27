# 设备状态上报 #

sophonsight管理平台调用用户系统接口上报设备状态。本章节介绍相关上报接口的约定协议，用户系统按约定协议实现接口，管理员登录sophonsight管理平台配置上对应URL。

## 1.1 相关配置 ##

在sophonsight管理平台通行管理->系统设置页面，点击事件上报设置可以进行相关的配置。包括设备状态上报URL。如下图：

![](../../../../imgs/shebei-she-bei-shang-bao.png)

## 1.2 接口列表 ##

上报接口由第三方实现，给对方上报对应设备状态信息

### 1.2.1 设备状态上报 ###

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

    curl -d 
    '
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
    '
    -H 'Content-Type: application/json;charset=UTF-8'
    'http://第三方URI'

**返回参数**

无

**返回示例**

    {     
    	"message": "SUCCESS",
    	"status": 0
	}
