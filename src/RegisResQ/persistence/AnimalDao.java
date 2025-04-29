
package RegisResQ.persistence;

import RegisResQ.application.*;
import java.sql.*;
import java.util.*;
/**
 *Darren Baker
 * 
 */
public class AnimalDao implements Dao<Animal> {
    
    private ArrayList<Animal> animals = new ArrayList();
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    
    // Default constructor
    public AnimalDao() {
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to the MySQL server
            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/animals","cs444","p@sswordCS444")) {
                    statement = connection.createStatement();
                
                // Exceute a select SQL command on the adoptable pets table in 
                // the animals database
                ResultSet result = statement.executeQuery("select * from adoptable_pets");
            }
        } catch( ClassNotFoundException | SQLException e ) {
            System.err.println(e);
        }
    }
    
    
    /* Gets all the entries from the Animal database and creates
        corresponding Animal objects
    */
    public ArrayList<Animal> getAll() {
        Boolean sterilized;
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/animals","cs444","p@sswordCS444")){
            
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from adoptable_pets");
            
            while(result.next()) {
                if (result.getString(4).equals("1")) {
                    sterilized = true;
                }
                else {
                    sterilized = false;
                }
                
                if (result.getString(1).equalsIgnoreCase("cat")) {
                    Cat c = new Cat();
                    c.setBreed(result.getString(2));
                    c.setName(result.getString(3));
                    c.setSterilized(sterilized);
                    c.setDateArrived(result.getString(5));
                    animals.add(c);
                }
                if (result.getString(1).equalsIgnoreCase("dog")) {
                    Dog d = new Dog();
                    d.setBreed(result.getString(2));
                    d.setName(result.getString(3));
                    d.setSterilized(sterilized);
                    d.setDateArrived(result.getString(5));
                    animals.add(d);
                }
                
            }
            
        }
        catch (SQLException e) {
            System.err.println(e);
            
        }
        return animals;
    }
    
    // Adds an entry to the database
    @Override
    public Boolean add(Animal animal) {
        boolean added = false;
        String species = animal.getSpecies();
        String breed = animal.getBreed();
        String name = animal.getName();
        String sterilized = String.valueOf(animal.getSterilized());
        String date = animal.getDateArrived();
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/animals","cs444","p@sswordCS444")){
               statement = connection.createStatement();
               statement.execute("insert into adoptable_pets (type, breed, name, "
                        + "sterilized, arrived) values ('" + species + "', '" + 
                        breed + "', '" + name + "', " + sterilized + ", '" + 
                        date + "');");
               added = true;
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return added;
    }
    
    // Updates a database entry
    @Override
    public Boolean update(Animal animal) {
        Boolean updated = false;
        int numUpdated = 0;
        String species = animal.getSpecies();
        String breed = animal.getBreed();
        String name = animal.getName();
        String sterilized = String.valueOf(animal.getSterilized());
        String date = animal.getDateArrived();
        
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/animals","cs444","p@sswordCS444")) {
            statement = connection.createStatement();
            numUpdated = statement.executeUpdate("update adoptable_pets set "
                    + "type = '" + species + "', breed = '" + breed + "', sterilized = "
            + sterilized + ", arrived = '" + date + "' where name = '" + name + "';");
                     
            if (numUpdated != 0) {
                updated = true;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return updated;
    }
    
    // Deletes an entry from database
    @Override
    public Boolean delete(Animal animal) {
        Boolean deleted = false;
        int numDeleted;
        String name = animal.getName();
        
        try(Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/animals","cs444","p@sswordCS444")) {
            statement = connection.createStatement();
            numDeleted = statement.executeUpdate("delete from adoptable_pets "
                    + "where name = '" + name +"';");
            if (numDeleted != 0) {
                deleted = true;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        
        return deleted;
    }
}
