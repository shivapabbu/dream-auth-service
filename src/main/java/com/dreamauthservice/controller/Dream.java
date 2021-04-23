package com.dreamauthservice.controller;

import com.dreamauthservice.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Dream {

    public static <T> Predicate<T> distinctByBabu(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static void main(String args[]){

        List<Person> persons = getPersons();

        System.out.println(persons.stream().filter(distinctByBabu(Person::getPhone)));

    }

    private static List<Person> getPersons() {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Babu", "Naga", String.valueOf(9)));
        for(int i=0; i<10; i++){
            persons.add(new Person("Babu", "Naga", String.valueOf(i)));
        }

                return persons;
    }
}
