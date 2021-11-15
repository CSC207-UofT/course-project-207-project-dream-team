# Course Schedule System

## License
MIT License

Copyright (c) 2021 CSC207-Project-Dream-Team-UofT

## System Requirements
Java (1.7 or later)

## Goal
Our program aims to help UofT (only St. George Campus) students organize appropriate timetables based on provided
courses and users’ preferences. For instance, if a user want to take five courses in the winter semester, he or she can
enter all the course codes (e.g. CSC207H1) on the user interface, and our algorithms will return all the possible
combinations for the given courses. Specifically, our program has three different filters including Instructor Filter,
Timeslot Filter and Maximum Hour Filter. The Instructor Filter helps to rule out the sessions that are delivered by
users’ unwanted instructors. The Timeslot Filter helps to rule out the users’ unwanted timeslots (e.g. morning course
from 9am - 10am). The Maximum Hour Filter will organize a timetable with everyday lecture hours less or equal to the
users’ acceptable study hours.



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



