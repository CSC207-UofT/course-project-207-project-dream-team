#Design Document

##Introduction:
- Our program aims to help UofT undergraduate students organize appropriate timetables based on provided
  courses and users’ preferences. For instance, if users want to take five courses in the winter semester, they
  can enter all the course codes (e.g. CSC207H1) on the user interface, and our algorithms will return all the possible
  combinations for the given courses. Specifically, our program has three different filters including Instructor Filter,
  Timeslot Filter and Maximum Hour Filter. The Instructor Filter helps to rule out the sessions that are delivered by
  users’ unwanted instructors. The Timeslot Filter helps to rule out the users’ unwanted timeslots (e.g. morning course
  from 9am - 10am). The Maximum Hour Filter will organize a timetable with everyday lecture hours less or equal to the
  users’ acceptable study hours.

##SOLID
###Single responsibility principle:
  - [SimpleScheduler](../src/main/java/ApplicationBusinessRule/SimpleScheduler.java): only responsible for scheduling the timetable via recursion, will only change if the structure of Timetable changes.


  - [Filter and its subclasses](../src/main/java/ApplicationBusinessRule/filter): for three non-abstract Filter classes, each of them is responsible for dealing with
  one kind of user preference. For instance, Instructor Filter only works if users want to rule out specific unwanted
  instructors. Therefore, one non-abstract Filter class has its own responsibility, and will change if and only its own 
  Filter method (named “sort” in the algorithms) changes.

###Open/closed principle:
  - [Filter and its subclasses](../src/main/java/ApplicationBusinessRule/filter): the instance variables in Filter are made
  private and can only be accessed through getter methods. The helper methods are also private so changes of the
  data in Filter can only be made inside the Filter class. However, outside the Filter class, only access is allowed
  and no change shall occur to the data stored in the Filter class.

###Liskov Substitution principle:
  - [Filter and its subclasses](../src/main/java/ApplicationBusinessRule/filter): all three subclasses of Filter only has an overwritten version the parent
    class's abstract sort() method, which is used to filter out the unwanted timetables based on users' preference. We did
    not replace the parent class.

## Clean Architecture

###CRC
- In [CRC](CRC%20Card), we divided CRC cards of different classes into four packages based on the Clean Architecture.
(ApplicationBusinessRules, EnterpriseBusinessRules, Frameworks&Drivers, InterfaceAdapters). On each CRC card, we have 
implicitly stated the basic information and functions of the classes.

### Scenario walk-through:
- A typical walk-though of the program starts with running the Controller. The Controller class then activates the 
  UserInterface, which present all option concerning preferences and progress saving. Then, UserInterface collaborates 
  with WebParse to gather inputs from both the user and the UofT Course Finder site. This information is further passed
  on to the SimpleScheduler and then the Filter classes. They will run our algorithm to produce the timetables fitting 
  to the user's demands. The last task of the UserInterface is to present the generated timetables to the user, in which
  it uses help from ConvertToUI. If the user wants, a csv file can be generated containing all presented timetables. 
  Throughout the program, there is an option in the UserInterface to make the entire interface display in high contrast 
  colors.

## Design Pattern
###Template Method Pattern
- [Filter and its subclasses](../src/main/java/ApplicationBusinessRule/filter): In our project, we have implemented 
  Template Method Design Pattern in the Filter Class and its subclasses. The Filter is the abstract class that has 
  constructor, call(), abstract sort(), getInput(), getOutput(), and getUnwanted() methods. The Filter 
  class has three subclasses including Instructor Filter, Timeslot Filter and Maximum Hour Filter which are the concrete
  derived classes. By running Filter class, the placeholder class will constructor a filter instance and call the call() 
  method, which is a template method. If the user chooses Instructor Filter, the call() method will call 
  InstructorFilter, and so on. The three child filter will rule out all the unwanted timetables based on the user input. 
  We chose to use abstract class instead of interface as implementation of some method is required to avoid reuse of 
  code and allow the possibility of not having any preference.

###Dependency Injection 
- [SimpleScheduler](../src/main/java/ApplicationBusinessRule/SimpleScheduler.java): Using the class SimpleScheduler
  depends on a collection of courses that we wish to schedule, which are instances of [NewCourse](../src/main/java/EnterpriseBusinessRules/NewCourse.java).
  However, initializing such instances within SimpleScheduler creates hard dependency, that is, these instances of NewCourse
  cannot be used or tested independently, which is potentially more difficult to debug. As a result, The ArrayList of NewCourse instances
  is constructed outside SimpleScheduler and passed to an instance of SimpleScheduler when it is initialized.

