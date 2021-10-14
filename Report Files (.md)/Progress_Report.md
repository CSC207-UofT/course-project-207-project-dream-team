#Progress Report

## Software Design
We aim to design a timetable management software that allows the users to schedule their course.

Whether the program can schedule one's personal activities or estimate the buildings between classes is yet to be discussed.

## Classes
- Course: the basic information about a course
- CourseManage: store the information provided by users and instances of Course
- Scheduler (Super Class): an abstract class with multiple child classes
- BackToBackScheduler (Child Class): for users who prefer a clustered timetable
- ProfPreferenceScheduler (Child Class): for users who have preferences on instructors
- DurationScheduler (Child Class): for users who have preferences on class duration
- SleepScheduler (Child Class): for users who prefer to have class in certain timeslot 
- TimeTable: represent a particular table and show it to the users.
- TimeSlot: 

## Scenario Walk-Through



## Skeleton Program
We have defined basic classes for the programs. 