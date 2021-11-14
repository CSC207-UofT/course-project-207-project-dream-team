module modules.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;

    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
    exports com.example.timetable;
    exports com.example.filter;
}