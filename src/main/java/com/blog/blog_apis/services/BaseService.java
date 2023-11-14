package com.blog.blog_apis.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import com.blog.blog_apis.exceptions.ResourceNotFoundException;

public class BaseService<Repo extends JpaRepository<E, Integer>, E, Dto> {
    @Autowired
    private Repo repo;

    @Autowired
    private ModelMapper modelMapper;

    public Dto create(Dto dto) {
        E entity = convertToEntity(dto);
        E savedEntity = repo.save(entity);
        return convertToDto(savedEntity);
    }

    public void delete(Integer id) {
        this.repo.deleteById(id);

    }

    @Transactional
    public Dto update(Dto dto, Integer id) {
        long idForError = Long.valueOf(id);
        E entity = this.repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity", "id", idForError));
        modelMapper.map(dto, entity);

        return this.convertToDto(this.repo.save(entity));
    }

    public Dto getById(Integer Id){
        long idForError = Long.valueOf(Id);
        E entity = this.repo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity", "id", idForError));
        return this.convertToDto(entity);

    }

    public List<Dto> getAll() {
        List<Dto> entities = this.repo.findAll().stream().map(e -> this.convertToDto(e))
                .collect(Collectors.toList());
        return entities;
    }


    private E convertToEntity(Dto dto) {
        return modelMapper.map(dto, entityClass);
    }

    private Dto convertToDto(E entity) {
        return modelMapper.map(entity, dtoClass);
    }

    private Class<E> entityClass;

    private Class<Dto> dtoClass;

    public BaseService(Class<E> entityClass, Class<Dto> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }
}
