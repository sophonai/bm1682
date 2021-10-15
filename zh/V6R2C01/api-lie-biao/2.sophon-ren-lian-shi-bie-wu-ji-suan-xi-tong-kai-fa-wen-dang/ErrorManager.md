# 错误码

| Index | 错误码                               | message        | 描述                                                         |
| ----- | ------------------------------------ | -------------- | ------------------------------------------------------------ |
| 1     | ANOTHER_PICTURE_SEARCH_RUNNING_ERROR |                | 另外一个以图搜图正在运行                                     |
| 2     | CONFIG_ITEM_FAIL                     |                | 配置失败列表                                                 |
| 3     | DEVICE_ADDRESS_DUPLICATE_ERROR       |                | device_url地址重复                                           |
| 4     | DEVICE_ID_NOT_FOUND                  |                | 设备id未找到                                                 |
| 5     | DEVICE_INIT_ERROR                    |                | 设备初始化中，无法读取设备信息                               |
| 6     | DEVICE_MAX_NUM_ERROR                 |                | 设备超出最大添加数量                                         |
| 7     | DEVICE_PERVIEW_ID_NOT_EXIST          |                | 在设备列表里面无法找到该预览设备id                           |
| 8     | DEVICE_RTMP_ADDRESS_DUPLICATE_ERROR  |                | rtmp推流地址重复                                             |
| 9     | EMPTY_GROUP_ERROR                    |                | 比对组为空                                                   |
| 10    | EMPTY_REQUEST_JSON                   |                | 空白的JSON数据请求                                           |
| 11    | EXCUTE_FRPC_SERVICE_ERROR            |                | 执行frpc服务失败                                             |
| 12    | EXCUTE_START_SHELL_ERROR             |                | 下载包中启动脚本错误                                         |
| 13    | FRPC_SET_INI_FILE_ERROR              |                | frpc配置文件写入失败                                         |
| 14    | FRPC_PORT_ERROR                      |                | frpc端口已被占用                                             |
| 15    | ID_NOT_FOUND                         | 未找到的ID值   | ID未找到错误                                                 |
| 16    | ID_REPEAT_ERROR                      | 重复的ID值     | ID重复错误                                                   |
| 17    | INTERNAL_ERROR                       |                | 服务器内部错误，当此类错误发生时请再次请求，如果持续出现此类错误，请及时联系技术支持团队 |
| 18    | INTERNET_ERROR                       |                | 网络错误                                                     |
| 19    | IMAGE_DECODE_ERROR                   |                | 图片解码失败                                                 |
| 20    | IMAGE_DOWNLOAD_TIMEOUT               |                | 图片下载超时                                                 |
| 21    | IMAGE_NOT_OPENED                     |                | 图片路径无法打开                                             |
| 22    | IMAGE_SIZE_TOO_LARGE_ERROR           |                | 图片尺寸过大                                                 |
| 23    | INSUFFICIENT_SPACE_LEFT              |                | 剩余空间不足                                                 |
| 24    | INVALID_ARGUMENTS                    | 无效参数的值   | 无效的参数。                                                 |
| 25    | INVALID_IMAGE_URL                    |                | 无法从指定的image_url下载图片，图片URL错误或者无效           |
| 26    | INVALID_REQUEST_JSON                 |                | 无效的JSON数据请求。                                         |
| 27    | GROUP_LEN_ERROR                      |                | 超过人员底库容量                                             |
| 28    | LIVENESS_DETECT_FAIL                 |                | 活体检测失败                                                 |
| 29    | LOW_QUALITY_ERROR                    | 失败项目       | 图像质量不过关 <br />headpose : 人脸角度过大 <br />clarity : 清晰度不足 <br />face_size :人脸大小不足 \|<br />partial : 人脸不完整 <br />face_color :光照不均匀 <br />brightness :亮度不足 <br />mask :口罩遮挡 <br />occlusion :人脸有遮挡 <br />建议：图像质量不过关(口罩遮挡，光照不均匀） |
| 30    | MATCH_FAIL                           |                | 比对失败                                                     |
| 31    | MD5_VALUE_ERROR                      |                | md5值不一致                                                  |
| 32    | MISSING_ARGUMENTS                    | 缺失参数的名称 | 缺乏必要的参数。                                             |
| 33    | NAME_REPEAT_ERROR                    | 重复的名字     | 名字重复错误。                                               |
| 34    | NO_FACE_ERROR                        |                | 没有找到人脸                                                 |
| 35    | NOT_FOUND_4G_MODULE                  |                | 未检测到4G模块                                               |
| 36    | NOT_IN_PASS_TIME                     |                | 非布防时间                                                   |
| 37    | NOT_SUPPORT_IN_GRAB_MODE             |                | 在抓拍模式下不支持                                           |
| 38    | NOT_SUPPORT_IR_LIVENESS              |                | 无法支持红外活体                                             |
| 39    | PASSWORD_ERROR                       |                | 密码错误                                                     |
| 40    | PERMISSION_ID_NOT_FOUND              |                | 人员库ID不存在                                               |
| 41    | UNSUPPORT_CONTENT_TYPE               |                | http内容类型不支持。<br/>目前所有的请求支持：application/json |

