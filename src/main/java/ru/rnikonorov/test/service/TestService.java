package ru.rnikonorov.test.service;

import org.springframework.dao.DataAccessException;
import ru.rnikonorov.test.TestDB;

import java.util.List;

public interface TestService {
    boolean reset();
    List<TestDB> findAll() throws DataAccessException;
    List<TestDB> findByName(String name) throws DataAccessException;
    boolean save (String name) throws DataAccessException;
}
