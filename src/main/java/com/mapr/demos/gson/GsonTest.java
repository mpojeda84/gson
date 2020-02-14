package com.mapr.demos.gson;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonTest {

  public static void main(String[] args) {

    try (JsonReader reader = new JsonReader(new FileReader("/mapr/dmitry001.hpe.com/user/mapr/tmp/file.json"))) {

      JsonObject object = new JsonObject();

      reader.beginObject();
      while (reader.hasNext()) {
        String propertyName = reader.nextName();

        switch (propertyName){
          case "id":
            object.addProperty("_id", reader.nextString());
            break;
          case "value":
            object.addProperty("value", reader.nextString());
            break;
          case "items":
            reader.beginArray();

            while (reader.hasNext()) {

              reader.beginObject();
              JsonObject finalObject = new JsonObject();

              while(reader.hasNext()) {
                finalObject.addProperty(reader.nextName(), reader.nextString());
              }

              reader.endObject();

              object.keySet().forEach(x -> {
                finalObject.addProperty(x, object.get(x).getAsString());
              });

              System.out.println("Producing ... " + finalObject.toString());
            }

            reader.endArray();
            break;
        }
      }
      reader.endObject();


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
