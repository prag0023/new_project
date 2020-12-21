package com.example.demo.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supervisor", schema = "studentdb", catalog = "")
public class Supervisor {
    private int supervisorId;
    private String supervisorName;

    @Id
    @Column(name = "supervisor_id")
    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Basic
    @Column(name = "supervisor_name")
    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supervisor that = (Supervisor) o;
        return supervisorId == that.supervisorId &&
                Objects.equals(supervisorName, that.supervisorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supervisorId, supervisorName);
    }
}
