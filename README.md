# Schedule

## ScheduleProject

- 작성자 : 김지영
- 개발기간 : 2025.02.07 ~ 2025.02.13
- 개발일정 :

|날짜|개발단계|
|---|-----|
02.07|Lv 2. 유저 CRUD, Lv 3. 회원가입
02.10 ~ 02.11 |Lv 4. 로그인(인증)

---------------

## 시작가이드(GUIDE FOR START)

### Requirements
For building and running the application you need:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/?section=mac)
<br><br>
### Installation
[https://github.com/flammaa/calculator.git](https://github.com/flammaa/KioskProject.git)

<br><br>
### Stacks
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">


-----------

## Schedule API

|기능(feature) | Http method | URL                       | 상태코드(Status) |
|-------------|-------------|---------------------------|---------------|
유저 생성 | `POST` | /api/users                | `201`, `400`
유저 조회 | `GET` | /api/users/{id}           | `200`, `404`
유저 수정 | `PATCH` | /api/users/(feature)/{id} | `200`, `400`, `404`
유저 삭제 | `DELETE` | /api/users/{id}           | `200`, `404`
|||
로그인 | `POST` | /api/login                | `201`, `400`
로그아웃 | `POST` | /api/logout               | `201`, `400`
|||
일정 생성 | `POST` | /api/schedules            | `201`, `400`
일정 조회 | `GET` | /api//api/schedules/{id}  | `200`, `404`
일정 목록 조회 | `GET` | /api/schedules            | `200`, `400`
일정 수정 | `PATCH` | /api//api/schedules/{id}  | `200`, `400`, `404`
일정 삭제 | `DELETE` | /api//api/schedules/{id}  | `200`, `404`
|||
댓글 생성 | `POST` | /api/comments             | `201`, `400`
댓글 조회 | `GET` | /api/comments/{id}        | `200`, `404`
댓글 목록 조회 | `GET` | /api/sccomments           | `200`, `400`
댓글 수정 | `PATCH` | /api/comments/{id}        | `200`, `400`, `404`
댓글 삭제 | `DELETE` | /api/comments/{id}        | `200`, `404`



## ERD




<br><br><br><br>
# 주요기능(Main function)

## users
| 기능 | URL                                | Request                                                             | Response                                                                 | Status | 
|-----|------------------------------------|---------------------------------------------------------------------|--------------------------------------------------------------------------|--------|
유저 등록 | localhost:8080/users/signup        | { <br/>"username": "test",  <br/>"email":"sparta@gmail.com", "password": "1234"<br/>} | {<br/>"id": 1, <br/>"username": "test", "email":"sparta@gmail.com"<br/>} | `201 Created`
유저 조회 | localhost:8080/users/{id}          |  | {<br/> "username": "test", <br/>"email": "sparta@gmail.com"<br/>}        | `200 OK`
이름 수정 | localhost:8080/users/username/{id} | {<br/> "verifyPassword":"1234", <br/>"newUsername": "changename"<br/>} |                                                                          | `200 OK`
이메일 수정 | localhost:8080/users/email/{id}    | {<br/>"verifyPassword":"1234", <br/>"newEmail": "newemail@gmail.com"<br/>} | | `200 OK`
비밀번호 수정 | localhost:8080/users/password/{id} | {<br/> "oldPassword": "1234", <br/>"newPassword": "1111"<br/>} | | `200 OK`
유저 삭제 | | | `200 OK`


## login & logout
| 기능 | URL                                | Request                                                             | Response                                                                 | Status | 
|-----|------------------------------------|---------------------------------------------------------------------|--------------------------------------------------------------------------|--------|
login | localhost:8080/login | {<br/> "email": "sparta@gmail.com", <br/>"password": "1234" <br/>} | {<br/> "id": 1, <br/>"username": "test", "email": <br/>"sparta@gmail.com"<br/>} | `200 OK`
logout| localhost:8080/logout | | 로그아웃 성공 | `200 OK`



## shcedules

## comments


<br><br><br>
<br>








