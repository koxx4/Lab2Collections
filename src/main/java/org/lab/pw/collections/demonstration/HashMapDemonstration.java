package org.lab.pw.collections.demonstration;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonOverridden;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDemonstration extends CollectionDemonstration{

    private final Map<Integer, Person> data;
    private final Map<Integer, PersonOverridden> dataOverridden;

    public HashMapDemonstration() {
        super("HashMap demonstration");
        data = new HashMap<>();
        dataOverridden = new HashMap<>();
    }

    @Override
    public void printStoredNotOverriddenObjects() {
        for(var dataKey : data.keySet())
            System.out.println("| " + dataKey + " : "+ data.get(dataKey) + " |");
    }

    @Override
    public void printStoredOverriddenObjects() {
        for(var dataKey : dataOverridden.keySet())
            System.out.println("| " + dataKey + " : "+ dataOverridden.get(dataKey) + " |");
    }

    @Override
    public void addNotOverriddenDataObjects(List<Person> dataObjects) {
        int key = 0;
        for(var dataObject : dataObjects){
            this.data.put(key, dataObject);
            key++;
        }
    }

    @Override
    public void addOverriddenDataObjects(List<PersonOverridden> dataObjects) {
        int key = 0;
        for(var dataObject : dataObjects){
            this.dataOverridden.put(key, dataObject);
            key++;
        }
    }

    @Override
    public void removeDataObjects() {
        this.data.clear();
        this.dataOverridden.clear();
    }
}
