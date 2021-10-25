package org.lab.pw.collections.demonstration;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonOverridden;

import java.util.List;

public abstract class CollectionDemonstration {

    private final String demonstrationName;

    public CollectionDemonstration(String demonstrationName){
        this.demonstrationName = demonstrationName;
    }

    public String getDemonstrationName() {
        return demonstrationName;
    }

    public abstract void printStoredNotOverriddenObjects();
    public abstract void printStoredOverriddenObjects();
    public abstract void addNotOverriddenDataObjects(List<Person> dataObjects);
    public abstract void addOverriddenDataObjects(List<PersonOverridden> dataObjects);
    public abstract void removeDataObjects();
}
