
package com.myprofile.bean;

import java.io.Serializable; // Important for JavaBeans

public class ProfileBean implements Serializable {

    // 1. Private attributes (instance variables) - These match your database columns
    private int id; // Corresponds to the 'id' column in the database
    private String name;
    private String studentId; // Renamed from student_id for Java convention (camelCase)
    private String program;
    private String email;
    private String hobbies;
    private String selfIntroduction; // Renamed from self_introduction for Java convention

    // 2. A no-argument constructor (required for JavaBeans)
    public ProfileBean() {
        // Default constructor
    }

    // 3. Optional: A constructor to easily set all values
    public ProfileBean(int id, String name, String studentId, String program, String email, String hobbies, String selfIntroduction) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.program = program;
        this.email = email;
        this.hobbies = hobbies;
        this.selfIntroduction = selfIntroduction;
    }

    // Optional: Another constructor without the 'id' for new profiles (as DB generates ID)
    public ProfileBean(String name, String studentId, String program, String email, String hobbies, String selfIntroduction) {
        this.name = name;
        this.studentId = studentId;
        this.program = program;
        this.email = email;
        this.hobbies = hobbies;
        this.selfIntroduction = selfIntroduction;
    }

    // 4. Public getters and setters for each private attribute

    // For 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // For 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // For 'studentId'
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // For 'program'
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    // For 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // For 'hobbies'
    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    // For 'selfIntroduction'
    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    // Optional: Override toString() for easy debugging
    @Override
    public String toString() {
        return "ProfileBean{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", studentId='" + studentId + '\'' +
               ", program='" + program + '\'' +
               ", email='" + email + '\'' +
               ", hobbies='" + hobbies + '\'' +
               ", selfIntroduction='" + selfIntroduction + '\'' +
               '}';
    }
}


