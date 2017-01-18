import java.util.Map;
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
     		
     		Map<String, Object> model = new HashMap<String, Object>();
     		model.put("view", "templates/hello.vtl");

	 	  	return new ModelAndView(model, "templates/layout.vtl");
		    }, new VelocityTemplateEngine()
	    );
     // Favourite photos route
     get("/favourite_photos", (request, response) ->
     	 {
     	 	Map<String, Object> model = new HashMap<String, Object>();
     		model.put("view", "templates/favourite_photos.vtl");

     	 	return new ModelAndView(model, "templates/layout.vtl");
     	 }, new VelocityTemplateEngine()
     	);
  }
}
