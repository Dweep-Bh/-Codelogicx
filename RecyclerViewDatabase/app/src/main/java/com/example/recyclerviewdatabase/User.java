package com.example.recyclerviewdatabase;

public class User {
    public User(String phonenumber, String employeename, String employeeaddress, String designation) {
        this.phonenumber = phonenumber;
        this.employeename = employeename;
        this.employeeaddress = employeeaddress;
        this.designation = designation;
    }

    public User() {
    }

    String phonenumber,employeename,employeeaddress,
            designation;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeeaddress() {
        return employeeaddress;
    }

    public void setEmployeeaddress(String employeeaddress) {
        this.employeeaddress = employeeaddress;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }




}
