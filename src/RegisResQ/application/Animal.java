
package RegisResQ.application;

/**
 * @author Darren Baker
 * 9/17/23e
 * CS444
 * 
 */
public abstract class Animal {
    protected String species;
    protected String breed;
    protected String name;
    protected Boolean sterilized;
    protected String dateArrived;
    
    // Default constructor
    Animal() {
        breed = null;
        name = null;
        sterilized = false;
        dateArrived = null;
    }
    // Constructor with parameters
    Animal(String breed, String name, Boolean sterilized, String dateArrived) {
        this.breed = breed;
        this.name = name;
        this.sterilized = sterilized;
        this.dateArrived = dateArrived;
    }
    
    // Validates all input values
    public Boolean validate(){
        String datePattern = "\\d{4}-\\d{2}-\\d{2}";
        String[] splitDate;
        int year;
        int month;
        int day;
        
        // check to see if any of the values are null
        if (species == null || breed == null || name == null || 
                sterilized == null || dateArrived == null) {
            return false;
        }
        // checks to make sure date is formmatted YYYY-MM-DD
        if (dateArrived.matches(datePattern) == false) {
            return false;
        }
        // Split the date based on - delimiter, and assign integer values
        splitDate = dateArrived.split("-", 0);
        year = Integer.parseInt(splitDate[0]);
        month = Integer.parseInt(splitDate[1]);
        day = Integer.parseInt(splitDate[2]);
        
        // Sets range for month integer
        if (month < 1 || month > 12) {
            return false;
        }
        
        // if month is a month with 31 days, sets day range to 1-3-
        if(month % 2 != 0 || month == 8) {
                
                    if (day < 1 || day > 31) {
                        return false;
                    }
        }
        // if month is february, checks if it is a leap year (come back and clean up this logic).
        else if (month == 2) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        if (day < 1 || day > 29) {
                            return false;
                        }
                    }
                    else {
                        if (day < 1 || day > 28) {
                            return false;
                        }
                    }
                }
                else {
                    if (day < 1 || day > 29) {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
        }
        else {
            if (day < 1 || day > 30) {
                return false;
            }
        }
        return true;
    }
    
    
    //Setters for class attributes
    public void setBreed(String breed){
        this.breed = breed;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSterilized(Boolean sterilized) {
        this.sterilized = sterilized;
    }
    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }
    
    //Getters for class attributes
    public String getSpecies() {
        return species;
    }
    public String getBreed() {
        return breed;
    }
    public String getName() {
        return name;
    }
    public Boolean getSterilized() {
        return sterilized;
    }
    public String getDateArrived() {
        return dateArrived;
    }
    
    // Overriding toString method
    @Override
    public String toString() {
        return("Species: " + species + "; Breed: " + breed + "; Name: " + 
                name + "; Sterilized: " + sterilized + "; Date Arrived: " + 
                dateArrived);
    }
}
