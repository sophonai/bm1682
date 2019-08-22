# AIBOX

- [版本](README.md)
- [V2.2.1](zh/V2R2C01_README.md)
  - [1. SE3 AI迷你机说明书](zh/V2R2C01/api-lie-biao/SE3-AI-Mini-ji-shuo-ming-shu/README.md)
  - [2. 系统配置指南](zh/V2R2C01/api-lie-biao/xi-tong-pei-zhi-zhi-nang/README.md)
    - [2.1 网络摄像机模式](zh/V2R2C01/api-lie-biao/xi-tong-pei-zhi-zhi-nang/wang-luo-she-xiang-ji-mo-shi/README.md)
    - [2.2 闸机模式](zh/V2R2C01/api-lie-biao/xi-tong-pei-zhi-zhi-nang/zha-ji-mo-shi/README.md)
    - [2.3 抓拍机模式](zh/V2R2C01/api-lie-biao/xi-tong-pei-zhi-zhi-nang/zhua-pai-ji-mo-shi/README.md)
  - [3. 系统对接](zh/V2R2C01/api-lie-biao/xi-tong-dui-jie-shuo-ming-shu/README.md)
    - [3.1 对接现有管理平台](zh/V2R2C01/api-lie-biao/xi-tong-dui-jie-shuo-ming-shu/dui-jie-guan-li-ping-tai/README.md)
    - [3.2 自建管理平台](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/README.md)
      - [3.2.1 系统架构设计](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/1.-ji-yu-rabbit-mq-de-duan-yun-xi-tong-jia-gou-she-ji.md)
      
      - [3.2.2 MQ接口流程说明](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/2.-mq-jie-kou-liu-cheng-shuo-ming/README.md)
        - [3.2.2.1 建立连接](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/2.-mq-jie-kou-liu-cheng-shuo-ming/2.1-jian-li-lian-jie.md)
        
        - [3.2.2.2 用户管理](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/2.-mq-jie-kou-liu-cheng-shuo-ming/2.2-yong-hu-guan-li.md)
        
      - [3.2.3 状态码详细说明](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/3.-zhuang-tai-ma-xiang-xi-shuo-ming.md)
      
      - [3.2.4 管理平台系统登录接口](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/4.-guan-li-ping-tai-xi-tong-deng-lu-jie-kou.md)
      
      - [3.2.5 MQ命令接口详细说明](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/5.-mq-ming-ling-jie-kou-xiang-xi-shuo-ming/README.md)
        - [3.2.5.1 用户管理MQ消息](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/5.-mq-ming-ling-jie-kou-xiang-xi-shuo-ming/5.1-yong-hu-guan-li-mq-xiao-xi/README.md)
          - [3.2.5.1.1 添加或更新用户（add\_users\_plus）](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/5.-mq-ming-ling-jie-kou-xiang-xi-shuo-ming/5.1-yong-hu-guan-li-mq-xiao-xi/5.1.1-tian-jia-huo-geng-xin-yong-hu-addusersplus.md)
          - [3.2.5.1.2 删除用户（delete\_users）](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/5.-mq-ming-ling-jie-kou-xiang-xi-shuo-ming/5.1-yong-hu-guan-li-mq-xiao-xi/5.1.2-shan-chu-yong-hu-deleteusers.md)
        - [3.2.5.2 设备数据清理MQ消息](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/5.-mq-ming-ling-jie-kou-xiang-xi-shuo-ming/5.2-she-bei-shu-ju-qing-li-mq-xiao-xi.md)
        - [3.2.5.3 人脸图片质量检测（FIQA）MQ消息](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/5.-mq-ming-ling-jie-kou-xiang-xi-shuo-ming/5.3-ren-lian-tu-pian-zhi-liang-jian-ce-fiqamq-xiao-xi.md)
        - [3.2.5.4 mq执行结果返回接口](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/5.-mq-ming-ling-jie-kou-xiang-xi-shuo-ming/5.4-mq-zhi-hang-jie-guo-fan-hui-jie-kou.md)
        
      - [3.2.6 向管理平台获取信息的接口定义](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/6.-xiang-guan-li-ping-tai-huo-qu-xin-xi-de-jie-kou-ding-yi/README.md)
        - [3.2.6.1 获取用户详细信息的接口](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/6.-xiang-guan-li-ping-tai-huo-qu-xin-xi-de-jie-kou-ding-yi/6.1-huo-qu-yong-hu-xiang-xi-xin-xi-de-jie-kou.md)
        
      - [3.2.7 设备上报信息的接口规范](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/7.-she-bei-shang-bao-xin-xi-de-jie-kou-gui-fan/README.md)
        - [3.2.7.1 实时事件上报内容](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/7.-she-bei-shang-bao-xin-xi-de-jie-kou-gui-fan/7.1-shi-shi-shi-jian-shang-bao-nei-rong.md)
        - [3.2.7.2 设备操作事件上报](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/7.-she-bei-shang-bao-xin-xi-de-jie-kou-gui-fan/7.2-she-bei-cao-zuo-shi-jian-shang-bao.md)
        
      - [3.2.8 云平台配置](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/8.-yun-ping-tai-pei-zhi/README.md)
        - [3.2.8.1 小盒子唯一授权标识字段](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/8.-yun-ping-tai-pei-zhi/8.1-xiao-he-zi-wei-yi-shou-quan-biao-shi-zi-duan/README.md)
          - [3.2.8.1.1 查询授权码/SophonMQ/api/DevSno（GET）](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/8.-yun-ping-tai-pei-zhi/8.1-xiao-he-zi-wei-yi-shou-quan-biao-shi-zi-duan/8.1.1-cha-xun-shou-quan-ma-sophonmqapidevsnoget.md)
          - [3.2.8.1.2 更新授权码/SophonMQ/api/DevSno（PUT）](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/8.-yun-ping-tai-pei-zhi/8.1-xiao-he-zi-wei-yi-shou-quan-biao-shi-zi-duan/8.1.2-geng-xin-shou-quan-ma-sophonmqapidevsnoput.md)
        - [3.2.8.2 管理平台访问是否需要先登录授权](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/8.-yun-ping-tai-pei-zhi/8.2-guan-li-ping-tai-fang-wen-shi-fou-xu-yao-xian-deng-lu-shou-quan/README.md)
          - [3.2.8.2.1 查询管理平台登录地址/SophonMQ/api/LoginUrl（GET）](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/8.-yun-ping-tai-pei-zhi/8.2-guan-li-ping-tai-fang-wen-shi-fou-xu-yao-xian-deng-lu-shou-quan/8.2.1-cha-xun-guan-li-ping-tai-deng-lu-di-zhi-sophonmqapiloginurlget.md)
          - [3.2.8.2.2 更新管理平台登录地址/SophonMQ/api/LoginUrl（PUT）](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/8.-yun-ping-tai-pei-zhi/8.2-guan-li-ping-tai-fang-wen-shi-fou-xu-yao-xian-deng-lu-shou-quan/8.2.2-geng-xin-guan-li-ping-tai-deng-lu-di-zhi-sophonmqapiloginurlput.md)
        
      - [3.2.9 URL组合](zh/V2R2C01/api-lie-biao/1.-ji-yu-rabbit-mq-de-duan-yun-dui-jie-shuo-ming/9.-url-zu-he.md)
    

