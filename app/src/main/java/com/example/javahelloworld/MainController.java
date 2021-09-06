package com.example.javahelloworld;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    protected MongoCollection<Document> documentMongoCollection;

    @GetMapping("/docs")
    @ResponseBody
    public List<Document> test() {
        FindIterable<Document> documents = documentMongoCollection.find();
        MongoCursor<Document> cursor = documents.cursor();

        List<Document> reps = new ArrayList<>();
        while (cursor.hasNext()) {
            Document next = cursor.next();
            reps.add(next);
        }
        return reps;
    }
}
