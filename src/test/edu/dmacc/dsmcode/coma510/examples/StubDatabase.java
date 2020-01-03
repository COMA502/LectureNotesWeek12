package edu.dmacc.dsmcode.coma510.examples;

public class StubDatabase implements Database {

    private int resultCounter = 0;
    private String[][] results = new String[][] {
            new String[] {"Greg", "2"},
            new String[] {"John", "1"}
    };

    @Override
    public void connect(String name) {
    }

    @Override
    public void closeConnection() {
    }

    @Override
    public void query(String query) {
    }

    @Override
    public String[] getNextResults() {
        if( resultCounter < results.length) {
            String[] result = results[resultCounter];
            resultCounter++;
            return result;
        }
        return null;
    }
}
