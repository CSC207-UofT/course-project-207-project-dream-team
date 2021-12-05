module main{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.sql;

    opens InterfaceAdapters to javafx.graphics, javafx.fxml, javafx.base;

    exports InterfaceAdapters;
    exports ApplicationBusinessRule;
    exports EnterpriseBusinessRules;
    exports FrameworksDrivers;
}