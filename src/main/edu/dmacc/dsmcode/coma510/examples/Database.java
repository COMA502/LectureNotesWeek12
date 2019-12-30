package edu.dmacc.dsmcode.coma510.examples;

public interface Database {
    public void connect(String name);

    public void closeConnection();

    public void query(String query);

    public String[] getNextResults();
}
