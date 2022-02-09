package sample.datamodel;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * class implementing IAdd interface and defining its method
 * for the purpose of adding new contact information to the csv file
 */
public class CSVAdd implements IAdd{
    /**
     * defining the add_contact interface method to be able to add data to a csv file
     * @param c contact provided to be added to the csv file
     */
    @Override
    public void add_contact(Contacts c) {
        StringBuilder valueBuild = new StringBuilder();
        //create a comma separated string with all the values in the order
        for (int i =0 ;i<24 ;i++)
        {
            valueBuild.append(c.getElement(i)+",");
        }
        String value = valueBuild.toString();
        //open the file in append mode and write the created string to its end, then close the file
        try {
            Writer writer = Files.newBufferedWriter(
                    Paths.get("data/MOCK_DATA.csv"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(value);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
