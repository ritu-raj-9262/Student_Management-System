package model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBConnection {

    private static MongoClient mongoClient = null;
    private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // Default local MongoDB URI
    private static final String DATABASE_NAME = "StudentDB"; // Your MongoDB database

    // Static block for one-time initialization
    static {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get database instance
    public static MongoDatabase getDatabase() {
        if (mongoClient != null) {
            return mongoClient.getDatabase(DATABASE_NAME);
        }
        return null;
    }

    // Optional: Close Mongo client
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
