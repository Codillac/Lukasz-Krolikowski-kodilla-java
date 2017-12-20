package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void searchForCompanyTest() throws Exception {
        //Given
        String searchPhrase = "le";

        //When
        List<Company> resultList = facade.searchCompany(searchPhrase);

        //Then
        Assert.assertEquals(2, resultList.size());
    }

    @Test
    public void searchForEmployeeTest() throws Exception {
        //Given
        String searchPhrase = "rr";

        //When
        List<Employee> resultList = facade.searchEmployee(searchPhrase);

        //Then
        Assert.assertEquals(1, resultList.size());
    }

    @Test(expected = SearchException.class)
    public void searchForCompanyTestException() throws Exception {
        //Given
        String searchPhrase = "aa";

        //When
        facade.searchCompany(searchPhrase);

        //Then
        //exception is thrown
    }

    @Test(expected = SearchException.class)
    public void searchForEmployeeTestException() throws Exception {
        //Given
        String searchPhrase = "aa";

        //When
        facade.searchEmployee(searchPhrase);

        //Then
        //exception is thrown
    }
}