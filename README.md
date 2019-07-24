# shiro-demo
shiro

### 描述

### 过滤器执行流程


### 错误异常
1. 在自定义Realm中无法注入Service
- 问题原因：\
ShiroConfig在注入SecurityManager时setRealm()的参数ShiroRealm不能自己new出来，而要先将其注入Bean
- 解决方法：\
在ShiroConfig中将Realm的注入单独提取出来一个方法实现注入，然后再注入到SecurityManager中
2. Realm does not support authentication token
- 问题原因：\
每一个Realm都有一个supports方法，用于检测是否支持此Token
- 解决方法：\
在Realm中重写该方法，具体参考代码
