/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RegisResQ.application;

/**
 *Darren Baker
 * 
 */
public class Dog extends Animal {
    public Dog() {
        super();
        species = "Dog";
    }
    public Dog(String breed, String name, Boolean sterilized, String dateArrived) {
        super(breed, name, sterilized, dateArrived);
        species = "Dog";
    }
}

