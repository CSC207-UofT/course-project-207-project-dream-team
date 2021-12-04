# CSC207 Dream Team - Course Schedule System

## License
MIT License

Copyright (c) 2021 CSC207-Project-Dream-Team-UofT

## System Requirements
Java (1.7 or later)

## Get Started

### Phase 0:
- [CRC Card](Phase%200/CRC%20Card)
- [README](Phase%200/README.md)
- [Progress Report](Phase%200/Report%20Files%20(.md)/Progress_Report.md)
- [Scenario Walk Through](Phase%200/Report%20Files%20(.md)/Scenario_Walk_Through.md)
### Phase 1:
- [Design Document](Phase%201/Design%20Document.md)
### Phase 2:
- [Design Document 2.0](Phase%202/Design_Document_phase_2.md)


## Our Goal
Our program aims to help UofT (only St. George Campus) students organize appropriate timetables based on provided
courses and users’ preferences. For instance, if a user want to take five courses in the winter semester, he or she can
enter all the course codes (e.g. CSC207H1) on the user interface, and our algorithms will return all the possible
combinations for the given courses. Specifically, our program has three different filters including Instructor Filter,
Timeslot Filter and Maximum Hour Filter. The Instructor Filter helps to rule out the sessions that are delivered by
users’ unwanted instructors. The Timeslot Filter helps to rule out the users’ unwanted timeslots (e.g. morning course
from 9am - 10am). The Maximum Hour Filter will organize a timetable with everyday lecture hours less or equal to the
users’ acceptable study hours.

## Functionality
- When someone starts our program, the Controller class will call the user interface. On the User Interface, our program
  will ask the user to input the course code (e.g. CSC207H1) of the classes he or she are going to take. Afterwards,
  our program will automatically load all the sessions of those courses via methods in the WebParse class. Afterwards,
  the Controller will call the Timetable class to generate a new Timetable instance, in which Sessions are stored in the
  values led by keys indicating the time of the Session. Afterwards, the SimpleScheduler will schedule all appropriate
  timetables and return them in an Arraylist. The Controller will then call the Filter class. If the user chooses the
  Instructor Filter, the Filter class will then call it to rule out the timetables that contain the unwanted sessions
  delivered by unwanted instructors. If the user chooses the TimeslotFilter, the Filter class will then call it to rule
  out the timetables with unwanted time slots (e.g. some people do not want to take morning class). If the user chooses
  Maximum Hour Filter, the Filter Class will then call it to rule out the timetables that have more everyday lecture
  hours that exceed the users’ acceptable study hour. The data is handed over in the form of a Timetable to Javafx
  application for initial display to the user.


- The following is the functions of each class:
    - Timetable class is a data structure that stores the result of a scheduled timetable. Each Timetable instance has
      an attribute timetable which is in TreeMap type. The key is a 5-digit string representation of the time in which each
      stored session takes place. The values are Session instances from which we can gather information to display to the
      user later. The second attribute is occupied. It stores the same 5-digit string representation, this may seem
      redundant given the timetable attribute already has the time info. However, this makes the Timetable more transparent
      to debugging, and the program more adaptive to further extension.

    - NewCourse is the replacement for the old Course class. By moving to the NewCourse data structure. we can easily
      manage sessions that belong to one course therefore shorten the time in accessing session attributes to determine
      what course it belongs to on many occasions. The old Course class is now the Session class and once scheduler
      decides what session it puts on the timetable. Information stored in Session is still sufficient for the timetable
      output.
    - Session is essentially the old Course class. It contains less information when compared to the old Course class for
      the sake of efficiency. Session instances are stored in NewCourse.
    - Filter is an abstract class that will call different child classes based on the users' preference.
    - Instructor ApplicationBusinessRule.filter: if you have any preference on instructors, for instance, you prefer not to enroll in specific
      instructors’ sessions, please choose the Instructor Filter. With this ApplicationBusinessRule.filter, our program will automatically rule out
      the lecture sessions delivered by your unwanted instructors in your schedule.
    - Maximum Hour Filter: if you have any preference on study hours per day, for instance, you prefer not to take more
      than 5 hours of lecture each day, please choose the Maximum Hour Filter. Our program will organize a timetable with an
      everyday lecture hour less or equal to your provided number.
    - Timeslot ApplicationBusinessRule.filter: if you have any preference on certain time slots, for instance, you prefer not to take a morning
      course (e.g. 9 am – 10 am) or a night course (e.g. 8 pm – 10 pm), please choose the Timeslot Filter. We will rule out
      the sessions with your unwanted timeslots in your timetable.


- Our program can store the state and load state as the users continue. Everytime a user inputs one course, our
  algorithm will automatically call the inputCourse() method in the UserData class. As a result, the information of
  every course will be stored in the same directory where our program is stored on the user’s computer after calling
  the method. Everytime a user starts the program, our algorithms will automatically detect if the user has used the
  program before by calling inputExist(). If our program detects that there is an existing version stored on the computer,
  we would ask if you want to load your last version. If the user answers “Yes”, our program will load his or her stored
  last version on the computer, and continue the rest process -- schedule timetables and ApplicationBusinessRule.filter unwanted timetables based
  on the users’ preferences. The state persists across runs of our program.



## Compiling
To compile the code, run the command bellow in the terminal
Note: Make sure you're running it from the root directory:

1. cd Course_Project/main/java
2. $ javac Controller.java
3. $ java Controller



## Running the program
Running the project starts with an initially empty timetable arrangement interface that allows the user to make
arrangement with their preference.


## User Input
List of information to enter:
* Course code
* Type
* Instructor
* Day of week
* Start time
* End time


## Example entering prompts
* Course code:  $ CSC207H1F
* Type: $ LEC
* Instructor: $ Lindsey Shorser
* Day of week: $ 4
* Start time: $ 18
* End time: $ 20



