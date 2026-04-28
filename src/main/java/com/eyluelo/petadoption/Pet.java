package com.eyluelo.petadoption;
import jakarta.persistence.*;

/**
 * STEP 1 : define a domain obj
 * think abt what data looks like :
 * this class rep. a pet in our system (like customer in the guides)
 * class is annotated with @Entity, indicating that it's a JPA Entity
 * Spring Boot will autom. create a table called "PET" in our H2 database
 * no SQL needed
 */

@Entity
public class Pet {

    /**
     * every ENTITY needs a PRIMARY KEY
     * @Id so that JPA recignizes it as the obj's ID
     * @GeneratedValue meand ID should be generated auto.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //fields under map directly to COLUMNS in table PET:
    private String name;
    private String species;
    private String breed;
    private int age;
    private boolean adopted;

    //N:1 relationship - every pat has max 1 owner
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    //gettesr and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}