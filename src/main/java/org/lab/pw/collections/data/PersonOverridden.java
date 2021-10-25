package org.lab.pw.collections.data;

import java.util.Objects;

public class PersonOverridden extends Person implements Comparable<Person>{

    public PersonOverridden(String first_name, String last_name) throws PersonException {
        super(first_name, last_name);
    }

    public PersonOverridden(Person person) throws PersonException {
        super(person);
    }

    @Override
    public int compareTo(Person person) {
        if(person == null)
            throw new NullPointerException();

        String otherPersonWholeName = person.getFirstName() + " " + person.getLastName();
        String thisPersonWholeName = super.getFirstName() + " " + super.getLastName();
        return thisPersonWholeName.compareTo(otherPersonWholeName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonOverridden person = (PersonOverridden) o;
        return getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getFirstName(), super.getLastName());
    }
}
