package com.example.my_first_java_servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {

    private static List<Company> companies = new ArrayList<>();
    private static int autoIncrementKey = 1;

    public void create(Company company) {
        company.setId(Database.autoIncrementKey++);
        Database.companies.add(company);
    }

    public List<Company> findAll() {
        return Database.companies;
    }

    public Company findOne(int id) {
        for(Company company : Database.companies) {
            if(company.getId() == id)
                return company;
        }

        return null;
    }

    public void updateOne(int id, Company updatedCompany) {
        Company company = findOne(id);
        company.setName(updatedCompany.getName());
        company.setCreatedAt(updatedCompany.getCreatedAt());
    }

    public void removeById(int id) {
        Iterator<Company> it = Database.companies.iterator();

        while(it.hasNext()) {
            Company company = it.next();

            if(company.getId() == id)
                it.remove();
        }
    }

}
