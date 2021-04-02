package com.example.my_first_java_servlet;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static List<Company> companies = new ArrayList<>();

    public void add(Company company) {
        Database.companies.add(company);
    }

    public List<Company> getAll() {
        return Database.companies;
    }

}
