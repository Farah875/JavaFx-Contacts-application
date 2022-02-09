package sample.datamodel;

/**
 * the json file contains more fields than a standard contacts object fields,
 * this class is used for json files that use that inherits the contacts base class fields and methods,
 * and use additional fields and overrides the necessary methods to hold the new variables
 */
public class JContact extends Contacts{

    /**
     * the additional business mail address field
     */
    private String business_mail;

    /**
     *the constructor that calls the super method, the base constructor from Contacts class
     * and add defines the additional field/s
     */
    public JContact(String name, String fName, String birthday, String gender, String location, String occupation, String notes, String group, String e_mail,String business_mail) {
        super(name, fName, birthday, gender, location, occupation, notes, group, e_mail);
        this.business_mail = business_mail;
    }

    /**
     * if the index is one of the base 24 fields the base class function is called,
     * otherwise the current fields value is returned
     * @param i the index for the asked field
     * @return string with the field value
     */
    @Override
    public String getElement (int i )
    {
        if (i <24 )
            return super.getElement(i);
        return this.business_mail;
    }

    /**
     * since the added field is from information fields,
     * the return string should include the added field
     * @return String holding the contacts information
     */
    @Override
    public String getInformation()
    {
        return super.getInformation()+
            "Business Email: "+ this.business_mail+"\n";
    }
}
