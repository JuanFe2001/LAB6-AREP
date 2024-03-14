package edu.eci.awsprimerlogservice;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class ConnectionDB {
    private static final String CONNECTION_STRING = "mongodb://MongoDB:27017";
    private static final String DATABASE_NAME = "Taller6DB";

  
    public static MongoDatabase getDB() {
        MongoClient client = MongoClients.create(CONNECTION_STRING);
        return client.getDatabase(DATABASE_NAME);
    }
}
