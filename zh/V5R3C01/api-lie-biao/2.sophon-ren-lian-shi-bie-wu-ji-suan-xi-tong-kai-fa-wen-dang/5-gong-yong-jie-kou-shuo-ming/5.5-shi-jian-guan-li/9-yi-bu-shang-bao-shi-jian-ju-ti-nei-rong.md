# 异步上报事件具体内容

**功能描述**

上报所有事件（数据库保存所有Event字段）给云平台。需要和监控服务器约定url，假设/EventServer/api/HistoryEvent

**调用URL**

调用方法: POST

**参数描述（JSON格式）：**

| **index** | **一级参数**  | **二级参数**   | 三级参数 | 类型   | **选择** | **说明**                                                     |  举例                    |
| --------- | ------------- | -------------- | ------ | -------- | ------------------------------------------------------------ | ----------------------------------------------------- | --------- |
| 1         | identity_id   |                |                | string | **必选** | 用户编号                                                     | "13435454"                                            |
| 2         | identity_name |                |                | string | **必选** | 用户名称                                                     | "Tom"                                                 |
| 3         | group_name    |                |                | string | **必选** | 比对的group name，如果没有group_name返回group_id             | "default_group"                                       |
| 4         | reg_pic       |                |                | base64 | 可选     | 注册的人脸底库，可配置去除                                   |                                                       |
| 5         | timestamp     |                |                | int32  | **必选** | 事件发生的时间戳                                             | 1565771454932                                         |
| 6         | score         |                |                | float  | **必选** | 比对的分数                                                   | 0.23                                                  |
| 7 | want_action | | | string | **必选** | 根据该字段判断需要进行的操作： ”0“：默认值， 不进行额外操作。 ”1001“：新的陌生人注册。 ”1002“：人脸注册底库更新。 | ”0“ |
| 8       | ext_data      |                |                | dict   | **必选** | 拓展数据字段，可迭代添加                                     |                                                       |
|           |               | device_ip      |       | string | **必选** | 设备ip                                                       | "192.168.1.101"                                       |
|           |               | ep_id          |           | string | **必选** | 边缘节点ID，是指SE3 AI迷你机连接的采集设备的ID。<br />ID：dev_sno和IP的组合，用双下划线做连接。举例：AKOPKKKKK__192.168.1.25 | "3714be15-09b3-41ec-b9ce-62b668e5fa32__192.168.1.101" |
|           |               | spot_pic       |        | base64 | 可选 | 现场照片                                   |                                                       |
| | | ir_pic | | base64 | 可选 | 每张人脸的红外照片 | |
| | | recognize_face |  | base | 可选 | 背景图中的每张人脸图 | |
|           |               | person_type    |     | int    | **必选** | 1:员工（默认为员工，包括这个字段不存在的情况）<br />2: 访客<br />3: 黑名单<br />4：陌生人<br />5：VIP | 1                                                     |
|           |               | device_type    |     | string | **必选** | 0：闸机，<br />1：抓拍机 <br />3：IPC 动态 <br />4：门禁 | 0                                                     |
|           |               | dev_sno        |         | string | **必选** | SE3 AI迷你机唯一标识授权码                                   |                                                       |
| | | info           |          | dict   | **可选** | 上传人脸属性等                                               | {}                                                           |
| | |                | age      | string | **可选** | 年龄,  child / juvenile / youth / middle-aged /aged          | 0   <   age < 6:   儿童，child<br />6 <=  age < 18 : 少年，juvenile****<br />18 <= age < 40: 青年，youth<br /><br />40 <= age < 65: 中年，middle-aged<br /><br />65 <= age       :  老年，aged**** |
| | |                | gender   | string | **可选** | male/female | |
| | |                | glasses  | string | **可选** | yes/no | |
| | | | feature | list | **可选** | 提取的人脸特征值数组 | |
| | | | box | list | **可选** | 人脸的box | |



**返回信息：**

```json
{
	'score': 0.16, 
	'reg_pic': '', 
	'group_name': 'default_group', 
	'identity_id': '13028', 
	'identity_name': 'stranger', 
    "want_action":"0",
	'timestamp': 1560408984678, 
	'ext_data': {
			'device_type': '1',
			'spot_pic': 'xxxxx',
        	'ir_pic':"xxxx",
        	'recognize_face':"XXXXX",
        	'info':{
                "age":"child",
                "gender":"male",
                "glasses":"no",
                "box":[],
                "feature":[]
            },
			'person_type': 1,   //通过此处的人员类型来判断是否是陌生人，如果是person_type为4， 则是陌生人，且fiqa_result为False，则说明陌生人的图片质量不是很好，不能进行再次下发注册
			 'device_ip': '192.168.1.151'}
}
```

**示例：**

可以使用小盒子附带的server来获取上传的事件。

假设小盒子的ip为：192.168.1.19，接收的resetful api为HistoryEvent ，端口号为9528。

那webui或是配置/修改历史事件上报接收服务器地址信息为：[http://192.168.1.19:9528/HistoryEvent](http://192.168.1.19:9528/RealTimeEvent)

启动server方法：

```shell
$ sudo -i
\# cd /system/data/sophon_gate/script
\# python3 Event_Receive_server.py
* Serving Flask app "Event_Receive_server" (lazy loading)
* Environment: production
WARNING: Do not use the development server in a production environment.
Use a production WSGI server instead.
* Debug mode: off
* Running on http://0.0.0.0:9528/ (Press CTRL+C to quit)
```

