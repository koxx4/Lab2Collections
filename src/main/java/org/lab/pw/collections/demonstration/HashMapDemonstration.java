package org.lab.pw.collections.demonstration;

import org.lab.pw.collections.data.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDemonstration extends CollectionDemonstration{

    private Map<Integer, Person> data;

    public HashMapDemonstration(int dataCount) {
        super("HashMap demonstration", dataCount);
        data = new HashMap<>(dataCount);
    }

    @Override
    protected void printDataObjects() {
        for(var dataKey : data.keySet())
            System.out.print("| " + dataKey + " : "+ data.get(dataKey) + " |");
    }

    @Override
    protected void addDataObjects(List<Person> dataObjects) {
        int key = 0;
        for(var dataObject : dataObjects){
            this.data.put(key, dataObject);
            key++;
        }

    }

    @Override
    protected void removeDataObjects() {
        this.data.clear();
    }
}
