# 设备上报信息的接口规范

SE3 AI 迷你机上每一次人员比对会产生一个比对事件，因为SE3 AI迷你机的存储空间有限。通常的架构设计是 SE3 AI 迷你机存储短期事件（默认1万条），并且把所有的事件上传到管理平台，由云平台做长期历史事件的存储及查询。

目前提供两种事件上报方式，分别适用于不同场景：

| **index** | **上报方式** | **上报内容**                     | **实现机制**                                                 | **实时性** | **可靠性**                           | **适用场景**                               |
| --------- | ------------ | -------------------------------- | ------------------------------------------------------------ | ---------- | ------------------------------------ | ------------------------------------------ |
| 1         | 实时上报     | 只上报比对分数大于阈值的比对事件 | 比对完成，并且分数大于阈值即开始上报                         | 高         | 低（不等待接收服务器的接收完成响应） | 比对型，如人脸识别迎宾，闸机门禁开门控制等 |
| 2         | 历史事件上报 | 上报所有的事件                   | 1 从历史事件数据库中查询未上传的事件进行批量上传； <br />2 上传完成后会记录当前游标，作为下次上传的起点； <br />3 上传的周期可配置的，默认为20s。周期可配置，需大于等于20s。 <br />4 每次上传的事件数目不大于100条。 | 低         | 高（会重试上传）                     | 记录型，如人脸识别考勤系统，客流统计系统等 |
