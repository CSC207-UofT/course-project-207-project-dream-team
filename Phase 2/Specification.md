# CSC207 Dream Team - Course Schedule System

## License

MIT License

Copyright (c) 2021 CSC207-Project-Dream-Team-UofT

## System Requirements

Java (1.7 or later)

## Get Started

### Phase 0:

- [CRC Card](../Phase%200/CRC%20Card)
- [README](../Phase%200/README.md)
- [Progress Report](../Phase%200/Report%20Files%20(.md)/Progress_Report.md)
- [Scenario Walk Through](../Phase%200/Report%20Files%20(.md)/Scenario_Walk_Through.md)

### Phase 1:

- [Design Document](../Phase%201/Design%20Document.md)

### Phase 2:

- [Design Document 2.0](Design_Document_phase_2.md)
- [Progress Report](Progress%20Report.md)
- [Project Accessibility Report](Project%20Accessibility%20Report.md)

## Our Goal

Our program aims to help UofT students organize appropriate timetables based on provided courses and users’ preferences.
For instance, if a user want to take five courses in the winter semester, he or she can enter all the course codes (e.g.
CSC207H1) on the user interface, and our algorithms will return all the possible combinations for the given courses.
Specifically, our program has three different filters including Instructor Filter, Timeslot Filter and Maximum Hour
Filter. The Instructor Filter helps to rule out the sessions that are delivered by users’ unwanted instructors. The
Timeslot Filter helps to rule out the users’ unwanted timeslots (e.g. morning course from 9am - 10am). The Maximum Hour
Filter will organize a timetable with everyday lecture hours less or equal to the users’ acceptable study hours.

## Functionality

- When someone starts our program, the Controller class will call the user interface. On the User Interface, our program
  will ask the user to input the course code (e.g. CSC207H1) of the classes he or she are going to take. Afterwards, our
  program will automatically load all the sessions of those courses via methods in the WebParse class. Afterwards, the
  Controller will call the Timetable class to generate a new Timetable instance, in which Sessions are stored in the
  values led by keys indicating the time of the Session. Afterwards, the SimpleScheduler will schedule all appropriate
  timetables and return them in an Arraylist. The Controller will then call the specific classes indicated by the user
  by preference input. If the user chooses the Instructor Filter, the Controller class will then call it to rule out the
  timetables that contain the unwanted sessions delivered by unwanted instructors, and so on. The data is handed over in
  the form of a Timetable to Javafx application for initial display to the user. UserInterface displays at most 5
  timetables each time. If the user chooses to, the program can be asked to produce a csv file to with a button press.
  The output csv file contains basic information and the user has the choice to manipulate it anyway they like outside
  the program.


- The following are the functions of each class:
    - Timetable class is a data structure that contains timetable information.
    - NewCourse is the replacement for the old Course class. It has Session inside one of its attribute for more
      efficient access.
    - Session is essentially the old Course class. It contains less information when compared to the old Course class
      for the sake of efficiency.
    - Filter is an abstract class that will call different child classes based on the users' preference.
    - Instructor Filter filters out the timetables containing unwanted professors indicated by the user.
    - Maximum Hour Filter filters out the timetables that has too many hours in one day according to the user's
      preference.
    - Timeslot Filter filters out timetables that contains classes at the time which user does't want to have classes.
    - MakeCSV class makes a csv file containing all timetables presented.


- Our program can store the state and load state as the users continue. Everytime a user inputs one course, our
  algorithm will automatically call the inputCourse() method in the UserData class. As a result, the information of
  every course will be stored in the same directory where our program is stored on the user’s computer after calling the
  method. Everytime a user starts the program, our algorithms will automatically detect if the user has used the program
  before by calling inputExist(). If our program detects that there is an existing version stored on the computer, we
  would ask if you want to load your last version. If the user answers “Yes”, our program will load his or her stored
  last version on the computer, and continue the rest process -- schedule timetables and filter unwanted timetables
  based on the users’ preferences. The state persists across runs of our program.


- We include a high-contrast mode for user with visual deficit.

## Compiling

To compile the code, run the command bellow in the terminal Note: Make sure you're running it from the root directory:

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



