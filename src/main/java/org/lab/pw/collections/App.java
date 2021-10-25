package org.lab.pw.collections;

import org.lab.pw.collections.demonstration.*;
import org.lab.pw.collections.utils.Demonstrator;

import java.util.List;

public class App {

    static int DATA_SET_SIZE = 10;
    static boolean IS_DATA_SET_CONSISTENT = true;

    public static void main( String[] args ) {
        Demonstrator demonstrator = new Demonstrator(DATA_SET_SIZE, IS_DATA_SET_CONSISTENT);
        try{
            demonstrator.startDemonstration(List.of(
                    new ArrayListDemonstration(),
                    new LinkedListDemonstration(),
                    new HashSetDemonstration(),
                    new TreeSetDemonstration(),
                    new HashMapDemonstration(),
                    new TreeMapDemonstration()));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.exit(0);
    }
}
