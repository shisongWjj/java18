### 数据加解密包`mybatis-encrypt`

```xml
<dependency>
    <groupId>com.autoyol</groupId>
    <artifactId>mybatis-encrypt</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

加解密工具类：`com.autoyol.mybatis.encrypt.util.EncryptUtil`

#### 一、使用`typeHandler`方式

将`com.autoyol.mybatis.encrypt.type.EncryptTypeHandler` 注入进`mybatis`，并注册为别名`encrypt`

```properties
mybatis.type-aliases-package=com.autoyol.mybatis.encrypt.alias
mybatis.type-handlers-package=com.autoyol.mybatis.encrypt.type
```

在`sql mapper` 的`SQL`中声明使用`javaType=encrypt`

```xml
<resultMap id="BaseResultMap" type="xxx">
    ...
    <result column="mobile" javaType="encrypt" property="mobile"/>
    ...
</resultMap>
```

或者

```xml
<update id="updateMobile">
    update t_user set mobile = #{mobile,javaType=encrypt} where id = #{id}
</update>	
```

#### 二、使用`mybatis plugin`方式，根据注解加解密

将`com.autoyol.mybatis.encrypt.intercept.ParameterEncryptInterceptor` 和 `com.autoyol.mybatis.encrypt.intercept.ResultDecryptSetInterceptor` 加载进容器

```java
   /**
     * 参数加密插件
     */
    @Bean
    public Interceptor parameterEncryptInterceptor() {
        return new ParameterEncryptInterceptor();
    }

    /**
     * 返回值解密插件
     */
    @Bean
    public Interceptor resultDecryptSetInterceptor() {
        return new ResultDecryptSetInterceptor();
    }
```

在入参或返回值DTO中需要加解密的字段上使用注解`@EncryptField`

```java
@Data
public class TUser implements Serializable {
    
    /**
     * 电话
     */
    @EncryptField
    private String mobile;

}
```

`sql mapper`正常使用

```xml
   <select id="queryOne" resultType="com.xxx.TUser">
        select id,mobile from t_user where id = #{id}
    </select>
```

#### 三、暂不支持的方式

不支持其他类型，只支持String的加解密;  
​不支持使用${};  
​不支持返回单个字段值。 如：`String selectMobile(Integer id);`;  
