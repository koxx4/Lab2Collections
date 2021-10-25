package org.lab.pw.collections.demonstrable;

import org.lab.pw.collections.data.Person;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemonstration implements CollectionDemonstration{

    private List dataSet;

    public ArrayListDemonstration(){
        dataSet = new ArrayList();
    }

    @Override
    public void demonstrateWithObjectMethodsNotOverrode() {
        dataSet.add(new Person(""))
    }

    @Override
    public void demonstrateWithObjectMethodsOverrode() {

    }
}
