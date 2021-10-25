package org.lab.pw.collections;

import org.lab.pw.collections.demonstration.*;
import org.lab.pw.collections.utils.Demonstrator;
import org.lab.pw.collections.utils.DemonstratorOptions;

import java.util.*;

public class App {


    public static void main( String[] args ) {

        DemonstratorOptions options = new DemonstratorOptions();
        options.setDataSetSize(5);
        options.setAreDeepDuplicatedValuesGuaranteed(true);
        options.setDataConsistent(true);

        Demonstrator demonstrator = new Demonstrator(options);
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
        } finally {
            System.exit(0);
        }
    }
}
