package org.lab.pw.collections.utils;

import org.lab.pw.collections.data.Person;
import org.lab.pw.collections.data.PersonOverridden;
import org.lab.pw.collections.demonstration.CollectionDemonstration;

import java.util.ArrayList;
import java.util.List;

public class Demonstrator {

    private List<Person> notOverriddenDataObjects;
    private List<PersonOverridden> overriddenDataObjects;
    private final PersonDataService personDataService;
    private final ConsoleUserDialog consoleUserDialog;
    private final DemonstratorOptions options;

    public Demonstrator(DemonstratorOptions options) {
        this.options = options;
        this.consoleUserDialog = new ConsoleUserDialog();
        this.personDataService = new RandomPersonDataProvider();
        this.notOverriddenDataObjects = new ArrayList<>();
        this.overriddenDataObjects = new ArrayList<>();
        this.populateDataObjects();
    }

    public void startDemonstration(List<CollectionDemonstration> demonstrations) throws InterruptedException {
        printExecutionFlags();
        for(var demonstration : demonstrations){
            consoleUserDialog.printMessage("#############################################");
            consoleUserDialog.printMessage("Starting demonstration of " + demonstration.getDemonstrationName());
            consoleUserDialog.printMessage("#############################################");
            Thread.sleep(3000);
            consoleUserDialog.printMessage("Demonstration with " + options.getDataSetSize() + " not overridden objects");
            Thread.sleep(3000);
            demonstrateWithObjectMethodsNotOverridden(demonstration);
            Thread.sleep(3000);
            consoleUserDialog.printMessage("#############################################");
            consoleUserDialog.printMessage("Demonstration with " + options.getDataSetSize() + " overridden objects");
            Thread.sleep(3000);
            demonstrateWithObjectMethodsOverridden(demonstration);
            Thread.sleep(3000);
        }

    }

    private void printExecutionFlags(){
        consoleUserDialog.printMessage("Test with: " + options.toString());
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

    private void populateDataObjects() {
        try {
            for (int i = 0; i < options.getDataSetSize(); i++){

                Person newPerson = new Person(
                        this.personDataService.getPersonName(),
                        this.personDataService.getPersonLastName());
                PersonOverridden newPersonOverridden;

                if(!options.isDataConsistent())
                    newPersonOverridden = new PersonOverridden(
                            this.personDataService.getPersonName(),
                            this.personDataService.getPersonLastName());
                else
                    newPersonOverridden = new PersonOverridden(newPerson);

                notOverriddenDataObjects.add(newPerson);
                overriddenDataObjects.add(newPersonOverridden);

                if(options.isAreDeepDuplicatedValuesGuaranteed() && options.getDataSetSize() - 1 != i){
                    //Deep copy of persons
                    notOverriddenDataObjects.add(new Person(newPerson));
                    overriddenDataObjects.add(new PersonOverridden(newPersonOverridden));
                    //If we explicitly added another data object we must increment our loop counter
                    i++;
                }

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalStateException("Error while populating data set. Aborting!");
        }

    }
}
