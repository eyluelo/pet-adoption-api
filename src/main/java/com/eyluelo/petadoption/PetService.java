package com.eyluelo.petadoption;

import org.springframework.stereotype.Service;
import java.util.List;

/**
 *STEP 3 : create a service layer
 * The Spring REST tutorial separates concerns into distinct layers:
 * Controller → Service → Repository
 *
 * Payroll example:
 * “We store employee objects in a (H2 in-memory) database, and access them
 * through JPA. Then we wrap that with something that allows access over
 * the internet — the Spring MVC layer.”
 *
 * The Service is between those two layers.
 * The Controller doesn’t need to know HOW data is saved, it just asks the Service to do it.
 * @Service tells Spring: “Manage this class and make it available for
 * injection wherever it’s needed.” Spring creates one instance of this
 * class and shares it across the application ( a Bean).
 */
@Service
public class PetService {

    /**
     *instead of creating a new PetRepository  with “new” -> declare it as a dependency and let Spring inject it.
     * (Dependency Injection)
     *
     * Spring sees the constructor param. and auto. provides the PetRepository bean it already manages
     */
    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }



    /**
     * Returns all pets currently in the database.
     * JPA's findAll()
     */
    public List<Pet> getAllPets() {
        return repository.findAll();
    }

    /**
     * Saves a new pet to the database.
     * JPA’s save(): INSERT
     */
    public Pet addPet(Pet pet) {
        return repository.save(pet);
    }

    /**
     * Finds an existing pet by id, updates its fields and saves
     * orElseThrow(): if the id doesn’t exist, Spring throws an exception
     */
    public Pet updatePet(Long id, Pet updated) {
        Pet pet = repository.findById(id).orElseThrow();
        pet.setName(updated.getName());
        pet.setSpecies(updated.getSpecies());
        pet.setBreed(updated.getBreed());
        pet.setAge(updated.getAge());
        pet.setAdopted(updated.isAdopted());
        return repository.save(pet);
    }

    /**
     * Deletes a pet permanently by id
     */
    public void deletePet(Long id) {
        repository.deleteById(id);
    }
}
