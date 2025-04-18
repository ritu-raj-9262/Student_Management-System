package model;

import bean.Student;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private final MongoCollection<Document> studentCollection;

    public StudentDAO() {
        String uri = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("studentdb");
        studentCollection = database.getCollection("students");
    }

    public void addStudent(Student student) {
        Document doc = new Document("rollno", student.getRollno())
                .append("name", student.getName())
                .append("email", student.getEmail())
                .append("course", student.getCourse())
                .append("marks", student.getMarks());
        studentCollection.insertOne(doc);
    }

    public void deleteStudent(String id) {
        studentCollection.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        FindIterable<Document> docs = studentCollection.find();

        for (Document doc : docs) {
            Student s = new Student();
            s.setId(doc.getObjectId("_id").toHexString());
            s.setRollno(doc.getString("rollno"));
            s.setName(doc.getString("name"));
            s.setEmail(doc.getString("email"));
            s.setCourse(doc.getString("course"));
            s.setMarks(doc.getInteger("marks", 0));
            studentList.add(s);
        }

        return studentList;
    }
}