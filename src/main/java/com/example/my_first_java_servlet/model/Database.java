package com.example.my_first_java_servlet.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {

    private static List<Company> companies = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static int autoIncrementKey = 1;

    static {
        User admin = new User("admin", "admin");
        users.add(admin);
    }

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

    public User findOneUser(String login, String password) {
        for(User user : Database.users) {
            if(user.validate(login, password))
                return user;
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
