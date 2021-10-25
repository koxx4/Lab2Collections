package org.lab.pw.collections.demonstration;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonOverridden;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemonstration extends CollectionDemonstration{

    private final List<Person> data;
    private final List<PersonOverridden> dataOverridden;

    public ArrayListDemonstration() {
        super("ArrayList demonstration");
        data = new ArrayList<>();
        dataOverridden = new ArrayList<>();
    }

    @Override
    public void printStoredNotOverriddenObjects() {
        for(var dataObject : data)
            System.out.println("| " + dataObject.toString() + " |");
    }

    @Override
    public void printStoredOverriddenObjects() {
        for(var dataObject : dataOverridden)
            System.out.println("| " + dataObject.toString() + " |");
    }

    @Override
    public void addNotOverriddenDataObjects(List<Person> dataObjects) {
        this.data.addAll(dataObjects);
    }

    @Override
    public void addOverriddenDataObjects(List<PersonOverridden> dataObjects) {
        this.dataOverridden.addAll(dataObjects);
    }

    @Override
    public void removeDataObjects() {
        this.data.clear();
        this.dataOverridden.clear();
    }
}
