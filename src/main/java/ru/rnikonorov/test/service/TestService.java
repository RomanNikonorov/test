package ru.rnikonorov.test.service;

import ru.rnikonorov.test.TestDB;

import java.util.List;

public interface TestService {
    void reset();
    List<TestDB> findAll();
    List<TestDB> findByName(String name);
    void save (String name);
}
