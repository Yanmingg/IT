package com.example.crm.methods;


public class Schedule extends CRMObject{
    // Attributes of a schedule
    private String name = super.getName();
    private String time = "NULL";
    private String address = "NULL";
    private String context = "NULL";
    private Contact relatedContact = null;

    // Constructor with a given name
    public Schedule(String name) {
        this.name = name;
    }

    // Constructor with all basic information
    public Schedule(String name, String time, String address, String context) {
        this.name = name;
        this.time = time;
        this.address = address;
        this.context = context;
    }

    // Constructor with related contacts
    public Schedule(String name, Contact contact) {
        this.name = name;
        this.relatedContact = contact;
    }

    // Constructor with all attributes
    public Schedule(String name, String time, String address,
                    String context, Contact contact) {
        this.name = name;
        this.time = time;
        this.address = address;
        this.context = context;
        this.relatedContact = contact;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setRelatedContact(Contact relatedContact) {
        this.relatedContact = relatedContact;
    }

    // This method is returning the attribute information into a csv format
    public String toCsv(){
        String csv = this.getName() + ',' + this.getTime() + ',' + this.getAddress() + ','
                + ',' + this.getContext();
        return csv;
    }

    // ToString method
    @Override
    public String toString() {
        return "Schedule{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
