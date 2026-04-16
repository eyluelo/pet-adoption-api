package com.eyluelo.petadoption;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * STEP 2: create a repository
 * "Spring Data JPA repositories are interfaces w methods supporting creating, reading, updating and deleting records.
 * Spring synthesizes implementations, based on conventions found in the naming of the methods in the interface."
 *
 * so
 * just by extending JpaRepository , Spring gives us:
 *      findAll()       -> SELECT * FROM pet
 *      findById(id)       -> SELECT * FROM pet WHERE id = ?
 *      save(pet)      -> INSERT or UPDATE
 *      deleteById(id)    -> DELETE FROM pet WHERE id = ?
 *
 * "Spring Boot aotum. spins up Spring Data JPA to create a concrete implementation of this interface"
 * <Pet, Long></>  -> table, data type of that entity's id
 */
public interface PetRepository extends JpaRepository<Pet, Long>{

}
