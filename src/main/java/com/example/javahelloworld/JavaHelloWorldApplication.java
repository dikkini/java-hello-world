package com.example.javahelloworld;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class JavaHelloWorldApplication {

    @Value("${mongodb.host}")
    protected String mongodbHost;
    @Value("${mongodb.port}")
    protected int mongodbPort;
    @Value("${mongodb.db}")
    protected String mongoDbDatabase;
    @Value("${mongodb.collection}")
    protected String mongoDbCollection;

    public static void main(String[] args) {
        SpringApplication.run(JavaHelloWorldApplication.class, args);
    }

    @Bean
    public MongoCollection<Document> userMongoCollection() {
        MongoClient mongoClient = new MongoClient(mongodbHost, mongodbPort);
        MongoDatabase test = mongoClient.getDatabase(mongoDbDatabase);
        MongoCollection<Document> collection = test.getCollection(mongoDbCollection);
        return collection;
    }
}
