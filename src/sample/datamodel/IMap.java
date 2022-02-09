package sample.datamodel;
import java.util.HashMap;

/**
 * interface IMap that contains the mapping method
 * this interface is defined by the calling function to define the
 * method of mapping the contacts to their indexes
 */
public interface IMap {
    /**
     * mapping method that maps contacts from any source to
     * their keys in a hash map
     * @return HashMap that maps contacts to keys
     */
    HashMap<Integer,Contacts> mapping ();
}

