package sample.datamodel;

import java.util.ArrayList;

/**
 * class holding all the base contact elements,
 * with their methods
 * Contacts
 */
public class Contacts {
    /**
     * information class object having the contact basic information
     * information
     */
    private Information information;
    /**
     * PhoneInfo class object having all the phone information
     * phoneInfo
     */
    private PhoneInfo phoneInfo= new PhoneInfo();
    /**
     * Address class object for all the contacts address fields
     * address
     */
    private Address address;
    /**
     * Organization class object that hold all contact organization fields
     * organization
     */
    private Organization organization;

    //constructor and set functions

    /**
     * @param name  first name
     * @param fName second name
     * @param birthday birthday date
     * @param gender gender filed
     * @param location location field
     * @param occupation occupation field
     * @param notes notes field
     * @param group group field
     * @param e_mail email field
     */
    /**
     * constructor that creates  the information class instance
     */
    public Contacts (String name, String fName, String birthday,
                     String gender, String location,
                     String occupation, String notes,
                     String group, String e_mail)

    {
        this.information = new Information(name,fName,birthday,
                gender,location,occupation,notes,group,e_mail);
    }


    /**
     * setting phone information fields
     */
    public void setPhoneInfo (String type, String value)

    {
        this.phoneInfo.addPhoneInfo(type,value);
    }
    /**
     * setting address fields by creating an instance of Address class
     */
    public void setAddress(String type, String street, String city,
                           String region, String country)
    {
        this.address= new Address(type, street, city, region, country);
    }
    /**
     * setting organization fields by creating an instance of Organization class
     */
    public void setOrganization(String type, String name, String location,
                                String jobDescription, String websiteType,
                                String websiteValue)
    {
        this.organization= new Organization(type, name, location,
                jobDescription, websiteType, websiteValue);
    }

    //some get functions from printing results
    public String getInformation()
    {
        return this.information.getInformation();
    }
    public String getPhoneInfo()
    {
        return this.phoneInfo.getPhoneInfo();
    }
    public String getAddress()
    {
        return this.address.getAddressInfo();
    }
    public String getOrganization()
    {
        return this.organization.getOrganizationInfo();
    }

    //some get functions for each filed for checking availability
    /**
     * this function returns a contact field based on the input index,
     * this function is used so we want fields to be read, we don't have to call the 24
     * each by his name, either by index for one field,or using a for loop for a group of fields.
     * According to the index the switch statement returns the specified String value.
     */
    public String getElement (int i )
    {
        switch (i){
            case 0: return this.information.getName();
            case 1: return this.information.getfName();
            case 2: return this.information.getBirthday();
            case 3: return this.information.getGender();
            case 4: return this.information.getLocation();
            case 5: return this.information.getOccupation();
            case 6: return this.information.getNotes();
            case 7: return this.information.getGroup();
            case 8: return this.information.getE_mail();
            case 9: return this.phoneInfo.getType(0);
            case 10: return this.phoneInfo.getValue(0);
            case 11: return this.phoneInfo.getType(1);
            case 12: return this.phoneInfo.getValue(1);
            case 13: return this.address.getType();
            case 14: return this.address.getStreet();
            case 15: return this.address.getCity();
            case 16: return this.address.getRegion();
            case 17: return this.address.getCountry();
            case 18: return this.organization.getType();
            case 19: return this.organization.getName();
            case 20: return this.organization.getLocation();
            case 21: return this.organization.getJobDescription();
            case 22: return this.organization.getWebsiteType();
            case 23: return this.organization.getWebsiteValue();
            default: return null;
        }
    }

    //private classes for each group of information for organizing
    // and ability to read

    /**
     * inner class for holding basic personal information of the user
     * Information
     */
    private class Information
    {
        private String name;
        private String fName;
        private String birthday;
        private String gender;
        private String location;
        private String occupation;
        private String notes;
        private String group;
        private String e_mail;

        public String getName() {
            return name;
        }

