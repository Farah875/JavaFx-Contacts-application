package sample.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class having independent functions to load, search for data, and add data
 */
public class ContactData {

    /**
     * function that reads data from file dependent
     *  parser, using the interface Idata, the file source could be changed by changing the
     *  Idata interface object instance.
     * return data as an array list
     *  of type contacts,
     *   loadData()
     * @return array list of all contacts
     */
    public ArrayList loadData()
    {
        ArrayList<Contacts> data ;

        //parsing data using the interface and associated classes
        IParser Idata = new CSVParser();
        data = Idata.Reader();
        return data;
    }

    /**
     * load the data to an array list and search through
     * to find the contacts that match the input string field constraints
     * @param input comma separated field constraints to search based on
     * @return it returns a string holding the matching number of entries
     * with all their data fields
     */
    public String getSearchResult(String input)
    {
        ArrayList<Contacts> data = loadData();

        String[] sInput = input.split(",",0);
        //define the interface function that maps integer values(keys
        //which are used to track data from array list produced
        //to their corresponding contact entry value
        IMap mappingName = ()->{
            HashMap<Integer,Contacts> nameMap = new HashMap<>();
            for (int i=0; i<data.size();i++)
            {
                nameMap.put(i,data.get(i));
            }
            return nameMap;
        };

        //create the Hashmap
        HashMap<Integer,Contacts> nameMap = mappingName.mapping();
        //array list to track the search matched keys found
        ArrayList<Integer> indexes = new ArrayList<>();

        //Create a pattern and a matcher to be used in the testing
        //so if a string matches the beginning or the end of an available
        //string from our data it is accepted
        String pattern;
        Pattern r ;
        Matcher m ;

        //test if the name is a search key
        //if yes we have to find the corresponding entry
        if(! sInput[0].equals(""))
        {
            //search all the entries and check if the name is not null in the entry
            // if the entry name matches the entered name

            pattern= "(?s)^(" + Pattern.quote(sInput[0].toLowerCase()) + ".*$|.*" + Pattern.quote(sInput[0].toLowerCase()) + ")$";
            for (int j=0;j<data.size()-1;j++)
            {
                if(nameMap.get(j).getElement(0) != null)
                {
                    r= Pattern.compile(pattern);
                    m= r.matcher(nameMap.get(j).getElement(0).toLowerCase());
                    if (nameMap.get(j).getElement(0).toLowerCase().matches(pattern))
                        indexes.add(j);
                }
            }
        }

        //if the name is not a search criteria then we have to take all
        //the key integers matching all the entries to expand teh search through
        else {
            System.out.println("enter else");
            indexes.addAll(nameMap.keySet());
            //if we get only one entry in the matching results
            //then this is it we do not have to continue searching through the rest of the data
            if (indexes.size() > 1) {
                //else we take a current search result array list
                // that will be filled by current matching entries from the previous matching entries
                ArrayList<Integer> index1 = new ArrayList<>();
                //the entered constraints are 24 and we have to check them all
                //if previous conditions are matched
                for (int i = 1; i < sInput.length; i++) {
                    if (indexes.size() <= 0)
                        break;
                    else {
                        //if the constraint entry is null no need to check
                        //else we have to do the checking process
                        if (!sInput[i].equals("")) {
                            //clear the current array list to add current values
                            index1.clear();
                            pattern= "(?s)^(" + Pattern.quote(sInput[i].toLowerCase()) + ".*$|.*" + Pattern.quote(sInput[i].toLowerCase()) + ")$";
                            //we check for matches in just the previous matched entries
                            //if a match is found we add the matched entry index to the current array list values
                            for (Integer j : indexes) {
                                //if testing phone type we have to test both entries of phone type
                                if (i == 9 || i == 11) {
                                    if ((nameMap.get(j).getElement(9) != null ) || (nameMap.get(j).getElement(11) != null) ) {
                                        r= Pattern.compile(pattern);
                                        m= r.matcher(nameMap.get(j).getElement(i).toLowerCase());
                                        if ((nameMap.get(j).getElement(9).matches(pattern))
                                                && (nameMap.get(j).getElement(11).matches(pattern)))
                                            index1.add(j);
                                    }
                                } else {
                                    //if testing phone value we have to test both entries of phone value
                                    if (i == 10 || i == 12) {
                                        if ((nameMap.get(j).getElement(10) != null ) || (nameMap.get(j).getElement(12) != null) ) {
                                            r= Pattern.compile(pattern);
                                            m= r.matcher(nameMap.get(j).getElement(i).toLowerCase());
                                            if ((nameMap.get(j).getElement(10).matches(pattern))
                                                && (nameMap.get(j).getElement(12).matches(pattern)))
                                            index1.add(j);
                                        }
                                    } else
                                    //if it is not a phone we test the match between specified entry and the corresponding field
                                    //if corresponding data entry is not null
                                    {
                                        if(nameMap.get(j).getElement(i) != null)
                                        {
                                            r= Pattern.compile(pattern);
                                            m= r.matcher(nameMap.get(j).getElement(i).toLowerCase());
                                            if (nameMap.get(j).getElement(i).toLowerCase().matches(pattern))
                                                index1.add(j);

                                        }
                                    }
                                }
                            }
                            System.out.println(index1.size());
                        }
                    }
                    if (index1.size() > 0) {
                        indexes.clear();
                        indexes.addAll(index1);
                    }

                }

            }
        }

        StringBuilder result = new StringBuilder();
        result.append("Number of results: "+ indexes.size()+"\n");
        for (Integer i : indexes)
        {
            result.append(data.get(i).getInformation()+
                    data.get(i).getOrganization()+
                    data.get(i).getAddress()+
                    data.get(i).getPhoneInfo()+"\n");
        }
        return result.toString();
    }

    /**
     * using the independent IAdd interface object and method to
     * add data to files, change the file type by changing the instance class
     * @param c Contact data to be added to the data file
     */
    public void addNew (Contacts c)
    {
        IAdd addNew = new CSVAdd();
        addNew.add_contact(c);
    }

}
