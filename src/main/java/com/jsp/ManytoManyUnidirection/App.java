package com.jsp.ManytoManyUnidirection;

import java.util.ArrayList;
import java.util.List;

import com.jsp.ManytoManyUnidirection.dao.PersonDao;
import com.jsp.ManytoManyUnidirection.dta.Language;
import com.jsp.ManytoManyUnidirection.dta.Person;

public class App {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        Language lang1 = new Language();
        lang1.setName("Kannada");
        lang1.setOrigin("Karnataka");

        Language lang2 = new Language();
        lang2.setName("Telugu");
        lang2.setOrigin("Andhra Pradesh");

        // Save the languages first
        personDao.saveLanguage(lang1);
        personDao.saveLanguage(lang2);

        List<Language> l1 = new ArrayList<>();
        l1.add(lang1);
        l1.add(lang2);

        List<Language> l2 = new ArrayList<>();
        l2.add(lang2);

        Person p1 = new Person();
        p1.setName("Omkar");
        p1.setAge(26);
        p1.setList(l1);

        Person p2 = new Person();
        p2.setName("Krishna");
        p2.setAge(89);
        p2.setList(l2);

        // Now save the persons with the already persisted languages
        personDao.saveperson(p1);
        personDao.saveperson(p2);
    }
}
