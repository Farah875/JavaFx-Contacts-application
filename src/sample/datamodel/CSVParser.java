package sample.datamodel;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * csv parser class implementing the IParser Reader method,
 * inorder to be able to parse data from a csv folder into an array list
 * of contacts variable
 */
public class CSVParser implements IParser {

    /**
     * interface function definition that use open csv reader,
     * to parse input from the file into contacts object class and add them to an array list
     * @return array list of contacts objects
     */
    @Override
    public ArrayList<Contacts> Reader() {
        ArrayList<Contacts> data = new ArrayList<>();
        try {
            FileInputStream fileReader = new FileInputStream(
                    "data/MOCK_DATA.csv");
            InputStreamReader input = new InputStreamReader(fileReader,
                    StandardCharsets.UTF_8);
            CSVReader reader = new CSVReader(input);
            String[] lines;
            while ((lines = reader.readNext()) != null)
            {
                data.add(new Contacts(lines[0],lines[1],lines[2],lines[3],
                        lines[4],lines[5],lines[6],lines[7],lines[8]));
                //I already know that in my csv i have only 2 phone numbers
                data.get(data.size()-1).setPhoneInfo(lines[9],lines[10]);
                data.get(data.size()-1).setPhoneInfo(lines[11],lines[12]);
                data.get(data.size()-1).setAddress(lines[13],lines[14],lines[15],
                        lines[16],lines[17]);
                data.get(data.size()-1).setOrganization(lines[18],lines[19],lines[20],lines[21],
                        lines[22],lines[23]);
            }
            System.out.println(data.size());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return data;


    }
}

