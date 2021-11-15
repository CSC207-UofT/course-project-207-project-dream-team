module main{
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.sql;
    requires junit;

    exports InterfaceAdapters;
    exports ApplicationBusinessRule;
    exports EnterpriseBusinessRules;
    exports FrameworksDrivers;
}