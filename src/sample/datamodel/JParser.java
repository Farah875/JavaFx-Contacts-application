package sample.datamodel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * json parser class implementing the IParser Reader method,
 * inorder to be able to parse data from a json folder into an array list
 * of contacts variable
 */
public class JParser implements IParser {

    /**
     * interface function definition that use org.json.simple,
     * to parse input from the file into contacts object class and add them to an array list
     * @return array list of contacts objects
     */
    @Override
    public ArrayList<Contacts> Reader() {
        ArrayList<Contacts> data = new ArrayList<>();
        try {
            Object obj = new JSONParser().parse(new FileReader("data/mock"));
            JSONArray jsonArray = (JSONArray)obj;
            for (Object jsonObj : jsonArray) {
                JSONObject json  = (JSONObject) jsonObj;
                Map value = ((Map) json.get("name"));
                data.add(new JContact((String) value.get("first"), (String) value.get("last"),
                        (String) json.get("birthday"), (String) json.get("gender"), (String) json.get("location"),
                        (String) json.get("occupation"), (String) json.get("notes"),
                        (String) json.get("group"), (String) json.get("email"),(String) json.get("bmail")));
                JSONArray ja = ((JSONArray) json.get("phone"));

                Iterator it = ja.iterator();
                Iterator it2;
                while (it.hasNext()) {
                    it2 = ((Map) it.next()).entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry pair = (Map.Entry) it2.next();
                        data.get(data.size() - 1).setPhoneInfo(
                                (String) pair.getKey(), (String) pair.getValue());
                    }
                }
                value = ((Map) json.get("address"));
                data.get(data.size() - 1).setAddress((String) value.get("type"),
                        (String) value.get("street"), (String) value.get("city"),
                        (String) value.get("region"), (String) value.get("country"));
                value = ((Map) json.get("organization"));
                Map v2 = ((Map) json.get("website"));
                data.get(data.size() - 1).setOrganization((String) value.get("type"),
                        (String) value.get("name"), (String) value.get("location"),
                        (String) value.get("job_description"), (String) v2.get("type"),
                        (String) v2.get("value"));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
