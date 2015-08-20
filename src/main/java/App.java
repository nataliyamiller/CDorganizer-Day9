import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("cds", request.session().attribute("cds"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("cds", CDorganizer.all());
      model.put("template", "templates/cds.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/cd-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cds", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      ArrayList<CDorganizer> cdList = CDorganizer.all();
      String title = request.queryParams("title");
      String artist = request.queryParams("artist");

      CDorganizer newCDorganizer = new CDorganizer(title, artist);
      model.put("cdList", cdList);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      CDorganizer foundCD = CDorganizer.find(Integer.parseInt(request.params(":id")));
      model.put("cd", foundCD);
      model.put("template", "templates/cd.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
