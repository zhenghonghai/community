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


# 导入bootstrap
1. 下载jar包解压并将目录复制到static目录下
2. 在html页面导入相应的文件
```html
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js" type="application/javascript"></script>
```
3. 组件的使用可以查考网址：https://v3.bootcss.com/components/#navbar