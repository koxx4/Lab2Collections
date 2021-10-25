package org.lab.pw.collections.demonstration;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonException;
import org.lab.pw.collections.data.PersonOverrode;
import org.lab.pw.collections.utils.ConsoleUserDialog;
import org.lab.pw.collections.utils.PersonDataService;
import org.lab.pw.collections.utils.RandomPersonDataProvider;

import java.util.ArrayList;
import java.util.List;

public abstract class CollectionDemonstration {

    private final String demonstrationName;
    private final ConsoleUserDialog consoleUserDialog;
    private final PersonDataService personDataService;
    private final int dataCount;

    private List<Person> notOverriddenDataObjects;
    private List<Person> overriddenDataObjects;

    public CollectionDemonstration(String demonstrationName, int dataCount){
        this.demonstrationName = demonstrationName;
        this.consoleUserDialog = new ConsoleUserDialog();
        this.dataCount = dataCount;
        this.personDataService = new RandomPersonDataProvider();
        this.notOverriddenDataObjects = new ArrayList<>(dataCount);
        this.overriddenDataObjects = new ArrayList<>(dataCount);
        this.populateDataObjects();
    }

    public void startDemonstration(){
        consoleUserDialog.printMessage("#############################################");
        consoleUserDialog.printMessage("Starting demonstration of " + demonstrationName);
        consoleUserDialog.printMessage("#############################################");
        consoleUserDialog.printMessage("Demonstration with " + dataCount + " not overridden objects");
        this.demonstrateWithObjectMethodsNotOverridden();
        consoleUserDialog.printMessage("#############################################");
        consoleUserDialog.printMessage("Demonstration with " + dataCount + " overridden objects");
        this.demonstrateWithObjectMethodsOverridden();
    }

    public ConsoleUserDialog getConsoleUserDialog() {
        return consoleUserDialog;
    }

    public int getDataCount() {
        return dataCount;
    }

    private void addRemoveTest(List<Person> dataObjects){
        consoleUserDialog.printMessage("Adding objects...");
        addDataObjects(dataObjects);
        consoleUserDialog.printMessage("Objects in collection: ");
        printDataObjects();
        consoleUserDialog.printMessage("Removing objects...");
        removeDataObjects();
        consoleUserDialog.printMessage("Objects in collection: ");
        printDataObjects();
    }

    private void demonstrateWithObjectMethodsNotOverridden(){
        addRemoveTest(this.notOverriddenDataObjects);
    }

    private void demonstrateWithObjectMethodsOverridden(){
        addRemoveTest(this.overriddenDataObjects);
    }

    private void populateDataObjects() {

        try {
            for (int i = 0; i < dataCount; i++){
                notOverriddenDataObjects.add(new Person(
                        this.personDataService.getPersonName(),
                        this.personDataService.getPersonLastName()));
                overriddenDataObjects.add(new PersonOverrode(
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

    protected abstract void printDataObjects();
    protected abstract void addDataObjects(List<Person> dataObjects);
    protected abstract void removeDataObjects();
}
