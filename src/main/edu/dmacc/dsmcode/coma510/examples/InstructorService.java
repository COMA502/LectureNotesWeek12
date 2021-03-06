package edu.dmacc.dsmcode.coma510.examples;

import java.util.ArrayList;
import java.util.List;

public class InstructorService {

    Database instructorDatabase;

    public InstructorService(NamingService namingService, Database instructorDatabase) {
        this.instructorDatabase = instructorDatabase;

        instructorDatabase.connect(namingService.getDatabaseName());
    }

    public List<String> getInstructorNames() {
        try {
            instructorDatabase.query("get all instructors");
            ArrayList<String> names = new ArrayList<>();

            String[] nextResults = instructorDatabase.getNextResults();
            while (nextResults != null) {
                String name = nextResults[0];
                names.add(name);

                nextResults = instructorDatabase.getNextResults();
            }

            return names;
        } finally {
            instructorDatabase.closeConnection();
        }
    }
}
