/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Student {
    private String studentId;
    private String fullname;
    private double gpa;

    public Student(String studentId, String fullname, double gpa) {
        this.studentId = studentId;
        this.fullname = fullname;
        this.gpa = gpa;
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", fullname=" + fullname + ", gpa=" + gpa + '}';
    }
}
