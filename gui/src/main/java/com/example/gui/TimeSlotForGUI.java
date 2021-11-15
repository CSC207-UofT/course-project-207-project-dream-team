package com.example.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class TimeSlotForGUI {
    private final StringProperty MondaySession;
    private final StringProperty TuesdaySession;
    private final StringProperty WednesdaySession;
    private final StringProperty ThursdaySession;
    private final StringProperty FridaySession;

    public TimeSlotForGUI(String MondaySession,
                          String TuesdaySession,
                          String WednesdaySession,
                          String ThursdaySession,
                          String FridaySession) {
        this.MondaySession = new SimpleStringProperty(MondaySession);
        this.TuesdaySession = new SimpleStringProperty(TuesdaySession);
        this.WednesdaySession = new SimpleStringProperty(WednesdaySession);
        this.ThursdaySession = new SimpleStringProperty(ThursdaySession);
        this.FridaySession = new SimpleStringProperty(FridaySession);
    }

    // Monday
    public String getMondaySession() {
        return MondaySession.get();
    }

    public void setMondaySession(String mondaySession) {
        MondaySession.set(mondaySession);

    }

    public StringProperty mondaySessionProperty() {
        return MondaySession;
    }

    // Tuesday
    public String getTuesdaySession() {
        return TuesdaySession.get();
    }

    public void setTuesdaySession(String tuesdaySession) {
        TuesdaySession.set(tuesdaySession);
    }

    public StringProperty tuesdaySessionProperty() {
        return TuesdaySession;
    }

    // Wednesday
    public String getWednesdaySession() {
        return WednesdaySession.get();
    }

    public void setWednesdaySession(String wednesdaySession) {
        WednesdaySession.set(wednesdaySession);
    }

    public StringProperty wednesdaySessionProperty() {
        return WednesdaySession;
    }

    // Thursday
    public String getThursdaySession() {
        return ThursdaySession.get();
    }

    public void setThursdaySession(String thursdaySession) {
        ThursdaySession.set(thursdaySession);
    }

    public StringProperty thursdaySessionProperty() {
        return ThursdaySession;
    }

    // Friday
    public String getFridaySession() {
        return FridaySession.get();
    }

    public void setFridaySession(String fridaySession) {
        FridaySession.set(fridaySession);
    }

    public StringProperty fridaySessionProperty() {
        return FridaySession;
    }
    // if this method is commented out then the tableview will not refresh when the email is set.
}

