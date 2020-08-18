# csye6220

## Duolingo -- Language Learning Platform
### Main idea
In terms of the final project for CSYE6220 Enterprise Software Design, I intend to build a language learning platform for interest. Specifically, it is going to be a web service that possesses different features, such as language learning course registration, progress tracker, chatting and conversation simulation, competition leaderboard, and so on. It utilizes Spring MVC and Hibernate as major frameworks, and other possible front-end development tools.
### Features
#### Log in/out, profile management
-	You could log in as a user, which manages your profile as basic personal information
-	Also, your courses enrollment status, and learning history… are recorded and come with your profile
-	You could check other user’s profile and add them as friends
#### Language course enrollment
-	Users could choose which language course to enroll
-	Users could choose which section to start
-	Users could choose to skip some parts if passed the pretest
-	Users need to fill in the blanks, translate the sentences or pair the phases to
#### Learning progress tracker
-	Your overall learning progress will be logged
-	You could set a daily goal and whatever you learnt will be counted
-	You could add the words to the vocabulary book for reviewing later
-	You will be asked to take a review when finishing a section
-	Course report will be generated weekly
#### Chatting and conversation simulation
-	Users could chat with each other as language partners
-	Users could interact with conversation automatic replay generator for practicing
-	Users could start a language event, post and manage it
#### Competition leaderboard
-	The competition on daily goals or other events, started either by admin or users will be held monthly
-	The score leaderboard will show the top 10 leaners which updates every seconds
-	Statistic reports for each competition will be automatically presented to the host and admin
### Logic Components
1.	DAOs
2.	POJOs
3.	Views (Login page, profile, course, test, leaderboard, chatroom, …)
4.	Login Controller
5.	Profile Controller
6.	Progress Tracker Controller
7.	Chatting Controller
8.	Competition Controller
### Main Technology
-	Spring MVC
--  Responsible for building the entire back-end web server
-	Hibernate
--	Responsible for mapping the persistence of data
-	MySQL
--	Responsible for storing data
- Maven
--	Responsible for managing Java Libraries
-	Bootstrap (Possible)
--	Responsible for agile development for front-end websites
-	Docker (Possible)
--	Responsible for the containerization of the application
