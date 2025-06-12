package com.felipemcassiano.kratiseis.service;

import com.felipemcassiano.kratiseis.exceptions.ResourceNotFoundException;
import com.felipemcassiano.kratiseis.model.Resource.Resource;
import com.felipemcassiano.kratiseis.model.Resource.CreateResourceDTO;
import com.felipemcassiano.kratiseis.repository.ResourceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
         this.resourceRepository = resourceRepository;
    }

    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }
    public Resource findById(long id) {
        return resourceRepository.findById(id).get();

    }

    @Transactional
    public void createResource(CreateResourceDTO dto) {
        Resource resource = new Resource(dto);

        resourceRepository.save(resource);
    }
    @Transactional
    public void saveResource(Resource resource) {
        resourceRepository.save(resource);
    }

    @Transactional
    public void updateResource(CreateResourceDTO dto, long id) {
        Optional<Resource> founded = resourceRepository.findById(id);
        if (founded.isEmpty()) {
            throw  new ResourceNotFoundException("Resource not found");
        }
        Resource resource = founded.get();
        resource.setName(dto.name());
        resourceRepository.save(resource);
    }

    public void deleteResource(long id) { resourceRepository.deleteById(id); }

}
