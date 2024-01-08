package com.bankmanagement.bankmanagement.model;


import com.bankmanagement.bankmanagement.helper.status.ActivityAction;
import jakarta.persistence.*;

import java.util.Date;
@Entity @SuppressWarnings("unused")
public class Activities {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employee employee;
    @Column(name = "table_name")
    private String table; //Order, Employee, Users, Service
    @Column(name = "object_id")
    private Integer objectId;
    private ActivityAction action;
    private String description;
    @Column(name = "action_date")
    private Date actionDate;
    public Activities(){}

    public Activities(Employee employee, String table, Integer objectId, ActivityAction action, String description, Date actionDate) {
        this.employee = employee;
        this.table = table;
        this.objectId = objectId;
        this.action = action;
        this.description = description;
        this.actionDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public ActivityAction getAction() {
        return action;
    }

    public void setAction(ActivityAction action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "id=" + id +
                ", employee=" + employee +
                ", table='" + table + '\'' +
                ", objectId=" + objectId +
                ", action=" + action +
                ", description='" + description + '\'' +
                ", actionDate=" + actionDate +
                '}';
    }
}
