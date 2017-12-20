package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {
    @Autowired
    Facade facade;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Before
    public void createData() {
        Employee employee1 = new Employee("John", "Kovalsky");
        Employee employee2 = new Employee("John", "Malkovitch");
        Employee employee3 = new Employee("Marry", "Novak");
        Employee employee4 = new Employee("Tycyan", "Kovalsky");

        Company company1 = new Company("Microsoft");
        Company company2 = new Company("Apple");
        Company company3 = new Company("MickeyMouse");
        Company company4 = new Company("Michelin");
        Company company5 = new Company("Milestone");
        Company company6 = new Company("Check Mic");

        employee1.getCompanies().add(company1);
        employee1.getCompanies().add(company2);
        employee1.getCompanies().add(company3);
        employee1.getCompanies().add(company4);
        employee1.getCompanies().add(company5);
        employee1.getCompanies().add(company6);

        company1.getEmployees().add(employee1);
        company2.getEmployees().add(employee1);
        company3.getEmployees().add(employee1);
        company4.getEmployees().add(employee1);
        company5.getEmployees().add(employee1);
        company6.getEmployees().add(employee1);

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        employeeDao.save(employee4);
    }

    @After
    public void cleanUp() {
        //CleanUp
        try {
            for (int i = 1; i <= 6; i++) {
                companyDao.delete(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void searchForCompanyTest() {
        //Given
        String searchPhrase = "le";

        //When
        List<Company> resultList = new ArrayList<>();
        try {
            resultList = facade.searchCompany(searchPhrase);
            for (Company resultCompany : resultList) {
                System.out.println(resultCompany.getName());
            }
        } catch (SearchException e) {
            System.out.println(e);
        }

        //Then
        Assert.assertEquals(2, resultList.size());
    }

    @Test
    public void searchForEmployeeTest() {
        //Given
        String searchPhrase = "rr";

        //When
        List<Employee> resultList = new ArrayList<>();
        try {
            resultList = facade.searchEmployee(searchPhrase);
            for (Employee resultEmployee : resultList) {
                System.out.println(resultEmployee.getFirstname() + " " + resultEmployee.getLastname());
            }
        } catch (SearchException e) {
            System.out.println(e);
        }

        //Then
        Assert.assertEquals(1, resultList.size());
    }
}