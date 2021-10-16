#Progress Report

## Software Design
We aim to design a timetable management software that allows the users to schedule their course. 

The system requirement for the program is Java 1.7 or later.

To compile our code, run the command bellow in the terminal(Note: Make sure you're running it from the root directory):

1. cd Course_Project/main/java
2. $ javac Controller.java
3. $ java Controller

Whether the program can schedule one's personal activities or estimate the buildings between classes is yet to be discussed.

## Classes/CRC Card
- Course: the basic information about a course including course code, session, instructor, timeslot and location.
- CampusMap: store the map of University of Toronto
- TimeTable: store a mapping of course code to time slots
- Scheduler (Abstract Super Class): an abstract class with multiple child classes
- BackToBackScheduler (Child Class): for users who prefer a clustered timetable
- InstructorScheduler (Child Class): for users who have preferences on instructors
- DurationScheduler (Child Class): for users who have preferences on class duration
- TimeslotScheduler (Child Class): for users who prefer to have class in certain timeslot
- SimpleScheduler (Child Class): for users who have no scheduling preference
- Presenter: display the timetables to the users
- Controller: Utilize multiple classes to retrieval course information from users and provide possible timetables to the users

## Scenario Walk-Through
We have included a basic work-through scenario.


## Skeleton Program
We have defined 12 basic classes for the programs (please check the Class section above).

In Presenter and Timetable, we have implemented a list of basic methods.

- InputInfo:
  - askCourse: ask the number of courses a user want to enter 
  - askSingleCourse: ask user to enter course information
  
- Timetable: 
  - canAdd: check if the course can be added to timetable
  - isEmpty: check if timeslot is empty 
  - addCourse: add course to the timetable.
  
- Presenter:
  - addRow: add cells to the timetable
  - print: print the complete timetable
  - printLine: print the "|" and "-" for timetable
  - printRow: print the empty cell for the timetable
  - presentable: transform arranged timetable into Presenter recognized form

- Controller
  - main: utilize the InputInfo class to ask for user's information about courses; utilize the Scheduler class to Schedule the courses entered;
          utilize the Presenter class to print the timetable in terminal

The methods for Scheduler have not been designed and implemented explicitly.

## Members Tasks
- Everyone participated in designing the program structure.
- Everyone participated in coding the skeleton programs and unittest.

## Next Step
- We will design the specific implementations for all the Scheduler class 
- We will discuss if the programs should include features of scheduling one's personal activities or estimating the buildings,

## Worked Well
We have 
