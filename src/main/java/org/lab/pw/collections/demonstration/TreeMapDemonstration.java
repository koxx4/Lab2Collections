package org.lab.pw.collections.demonstration;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonOverridden;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemonstration extends CollectionDemonstration{

    private final Map<Integer, Person> data;
    private final Map<Integer, PersonOverridden> dataOverridden;

    public TreeMapDemonstration() {
        super("TreeMap demonstration");
        data = new TreeMap<>();
        dataOverridden = new TreeMap<>();
    }

    @Override
    public void printStoredNotOverriddenObjects() {
        for(var dataKey : data.keySet())
            System.out.print("| " + dataKey + " : "+ data.get(dataKey) + " |");
    }

    @Override
    public void printStoredOverriddenObjects() {
        for(var dataKey : dataOverridden.keySet())
            System.out.print("| " + dataKey + " : "+ dataOverridden.get(dataKey) + " |");
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
