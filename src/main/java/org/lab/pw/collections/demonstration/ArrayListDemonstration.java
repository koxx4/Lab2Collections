package org.lab.pw.collections.demonstration;

import org.lab.pw.collections.data.Person;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemonstration extends CollectionDemonstration{

    private List<Person> data;

    public ArrayListDemonstration(int dataCount) {
        super("ArrayList demonstration", dataCount);
        data = new ArrayList<>(dataCount);
    }

    @Override
    protected void printDataObjects() {
        for(var dataObject : data)
            System.out.print("| " + dataObject.toString() + " |");
    }

    @Override
    protected void addDataObjects(List<Person> dataObjects) {
        this.data.addAll(dataObjects);
    }

    @Override
    protected void removeDataObjects() {
        this.data.clear();
    }
}
