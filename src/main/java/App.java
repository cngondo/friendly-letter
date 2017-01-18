import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		// To locate the resources for the project
		staticFileLocation("/public");
		//Port Number
		port(1234);
		//Hello route
		/*
			Make sure that the get request returns the required velocity template
		*/
     get("/", (request, response) -> {
     	  return new ModelAndView(new HashMap(), "templates/hello.vtl");
		     }, new VelocityTemplateEngine()
	    );
     // Favourite photos route
     get("/favourite_photos", (request, response) ->
     	 {
     	 	return new ModelAndView(new HashMap(), "templates/favorite_photos.vtl");
     	 }, new VelocityTemplateEngine()
     	);
  }
}
