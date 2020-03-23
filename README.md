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