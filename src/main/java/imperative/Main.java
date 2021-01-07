package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("John", MALE),
                new Person("pgh", FEMALE),
                new Person("JAne", FEMALE),
                new Person("PAul", MALE),
                new Person("PETER", MALE),
                new Person("MARIA", FEMALE)
        );

        List<Person> females = new ArrayList<>();
        for (Person person : personList) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }
        System.out.println("declaraive /n");
        personList.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("male \n");
        personList.stream()
                .filter(person -> MALE.equals(person.gender))
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
