package edu.dmacc.dsmcode.coma510.examples;

public class FakeNamingService implements NamingService {
    @Override
    public String getDatabaseName() {
        return "COMA502_Database";
    }
}
