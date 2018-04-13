package com.example.admin.orgcharttest.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String empId;
    private Employee superior;
    private List<Employee> subordinates;

    public Employee(String empId) {
        this.empId = empId;
        superior = null;
        subordinates = new ArrayList<>();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Employee getSuperior() {
        return superior;
    }

    public void setSuperior(Employee superior) {
        this.superior = superior;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void printTree(List<Employee> subordinates, int subLevel) {
        for (Employee employee : subordinates) {
            for (int i = 0; i < subLevel; i++) {
                System.out.print("\t");
            }

            System.out.print(employee.getEmpId() + "\n");

            if (!employee.getSubordinates().isEmpty()) {
                printTree(employee.getSubordinates(), subLevel + 1);
            }
        }
    }
}
