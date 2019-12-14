package com.example.tjws;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Party {

    private List<Person> peopleList;

    private Party(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    public static Party of(Person... people) {
        return new Party(Arrays.asList(people));
    }

    public int getNumberOfPeople() {
        return peopleList.size();
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(peopleList);
    }
}
