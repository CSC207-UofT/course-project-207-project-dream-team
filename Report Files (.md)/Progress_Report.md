#Progress Report

## Software Design
We aim to design a timetable management software that allows the users to schedule their course.

Whether the program can schedule one's personal activities or estimate the buildings between classes is yet to be discussed.

## Classes
- Course: the basic information about a course including course code, session, instructor, timeslot and location.
[comment]: <> (- CourseManage: store the information provided by users and instances of Course)
- Controller: 
- Scheduler (Super Class): an abstract class with multiple child classes
- BackToBackScheduler (Child Class): for users who prefer a clustered timetable
- InstructorScheduler (Child Class): for users who have preferences on instructors
- DurationScheduler (Child Class): for users who have preferences on class duration
- SleepScheduler (Child Class): for users who prefer to have class in certain timeslot 
- TimeslotScheduler (Child Class): 
- TimeTable: store a mapping of course code to time slots
- Presenter: receive information from users and display the timetables to the users 

## Scenario Walk-Through
We have included a basic work-through scenario. 


## Skeleton Program
We have defined basic 10 basic classes for the programs (please check the Class section above). 
In Presenter and Timetable, we have implemented a list of basic methods.
- Timetable: 
  - getTable 
  - isEmpty 
  - addCourse
- Presenter: addRow, print, printLine, printRow

The methods for Scheduler have not been designed and implemented explicitly.
