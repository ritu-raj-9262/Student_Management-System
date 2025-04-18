package rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")  // Base path: http://localhost:8080/StudentManagement/api
public class ApplicationConfig extends Application {
    // Auto-discovers classes in the same package (like StudentAPI)
}
