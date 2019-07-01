package com.ss.spring.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * Standalone XML application context, taking the context definition files
 * from the class path, interpreting plain paths as class path resource names
 * that include the package path (e.g. "mypackage/myresource.txt"). Useful for
 * test harnesses as well as for application contexts embedded within JARs.
 *
 * <p>The config location defaults can be overridden via {@link #getConfigLocations},
 * Config locations can either denote concrete files like "/myfiles/context.xml"
 * or Ant-style patterns like "/myfiles/*-context.xml" (see the
 * {@link org.springframework.util.AntPathMatcher} javadoc for pattern details).
 *
 * <p>Note: In case of multiple config locations, later bean definitions will
 * override ones defined in earlier loaded files. This can be leveraged to
 * deliberately override certain bean definitions via an extra XML file.
 *
 * <p><b>This is a simple, one-stop shop convenience ApplicationContext.
 * Consider using the {@link GenericApplicationContext} class in combination
 * with an {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}
 * for more flexible context setup.</b>
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see #getResource
 * @see #getResourceByPath
 * @see GenericApplicationContext
 */

/**
 * ClassPathXmlApplicationContext
 *
 * @author shisong
 * @date 2019/7/1
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    @Nullable
    private Resource[] configResources;


    /**
     * Create a new ClassPathXmlApplicationContext for bean-style configuration.
     * @see #setConfigLocation
     * @see #setConfigLocations
     * @see #afterPropertiesSet()
     */
    public ClassPathXmlApplicationContext() {
    }

    /**
     * Create a new ClassPathXmlApplicationContext for bean-style configuration.
     * @param parent the parent context
     * @see #setConfigLocation
     * @see #setConfigLocations
     * @see #afterPropertiesSet()
     */
    public ClassPathXmlApplicationContext(ApplicationContext parent) {
        super(parent);
    }

    /**
     * Create a new ClassPathXmlApplicationContext, loading the definitions
     * from the given XML file and automatically refreshing the context.
     * @param configLocation resource location
     * @throws BeansException if context creation failed
     */
    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[] {configLocation}, true, null);
    }

    /**
     * Create a new ClassPathXmlApplicationContext, loading the definitions
     * from the given XML files and automatically refreshing the context.
     * @param configLocations array of resource locations
     * @throws BeansException if context creation failed
     */
    public ClassPathXmlApplicationContext(String... configLocations) throws BeansException {
        this(configLocations, true, null);
    }

    /**
     * Create a new ClassPathXmlApplicationContext with the given parent,
     * loading the definitions from the given XML files and automatically
     * refreshing the context.
     * @param configLocations array of resource locations
     * @param parent the parent context
     * @throws BeansException if context creation failed
     */
    public ClassPathXmlApplicationContext(String[] configLocations, @Nullable ApplicationContext parent)
            throws BeansException {

        this(configLocations, true, parent);
    }

    /**
     * Create a new ClassPathXmlApplicationContext, loading the definitions
     * from the given XML files.
     * @param configLocations array of resource locations
     * @param refresh whether to automatically refresh the context,
     * loading all bean definitions and creating all singletons.
     * Alternatively, call refresh manually after further configuring the context.
     * @throws BeansException if context creation failed
     * @see #refresh()
     */
    public ClassPathXmlApplicationContext(String[] configLocations, boolean refresh) throws BeansException {
        this(configLocations, refresh, null);
    }

    /**
     * Create a new ClassPathXmlApplicationContext with the given parent,
     * loading the definitions from the given XML files.
     * @param configLocations array of resource locations
     * @param refresh whether to automatically refresh the context,
     * loading all bean definitions and creating all singletons.
     * Alternatively, call refresh manually after further configuring the context.
     * @param parent the parent context
     * @throws BeansException if context creation failed
     * @see #refresh()
     */
    public ClassPathXmlApplicationContext(
            String[] configLocations, boolean refresh, @Nullable ApplicationContext parent)
            throws BeansException {
        //调用父类的构造方法
        super(parent);
        //设置此应用程序上下文的配置位置。如果没有设置，则实现可能使用适当的缺省值。
        setConfigLocations(configLocations);
        if (refresh) {
            //加载或刷新配置的持久表示，配置可以是XML文件、属性文件或关系数据库模式。由于这是一种启动方法，如果失败，它应该销毁已经创建的单例，以避免挂起资源。换句话说，在调用该方法之后，应该实例化所有或根本不实例化单例。
            refresh();
        }
    }


    /**
     * Create a new ClassPathXmlApplicationContext, loading the definitions
     * from the given XML file and automatically refreshing the context.
     * <p>This is a convenience method to load class path resources relative to a
     * given Class. For full flexibility, consider using a GenericApplicationContext
     * with an XmlBeanDefinitionReader and a ClassPathResource argument.
     * @param path relative (or absolute) path within the class path
     * @param clazz the class to load resources with (basis for the given paths)
     * @throws BeansException if context creation failed
     * @see org.springframework.core.io.ClassPathResource#ClassPathResource(String, Class)
     * @see org.springframework.context.support.GenericApplicationContext
     * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader
     */
    public ClassPathXmlApplicationContext(String path, Class<?> clazz) throws BeansException {
        this(new String[] {path}, clazz);
    }

    /**
     * Create a new ClassPathXmlApplicationContext, loading the definitions
     * from the given XML files and automatically refreshing the context.
     * @param paths array of relative (or absolute) paths within the class path
     * @param clazz the class to load resources with (basis for the given paths)
     * @throws BeansException if context creation failed
     * @see org.springframework.core.io.ClassPathResource#ClassPathResource(String, Class)
     * @see org.springframework.context.support.GenericApplicationContext
     * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader
     */
    public ClassPathXmlApplicationContext(String[] paths, Class<?> clazz) throws BeansException {
        this(paths, clazz, null);
    }

    /**
     * Create a new ClassPathXmlApplicationContext with the given parent,
     * loading the definitions from the given XML files and automatically
     * refreshing the context.
     * @param paths array of relative (or absolute) paths within the class path
     * @param clazz the class to load resources with (basis for the given paths)
     * @param parent the parent context
     * @throws BeansException if context creation failed
     * @see org.springframework.core.io.ClassPathResource#ClassPathResource(String, Class)
     * @see org.springframework.context.support.GenericApplicationContext
     * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader
     */
    public ClassPathXmlApplicationContext(String[] paths, Class<?> clazz, @Nullable ApplicationContext parent)
            throws BeansException {

        super(parent);
        Assert.notNull(paths, "Path array must not be null");
        Assert.notNull(clazz, "Class argument must not be null");
        this.configResources = new Resource[paths.length];
        for (int i = 0; i < paths.length; i++) {
            this.configResources[i] = new ClassPathResource(paths[i], clazz);
        }
        refresh();
    }


    @Override
    @Nullable
    protected Resource[] getConfigResources() {
        return this.configResources;
    }

}

