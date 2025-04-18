package rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/students")
public class StudentAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStudents() {
        // For now, just return a sample response
        String sample = "[{\"name\":\"Rahul\",\"rollNo\":\"101\",\"course\":\"MCA\"}]";
        return Response.ok(sample).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudent(String studentJson) {
        // You can parse the JSON and save it to MongoDB here
        return Response.status(Response.Status.CREATED).entity(studentJson).build();
    }
}
