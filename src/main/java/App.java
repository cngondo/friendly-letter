/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import static spark.Spark.*;

public class App {

     get("/hello", (request, response) -> "Hello Friend!");
    
}