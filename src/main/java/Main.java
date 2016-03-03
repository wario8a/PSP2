import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

import java.io.File;
import java.util.LinkedList;

import FileManager.FileManager;
import Statistics.Statistics;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/PSP2", (req, res) -> "Hello World!!!!!");
    
    
  }

}
