# 接口API详细说明

[TOC]

## **通用约定：**

''不为空，None才为空



## **接口列表**

#### 权限组管理

| Index | 业务能力                                                     | 请求接口                                 |
| ----- | ------------------------------------------------------------ | ---------------------------------------- |
| 1     | [创建权限组](5.1-permission-manager/1-create-permission.md)  | /sophon/v2/face/createpermission（POST） |
| 2     | [获取权限组信息](5.1-permission-manager/3-get-permission.md) | /sophon/v2/face/getpermission（POST）    |
| 3     | [获取权限组列表](5.1-permission-manager/2-get-permissions.md) | /sophon/v2/face/getpermissions（POST）   |
| 4     | [更新权限组](5.1-permission-manager/5-update-permission.md)  | /sophon/v2/face/updatepermission（POST） |
| 5     | [删除权限组](5.1-permission-manager/4-delete-permission.md)  | /sophon/v2/face/deletepermission  (POST) |

#### 人员管理

| Index | 业务能力                                                     | 请求接口                                |
| ----- | ------------------------------------------------------------ | --------------------------------------- |
| 1     | [人员注册](5.3-identity-manager/1-create-identity.md)        | /sophon/v2/face/createidentity（POST）  |
| 2     | [人员信息查询](5.3-identity-manager/2-get-identity.md)       | /sophon/v2/face/getidentity (POST)      |
| 3     | [人员列表查询](5.3-identity-manager/3-get-identities.md)     | /sophon/v2/face/getidentities(POST)     |
| 4     | [更新人员基础信息](5.3-identity-manager/4-update-identity.md) | /sophon/v2/face/updateidenity (POST)    |
| 5     | [删除人员](5.3-identity-manager/5-delete-identity.md)        | /sophon/v2/face/deleteidentities (POST) |
| 6     | [给指定人员新加一张人脸](5.3-identity-manager/6-add-face.md) | /sophon/v2/face/addface（POST）         |
| 7     | [删除指定人员的人脸](5.3-identity-manager/7-delete-face.md)  | /sophon/v2/face/deleteface (POST)       |
| 8     | [更换人员注册照片](5.3-identity-manager/8-update-image.md)   | /sophon/v2/face/replaceface (POST)      |
| 9     | [获取人脸底库图](5.3-identity-manager/9-get-register-pic.md) | /sophon/v2/face/getregisterimage (POST) |

#### 人脸识别

| Index | 业务能力                                                   | 请求接口                                 |
| ----- | ---------------------------------------------------------- | ---------------------------------------- |
| 1     | [获取底库图片](5.3-identity-manager/9-get-register-pic.md) | /sophon/v2/face/getregisterimage（POST） |
| 2     | [人脸检测](5.4-compare-manager/2-face-detect.md)           | /sophon/v2/face/detect（POST）           |
| 3     | [人脸比对](5.4-compare-manager/3-face-compare.md)          | /sophon/v2/face/compare（POST）          |
| 4     | [图像质量检测](5.4-compare-manager/4-face-fiqa.md)         | /sophon/v2/face/fiqa（POST）             |
| 5     | [人脸搜索](5.4-compare-manager/5-face-search.md)           | /sophon/v2/face/search  (POST)           |

#### 设备管理

| Index | 业务能力                                                 | 请求接口                                   |
| ----- | -------------------------------------------------------- | ------------------------------------------ |
| 1     | [增加设备](5.7-device-manger/1-add-device.md)            | /sophon/v2/face/addmediadevice（POST）     |
| 2     | [查询设备](5.7-device-manger/2-get-device.md)            | /sophon/v2/face/getmediadevices（POST）    |
| 3     | [更新设备](5.7-device-manger/3-update-device.md)         | /sophon/v2/face/updatemediadevice（POST）  |
| 4     | [删除设备](5.7-device-manger/4-delete-device.md)         | /sophon/v2/face/deletemediadevices（POST） |
| 5     | [查询设备预览信息](5.7-device-manger/5-get-preview.md)   | /sophon/v2/face/getpreview  (POST)         |
| 6     | [更新设备预览信息](5.7-device-manger/6-set-preview.md)   | /sophon/v2/face/updatepreview  (POST)      |
| 7     | [设备状态获取方式](5.7-device-manger/7-device-status.md) | 设备状态的获取方式                         |

#### 识别记录管理

| Index | 业务能力                                                     | 请求接口                                           |
| ----- | ------------------------------------------------------------ | -------------------------------------------------- |
| 1     | [查询识别记录](5.5-event-manager/18-event-query.md)          | /sophon/v2/face/getevent（POST）                   |
| 2     | [查询多个识别记录](5.5-event-manager/12-events-query.md)     | /sophon/v2/face/getevents（POST）                  |
| 3     | [主动查询识别记录的字段描述](5.5-event-manager/13-event-detail.md) | 对于查询识别记录和查询多个识别记录返回值的补充描述 |
| 4     | [以图搜图接口](5.5-event-manager/16-search-by-image.md)      | /sophon/v2/face/searchbyimage(POST)                |
| 5     | [底库图获取接口](5.3-identity-manager/9-get-register-pic.md) | /sophon/v2/face/getregisterimage（POST）           |
| 6     | [现场图(背景大图 & 人脸扣图) 获取接口](15.5-event-manager/7-get-spot-pic.md) | /sophon/v2/face/getspotimage（POST）               |
| 7     | [实时上报的识别记录字段描述](5.5-event-manager/6-realtime-event.md) | 实时上报的识别记录字段描述                         |
| 8     | [集中上报的识别记录字段描述](5.5-event-manager/5-history-event.md) | 集中上报的识别记录字段描述                         |

#### 配置管理

| Index | 业务能力                                           | 请求接口                           |
| ----- | -------------------------------------------------- | ---------------------------------- |
| 1     | [查询配置](5.11-config-manager/1-get-config.md)    | /sophon/v2/face/getconfigs（POST） |
| 2     | [修改配置](5.11-config-manager/2-update-config.md) | /sophon/v2/face/setconfigs (POST)  |
| 3     | [配置字段说明](3-config-detail.md)                 |                                    |

#### 数据管理

| Index | 业务能力                                                     | 请求接口                                    |
| ----- | ------------------------------------------------------------ | ------------------------------------------- |
| 1     | [数据清理](5.8-data-manager/1-qinq-li-shu-ju.md)             | /sophon/v2/face/wipedata（POST）            |
| 2     | [识别记录图片存储路径可用性检查](5.8-data-manager/1-get-spotimage-path.md) | /sophon/v2/face/checkeventimagepath（POST） |

#### 登录管理

| Index | 业务能力                                             | 请求接口                           |
| ----- | ---------------------------------------------------- | ---------------------------------- |
| 1     | [主机登录](5.10-deng-lu-guan-li/box_login.md)        | /sophon/v2/face/getconfigs（POST） |
| 2     | [密码更改](5.10-deng-lu-guan-li/set_box_password.md) | /sophon/v2/face/setconfigs (POST)  |

