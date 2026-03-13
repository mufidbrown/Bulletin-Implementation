INSERT INTO posts (
    title,
    author_name,
    password,
    content,
    view_count,
    created_at,
    modified_at,
    deleted
)
VALUES (
    '첫 번째 게시글',
    '일함',
    'test1234',
    '안녕하세요. 저는 일함 무피드입니다. 이 게시판 시스템은 Spring Boot와 PostgreSQL을 사용하여 만들었습니다.',
    0,
    NOW(),
    NULL,
    FALSE
);
