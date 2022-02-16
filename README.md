# hexagon架构特点
*  六边形架构主要实现业务与基础设施层相互独立
*  本代码结构适用于根据业务场景进行收缩和扩展
*  DDD 与 六边形架构没有关联关系, 可单独使用. 
      
#####传统架构问题: 
* 很容易跨越层间的边界，把业务逻辑渗透到其它层中去。
* 有的应用可能不止需要两个端口，所以不能用单维度架构来构建。
###模块说明:
            hexagon-bootstrap                                      启动类、配置文件、集成测试
            hexagon-facade                                         外观层, 对外提供所有的接口定义
            hexagon-domain                                         领域层, 处理主要的业务逻辑问题,如果逻辑复杂,可扩展子模块
            hexagon-application                                    应用层,体现对外功能实现. 判断当前功能性质: 执行不通的操作
            hexagon-common                                         工具类,枚举类,异常,跨模块通用对象.
            
            adaptor/hexagon-adaptor-rpc 
            adaptor/hexagon-adaptor-http 
            adaptor/hexagon-adaptor-consumer
                 **适配器层: 适配系统各种形式入口,可根据业务场景定制化**
                 
            infrastructure/hexagon-infrastructure-cache            缓存
            infrastructure/hexagon-infrastructure-producer         消息生产
            infrastructure/hexagon-infrastructure-repository       数据库
            infrastructure/hexagon-infrastructure-rpc              rpc
            infrastructure/hexagon-infrastructure-task             任务调度
                 **适配器层: 适配组件,可根据业务场景定制化**
# 模块依赖关系
*1. domain层与facade层不依赖其他层. (common除外)
*2. application层 依赖 domain,facade. 校验并判断,承上启下
*3. adaptor层实现facade接口. 
*4. infrastructure 依赖domain,application层 根据业务场景. 定制接口
*5. bootstrap 依赖所有模块提供启动能力     
# 数据类型分析
    

