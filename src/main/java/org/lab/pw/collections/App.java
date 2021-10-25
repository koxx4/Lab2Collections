package org.lab.pw.collections;

import org.lab.pw.collections.demonstration.*;
import org.lab.pw.collections.utils.ConsoleUserDialog;
import org.lab.pw.collections.utils.Demonstrator;

import java.util.Collection;
import java.util.List;

public class App {

    public static void main( String[] args ) {
        Demonstrator demonstrator = new Demonstrator(4, true);
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
