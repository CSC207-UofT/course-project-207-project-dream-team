# Progress Report

## Worked Well

- We have successfully designed and
  implemented [Application Business Rule](../src/main/java/ApplicationBusinessRule): [Filter and its subclasses](../src/main/java/ApplicationBusinessRule/filter)
  ;
- We have successfully designed and
  implemented [Enterprise Business Rule](../src/main/java/EnterpriseBusinessRules): [NewCourse](../src/main/java/EnterpriseBusinessRules/NewCourse.java)
  and
  [Session](../src/main/java/EnterpriseBusinessRules/Session.java);
- We have successfully designed and
  implemented [Frameworks & Drivers](../src/main/java/FrameworksDrivers): [Userdata](../src/main/java/FrameworksDrivers/UserData.java)
  and [WebParse](../src/main/java/FrameworksDrivers/WebParse.java);
- We have successfully designed and
  implemented [Interface Adapter](../src/main/java/InterfaceAdapters): [AlertBox](../src/main/java/InterfaceAdapters/AlertBox.java)
  , [Controller](../src/main/java/InterfaceAdapters/Controller.java),
  [ConvertToUI](../src/main/java/InterfaceAdapters/ConvertToUI.java)
  , [MakeCSV](../src/main/java/InterfaceAdapters/MakeCSV.java),
  [TimeSlotForGUI](../src/main/java/InterfaceAdapters/TimeSlotForGUI.java)
  and [UserInterface](../src/main/java/InterfaceAdapters/UserInterface.java)
- We also design an accessibility feature for visual deficit user -- high-contrast mode.
- We are effective during in-person meetings.

## Summary for Group Member

- Zhonghan Chen : OscarC9912
    - Complete the testing for InstructorFilter, MaximumHourFilter, TimeslotFilter classes.
    - Update the design patterns for the project.
    - Pull Request: [#42 Pull Request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/42)
      Re-design the InstructorFilter and MaximumHourFilter, which is one of the main sorting algorithm in the project.
- Lewei Er:
    - [#86 Pull Request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/86):
        - This is when MakeCSV is ready to be used. Although in this commit, I only fixed the brain fart I had in the
          last version.
    - [#74 Pull Request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/74):
        - This is when MakePDF is ready to be used. Later we decided to get rid of the PDF function as CSV is much
          simpler. MakePDF is deleted in #76 Pull Request in which MakeCSV is first added.
- Xuanyi Piao : PIAO-A-PIAO
    - [#77 Pull Request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/77):
        - Implemented the last method of class WebParse. WebParse is designed to parse information of a course online
          and to cast it into a NewCourse class item. This save the efforts for both developers and users to manually
          type in the information of different courses.
    - [#102 Pull Request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/102):
        - Implemented the last method of class UserData. UserData is designed to interact between GUI and back-end
          codes. It's main purpose is to help store and present users' history inputs.
- Jerry Yan : noaoch
    - Implemented a design pattern for SimpleScheduler
    - Added javadoc to classes SimpleScheduler, Timetable, NewCourse and Session
    - Pull Request: [#39 Pull Request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/39)
      Made significant adjustments to the scheduling algorithm, such that SimpleScheduler now returns the correct
      timetable combinations in a much more efficient manner. I believe this is quite important as the whole goal of
      this program is to help students schedule courses.
- Chenchen Zhang: czzcczz
    - updating Design Document and Specification
    - writing Progress Report and Project Accessibility
    - making PPT
    - add javadoc to the Filter classes and its subclasses
    - Pull Request：[#33 Pull Request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/33)
      established and completed the Abstract Filter class and two subclasses (InstructorFilter and TimeslotFilter), the
      program started to include algorithms dealing with different user preferences
- Yiteng Zhang：3th4novo
    - To modify the GUI for the accessibility feature in the project, add a high-contrast mode option.
    - Fixing bugs found in the process of GUI developing.
    - Reorganize GUI related classes to make them more extenable and readable.
    - Redesigned the scenes of the GUI to make it more enjoyable to the users.
    - Pull Request: [#75 Pull Request](https://github.com/CSC207-UofT/course-project-207-project-dream-team/pull/75)
        - The pull request reorganized the UserInterface class by using the fxml and controller feature of javafx
          module.
        - The use of the controller makes the generated gui code more readable, and also makes the subsequent function
          expansion more convenient.
    