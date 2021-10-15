# 人脸识别雾计算系统

Sophon人脸识别雾计算系统，是一套以Sophon计算盒为核心，结合门禁PAD，闸机PAD，人脸抓拍机和IPC等终端，提供人脸识别服务的完备系统，具有以下一些特点：

- 集成了针对AI芯片深度优化的算丰人脸相关算法族；

- 兼容多终端的人脸信息采集，人脸跟踪，去重，抠图；

- 人脸识别和人脸属性分析，如年龄，性别等；

- 秒级决策反馈，临时信息存储，识别事件过滤聚合，并提供上报功能；

- 兼容本地管理系统和云端管理系统；

- 5万人脸库，0.5秒级别识别与开门，98.5%的识别准确率，1:1,1:N多种比对方式；

- 支持10路门禁/闸机PAD，或10路人脸抓拍机，或4路IPC rtsp码流静态处理，或2路IPC rtsp码流动态处理。

  

  # 系统架构

  人脸识别雾计算系统框架如下：

  ![](/data/BM_WorkSpace/SourceCode/king_gerrit/docs_gitbook/imgs/SophonFog-si-you-yun-jia-gou.png)

  

  - **SE5**

  AI计算盒SE5是一款高性能、低功耗边缘计算产品，搭载TPU芯片BM1684，INT8算力高达17.6TOPS，可同时处理16路高清视频，支持38路1080P高清视频硬件解码与2路编码。

  SE5 AI计算盒适合应用于人脸闸机、人脸门禁、人脸考勤机以及微场景中的摄像头的后端控制中心。SE3可以接收前端摄像头传来的RTSP视频流或者抓拍到的照片流。

  - **LiteOS**

  LiteOS是人脸识别雾计算的本地管理后台。通过LiteOS可以完成一些设备管理，系统配置，状态查询，事件查询，人员和分组管理等工作。

  - **门禁/闸机PAD**

  Android系统设备，人脸识别系统提供一个配套的应用APK，提供初步的人脸检测，结果展示，道闸/门禁开关等功能。

  - **人脸抓拍机**

  抓拍机设备需要指出FTP上传能力，人脸识别系统在SE5上面搭建了一个FTP服务器，用来接收抓拍机上传的图片，以便做后续的人脸分析。

  - **IPC**

  RTSP输出。

  - **迎宾机**

  Android系统设备，人脸识别系统提供一个配套的应用APK，提供信息展示功能。

  人脸识别雾计算系统注册和识别流程如下：

  ![](../../../../imgs/liu-cheng-tu.png)
