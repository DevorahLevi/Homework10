package edu.ti.caih313.collections.dataobj;

public class PersonSortable extends Person implements Comparable<PersonSortable>
{
    public PersonSortable(Name name, Gender gender, int age)
    {
        super(name, gender);
        setAge(age);
    }

    @Override
    public int compareTo(PersonSortable otherPersonSortable)
    {
        int compare;
        double age = getAge(), otherAge = otherPersonSortable.getAge();
        Gender gender = getGender(), otherGender = otherPersonSortable.getGender();
        Name name = getName(), otherName = otherPersonSortable.getName();

        if (age < otherAge) {
            compare = -1;
        } else if (age > otherAge) {
           compare = 1;
        } else {  //age is the same
            if (gender != otherGender) //gender is not the same
            {
                if (gender == Gender.FEMALE) {
                    compare = 1;
                } else {
                    compare = -1;
                }
            } else { //gender is the same
                compare = name.getLastName().compareTo(otherName.getLastName());
                if (compare == 0) { //last name is the same
                    compare = name.getFirstName().compareTo(otherName.getFirstName());
                }
            }
        }
        return compare;
    }
}
