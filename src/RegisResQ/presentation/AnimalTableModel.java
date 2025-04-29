
package RegisResQ.presentation;
import javax.swing.table.AbstractTableModel;
import java.util.*;
import RegisResQ.application.*;

/**
 * Darren Baker
 * Updated: 10/8/23
 */
public class AnimalTableModel extends AbstractTableModel {
    private ArrayList<Animal> animals;
    private static final String[] columnNames = {"Type", "Breed", "Name", "Sterilized", "Arrived"};
    
    // Default Constructor
    public AnimalTableModel() {
        animals = null;
    }
    
    // Initiializes and populates animals list
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    
    // Getter for number of rows
    @Override
    public int getRowCount() {
        return animals.size();
    }
    
    // Getter for number of columns
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    // Getter for column name
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    //Gets the value at a specific row and column location
    @Override
    public Object getValueAt(int row, int column) {
        Animal animal = animals.get(row);
        Object value = null;
        switch (column) {
            case 0:
                value = animal.getSpecies();
                break;
            case 1:
                value = animal.getBreed();
                break;
            case 2:
                value = animal.getName();
                break;
            case 3:
                value = animal.getSterilized();
                break;
            case 4:
                value = animal.getDateArrived();
                break;
        }
        return value;
    }
}
