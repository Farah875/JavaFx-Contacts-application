package sample.datamodel;
import java.util.ArrayList;

/**
 *IParser interface defined by different classes, used as file source
 * independent implantation
 */
public interface IParser {
    /**
     * Reader method defined according by class according to parsing source file method
     * it should read the file contents into contacts  object and add them to an array list
     * to be returned
     * @return array list of contacts objects
     */
    ArrayList<Contacts> Reader();
}

