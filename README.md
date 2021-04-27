#  V5.2.1

| 文档版本   |            系统版本             |   说明   |
| :-------------: | :-----------------------------: | :------: |
| [V2.4.1](zh/V2R4C01_README.md) | V2R4C01 | AI迷你机SE3 |
| [V5.2.1](zh/V5R2C01_README.md) | V5R2C01 | AI计算盒SE5 |



## 1 性能参数

性能参数详见官网地址：

AI计算盒SE5官网地址：[https://sophon.cn/product/introduce/se5.html](https://sophon.cn/product/introduce/se5.html)

AI迷你机SE3官网地址：https://sophon.cn/product/introduce/se3.html

## 2 两种模式四种场景

### 2.1 Box模式

Box模式下，SE3/SE5只提供深度学习算力加速，使用灵活。

适用场景：合作伙伴自研算法（移植）和业务逻辑，完成整个系统开发。

注意：

1）出厂默认为Gate模式。

2）目前只提供Gate模式快速切换到Box模式的方法。从Box模式切回，需要使用TF Card进行升级。

3）如果需要切换到Box模式，请ssh 登录到盒子，执行如下命令：

- sudo -i
- sh /system/data/sophon_gate/env_setup/swtich2box.sh

### 2.2 Gate模式

Gate模式下，SE3/SE5主要提供设备管理，人脸识别算法，事件存储及上报等多种服务，使用简单。

适用场景：SE3/SE5通过人脸识别能力，合作伙伴专注业务逻辑。

系统环境配置，请参考[环境配置指南](zh/V5R2C01/api-lie-biao/xi-tong-pei-zhi-zhi-nang/README.md)。
