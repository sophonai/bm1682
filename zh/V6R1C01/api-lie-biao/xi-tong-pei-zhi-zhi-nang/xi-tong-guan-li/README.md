# 系统管理接口列表

| Index | 业务能力                 | 请求接口                                        |
| ----- | ------------------------ | ----------------------------------------------- |
| 1     | [查询主机名]()           | sophon/v2/system/gethostname（POST）            |
| 2     | [设置主机名]()           | sophon/v2/system/sethostname（POST）            |
| 3     | [查询ip地址]()           | sophon/v2/system/getip（POST）                  |
| 4     | [设置ip地址]()           | sophon/v2/system/setip（POST）                  |
| 5     | [查询cpu使用]()          | sophon/v2/system/getcpuinfo（POST）             |
| 6     | [查询tpu使用]()          | sophon/v2/system/gettpuinfo（POST）             |
| 7     | [查询主机温度]()         | sophon/v2/system/gettemperature（POST）         |
| 8     | [查询风扇转速]()         | sophon/v2/system/getfanspeed（POST）            |
| 9     | [获取时间模式]()         | sophon/v2/system/gettimesettingmode（POST）     |
| 10    | [设置时间模式]()         | sophon/v2/system/settimesettingmode（POST）     |
| 11    | [查询系统时间]()         | sophon/v2/system/gettime（POST）                |
| 12    | [设置系统时间]()         | sophon/v2/system/settime（POST）                |
| 13    | [查询ntp服务]()          | sophon/v2/system/getntpconfig（POST）           |
| 14    | [设置ntp服务]()          | sophon/v2/system/setntpconfig（POST）           |
| 15    | [查询系统运行时间]()     | sophon/v2/system/getuptime（POST）              |
| 16    | [查询系统版本号]()       | sophon/v2/system/getsoftwareversion（POST）     |
| 17    | [查询内存情况]()         | sophon/v2/system/getmemoryinfo（POST）          |
| 18    | [查询存储情况]()         | sophon/v2/system/getstorage（POST）             |
| 19    | [获取定时重启配置]()     | sophon/v2/system/getregularreboot（POST）       |
| 20    | [设置定时重启]()         | sophon/v2/system/setregularreboot（POST）       |
| 21    | [日志收集获取]()         | sophon/v2/system/getlogs（POST）                |
| 22    | [查询4G模块状态]()       | sophon/v2/system/getltemodem（POST）            |
| 23    | [配置4G模块]()           | sophon/v2/system/setltemodem（POST）            |
| 24    | [查询网络选择模式]()     | sophon/v2/system/getltemodemselection（POST）   |
| 25    | [设置网络选择模式]()     | sophon/v2/system/setltemodemselection（POST）   |
| 26    | [查询4G模块网络状态]()   | sophon/v2/system/getltemodemconnection（POST）  |
| 27    | [查询4G模块sim卡状态]()  | sophon/v2/system/getltemodemsimstatus（POST）   |
| 28    | [获取系统状态上报配置]() | sophon/v2/system/getsystemmonitorconfig（POST） |
| 29    | [配置系统状态上报配置]() | sophon/v2/system/setsystemmonitorconfig（POST） |