##Use of GitHub Features
###Issues
- Two issues: [Hyper links for specification #72](https://github.com/CSC207-UofT/course-project-207-project-dream-team/issues/72) and
[Javadoc inclusion #73](https://github.com/CSC207-UofT/course-project-207-project-dream-team/issues/73)
- Since we usually communicated in-person, this feature has not been used frequently
###Pull Request
- We pushed changes to our own branches, and created Pull Request. One or two other team members would approve 
the changes and merged them to the main branch if the changes are appropriate.
###Actions
- [Actions](https://github.com/CSC207-UofT/course-project-207-project-dream-team/actions) is a great tracker of what we have been doing, so we use it as material for our meetings.

## Code Style and Documentation
- Warning are resolved.
- Javadoc and comments were added for methods.
- Pull Requests always include detailed description.

## Testing
- All tests are included in directory [test](../src/test/java) 
  - [Application Business Rule](../src/main/java/ApplicationBusinessRule): 100% class been tested
  - [Enterprise Business Rule](../src/main/java/EnterpriseBusinessRules): 100% class been tested
  - [Frameworks & Drivers](../src/main/java/FrameworksDrivers): 100% class been tested
  - [Interface Adapter](../src/main/java/InterfaceAdapters): 33% class been tested

## Refactoring
- [#33 pull request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/33): refactored the 
Filter class and its subclasses to meet  Template Method Design Pattern.
- [#46 pull request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/46): refactored the Presenter class -- safe delete Presenter.
- [#55 pull request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/55): refactored all Java files into appropriate packages 
- [#99 pull request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/99): we used refactoring to change method name.

## Code Organization
Package were divided based on clean architecture:
- [Application Business Rule](../src/main/java/ApplicationBusinessRule):
  - includes [Filter and its subclasses](../src/main/java/ApplicationBusinessRule/filter)
  - the classes impose higher level rules on how to deal
- [Enterprise Business Rule](../src/main/java/EnterpriseBusinessRules): 
  - includes [NewCourse](../src/main/java/EnterpriseBusinessRules/NewCourse.java) and
  [Session](../src/main/java/EnterpriseBusinessRules/Session.java) as entities
  - the classes manage the most basic data structure in our program
- [Frameworks & Drivers](../src/main/java/FrameworksDrivers):
  - includes [Userdata](../src/main/java/FrameworksDrivers/UserData.java) and [WebParse](../src/main/java/FrameworksDrivers/WebParse.java); 
  - the classes handle the outer layer of the program that interacts in some way with either the user or the web.
- [Interface Adapter](../src/main/java/InterfaceAdapters):
  - includes [AlertBox](../src/main/java/InterfaceAdapters/AlertBox.java), [Controller](../src/main/java/InterfaceAdapters/Controller.java),
  [ConvertToUI](../src/main/java/InterfaceAdapters/ConvertToUI.java), [MakeCSV](../src/main/java/InterfaceAdapters/MakeCSV.java),
  [TimeSlotForGUI](../src/main/java/InterfaceAdapters/TimeSlotForGUI.java) and [UserInterface](../src/main/java/InterfaceAdapters/UserInterface.java)
  - the classes translate the computer results to what the user can view and oversee the flow of the program

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
  application for initial display to the user. If the user chooses to, the program can be asked to produce a csv file
  to with a button press. The output csv file contains basic information and the user has the choice to manipulate it
  anyway they like outside the program.


- The following are the functions of each class:
    - Timetable class is a data structure that contains timetable information.
    - NewCourse is the replacement for the old Course class. It has Session inside one of its attribute for more 
      efficient access.
    - Session is essentially the old Course class. It contains less information when compared to the old Course class for
      the sake of efficiency.
    - Filter is an abstract class that will call different child classes based on the users' preference.
    - Instructor Filter filters out the timetables containing unwanted professors indicated by the user.
    - Maximum Hour Filter filters out the timetables that has too many hours in one day according to the user's 
      preference.
    - Timeslot Filter filters out timetables that contains classes at the time which user does't want to have classes.
    - MakeCSV class makes a csv file containing all timetables presented.


- Our program can store the state and load state as the users continue. Everytime a user inputs one course, our
  algorithm will automatically call the inputCourse() method in the UserData class. As a result, the information of
  every course will be stored in the same directory where our program is stored on the user’s computer after calling
  the method. Everytime a user starts the program, our algorithms will automatically detect if the user has used the
  program before by calling inputExist(). If our program detects that there is an existing version stored on the computer,
  we would ask if you want to load your last version. If the user answers “Yes”, our program will load his or her stored
  last version on the computer, and continue the rest process -- schedule timetables and filter unwanted timetables based
  on the users’ preferences. The state persists across runs of our program. 

###Accessibility Feature
- We include a high-contrast mode for user with visual deficit