        public String getfName() {
            return fName;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getGender() {
            return gender;
        }

        public String getLocation() {
            return location;
        }

        public String getOccupation() {
            return occupation;
        }

        public String getNotes() {
            return notes;
        }

        public String getGroup() {
            return group;
        }

        public String getE_mail() {
            return e_mail;
        }

        /**
         * Constructor of the class
         */
        public Information(String name, String fName, String birthday,
                           String gender, String location,
                           String occupation, String notes,
                           String group, String e_mail) {
            this.name = name;
            this.fName = fName;
            this.birthday = birthday;
            this.gender = gender;
            this.location = location;
            this.occupation = occupation;
            this.notes = notes;
            this.group = group;
            this.e_mail = e_mail;
        }

        /**
         * used for printing basic personal information of the contact all together
         */
        public String getInformation ()
        {
            return "Name: " + this.name+"\n"+
                    "Family Name: "+ this.fName+"\n"+
                    "Birthday: "+this.birthday+"\n"+
                    "Gender: "+this.gender+"\n"+
                    "Location: "+this.location+"\n"+
                    "Occupation: "+this.occupation+"\n"+
                    "Notes: "+this.notes+"\n"+
                    "Group: "+this.group+"\n"+
                    "E_Mail: "+this.e_mail+"\n";
        }
    }

    /**
     * inner class for holding phone information of the contact
     */
    private class PhoneInfo
    {
        private ArrayList<String> type = new ArrayList<>();
        private ArrayList<String> value = new ArrayList<>();

        /**
         * filling the data entered into the array lists
         */
        public void addPhoneInfo( String type, String value)
        {
            this.type.add(type);
            this.value.add(value);
        }

        public String getType(int i) {
            return type.get(i);
        }

        public String getValue(int i) {
            return value.get(i);
        }

        /**
         * used for printing contact phone info based on the number of phones he has
         */
        public String getPhoneInfo ()
        {
            StringBuilder values = new StringBuilder();
            values.append("PhoneInformation"+"\n") ;
            int i=0;
            for (String e : type )
            {
                values.append("type: "+ e+"\t");
                values.append("value: "+ value.get(i)+"\n");
                i++;
            }
            values.append("\n");
            return values.toString();
        }
    }

    /**
     * inner class for holding address information of the contact
     */
    private class Address
    {
        private String type;
        private String street;
        private String city;
        private String region;
        private String country;

        /**
         * constructor
         */
        public Address(String type, String street,
                       String city, String region, String country) {
            this.type = type;
            this.street = street;
            this.city = city;
            this.region = region;
            this.country = country;
        }

        public String getType() {
            return type;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getRegion() {
            return region;
        }

        public String getCountry() {
            return country;
        }

        /**
         * used for printing address information of the contact
         */
        public String getAddressInfo()
        {

            return "Address Information:"+"\n"+
                    "Type: "+this.type+"\n"+
                    "Street: "+this.street+"\n"+
                    "City: "+this.city+"\n"+
                    "Region: "+this.region+"\n"+
                    "Country: "+this.country+"\n";
        }
    }

    /**
     * inner class for holding organization information of the contact
     */
    private class Organization
    {
        private String type;
        private String name;
        private String location;
        private String JobDescription;
        private String websiteType;
        private String websiteValue;
        /**
         * constructor
         */

        public Organization(String type, String name, String location,
                            String jobDescription, String websiteType,
                            String websiteValue) {

            this.type = type;
            this.name = name;
            this.location = location;
            this.JobDescription = jobDescription;
            this.websiteType=websiteType;
            this.websiteValue=websiteValue;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public String getJobDescription() {
            return JobDescription;
        }

        public String getWebsiteType() {
            return websiteType;
        }

        public String getWebsiteValue() {
            return websiteValue;
        }

        /**
         * used for printing organization information of the contact
         */
        public String getOrganizationInfo()
        {
            return "Organization Information:"+"\n"+
                    "Type: "+this.type+"\n"+
                    "Name: "+this.name+"\n"+
                    "Location: "+this.location+"\n"+
                    "Job Description: "+this.JobDescription+"\n"+
                    "Website Type: "+this.websiteType+"\n"+
                    "Website Value: "+this.websiteValue+"\n";
        }
    }

}
