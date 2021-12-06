##Design Pattern

##Introduction:
- Our program aims to help UofT students organize appropriate timetables based on provided 
courses and users’ preferences. For instance, if a user want to take five courses in the winter semester, he or she 
can enter all the course codes (e.g. CSC207H1) on the user interface, and our algorithms will return all the possible 
combinations for the given courses. Specifically, our program has three different filters including Instructor Filter, 
Timeslot Filter and Maximum Hour Filter. The Instructor Filter helps to rule out the sessions that are delivered by 
users’ unwanted instructors. The Timeslot Filter helps to rule out the users’ unwanted timeslots (e.g. morning course 
from 9am - 10am). The Maximum Hour Filter will organize a timetable with everyday lecture hours less or equal to the 
users’ acceptable study hours.

##SOLID
- Single responsibility principle:
  - SimpleScheduler: only responsible for scheduling the timetable via recursion. 
  - Filter and its subclasses: For our three non-abstract ApplicationBusinessRule.filter classes, each of them is responsible for dealing with 
  one kind of user preference. For instance, Instructor Filter only works if users want to rule out specific unwanted 
  instructors. Therefore, one non-abstract ApplicationBusinessRule.filter class has its own responsibility, and will change if and only if its own ApplicationBusinessRule.filter method (named “sort” in the algorithms) changes.
  
- Open/closed principle:
  - An implementation of the Open/closed principle is the Filter class. The instance variables in Filter are made 
  private and can only be accessed through getter methods. The helper methods are also private so changes of the 
  data in Filter can only be made inside the Filter class. However, outside the Filter class, only access is allowed 
  and no change shall occur to the data stored in the Filter class.

- Liskov Substitution principle:
  - For our Filter Class and its subclasses, all three subclasses of Filter only has an overwritten version the parent 
  class's abstract sort() method, which is used to ApplicationBusinessRule.filter out the unwanted timetables based on users' preference. We did 
  not replace the parent class.

- Interface Segregation principle & Dependency Inversion Principle: we did not implement any interface in the project

## Clean Architecture

- CRC
  - In the CRC directories, we have divided CRCs of different courses into four packages based on the Clean Architecture.
    (ApplicationBusinessRules, EnterpriseBusinessRules, Frameworks&Drivers, InterfaceAdapters). In each CRC, we have 
  implicitly stated the basic information and functions of the classes.

- Scenario walk-through:
  - The Controller class is the center of the operation. When run, it activates the Javafx application. The application 
  is the user interface. This is one of our Frameworks & Drivers. The Javafx application interacts with WebParse, which 
  is the other member of Frameworks & Drivers. They cooperate to get information from both the user and the web 
  (In this case, it would be the UofT Coursefinder website). Then the controller calls the simple scheduler, giving it 
  the information from the user and the web. This way, it is clear who is doing what task. If the user has any 
  preference, the controller learns this fact and hands it to the Filter. The ApplicationBusinessRule.filter determines what preference should 
  be applied. The finished product is in the form of a Timetable instance. Of course, the Timetable class also helps 
  this process by providing the state of itself. We achieved this by implementing helper methods in the Timetable class. 
  The data is handed over in the form of a Timetable to Javafx application for initial display to the user. 
  Finally, if the user desires, MakePDF is called by the Controller represented by the Javafx application. 
  MakePDF outputs a pdf file that is friendly to digital use and printing.

## Design Pattern
- In our project, we have implemented Template Method Design Pattern in the Filter Class and its subclasses. The Filter 
is the base case that has constructor, call(), abstract sort(), getInput(), getOutput(), getUnwanted(), and 
isFiltered() methods. The Filter class has three subclasses including Instructor Filter, Timeslot Filter and 
Maximum Hour Filter. By running Filter class, the class will constructor a ApplicationBusinessRule.filter instance and call the call() method, 
which is a template method. If the user chooses Instructor Filter, the call() method will call InstructorFilter. 
If the user chooses Timeslot Filter, the call() will call TimeslotFilter. If the user chooses Maximum Hour Filter, 
the call() will call Maximum Hour Filter. The three child ApplicationBusinessRule.filter will rule out all the unwanted timetables based on the 
users’ preference. The isFilter() method will check if the programs rule out some unwanted timetables by checking 
the whether the output is empty. If the output is empty, the method will print out “Timetable are not filtered”. 
Else, it will print out “Timetable are successfully filtered.” For #33 pull request, we started to implement the 
Template Method Design Pattern. 

- 

##Use of GitHub Features
- Our group sufficiently used Pull Requests combined with branches to each finish the assigned tasks. Our Pull requests 
are reviewed by people with related tasks (when classes communicate) unless changes are trivial or when we are meeting 
in-person. We haven’t used Issues as much since we have been communicating over group chats or face-to-face every day. 
Actions is a great tracker of what we have been doing, so we use it as material for our meetings.

## Code Style and Documentation
- We have resolved all the warnings in our algorithms. In most classes, we have added comments. In the pull requests we
posted, we have added detail description to prevent confusion.

## Testing
- In our program, we have tested that NewCourse and Session can successfully initialize new course instances and new 
course session instances. We also test that Timetable class and SimpleScheduler can successfully generate appropriate 
timetables. Besides, we also tested the Instructor Filter, Timeslot Filter, and Maximum Hour Filter. Instructor Filter 
can successfully rule out the sessions delivered by unwanted professors. Timeslot Filter can successfully rule out the 
sessions with unwanted time slots. Maximum Hour Filter can successfully ApplicationBusinessRule.filter out the timetables that have lecture 
hours larger than the users’ preferential lecture hours.
- The user interface functions appropriately on our computers.

## Refactoring
- For #33 pull request, we have refactored the Filter class and its subclasse. Since the Filter and its subclasses are 
designed based on Template Method Design Pattern.
- For #46 pull request, we have refactored the Presenter class: safe delete Presenter.
- For #55 and #58 pull requests, we used refactoring functionality to package all Java files.

## Code Organization
- We have splitted our classes into four packages including ApplicationBusinessRule, EnterpriseBusinessRules, Frameworks 
& Drivers, and InterfaceAdapters. These packages are divided based on clean architecture. The EnterpriseBusinessRules 
include both of the classes as entities. They manage the most basic data structure in our program.  
The ApplicationBusinessRule includes Filter and its subclasses. They impose our higher level rules on how to deal 
with the input to produce our output. The Frameworks & Drivers classes include Userdata, UserInterface, and WebParse. 
They handle the outer layer of the program that interacts in some way with either the user or the web. The Interface 
Adapters translate the computer results to what the user can view and oversee the flow of the program. These roles are 
taken by the Controller

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








