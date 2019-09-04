# AIBOX

- V2.2.1
  - [Sophon人脸识别雾计算系统开发文档](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/README.md)
    - [1. 概要](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/1-gai-yao.md)
    - [2. Sophon人脸识别雾计算系统架构](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/2-Sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-jia-gou.md)
    - [3. Sophon人脸识别雾计算系统和云端交互方式](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/3-Sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-he-yun-duan-jiao-hu-fang-shi.md)
    - [4. 接口API详细说明](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/README.md)
      - [4.1 权限组管理](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.1-quan-xian-zu-guan-li/README.md)
        - [创建分组/SophonFogSys/api/permissions（POST）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.1-quan-xian-zu-guan-li/1-chuang-jian-fen-zu-SophonFogSysapipermissions（POST）.md)
        - [查询分组/SophonFogSys/api/permissions（GET）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.1-quan-xian-zu-guan-li/2-cha-xun-fen-zu-SophonFogSysapipermissions（GET）.md)
        - [删除分组/SophonFogSys/api/permissions（DELETE）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.1-quan-xian-zu-guan-li/3-shan-chu-fen-zu-SophonFogSysapipermissions（DELETE）.md)
        - [更新分组/SophonFogSys/api/permissions（PUT）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.1-quan-xian-zu-guan-li/4-gen-xin-fen-zu-SophonFogSysapipermissions（PUT）.md)
      - [4.2 人脸底库组管理](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.2-ren-lian-di-ku-zu-guan-li/README.md)
        - [创建分组/SophonFogSys/api/groups（POST）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.2-ren-lian-di-ku-zu-guan-li/1-chuang-jian-fen-zu-SophonFogSysapigroups（POST）.md)
        - [查询分组/SophonFogSys/api/groups（GET）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.2-ren-lian-di-ku-zu-guan-li/2-cha-xun-fen-zu-SophonFogSysapigroups（GET）.md)
        - [删除分组/SophonFogSys/api/groups（DELETE）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.2-ren-lian-di-ku-zu-guan-li/3-shan-chu-fen-zu-SophonFogSysapigroups（DELETE）.md)
        - [添加人员到分组/SophonFogSys/api/GroupUsers（PUT）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.2-ren-lian-di-ku-zu-guan-li/4-tian-jia-ren-yuan-dao-fen-zu-SophonFogSysapiGroupUsers（PUT）.md)
        - [从分组删除人员/SophonFogSys/api/GroupUsers（DELETE）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.2-ren-lian-di-ku-zu-guan-li/5-cong-fen-zu-shan-chu-ren-yuan-SophonFogSysapiGroupUsers（DELETE）.md)
        - [更新分组SophonFogSysapigroups（PUT）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.2-ren-lian-di-ku-zu-guan-li/6-gen-xin-fen-zu-SophonFogSysapigroups（PUT）.md)
      - [4.3 人员管理](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.3-ren-yuan-guan-li/README.md)
        - [创建人员SophonFogSys/api/users（POST）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.3-ren-yuan-guan-li/1-chuang-jian-ren-yuan-SophonFogSysapiusers（POST）.md)
        - [查询人员/SophonFogSys/api/users（GET）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.3-ren-yuan-guan-li/2-cha-xun-ren-yuan-SophonFogSysapiusers（GET）.md)
        - [更新人员/SophonFogSys/api/users（PUT）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.3-ren-yuan-guan-li/3-geng-xin-ren-yuan-SophonFogSysapiusers（PUT）.md)
        - [删除人员/SophonFogSys/api/users（DELETE）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.3-ren-yuan-guan-li/4-shan-chu-ren-yuan-SophonFogSysapiusers（DELETE）.md)
      - [4.4 事件管理](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/README.md)
        - [设置事件反馈模式/SophonFogSys/api/GateControllerMode（POST）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/1-she-zhi-shi-jian-fan-kui-mo-shi-SophonFogSysapiGateControllerMode（POST）.md)
        - [获取事件反馈模式/SophonFogSys/api/GateControllerMode（GET）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/2-huo-qu-shi-jian-fan-kui-mo-shi-SophonFogSysapiGateControllerMode（GET）.md)
        - [请求小盒子响应事件/SophonFogSys/api/EventAction（PUT）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/3-qing-qiu-xiao-he-zi-xiang-ying-shi-jian-SophonFogSysapiEventAction（PUT）.md)
        - [配置/修改实时事件上报接收服务器地址/SophonFogSys/api/EventServerUrl（POST）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/4-pei-zhi-xiu-gai-shi-shi-shi-jian-shang-bao-jie-shou-fu-wu-qi-di-zhi-SophonFogSysapiEventServerUrl（POST）.md)
        - [获取实时事件上报接收服务器地址/SophonFogSys/api/EventServerUrl（GET）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/5-huo-qu-shi-shi-shi-jian-shang-bao-jie-shou-fu-wu-qi-di-zhi-SophonFogSysapiEventServerUrl（GET）.md)
        - [实时上报事件具体内容（p0）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/6-shi-shi-shang-bao-shi-jian-ju-ti-nei-rong（p0）.md)
        - [配置/修改历史事件上报接收服务器地址/SophonFogSys/api/HistoryEventUrl](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/7-pei-zhi-xiu-gai-li-shi-shi-jian-shang-bao-jie-shou-fu-wu-qi-di-zhi-SophonFogSysapiHistoryEventUrl.md)
        - [获取历史事件上报接收服务器地址/SophonFogSys/api/HistoryEventUrl（GET）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/8-huo-qu-li-shi-shi-jian-shang-bao-jie-shou-fu-wu-qi-di-zhi-SophonFogSysapiHistoryEventUrl（GET）.md)
        - [异步上报事件具体内容](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.4-shi-jian-guan-li/9-yi-bu-shang-bao-shi-jian-ju-ti-nei-rong.md)
      - [4.5 雾端状态管理](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.5-wu-duan-zhuan-tai-guan-li/README.md)
        - [配置/修改状态上报接收服务器地址/SophonFogSys/api/MonitorServerUrl（POST）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.5-wu-duan-zhuan-tai-guan-li/1-pei-zhi-xiu-gai-zhuan-tai-shang-bao-jie-shou-fu-wu-qi-di-zhi-SophonFogSysapiMonitorServerUrl（POST）.md)
        - [获取状态上报接收服务器地址/SophonFogSys/api/MonitorServerUrl（GET）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.5-wu-duan-zhuan-tai-guan-li/2-huo-qu-zhuan-tai-shang-bao-jie-shou-fu-wu-qi-di-zhi-SophonFogSysapiMonitorServerUrl（GET）.md)
        - [主动上报雾端状态](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.5-wu-duan-zhuan-tai-guan-li/3-zhu-dong-shang-bao-wu-duan-zhuan-tai.md)
        - [清空数据/SophonFogSys/api/WipeData（POST）](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/4-jie-kou-API-xiang-xi-shuo-ming/4.5-wu-duan-zhuan-tai-guan-li/4-qing-kong-shu-ju-SophonFogSysapiWipeData（POST）.md)
    - [其它](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/qita/README.md)
      - [SE3盒子迷你机管理](zh/V2R2C01/api-lie-biao/2.sophon-ren-lian-shi-bie-wu-ji-suan-xi-tong-kai-fa-wen-dang/qita/1-li-shi-ban-ben-xin-xi.md)
  
  - 抓拍机设备
  
    - [API概述](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/API-gai-shu.md)
  
    - [GrabBasicInfoAPI [GET]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabBasicInfoAPI.md)
  
    - [GrabOnlineListAPI [GET]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabBasicInfoAPI-get.md)
  
    - [GrabOnlineListAPI [DELETE]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabOnlineListAPI-delete.md)
  
    - [GrabWhiteIpListAPI [POST]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabWhiteIpListAPI-POST.md)
  
    - [GrabWhiteIpListAPI [GET]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabWhiteIpListAPI-POST.md)
  
    - [GrabWhiteIpListAPI [DELETE]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabWhiteIpListAPI-DELETE.md)
  
    - [GrabInfoAPI  [GET]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabInfoAPI-GET.md)
  
    - [GrabInfoAPI [PUT] ](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabInfoAPI-PUT.md)
  
    - [GrabRealDataAPI [GET]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabRealDataAPI-GET.md)
  
    - [GrabLiveListAPI [POST]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabLiveListAPI-POST.md)
  
    - 
    - [GrabLiveListAPI [GET]](zh/V2R2C01/api-lie-biao/zhua-pai-ji-she-bei/GrabLiveListAPI-GET.md)
  
  - IPC设备
  
    - [API概述](zh/V2R2C01/api-lie-biao/ipc-she-bei/api-gai-shu.md)
  
    - [AddVideoDevice [POST]](zh/V2R2C01/api-lie-biao/ipc-she-bei/AddVideoDevice-POST.md)
  
    - [RemoveVideoDevice [POST]](zh/V2R2C01/api-lie-biao/ipc-she-bei/RemoveVideoDevice-POST.md)
  
    - [EditVideoDevice [POST]](zh/V2R2C01/api-lie-biao/ipc-she-bei/EditVideoDevice-POST.md)
  
    - [AddVideoDevice2 [POST]](zh/V2R2C01/api-lie-biao/ipc-she-bei/AddVideoDevice2-POST.md)
  
  - 高级系统配置(WebUI）
  
    - [API概述](zh/V2R2C01/api-lie-biao/webui/api-gai-shu.md)
  
    - [Getcpuusageapi [GET]](zh/V2R2C01/api-lie-biao/webui/Getcpuusageapi-GET.md)
  
    - [Getnpuusageapi [GET]](zh/V2R2C01/api-lie-biao/webui/Getnpuusageapi-GET.md)
  
    - [Gettemperatureapi [GET]](zh/V2R2C01/api-lie-biao/webui/Gettemperatureapi-GET.md)
  
    - [Getboxipapi [GET]](zh/V2R2C01/api-lie-biao/webui/Getboxipapi-GET.md)
  
    - [Setboxipapi [POST]](zh/V2R2C01/api-lie-biao/webui/Setboxipapi-POST.md)
  
    - [Getboxhostnameapi [GET]](zh/V2R2C01/api-lie-biao/webui/Getboxhostnameapi-GET.md)
  
    - [Setboxhostnameapi [POST]](zh/V2R2C01/api-lie-biao/webui/Setboxhostnameapi-POST.md)
  
    - [Getipstatus [GET]](zh/V2R2C01/api-lie-biao/webui/Getipstatus-GET.md)
  
    - [CopydatatoSDcard [POST]](zh/V2R2C01/api-lie-biao/webui/CopydatatoSDcard-POST.md)
  
    - [Getdevicetype [GET] (C04)](zh/V2R2C01/api-lie-biao/webui/Getdevicetype-GET-C04.md)
  
    - [Getotasoftwareversion [GET] (C04)](zh/V2R2C01/api-lie-biao/webui/Getotasoftwareversion-GET-C04.md)
  
    - [Getotatype [GET] (C04)](zh/V2R2C01/api-lie-biao/webui/Getotatype-GET-C04.md)
  
    - [Setotatype [POST] (C04)](zh/V2R2C01/api-lie-biao/webui/Setotatype-POST-C04.md)
  
    - [Getprivateotaurl [GET] (C04)](zh/V2R2C01/api-lie-biao/webui/Getprivateotaurl-GET-C04.md)
  
    - [Setprivateotaurl [POST] (C04)](zh/V2R2C01/api-lie-biao/webui/Setprivateotaurl-POST-C04.md)
  
    - [Postotaupdate [POST] (C04)](zh/V2R2C01/api-lie-biao/webui/Postotaupdate-POST-C04.md)
  
    - [LocalUpdate [POST] (C04)](zh/V2R2C01/api-lie-biao/webui/LocalUpdate-POST-C04.md)
  
    - [publicOtaUrl [POST] (C04)](zh/V2R2C01/api-lie-biao/webui/publicOtaUrl-POST-C04.md)
  
    - [DeviceSN [POST] (C04)](zh/V2R2C01/api-lie-biao/webui/DeviceSN-POST-C04.md)
  
    - [Setboxtimeapi [POST] (C04)](zh/V2R2C01/api-lie-biao/webui/Setboxtimeapi-POST-C04.md)
  
    - [GetboxSystemtimeapi [Get] (C04)](zh/V2R2C01/api-lie-biao/webui/GetboxSystemtimeapi-Get-C04.md)
  
    - [GetboxSystemUptimeapi [Get]](zh/V2R2C01/api-lie-biao/webui/GetboxSystemUptimeapi-Get.md)
  
    - [GetboxFanSpeedapi [Get]](zh/V2R2C01/api-lie-biao/webui/GetboxFanSpeedapiGet.md)
  
    - [GetSystemMode[Get]](zh/V2R2C01/api-lie-biao/webui/GetSystemMode-Get.md)
  
    - [SetSystemMode[Post]](zh/V2R2C01/api-lie-biao/webui/SetSystemMode-Post.md)
  
  

