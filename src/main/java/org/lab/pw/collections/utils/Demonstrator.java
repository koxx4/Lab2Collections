package org.lab.pw.collections.utils;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonException;
import org.lab.pw.collections.data.PersonOverridden;
import org.lab.pw.collections.demonstration.CollectionDemonstration;

import java.util.List;

public class Demonstrator {

    private List<CollectionDemonstration> demonstrations;
    private List<Person> notOverriddenDataObjects;
    private List<PersonOverridden> overriddenDataObjects;
    private final PersonDataService personDataService;
    private final ConsoleUserDialog consoleUserDialog;
    private int dataCount;

    public Demonstrator(List<CollectionDemonstration> demonstrations, int dataCount, boolean consistentDataSet) {
        this.demonstrations = demonstrations;
        consoleUserDialog = new ConsoleUserDialog();
        this.personDataService = new RandomPersonDataProvider();
        this.populateDataObjects();
    }

    public void startDemonstration() throws InterruptedException {
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
        demonstration.printStoredOverriddenObjects();
        consoleUserDialog.printMessage("Removing objects...");
        demonstration.removeDataObjects();
        consoleUserDialog.printMessage("Objects in collection: ");
        demonstration.printStoredOverriddenObjects();
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

    private void populateDataObjects() {

        try {
            for (int i = 0; i < dataCount; i++){
                notOverriddenDataObjects.add(new Person(
                        this.personDataService.getPersonName(),
                        this.personDataService.getPersonLastName()));
                overriddenDataObjects.add(new PersonOverridden(
                        this.personDataService.getPersonName(),
                        this.personDataService.getPersonLastName()));
            }
        }
        catch (PersonException personException){
            personException.printStackTrace();
            this.consoleUserDialog.printErrorMessage("Error while populating data set. Aborting!");
            throw new IllegalStateException("Error while populating data set. Aborting!");
        }

    }
}
