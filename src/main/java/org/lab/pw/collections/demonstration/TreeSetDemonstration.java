package org.lab.pw.collections.demonstration;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonOverridden;

import java.util.*;

public class TreeSetDemonstration extends CollectionDemonstration{

    private final Set<Person> data;
    private final Set<PersonOverridden> dataOverridden;

    public TreeSetDemonstration() {
        super("HashSet demonstration");
        data = new TreeSet<>();
        dataOverridden = new TreeSet<>();
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
