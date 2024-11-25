-- Member 데이터 생성
INSERT IGNORE INTO member (name, passwd) VALUES
    ('Member1', 'password1'),
    ('Member2', 'password2'),
    ('Member3', 'password3'),
    ('Member4', 'password4'),
    ('Member5', 'password5'),
    ('Member6', 'password6'),
    ('Member7', 'password7'),
    ('Member8', 'password8'),
    ('Member9', 'password9'),
    ('Member10', 'password10');

-- Post 데이터 생성 (각 멤버당 10개의 포스트)
INSERT IGNORE INTO post (title, content, author, member_id)
WITH RECURSIVE numbers AS (
    SELECT 1 as num, 1 as member
    UNION ALL
    SELECT
        CASE
            WHEN num = 10 THEN 1
            ELSE num + 1
        END,
        CASE
            WHEN num = 10 THEN member + 1
            ELSE member
        END
    FROM numbers
    WHERE member <= 10
)
SELECT
    CONCAT('Post ', member, '-', num, ' Title'),
    CONCAT('This is content for post ', member, '-', num, '. Lorem ipsum dolor sit amet.'),
    CONCAT('Member', member),
    member
FROM numbers;

-- Comment 데이터 생성 (각 포스트당 10개의 댓글)
INSERT INTO test.comment (content, author, post_id)
SELECT
    CONCAT('Comment ', n, ' for post ', p.id, ': Lorem ipsum dolor sit amet'),
    CONCAT('Commenter_', n, '_', p.author),
    p.id
FROM test.post p
CROSS JOIN (
    SELECT 1 AS n UNION ALL
    SELECT 2 UNION ALL
    SELECT 3 UNION ALL
    SELECT 4 UNION ALL
    SELECT 5 UNION ALL
    SELECT 6 UNION ALL
    SELECT 7 UNION ALL
    SELECT 8 UNION ALL
    SELECT 9 UNION ALL
    SELECT 10
) numbers;
