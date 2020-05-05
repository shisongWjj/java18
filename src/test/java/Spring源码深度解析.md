## XmlBeanFactory
    继承于DefaultListableBeanFactory，并使用XmlBeanDefinitionReader来加载配置文件并进行bean注册。
    与DefaultListableBeanFactory区别在于XmlBeanFactory实现了个性化的解析（xml解析）

### 1.DefaultListableBeanFactory所对应的继承/实现的所有类
#### AliasRegistry 
    定义了对alias的简单增删改等操作
#### SimpleAliasRegistry
    主要使用map对alias进行缓存，并对AliasRegistry接口进行实现
#### SingletonBeanRegistry
    定义对单例的注册及获取
#### BeanFactory
    定义获取bean以及bean的各种特性
#### DefaultSingletonBeanRegistry
    对接口SingletonBeanRegistry的实现
#### HierarchicalBeanFactory
    继承BeanFactory，也就是在BeanFactory定义的功能的基础上增加了对parentFactory的支持
#### BeanDefinitionRegistry
    定义对BeanDefinition的各种增删改操作
#### FactoryBeanRegistrySupport
    在DefaultSingletonBeanRegistry的基础上，增加了对BeanFactory的特殊处理功能
#### ConfigurableBeanFactory
    提供配置Factory的各种方法
#### ListableBeanFactory
#### AbstractBeanFactory
#### AutowireCapableBeanFactory
#### AbstractAutowireCapableBeanFactory
#### ConfigurableListableBeanFactory
#### DefaultListableBeanFactory

### 2.XmlBeanDefinitionReader