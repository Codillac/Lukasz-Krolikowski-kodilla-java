package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testRetrieveByEmployeeLastName() {
        //Given
        final int NUMBER_OF_EMPLOYEES = 3;
        Employee employee1 = new Employee("John", "Kovalsky");
        Employee employee2 = new Employee("Marry", "Novak");
        Employee employee3 = new Employee("Tycyan", "Kovalsky");

        Company company = new Company("Microsoft");

        employee1.getCompanies().add(company);
        employee2.getCompanies().add(company);
        employee3.getCompanies().add(company);

        company.getEmployees().add(employee1);
        company.getEmployees().add(employee2);
        company.getEmployees().add(employee3);

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        //When
        List<Employee> resultList = employeeDao.retrieveByEmployeeLastname("Kovalsky");
        for (Employee resultEmployee : resultList) {
            System.out.println(resultEmployee.getFirstname() + " " + resultEmployee.getLastname());
        }

        //Then
        Assert.assertEquals(2, resultList.size());

        //CleanUp
        try {
            for (int i = 1; i <= NUMBER_OF_EMPLOYEES; i++) {
                employeeDao.delete(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testRetrieveByFirstThreeLettersOfCompanyName() {
        //Given
        final int NUMBER_OF_COMPANIES = 6;
        Employee employee = new Employee("John", "Kovalsky");

        Company company1 = new Company("Microsoft");
        Company company2 = new Company("Apple");
        Company company3 = new Company("MickeyMouse");
        Company company4 = new Company("Michelin");
        Company company5 = new Company("Milestone");
        Company company6 = new Company("Check Mic");

        employee.getCompanies().add(company1);
        employee.getCompanies().add(company2);
        employee.getCompanies().add(company3);
        employee.getCompanies().add(company4);
        employee.getCompanies().add(company5);
        employee.getCompanies().add(company6);

        company1.getEmployees().add(employee);
        company2.getEmployees().add(employee);
        company3.getEmployees().add(employee);
        company4.getEmployees().add(employee);
        company5.getEmployees().add(employee);
        company6.getEmployees().add(employee);

        //When
        employeeDao.save(employee);

//        companyDao.save(company1);
//        companyDao.save(company2);
//        companyDao.save(company3);
//        companyDao.save(company4);
//        companyDao.save(company5);
//        companyDao.save(company6);

        List<Company> resultList = companyDao.retrieveByFirstThreeLettersOfCompanyName("Mic");

        for (Company resultCompany : resultList) {
            System.out.println(resultCompany.getName());
        }

        //Then
        Assert.assertEquals(3, resultList.size());

        //CleanUp
        try {
            for (int i = 1; i <= NUMBER_OF_COMPANIES; i++) {
                companyDao.delete(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
