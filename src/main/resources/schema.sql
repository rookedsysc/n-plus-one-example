-- Member 테이블 생성
CREATE TABLE IF NOT EXISTS test.member (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    passwd VARCHAR(255) NOT NULL
);

-- Post 테이블 생성
CREATE TABLE IF NOT EXISTS test.post (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(255) NOT NULL,
    member_id BIGINT NOT NULL,
    FOREIGN KEY (member_id) REFERENCES test.member(id),
    INDEX idx_member_id (member_id)
);

-- Comment 테이블 생성
CREATE TABLE IF NOT EXISTS test.comment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    author VARCHAR(255) NOT NULL,
    post_id BIGINT NOT NULL,
    FOREIGN KEY (post_id) REFERENCES test.post(id),
    INDEX idx_post_id (post_id)
);

