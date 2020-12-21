package com.example.demo.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "studentdb", catalog = "")
public class Student {
    private int studentId;
    private String studentName;
    private String email;
    private int supervisorSupervisorId;

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "supervisor_supervisor_id")
    public int getSupervisorSupervisorId() {
        return supervisorSupervisorId;
    }

    public void setSupervisorSupervisorId(int supervisorSupervisorId) {
        this.supervisorSupervisorId = supervisorSupervisorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return studentId == that.studentId &&
                supervisorSupervisorId == that.supervisorSupervisorId &&
                Objects.equals(studentName, that.studentName) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, email, supervisorSupervisorId);
    }


}