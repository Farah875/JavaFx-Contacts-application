package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.datamodel.ContactData;
import sample.datamodel.Contacts;
import sample.datamodel.JContact;

/**
 * read and write data to the gui,
 * this class is used when we are using the JSONView.fxml,
 * and the JParser class, so its for the usage of teh app with json files
 * JSONController
 */

public class JSONController {


    /**
     * first name field
     * fname
     */
    @FXML
    private TextField fname;
    /**
     * second name field
     * sname
     */
    @FXML
    private TextField sname;
    /**
     * birthday date field
     * birthdayVal
     */
    @FXML
    private TextField birthdayVal;
    /**
     * gender type field
     * genderVal
     */
    @FXML
    private TextField genderVal;
    /**
     * location data filed
     * locationVal
     */
    @FXML
    private TextField locationVal;
    /**
     * occupation data filed
     * occupationVal
     */
    @FXML
    private TextField occupationVal;
    /**
     * notes data field
     * notesVal
     */
    @FXML
    private TextField notesVal;
    /**
     * group data field
     * groupVal
     */
    @FXML
    private TextField groupVal;
    /**
     * personal email  data field
     * e_mailVal
     */
    @FXML
    private TextField e_mailVal;
    /**
     * business email data field
     * e_mailVal2
     */
    @FXML
    private TextField e_mailVal2;
    /**
     * phone type 1 data field
     * phoneType1
     */
    @FXML
    private TextField phoneType1;
    /**
     * phone value 1 data field
     * phoneValue1
     */
    @FXML
    private TextField phoneValue1;
    /**
     * phone type 2 data field
     * phoneType2
     */
    @FXML
    private TextField phoneType2;
    /**
     * phone value 2 data field
     * phoneValue2
     */
    @FXML
    private TextField phoneValue2;
    /**
     * address type data field
     * typeAddVal
     */
    @FXML
    private TextField typeAddVal;
    /**
     * address street data field
     * streetVal
     */
    @FXML
    private TextField streetVal;
    /**
     * address city data field
     * cityVal
     */
    @FXML
    private TextField cityVal;
    /**
     * address region data field
     * regionVal
     */
    @FXML
    private TextField regionVAl;
    /**
     * address country data field
     * cuntryVal
     */
    @FXML
    private TextField cuntryVal;
    @FXML
    /**
     * Organization type  data field
     * typeOrgVal
     */
    private TextField typeOrgVal;
    /**
     * Organization name  data field
     * nameOrgVal
     */
    @FXML
    private TextField nameOrgVal;
    /**
     * Organization location data field
     * locationOrgVal
     */
    @FXML
    private TextField locationOrgVal;
    /**
     * Organization job description data field
     * jobDescriptionVal
     */
    @FXML
    private TextField jobDescriptionVal;
    /**
     * website type data field
     * websiteTypeVal
     */
    @FXML
    private TextField websiteTypeVal;
    /**
     * website value data field
     * websiteVal
     */
    @FXML
    private TextField websiteVal;

    /**
     * text area data field to be filled by the search result
     * results
     */
    @FXML
    private TextArea results;


    /**
     * read all the search input fields from gui
     * and return them as a string for ContactData class
     * inorder to study and find the matches
     * it is called when the search button is pressed
     * readSearchFields
     */
    public void readSearchFields ()  {
        String name = fname.getText();
        String fName = sname.getText();
        String birthday = birthdayVal.getText();
        String gender = genderVal.getText();
        String location = locationVal.getText();
        String occupation = occupationVal.getText();
        String notes = notesVal.getText();
        String group = groupVal.getText();
        String e_mail = e_mailVal.getText();
        String b_mail = e_mailVal2.getText();
        String type1 = phoneType1.getText();
        String value1 = phoneValue1.getText();
        String type2 = phoneType2.getText();
        String value2 = phoneValue2.getText();
        String typeAdd = typeAddVal.getText();
        String street = streetVal.getText();
        String city = cityVal.getText();
        String region = regionVAl.getText();
        String country = cuntryVal.getText();
        String typeOrg = typeOrgVal.getText();
        String nameOrg = nameOrgVal.getText();
        String locationOrg = locationOrgVal.getText();
        String jobDescription = jobDescriptionVal.getText();
        String websiteType = websiteTypeVal.getText();
        String websiteValue = websiteVal.getText();


        String constraint = name+","+fName+","+birthday+","+gender+","+location+","+occupation+","+
                notes+","+group+","+e_mail+","+type1+","+value1+","+type2+","+value2+","+
                type2+","+typeAdd+","+street+","+city+","+region+","+country+","+typeOrg+","+
                nameOrg+","+locationOrg+","+jobDescription+","+websiteType+","+websiteValue+","+b_mail;
        ContactData contact = new ContactData();
        String searchResult= contact.getSearchResult(constraint);

        results.setText(searchResult);


    }

    /**
     * read all the input data fields from user and add them to
     * a contact class object, then return this object to the
     * ContactData class for the purpose of adding it into
     * the data
     * called when a user press the add button
     * addNewElement
     */
    public void addNewElement ()
    {
        String name = fname.getText();
        String fName = sname.getText();
        String birthday = birthdayVal.getText();
        String gender = genderVal.getText();
        String location = locationVal.getText();
        String occupation = occupationVal.getText();
        String notes = notesVal.getText();
        String group = groupVal.getText();
        String e_mail = e_mailVal.getText();
        String b_mail = e_mailVal2.getText();
        String type1 = phoneType1.getText();
        String value1 = phoneValue1.getText();
        String type2 = phoneType2.getText();
        String value2 = phoneValue2.getText();
        String typeAdd = typeAddVal.getText();
        String street = streetVal.getText();
        String city = cityVal.getText();
        String region = regionVAl.getText();
        String country = cuntryVal.getText();
        String typeOrg = typeOrgVal.getText();
        String nameOrg = nameOrgVal.getText();
        String locationOrg = locationOrgVal.getText();
        String jobDescription = jobDescriptionVal.getText();
        String websiteType = websiteTypeVal.getText();
        String websiteValue = websiteVal.getText();

        ContactData contact = new ContactData();
        Contacts c = new JContact(name, fName, birthday, gender,
                location,occupation,notes, group, e_mail,b_mail);
        c.setPhoneInfo(type1,value1);
        c.setPhoneInfo(type2, value2);
        c.setAddress(typeAdd,street,city,region,country);
        c.setOrganization(typeOrg,nameOrg,locationOrg,jobDescription,
                websiteType,websiteValue);
        contact.addNew(c);
    }
}
