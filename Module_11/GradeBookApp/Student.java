/*
    Author: Kondet Petine
    Date: 11/07/2022
*/
package GradeBookApp;
public class Student {
    String fname;
    String lname;
    String courseName;
    String grade;

    public Student(){
    
    }

    public void setFname(String fname){
        this.fname = fname;
    }

    public String getFname(){
        return this.fname;
    }

    public void setLname(String lname){
        this.lname = lname;
    }

    public String getLname(){
        return this.lname;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public String getGrade(){
        return this.grade;
    }

    public String toString(){
        return("First Name: " + this.fname + "\n" + "Last Name: " + this.lname + "\n" + "Course: " + this.courseName + "\n" + "Grade: " + this.grade);
    }
}