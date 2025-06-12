package com.felipemcassiano.kratiseis.controller;

import com.felipemcassiano.kratiseis.model.Resource.Resource;
import com.felipemcassiano.kratiseis.model.Resource.CreateResourceDTO;
import com.felipemcassiano.kratiseis.service.ResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {


    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping()
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.findAll();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("{id}")
    public ResponseEntity<Resource> getResource(@PathVariable long id) {
        Resource resource = resourceService.findById(id);
        return ResponseEntity.ok(resource);
    }

    @PostMapping()
    public ResponseEntity<Void> createResource(@RequestBody CreateResourceDTO dto) {
        resourceService.createResource(dto);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("{id}")
    public ResponseEntity<String> put(@RequestBody CreateResourceDTO dto, @PathVariable long id) {
        resourceService.updateResource(dto, id);
        return  ResponseEntity.notFound().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(long id) {
        resourceService.deleteResource(id);
        return  ResponseEntity.noContent().build();
    }

}
