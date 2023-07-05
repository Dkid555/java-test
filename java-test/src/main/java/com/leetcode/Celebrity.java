package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Celebrity - is a guy who knows nobody, but everyone knows him
public class Celebrity {

    public static Persons findCeleb(Persons[] persons) {

        int begin = 0, end = persons.length - 1;
        while (begin != end) {
            if (persons[begin].knows(persons[end].getPerson())) {
                begin++;
            } else {
                end--;
            }
        }
        for (int i = 0; i < persons.length; i++) {
            if (persons[begin].getWHOknows().contains(persons[i])) {
                System.out.println("There is no celebrity");
                return null;
            }
        }
        return persons[end];
    }


    public static void main(String[] args) {
        Persons Alexey = new Persons("Alexey");
        Persons Michail = new Persons("Michail");
        Persons Igor = new Persons("Igor");
        Persons Oleg = new Persons("Oleg");
        Persons Evgeniy = new Persons("Evgeniy");
        Persons Dmitrii = new Persons("Dmitrii");

        Alexey.addWhoheknow(Arrays.asList(Michail, Igor, Oleg, Dmitrii, Evgeniy));
        Michail.addWhoheknow(Arrays.asList(Alexey, Evgeniy, Oleg, Dmitrii));
        Igor.addWhoheknow(Arrays.asList(Oleg, Evgeniy, Dmitrii));
        Oleg.addWhoheknow(Arrays.asList(Dmitrii, Evgeniy));
        Dmitrii.addWhoheknow(Arrays.asList(Evgeniy));
        System.out.println(findCeleb(new Persons[]{Alexey, Michail, Igor, Oleg, Dmitrii, Evgeniy}).getPerson());
//        int l;
//
//        System.out.println(Dmitrii.knows(Oleg.getPerson()));
    }
}

class Persons {
    public Persons(String person) {
        this.Person = person;
    }

    public void addWhoheknow(List<Persons> person) {
        this.WHOknows.addAll(person);
    }

    public String getPerson() {
        return Person;
    }

    public List<Persons> getWHOknows() {
        return WHOknows;
    }

    public boolean knows(String name) {
        for (Persons person : this.WHOknows) {
            if (person.getPerson().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String Person;
    public List<Persons> WHOknows = new ArrayList<>();
}