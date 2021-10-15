# 识别记录管理API概述

| Index | 业务能力                                                     | 请求接口                                           |
| ----- | ------------------------------------------------------------ | -------------------------------------------------- |
| 1     | [获取单个识别记录](18-event-query.md)                         | /sophon/v2/face/getevent（POST）                   |
| 2     | [获取多个识别记录](12-events-query.md)                       | /sophon/v2/face/getevents（POST）                  |
| 3     | [识别记录的字段定义](13-event-detail.md)                     | 对于查询识别记录和查询多个识别记录返回值的补充描述 |
| 4     | [以图搜图](5.5-event-manager/16-search-by-image.md)      | /sophon/v2/face/searchbyimage(POST)                |
| 5     | [获取底库图](5.3-identity-manager/9-get-register-pic.md) | /sophon/v2/face/getregisterimage（POST）           |
| 6     | [获取现场图](15.5-event-manager/7-get-spot-pic.md) | /sophon/v2/face/getspotimage（POST）               |
| 7     | [实时上报识别记录](6-realtime-event.md)            | 实时上报的识别记录字段描述                         |
| 8     | [异步上报识别记录](5-history-event.md)             | 集中上报的识别记录字段描述                         |
| 9     | [获取识别记录的本地图片存储路径](1-get-spotimage-path.md)    | /sophon/v2/face/checkeventimagepath（POST）        |

