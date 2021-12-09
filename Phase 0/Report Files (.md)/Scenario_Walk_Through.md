# Scenario Walk-Through

1. Controller tells InputInfo to asks for course info.

   (i) Courses the user intends to take associated info for the respective courses.

   (*) We will give value to each segment for the purpose of the walk-through.

   (*) We will allow for multiple inputs for the below info but the program will take only one course for the purpose of
   the walk-through.

       (1) Number of courses: 1
       
       (2) Course code: CSC207H1F

       (3) Type: LEC

       (4) Instructor: Lindsey Shorsern

       (5) Day of week: 4

       (6) Start time: 18

       (7) End time: 20

   (ii) Any preference info the user provides when prompted.

   (*) The user does not have a chance to put in any preferences for the purpose of the run-through.

   (iii) InputInfo put the input data into Entity and hands them to Controller.


2. Controller passes that data to Scheduler to run based on the info provided by the user.

   (i) Controller will determine which scheduler child class to run based on preference info.

   (*) In this case, there is no preference.

   (ii) the selected scheduler will take the data from Controller and collaborate with Entities to make instances of
   Entities and put them into memory and pass them back to Controller.

   (*) In this case, there will only be one timetable for the one course.

   (iii) Controller calls the presenter and give the data from scheduler to Presenter.


3. Presenter reports to the user.

   (i) Presenter takes the information from Controller and display the Timetable to the user on Terminal.

   (*) In this case, only one timetable is displayed for the one course.
