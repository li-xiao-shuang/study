## 什么是java spi？

![preview](https://pic2.zhimg.com/v2-e755e1d56a1bc819f7a1b02a6bda5d81_r.jpg)

SPI的英文名称是Service Provider Interface，是Java 内置的服务发现机制。可以做到动态的扩展实现类，避免在实现类在项目中硬编码的方式。

在开发过程中，将问题进抽象成API，可以为API提供各种实现。如果现在需要对API提供一种新的实现，我们可以不用修改原来的代码，直接生成新的Jar包，在包里提供API的新实现。通过Java的SPI机制，可以实现了框架的动态扩展，让第三方的实现能像插件一样嵌入到系统中。

## java spi 怎么使用？

- 创建META-INF/services目录

- 定义接口，例如: SearchDemo

- 在services目录下创建以接口全限定名命名的文件，例如:

  ![iShot2020-11-25 00.16.21](https://tva1.sinaimg.cn/large/0081Kckwly1gl0pxomfqqj30j806gaa8.jpg)

- 创建接口实现类 MySqlSearch 、RedisSearch 对应实现不同的接口逻辑

- 在com.lxs.study.biz.SearchDemo中添加两个实现类接口的全限定类名

  ![](https://tva1.sinaimg.cn/large/0081Kckwly1gl0q1l8gw5j30mc05cq3e.jpg)

- 通过java.util.ServiceLoader#load(java.lang.Class<S>)加载并返回所有的实现类实例

