# FinShot, Inc. Web Developer (Spring Framework)

This repository is a take-home test solution for FinShot, Inc. focused on implementing a web bulletin board using Java Spring Boot for the backend and Javascript Bootstrap for the frontend.
---

🛠 Setup & Run Instructions
1. Clone Repository
```bash
   git clone https://github.com/mufidbrown/Bulletin-Implementation.git
```

2. Build & Run
  ```bash
./mvnw clean install
```

```bash
./mvnw spring-boot:run
```

3. Configure Database Connection
  ```bash
Edit file:
src/main/resources/application.yml

spring.datasource.url=jdbc:postgresql://localhost:5432/bulletindb
spring.datasource.username=postgres
spring.datasource.password=your_password
```

4. Open browser & Access Application
  ```bash
browser:
http://localhost:8089/list.html
http://localhost:8089/detail.html
http://localhost:8089/edit.html
http://localhost:8089/delete.html

server/postman:
POST      http://localhost:8089/api/posts/create
request: {
  "authorName": "홍길동제목입니다",
  "password": "test1234",
  "title": "첫 번째 게시글 제목입니다",
  "content": "게시글 내용을 여기에 작성합니다."
}

GET ALL   http://localhost:8089/api/posts/all
GET BY ID http://localhost:8089/api/posts/13

PUT       http://localhost:8089/api/posts/8
request: {
  "authorName": "홍길동",
  "password": "test1234",
  "title": "첫 번째 게시글 제목입니다",
  "content": "게시글 내용을 여기에 작성합니다."
}

DELETE    http://localhost:8089/api/posts/8
request: {
  "password": "test1234"
}
```

Requirements

* Java 17+

* Maven 3.5.8+

* Database: PostgreSQL

