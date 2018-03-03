package com.gmail.herman.uladzimir.project.model.factory;

import com.gmail.herman.uladzimir.project.model.entity.Person;
import com.gmail.herman.uladzimir.project.model.functional.PersonInitializer;

public class PersonFactory {

    public static Person createPerson() {
        return new Person(PersonInitializer.initializeName(),
                PersonInitializer.initializeSurname(), PersonInitializer.initializeAge());
    }

}