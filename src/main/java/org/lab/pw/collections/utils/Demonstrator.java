package org.lab.pw.collections.utils;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonException;
import org.lab.pw.collections.data.PersonOverridden;
import org.lab.pw.collections.demonstration.CollectionDemonstration;

import java.util.ArrayList;
import java.util.List;

public class Demonstrator {

    private List<Person> notOverriddenDataObjects;
    private List<PersonOverridden> overriddenDataObjects;
    private final PersonDataService personDataService;
    private final ConsoleUserDialog consoleUserDialog;
    private final int dataCount;

    public Demonstrator(int dataCount, boolean consistentDataSet) {
        this.dataCount = dataCount;
        this.consoleUserDialog = new ConsoleUserDialog();
        this.personDataService = new RandomPersonDataProvider();
        this.notOverriddenDataObjects = new ArrayList<>();
        this.overriddenDataObjects = new ArrayList<>();
        this.populateDataObjects(consistentDataSet);
    }

    public void startDemonstration(List<CollectionDemonstration> demonstrations) throws InterruptedException {
        for(var demonstration : demonstrations){
            consoleUserDialog.printMessage("#############################################");
            consoleUserDialog.printMessage("Starting demonstration of " + demonstration.getDemonstrationName());
            consoleUserDialog.printMessage("#############################################");
            Thread.sleep(3000);
            consoleUserDialog.printMessage("Demonstration with " + dataCount + " not overridden objects");
            Thread.sleep(3000);
            demonstrateWithObjectMethodsNotOverridden(demonstration);
            Thread.sleep(3000);
            consoleUserDialog.printMessage("#############################################");
            consoleUserDialog.printMessage("Demonstration with " + dataCount + " overridden objects");
            Thread.sleep(3000);
            demonstrateWithObjectMethodsOverridden(demonstration);
            Thread.sleep(3000);
        }

    }

    private void addRemoveTestNotOverriddenObjects(CollectionDemonstration demonstration){
        printNotOverriddenObjectsInputData();
        consoleUserDialog.printMessage("Adding objects...");
        demonstration.addNotOverriddenDataObjects(notOverriddenDataObjects);
        consoleUserDialog.printMessage("Objects in collection: ");
        demonstration.printStoredNotOverriddenObjects();
        consoleUserDialog.printMessage("Removing objects...");
        demonstration.removeDataObjects();
        consoleUserDialog.printMessage("Objects in collection: ");
        demonstration.printStoredNotOverriddenObjects();
    }

    private void addRemoveTestOverriddenObjects(CollectionDemonstration demonstration){
        printOverriddenObjectsInputData();
        consoleUserDialog.printMessage("Adding objects...");
        demonstration.addOverriddenDataObjects(overriddenDataObjects);
        consoleUserDialog.printMessage("Objects in collection: ");
        demonstration.printStoredOverriddenObjects();
        consoleUserDialog.printMessage("Removing objects...");
        demonstration.removeDataObjects();
        consoleUserDialog.printMessage("Objects in collection: ");
        demonstration.printStoredOverriddenObjects();
    }

    private void demonstrateWithObjectMethodsNotOverridden(CollectionDemonstration demonstration){
        addRemoveTestNotOverriddenObjects(demonstration);
    }

    private void demonstrateWithObjectMethodsOverridden(CollectionDemonstration demonstration){
        addRemoveTestOverriddenObjects(demonstration);
    }

    private void printOverriddenObjectsInputData(){
        for(var obj : overriddenDataObjects)
            this.consoleUserDialog.printMessage("| " + obj.toString() + " |");
    }

    private void printNotOverriddenObjectsInputData(){
        for(var obj : notOverriddenDataObjects)
            this.consoleUserDialog.printMessage("| " + obj.toString() + " |");
    }

    private void populateDataObjects(boolean consistentDataSet) {
        try {
            for (int i = 0; i < dataCount; i++){
                Person newPerson = new Person(
                        this.personDataService.getPersonName(),
                        this.personDataService.getPersonLastName());
                PersonOverridden newPersonOverridden;

                if(!consistentDataSet)
                    newPersonOverridden = new PersonOverridden(
                            this.personDataService.getPersonName(),
                            this.personDataService.getPersonLastName());
                else
                    newPersonOverridden = new PersonOverridden(
                            newPerson.getFirstName(),
                            newPerson.getLastName());


                notOverriddenDataObjects.add(newPerson);
                overriddenDataObjects.add(newPersonOverridden);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            this.consoleUserDialog.printErrorMessage("Error while populating data set. Aborting!");
            throw new IllegalStateException("Error while populating data set. Aborting!");
        }

    }
}
