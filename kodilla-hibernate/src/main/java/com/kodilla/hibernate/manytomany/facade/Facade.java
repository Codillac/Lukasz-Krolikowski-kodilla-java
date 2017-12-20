package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class Facade {
    private static final Logger LOGGER = LoggerFactory.getLogger(Facade.class);

    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Company> searchCompany(final String nameFragment) throws SearchException {
        List<Company> searchResult = new ArrayList<>();
        LOGGER.info("Starting search for Companies");
        if (nameFragment == null) {
            LOGGER.error(SearchException.ERR_EMPTY_QUERY);
            throw new SearchException(SearchException.ERR_EMPTY_QUERY);
        }
        LOGGER.info("Query is correct");
        try {
            searchResult = companyDao.retrieveByAnyLettersOfCompanyName(nameFragment);
        } catch (Exception e) {
            throw new SearchException(SearchException.ERR_SEARCH_PROCESSOR_ERROR + ": " + e);
        }
        LOGGER.info("Query has been retrieved correctly");
        if (searchResult.size() == 0) {
            throw new SearchException(SearchException.ERR_NO_MATCH);
        }
        return searchResult;
    }

    public List<Employee> searchEmployee(final String nameFragment) throws SearchException {
        List<Employee> searchResult = new ArrayList<>();
        LOGGER.info("Starting search for Employees");
        if (nameFragment == null) {
            LOGGER.error(SearchException.ERR_EMPTY_QUERY);
            throw new SearchException(SearchException.ERR_EMPTY_QUERY);
        }
        LOGGER.info("Query is correct");
        try {
            searchResult = employeeDao.retrieveByAnyLettersOfEmployeeName(nameFragment);
        } catch (Exception e) {
            throw new SearchException(SearchException.ERR_SEARCH_PROCESSOR_ERROR + ": " + e);
        }
        LOGGER.info("Query has been retrieved correctly");
        if (searchResult.size() == 0) {
            throw new SearchException(SearchException.ERR_NO_MATCH);
        }
        return searchResult;
    }
}
