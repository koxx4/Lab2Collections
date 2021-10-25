package org.lab.pw.collections.utils;

import org.lab.pw.collections.utils.PersonDataService;

import java.util.Random;

public class RandomPersonDataProvider implements PersonDataService {

    private final String[] names = {"Gareth", "Lorelle", "Demetris" };
    private final String[] lastNames = {"Elbourn", "Rampton", "McManamon"};
    private final String[] jobs = {"General Manager", "Help Desk Operator", "Dental Hygienist"};
    private final Random random = new Random();

    @Override
    public String getPersonName() {
        return names[random.nextInt(names.length)];
    }

    @Override
    public String getPersonLastName() {
        return lastNames[random.nextInt(lastNames.length)];
    }

    @Override
    public String getPersonJobName() {
        return jobs[random.nextInt(jobs.length)];
    }
}
