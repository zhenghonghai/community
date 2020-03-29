# git命令
- git init  初始化仓库
- git status    查看状态
- git add .     添加所有修改的文件
- git commit -m "描述信息"  提交文件的描述
- git log   查看提交历史记录
- git remote add origin https://github.com/zhenghonghai/community.git
本地和远程仓库关联
- git push -u origin master     将本地代码提交到远程仓库
- git commit --amend --no-edit  (1参数)追加文件， （2参数）不用修改提交描述，还是原来的
- git config credential.helper store   在本地生成一个文本，上边记录账号和密码,不用每次提交都需要输入账号密码



# 导入bootstrap
1. 下载jar包解压并将目录复制到static目录下
2. 在html页面导入相应的文件
```html
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js" type="application/javascript"></script>
```
3. 组件的使用可以查考网址：[bootstrap组件](https://v3.bootcss.com/components/#navbar)

# 抽离变量
1. 在application.properties文件下key-value的形式保存变量，在相应的文件中通过@Value("${key}")获取变量的值；

# mysql
- 注意驱动问题

1 导入依赖
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```
2 在application.properties中添加配置 
```text
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/community?useUnicode=true&&useSSL=false&&characterEncoding=UTF-8&&serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=1234
```

# mybatis
1 导入依赖
```xml
<dependency>
   <groupId>org.mybatis.spring.boot</groupId>
   <artifactId>mybatis-spring-boot-starter</artifactId>
   <version>2.1.2</version>
</dependency>
```
2 在接口上添加注解@Mapper
```java
@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
```

3 运行命令
```bash
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

```
4 添加mybatis插件
```java
<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.4.0</version>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>
    </dependencies>
</plugin>
```
5 在resources目录下创建xml配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
<!--    <classPathEntry location="/Program Files/IBM/SQLLIB/java/db2java.zip" />-->

    <context id="DB2Tables" targetRuntime="MyBatis3">
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/community?useUnicode=true&amp;useSSL=false&amp;characterEncoding=UTF-8&amp;serverTimezone=GMT%2B8"
                        userId="root"
                        password="1234">
            <property name="nullCatalogMeansCurrent" value="true"/>
        </jdbcConnection>

        <javaTypeResolver >
            <property name="forceBigDecimals" value="false" />
        </javaTypeResolver>

        <javaModelGenerator targetPackage="com.redsea.community.model" targetProject="src\main\java">
            <property name="enableSubPackages" value="true" />
            <property name="trimStrings" value="true" />
        </javaModelGenerator>

        <sqlMapGenerator targetPackage="mapper"  targetProject="src\main\resources">
            <property name="enableSubPackages" value="true" />
        </sqlMapGenerator>

        <javaClientGenerator type="XMLMAPPER" targetPackage="com.redsea.community.mapper"  targetProject="src\main\java">
            <property name="enableSubPackages" value="true" />
        </javaClientGenerator>

        <table tableName="user" domainObjectName="User" >
<!--            <property name="useActualColumnNames" value="true"/>-->
<!--            <generatedKey column="ID" sqlStatement="DB2" identity="true" />-->
<!--            <columnOverride column="DATE_FIELD" property="startDate" />-->
<!--            <ignoreColumn column="FRED" />-->
<!--            <columnOverride column="LONG_VARCHAR_FIELD" jdbcType="VARCHAR" />-->
        </table>

    </context>
</generatorConfiguration>
```
6 扫描包

@MapperScan("包名")

7 在application.properties
```java
mybatis.type-aliases-package=com.redsea.community.mapper
mybatis.mapper-locations=classpath:mapper/*.xml
```

# flyway
作用：自动管理数据库版本

1.添加依赖
```java
<build>
    <plugins>
       ……
       <plugin>
           <groupId>org.flywaydb</groupId>
           <artifactId>flyway-maven-plugin</artifactId>
           <version>6.3.1</version>
           <configuration>
               <url>jdbc:mysql://localhost:3306/community?useUnicode=true&amp;useSSL=false&amp;characterEncoding=UTF-8&amp;serverTimezone=GMT%2B8</url>
               <user>root</user>
               <password>1234</password>
           </configuration>
           <dependencies>
               <dependency>
                   <groupId>mysql</groupId>
                   <artifactId>mysql-connector-java</artifactId>
                   <version>8.0.19</version>
               </dependency>
           </dependencies>
       </plugin>
    </plugins>
</build>
```
2.使用
```bash
mvn flyway:migrate
``` 

# lombok
1.添加依赖
```java
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.12</version>
    <scope>provided</scope>
</dependency>
```
2.使用
在实体类前加@Data即可

>注意事项: idea需要装Lombok的插件不然没法提示set和get方法。

# 热部署
1.依赖
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```
2.使用

必须自动编译
设置方法打开File->Settings ->Build ->Compiler ->Build project automatically

打开dubug的时候，修改代码保存后可以自动重启，主要用于调试前端代码
运行时若也要实现热部署可以按住ctrl+shift+alt+? 打开idea的配置
将compiler.automake.allow.when.app.running 的值改为true