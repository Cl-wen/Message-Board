CREATE DATABASE IF NOT EXISTS springboot;
 USE springboot;
 
 CREATE TABLE message (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     content TEXT NOT NULL,
     author VARCHAR(255) NOT NULL,
     publish_date DATETIME DEFAULT CURRENT_TIMESTAMP
 );
 
 INSERT INTO message (content, author, publish_date) VALUES
 ('欢迎来到留言板系统！', '系统管理员', '2024-01-01 00:00:00'),
 ('这是一个示例留言', '系统管理员', '2024-01-01 00:00:00'),
 ('您可以在这里发布您的留言', '系统管理员', '2024-01-01 00:00:00'),
 ('感谢您的使用！', '系统管理员', '2024-01-01 00:00:00');
 
 -- 创建users表
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- 创建messages表
CREATE TABLE IF NOT EXISTS messages (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 插入管理员账号
INSERT INTO users (username, password, role)
SELECT 'admin', '123456', 'ROLE_ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'admin'); 