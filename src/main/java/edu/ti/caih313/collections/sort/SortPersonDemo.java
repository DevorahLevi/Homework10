package edu.ti.caih313.collections.sort;

import edu.ti.caih313.collections.dataobj.NameByLast;
import edu.ti.caih313.collections.dataobj.Person;
import edu.ti.caih313.collections.dataobj.PersonSortable;
import edu.ti.caih313.collections.demo.PrintGeneric;
import edu.ti.caih313.collections.dataobj.Name;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortPersonDemo
{
    public static void main(String... args)
    {
        PersonSortable nameArray[] = {
                new PersonSortable(new Name("Devorah", "Levi"), Person.Gender.FEMALE, 19),
                new PersonSortable(new Name ("Chana", "Liberman"), Person.Gender.FEMALE, 23),
                new PersonSortable(new Name ("Tziporah", "Atkins"), Person.Gender.FEMALE, 19),
                new PersonSortable(new Name ("Chaya", "Milstein"), Person.Gender.FEMALE, 15),
                new PersonSortable(new Name ("Dr. Michael", "Allen"), Person.Gender.MALE, 50) ,
                new PersonSortable(new Name ("Sivia", "Helman"), Person.Gender.FEMALE, 70),
                new PersonSortable(new Name ("Sara", "Gordon"), Person.Gender.FEMALE, 19),
                new PersonSortable(new Name ("John", "Doe"), Person.Gender.MALE, 19)
        };

        List<PersonSortable> nameList = Arrays.asList(nameArray);

        PrintGeneric<PersonSortable> nameSortDemo = new PrintGeneric<>();
        nameSortDemo.printCollection(nameList);
        Collections.sort(nameList);
        System.out.print("\n");
        System.out.println("Print sorted nameList.");
        nameSortDemo.printCollection(nameList);
    }
}
