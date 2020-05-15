package edu.ti.caih313.collections.sort;

import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;
import edu.ti.caih313.collections.dataobj.PersonSortable;
import edu.ti.caih313.collections.demo.PrintGeneric;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPersonComparator
{
    public static void main(String... args) {
        Person devorahLevi = new Person(new Name("Devorah", "Levi"), Person.Gender.FEMALE);
        devorahLevi.setAge(19);
        Person chanaLiberman = new Person(new Name ("Chana", "Liberman"), Person.Gender.FEMALE);
        chanaLiberman.setAge(23);
        Person tziporahAtkins = new Person(new Name ("Tziporah", "Atkins"), Person.Gender.FEMALE);
        tziporahAtkins.setAge(19);
        Person chayaMilstein = new Person(new Name ("Chaya", "Milstein"), Person.Gender.FEMALE);
        chayaMilstein.setAge(15);
        Person drMichaelAllen = new Person(new Name ("Dr. Michael", "Allen"), Person.Gender.MALE);
        drMichaelAllen.setAge(50);
        Person siviaHelman = new Person(new Name ("Sivia", "Helman"), Person.Gender.FEMALE);
        siviaHelman.setAge(70);
        Person saraGordon = new Person(new Name ("Sara", "Gordon"), Person.Gender.FEMALE);
        saraGordon.setAge(19);
        Person johnDoe = new Person(new Name ("John", "Doe"), Person.Gender.MALE);
        johnDoe.setAge(19);

        Person nameArray[] = {devorahLevi, chanaLiberman, tziporahAtkins, chayaMilstein, drMichaelAllen,
                                siviaHelman, saraGordon, johnDoe};

        List<Person> nameList = Arrays.asList(nameArray);
        PrintGeneric<Person> sortPersonComparatorDemo = new PrintGeneric<>();
        sortPersonComparatorDemo.printCollection(nameList);

        Comparator<Person> personByAgeGenderName = new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                int compare;
                double person1Age = person1.getAge(), person2Age = person2.getAge();
                Person.Gender person1Gender = person1.getGender(), person2Gender = person2.getGender();
                Name person1Name = person1.getName(), person2Name = person2.getName();

                if (person1Age < person2Age) {
                    compare = -1;
                } else if (person1Age > person2Age) {
                    compare = 1;
                } else {  //age is the same
                    if (person1Gender != person2Gender) //gender is not the same
                    {
                        if (person1Gender == Person.Gender.FEMALE) {
                            compare = -1;
                        } else {
                            compare = 1;
                        }
                    } else { //gender is the same
                        compare = person1Name.getLastName().compareTo(person2Name.getLastName());
                        if (compare == 0) { //last name is the same
                            compare = person1Name.getFirstName().compareTo(person2Name.getFirstName());
                        }
                    }
                }
                return compare;
            }
        };

        Collections.sort(nameList, personByAgeGenderName);
        System.out.print("\n");
        System.out.println("Print sorted by last name nameList.");
        sortPersonComparatorDemo.printCollection(nameList);
    }
}
