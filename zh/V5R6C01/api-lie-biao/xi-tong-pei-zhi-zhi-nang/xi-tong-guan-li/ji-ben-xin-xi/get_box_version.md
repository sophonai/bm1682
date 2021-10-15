# 查询系统版本号 #

**功能描述**

获取SE主机系统版本。

**调用URL**

http://192.168.1.180:8888/SophonSystem/api/systemVersion

**调用方法**

GET

**请求示例：**

```json
请求url: http://192.168.1.180:8888/SophonSystem/api/systemVersion?
```

**返回信息：**

返回xml， repo manifeset



请求成功

| 一级参数 | 二级参数    |      | 类型   | 描述                                |
| :------- | :---------- | ---- | :----- | :---------------------------------- |
| data     |             |      | dict   |                                     |
|          | version     |      | string | 主机系统版本号。                    |
|          | mcu_version |      | string | mcu版本号                           |
|          | details     |      | string | 具体信息，内容为xml格式转成得字符串 |
|          |             |      |        |                                     |

请求成功示例：

```json
{
    "data": {
        "version": "V5R3C01_686e472",
        "mcu_version":"0x23",
        "details":"name:AI_SE/MooduleMoose path:algorithm/MooduleMoose revision:5e4c2097f501dedc0b279f5aa09ac61683f3061c upstream:master dest-branch:master groups:se5<br/>name:AI_SE/NPUVideo path:algorithm/NPUVideo revision:80c593ccb96a8531d7c9e054e28d19720faa7685 upstream:master dest-branch:master groups:se5<br/>name:AI_SE/SophonAlgoNN path:algorithm/SophonAlgoNN revision:26bedde154956df179067a21eacc02d78d2f9854 upstream:master dest-branch:master groups:se5<br/>name:AI_SE/SophonFaceSDK path:algorithm/SophonSDK revision:81041c3ccf9645fa65d7b89245ad6575011a62ff upstream:master dest-branch:master groups:se5<br/>name:AI_SE/SophonGate path:apps/gate_system revision:7385e481257c42442f88383b680ff2d5e5bafa47 upstream:master dest-branch:master groups:se5<br/>name:AI_SE/SophonHDMI path:apps/HDMI revision:7dfcb10a5b16cc923accb5fb52d21948280ed1ad upstream:master dest-branch:master groups:se5<br/>name:AI_SE/cross_compile_dep path:algorithm/cross_compile_dep revision:9af1e3b65253a9818e108e5d944e8a517a23ff19 upstream:master dest-branch:master groups:se5<br/>name:AI_SE/docker_images path:system/docker_images revision:da5d6546bacdc14961f5b65ff02c03ea0304b27c upstream:master dest-branch:master groups:se5<br/>name:AI_SE/gate_rootfs_extra path:system/rootfs revision:b6a13d5d098e59b790d1ee69bc388e023620332e upstream:master dest-branch:master groups:se5<br/>name:AI_SE/liteos path:web/edge/WebUI revision:72b3a47056f27b1647c62220876b1e9615d27a43 upstream:master dest-branch:master groups:se5<br/>name:AI_SE/prebuilds path:prebuilds revision:b3acd4eeb50b4feb576b28f7efe67ef89cb00294 upstream:master dest-branch:master groups:se5<br/>name:AI_SE/robot_gate path:tests/robot_gate revision:9b34472da5e18eee486de61aea9293cde3dd7088 upstream:master dest-branch:master groups:se5<br/>name:AI_SE/robotframework-se5library path:tests/robotframework-se5library revision:ea8fdb6ae71e92afa3fe5bac33368733519053f4 upstream:master dest-branch:master groups:se5<br/>name:AI_SE/root_project path:. revision:9b5ad13ec3195c6f9cf75fcc59a03a9720e2e8d9 upstream:master dest-branch:master groups:se5<br/>name:OTA_server path:build/scripts/OTA_server revision:c91c71bc81d6695a2c2848095cd3157600aa0064 upstream:OTA_SE5_dev dest-branch:OTA_SE5_dev groups:se5<br/>name:build path:build/scripts/bsp revision:b90968e0f9ccf410967734e52e7e949027148b4f upstream:master dest-branch:master groups:se5<br/>"
    }
}
```

请求失败

| 一级参数 | 二级参数 | 类型   | 描述       |
| :------- | :------- | :----- | :--------- |
| error    | code     | int    | 请求错误码 |
|          | message  | string | 错误描述   |
|          | status   | string | 错误类型   |

​    

