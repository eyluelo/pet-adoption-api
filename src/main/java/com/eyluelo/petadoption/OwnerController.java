package com.eyluelo.petadoption;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    private final OwnerRepository repository;

    public OwnerController(OwnerRepository repository){
        this.repository=repository;
    }
    @GetMapping
    public List<Owner> getAll(){return repository.findAll();}

    @PostMapping
    public Owner add(@RequestBody Owner owner) { return repository.save(owner);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){repository.deleteById(id);}
}
