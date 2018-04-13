package com.example.admin.orgcharttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.orgcharttest.model.Employee;
import com.example.admin.orgcharttest.utils.EmployeeUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args) {
        String[] inputData = {"B2,E5,F6", "A1,B2,C3,D4", "D4,G7,I9", "G7,H8"};
        List<Employee> employees = EmployeeUtils.parseEmployees(inputData);

        for (Employee employee : employees) {
            if (employee.getSuperior() == null) {
                System.out.println(employee.getEmpId());
                employee.printTree(employee.getSubordinates(), 1);
            }
        }
    }
}
