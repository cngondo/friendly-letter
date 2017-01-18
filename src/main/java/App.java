import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
	public static void main(String[] args) {
		
		String layout = "templates/layout.vtl";
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

	 	  	return new ModelAndView(model, layout);
		    }, new VelocityTemplateEngine()
	    );
     // Favourite photos route
     get("/favourite_photos", (request, response) ->
     	 {
     	 	Map<String, Object> model = new HashMap<String, Object>();
     		model.put("view", "templates/favourite_photos.vtl");

     	 	return new ModelAndView(model, layout);
     	 }, new VelocityTemplateEngine()
     	);
     // Form route
     /*
		The form submits to a route called "greeting_card". Check out form action the velocity templates
     */
     get("/form", (request, response) -> {
			  Map<String, Object> model = new HashMap<String, Object>();
			  model.put("view", "templates/form.vtl");
			  return new ModelAndView(model, layout);
			}, new VelocityTemplateEngine()
		);

     //Greeting card route. This is where we pick the form data and use it
     get("/greeting_card", (request, response) -> {
			  Map<String, Object> model = new HashMap<String, Object>();
			  String recipient = request.queryParams("recipient");
			  String sender = request.queryParams("sender");
			  model.put("recipient", recipient);
			  model.put("sender", sender);
			  model.put("view", "templates/greeting_card.vtl");
			  return new ModelAndView(model, layout);
			}, new VelocityTemplateEngine());
		}
}
