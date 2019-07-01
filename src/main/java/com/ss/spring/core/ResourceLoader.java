package com.ss.spring.core;

/**
 * ResourceLoader
 *
 * @author shisong
 * @date 2019/7/1
 */
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceEditor;
import org.springframework.lang.Nullable;
import org.springframework.util.ResourceUtils;

/**
 * Strategy interface for loading resources (e.. class path or file system
 * resources). An {@link org.springframework.context.ApplicationContext}
 * is required to provide this functionality, plus extended
 * {@link org.springframework.core.io.support.ResourcePatternResolver} support.
 *
 * <p>{@link DefaultResourceLoader} is a standalone implementation that is
 * usable outside an ApplicationContext, also used by {@link ResourceEditor}.
 *
 * <p>Bean properties of type Resource and Resource array can be populated
 * from Strings when running in an ApplicationContext, using the particular
 * context's resource loading strategy.
 *
 * 策略模式
 * 通过策略模式加载源文件
 * org.springframework.context.ApplicationContext这个类被要求提供这种功能（加载源文件），它使用了扩展类org.springframework.core.io.support.ResourcePatternResolver
 * DefaultResourceLoader是一个独立的实现，可以在ApplicationContext之外使用，也被ResourceEditor使用
 * 当在ApplicationContext中运行时，可以使用特定上下文的资源加载策略从字符串填充Resource类型和Resource数组的Bean属性。
 *
 * @author Juergen Hoeller
 * @since 10.03.2004
 * @see Resource
 * @see org.springframework.core.io.support.ResourcePatternResolver
 * @see org.springframework.context.ApplicationContext
 * @see org.springframework.context.ResourceLoaderAware
 */
public interface ResourceLoader {

    /** Pseudo URL prefix for loading from the class path: "classpath:" */
    /** 伪URL前缀，用于从类路径加载:“classpath:”*/
    String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;


    /**
     * Return a Resource handle for the specified resource location.
     * <p>The handle should always be a reusable resource descriptor,
     * allowing for multiple {@link Resource#getInputStream()} calls.
     * <p><ul>
     * <li>Must support fully qualified URLs, e.g. "file:C:/test.dat".
     * <li>Must support classpath pseudo-URLs, e.g. "classpath:test.dat".
     * <li>Should support relative file paths, e.g. "WEB-INF/test.dat".
     * (This will be implementation-specific, typically provided by an
     * ApplicationContext implementation.)
     * </ul>
     * <p>Note that a Resource handle does not imply an existing resource;
     * you need to invoke {@link Resource#exists} to check for existence.
     * @param location the resource location
     * @return a corresponding Resource handle (never {@code null})
     * @see #CLASSPATH_URL_PREFIX
     * @see Resource#exists()
     * @see Resource#getInputStream()
     */
    /** 返回指定资源位置的资源句柄*/
    Resource getResource(String location);

    /**
     * Expose the ClassLoader used by this ResourceLoader.
     * <p>Clients which need to access the ClassLoader directly can do so
     * in a uniform manner with the ResourceLoader, rather than relying
     * on the thread context ClassLoader.
     * @return the ClassLoader
     * @see org.springframework.util.ClassUtils#getDefaultClassLoader()
     */
    /**公开这个ResourceLoader使用的类加载器。需要直接访问类加载器的客户机可以使用ResourceLoader以统一的方式访问类加载器，而不是依赖于线程上下文类加载器。*/
    @Nullable
    ClassLoader getClassLoader();

}
