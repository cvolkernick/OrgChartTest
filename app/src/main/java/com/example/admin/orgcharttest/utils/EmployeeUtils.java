package com.example.admin.orgcharttest.utils;

import com.example.admin.orgcharttest.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

    public static List<Employee> parseEmployees(String[] inputData) {

        // create list of employees which will be returned
        List<Employee> employees = new ArrayList<>();

        // iterate over each string in the input data
        for (String data : inputData) {

            // split the values of this string
            String[] idList = data.split(",");

            // supervisor is first ID in the list
            String supervisorId = idList[0];

            Employee supervisor = null;

            // check if supervisor has already been created
            boolean supervisorExists = false;
            for (Employee employee : employees) {
                if (employee.getEmpId().equals(supervisorId)) {

                    // supervisor exists, set supervisor reference to this employee
                    supervisorExists = true;
                    supervisor = employee;
                }
            }

            if (!supervisorExists) {
                supervisor = new Employee(supervisorId);
                employees.add(supervisor);
            }

            // iterate through the rest of the employees in this string
            for (int i = 1; i < idList.length; i++) {

                Employee currentEmployee = null;

                // first check if this employee has already been created

                boolean employeeExists = false;
                for (Employee employee : employees) {
                    if (employee.getEmpId().equals(idList[i])) {

                        // employee exists, set current employee reference to this employee
                        employeeExists = true;
                        currentEmployee = employee;
                    }
                }

                // if employee doesn't exist, create it and add to list
                if (!employeeExists) {
                    currentEmployee = new Employee(idList[i]);

                    // set this employee's supervisor
                    currentEmployee.setSuperior(supervisor);
                    supervisor.addSubordinate(currentEmployee);
                    employees.add(currentEmployee);
                }

                if (!supervisor.getSubordinates().contains(currentEmployee)) {
                    supervisor.addSubordinate(currentEmployee);

                    // make sure this subordinate also has a reference back to this superior
                    if (currentEmployee.getSuperior() == null) {
                        currentEmployee.setSuperior(supervisor);
                    }
                }
            }
        }

        return employees;
    }
}
