# Task-management-Api

OVERVIEW--
1) This is Task Management System project.
2) In this prject you can add Task into the database and update that task into the database if you are a authorised user.
3) In this project I have integrated a best authentication which help in providing the access control on API.

User Registration, User Login and Authorization process.----
->User Resistration
  i)Post-api/auth/signup
  ii)(username , role , password , email)
  iii) after htting this api server wil check existing of user and save into the database.
->User Login
  i)Post-api/auth/signin
  ii)(username , password)
  iii) after hitting this api server will check about validation of user and send a Jwt token in form of response.

Project Endpoints...----
  1)Post-api/test/addTask
    i) You can add the task into the Db by using this api. 
    ii) you will be ending the rquest -AddTaskRquest(title , duedate , status , description username) int form of request  Body.
    iii) after getting this request it project will check that username is valid or not , if it is not valid then it will throw an error that User is not exist.
    iv) if username is true then it will send into the service and make the Task Object and set its all paramter and save it into the Database.

 2)
  
  


