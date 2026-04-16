package com.eyluelo.petadoption;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * STEP 4: build the REST Controller
 * “In Spring’s approach to building RESTful web services, HTTP requests are
 * handled by a controller. These components are identified by the @RestController annotation.”
 * “@RestController marks the class as a controller where every method returns
 * a domain object instead of a view. It is shorthand for including both
 * @Controller and @ResponseBody.”
 *
 * this means: instead of returning an HTML page, every method here returns
 * data (as JSON). Spring automatically converts our Pet objects to JSON
 * using a library called Jackson
 */

@RestController
@RequestMapping("/api/pets")
public class PetController {
    /**
     * same Dependency Injection pattern as the Service
     * Spring provides the PetService bean automatically w the constructor
     */
    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    /**
     * guide uses @GetMapping for read operations:
     * "The GET request should return a 200 OK response with JSON in the body."
     *
     * When someone visits GET, Spring calls this method and returns the full list of pets as a JSON array:
     * [ { "id": 1, "name": "Mochi", ... }, { "id": 2, ... } ]
     */
    @GetMapping
    public List<Pet> getAllPets() {
        return service.getAllPets();
    }

    /**
     * used to add a new pet.
     * JSON body:
     * { "name": "Mochi", "species": "cat", "breed": "Scottish Fold", "age": 2, "adopted": false }
     *
     * @RequestBody tells Spring: "Read the JSON from the request body
     * and convert it into a Pet object for me."
     */
    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        return service.addPet(pet);
    }

    /**
     * used to update an existing pet. The {id} in the URL is dynamic
     *
     * @PathVariable binds the {id} from the URL to the method parameter
     * @RequestBody provides the updated data from the request body
     */
    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return service.updatePet(id, pet);
    }


    /**
     * Removes a pet from the database, they found their home!
     * Returns void —> the HTTP response will be 200 OK w an empty body
     */
    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        service.deletePet(id);
    }
}
