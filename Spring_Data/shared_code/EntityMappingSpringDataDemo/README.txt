This application demonstrates how to map JPA entities while we have:
1) One to One relationship
2) One to Many relationship
3) Many to Many relationship

Setup:
Edit application.yml & change the database configuration as per your environment.

REST call details:

1) One to One relationship (Employee & Profile)
A) Create new employee:
http://localhost:8080/myapp/employee	[POST]
{
    "name": "Jerry",
    "sal": 28000,
    "profile": {
        "company": "Infosys",
        "experience": 2.5
    }
}
B) Read all employees:
http://localhost:8080/myapp/employee	[GET]

2) One to Many relationship (Question & Answer)
A) Create new question:
http://localhost:8080/myapp/question	[POST]
{
    "qusDesc": "Which are european countries?",
    "answers": [
        {"answer": "Sweden"}, {"answer": "France"}, {"answer": "England"}
    ]
}
B) Read all questions:
http://localhost:8080/myapp/question	[GET]

3) Many to Many relationship (Student & Course)
A) Create new student:
http://localhost:8080/myapp/student		[POST]
{
    "studentName": "Jerry",
    "courses": ["Jenkins", "Spring", "Angular"]
}
B) Read all students:
http://localhost:8080/myapp/student		[GET]
