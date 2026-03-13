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
GET ALL   http://localhost:8089/api/posts/all
GET BY ID http://localhost:8089/api/posts/13
PUT       http://localhost:8089/api/posts/8
DELETE    http://localhost:8089/api/posts/8
```

Requirements

* Java 17+

* Maven 3.5.8+

* Database: PostgreSQL

