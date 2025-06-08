# 留言板管理系统

这是一个基于Spring Boot开发的简单留言板管理系统，让用户可以发布留言、查看留言，并进行基本的留言管理。

## 🌟 功能特点

- 用户留言发布
- 留言列表展示
- 留言管理（编辑、删除）
- 简洁美观的用户界面
- 响应式设计，支持移动端访问

## 🛠️ 技术栈

- 后端：Spring Boot
- 数据库：MySQL
- 前端：HTML, CSS, JavaScript
- 项目管理：Maven

## 📋 系统要求

- JDK 17 或更高版本
- Maven 3.6 或更高版本
- MySQL 8.0 或更高版本

## 🚀 如何运行

1. 克隆项目到本地
```bash
git clone [项目地址]
```

2. 配置数据库
- 创建MySQL数据库
- 修改 `application.properties`以及`application.yml`中的数据库配置

3. 运行项目
```bash
mvn spring-boot:run
```

4. 访问系统
- 打开浏览器
- 访问 `http://localhost:8082`

## 📦 打包部署

1. 打包成JAR文件
```bash
mvn clean package
```
执行完成后，会在 `target` 目录下生成 `messageboard-0.0.1-SNAPSHOT.jar` 文件

2. 运行JAR包
```bash
java -jar target/messageboard-0.0.1-SNAPSHOT.jar
```

3. 后台运行（Linux环境）
```bash
nohup java -jar target/messageboard-0.0.1-SNAPSHOT.jar > messageboard.log 2>&1 &
```

## 📝 使用说明

1. 发布留言
   - 点击"发布留言"按钮
   - 填写留言内容
   - 点击提交

2. 查看留言
   - 在首页可以看到所有留言列表
   - 可以按时间顺序查看留言

3. 管理留言
   - 登录管理员账号admin 密码123456(唯一账号)
   - 可以对留言进行编辑或删除操作

## 👥 联系方式

3387982883@qq.com

---

