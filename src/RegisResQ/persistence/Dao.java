
package RegisResQ.persistence;

import java.util.*;
/**
 *
 * @author Darren Baker
 */

//Interface for AniumalDao class
public interface Dao<T> {
    
    ArrayList<T> getAll();
    Boolean add(T item);
    Boolean update(T item);
    Boolean delete(T item);
}
