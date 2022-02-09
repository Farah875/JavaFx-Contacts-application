package sample.datamodel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * class implementing IAdd interface and defining its method
 * for the purpose of adding new contact information to the json file
 */
public class JSONAdd implements IAdd {

    /**
     * defining the add_contact interface method to be able to add data to a json file
     * @param c contact provided to be added to the csv file
     */
    @Override
    public void add_contact(Contacts c) {
        //create json object to be added to the file
        JSONObject json = new JSONObject();
        //since the name is a composition we create a map
        Map name1 = new HashMap();
        name1.put("first",c.getElement(0));
        name1.put("last",c.getElement(1));

        json.put("name", name1);



        Map name = new HashMap();
        json.put("birthday" , c.getElement(2));
        json.put("gender" , c.getElement(3));
        json.put("location" , c.getElement(4));
        json.put("occupation" , c.getElement(5));
        json.put("notes" , c.getElement(6));
        json.put("group" , c.getElement(7));
        json.put("email" , c.getElement(8));
        json.put("business_email" , c.getElement(24));
        //the phone value is an array value in the json file
        JSONArray phonelist = new JSONArray();
        JSONObject phone = new JSONObject();
        phone.put("type",c.getElement(9));
        phone.put("value",  c.getElement(10));
        phonelist.add(phone);
        phone.clear();
        phone.put("type",c.getElement(11));
        phone.put("value",  c.getElement(12));
        phonelist.add(phone);

        //add the array phone object to the jsonObject
        json.put("phone", phonelist);
        //adding address info to a map
        name.clear();
        name.put("type", c.getElement(13));
        name.put("street", c.getElement(14));
        name.put("city", c.getElement(15));
        name.put("region", c.getElement(17));
        name.put("country", c.getElement(18));

        json.put("address", name);

        //use the same process to add the organization info
        name.clear();
        name.put("type", c.getElement(19));
        name.put("name", c.getElement(20));
        name.put("location", c.getElement(21));
        name.put("job_description", c.getElement(22));

        json.put("organization", name);

        //also the same process to add the website info
        name.clear();
        name.put("type", c.getElement(21));
        name.put("value", c.getElement(22));

        json.put("website", name);
        try{
            //first of all we gonna read the old data into json array
            //add the new data to the array
            //then write the array back to the file
            Object obj = new JSONParser().parse(new FileReader("C:\\Users\\good\\Documents\\mock"));
            JSONArray jsonArray = (JSONArray)obj;
            jsonArray.add(jsonArray.size()-1,json);
            Writer writer = Files.newBufferedWriter(
                    Paths.get("data/mock"), StandardCharsets.UTF_8);
            jsonArray.writeJSONString(writer);
            writer.close();

        }
         catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
