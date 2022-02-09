package sample.datamodel;

/**
 * interface that contains the add_contact method
 * to be used as destination folder dependent method in the caller function
 */
public interface IAdd {
    /**
     * undefined method used by interface, this method is defined in different classes
     * @param c the contacts object that should be added to the file
     */
    void add_contact(Contacts c);
}
