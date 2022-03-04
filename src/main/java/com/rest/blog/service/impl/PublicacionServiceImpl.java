package com.rest.blog.service.impl;

import com.rest.blog.dto.PublicacionDto;
import com.rest.blog.model.Publicacion;
import com.rest.blog.repository.IPublicacionRepository;
import com.rest.blog.service.IPublicacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Publicacion service.
 */
@Service
public class PublicacionServiceImpl implements IPublicacionService {

    @Autowired
    private IPublicacionRepository publicacionRepository;

    @Override
    public String crarPublicacion(PublicacionDto publicacionDto) {
        Publicacion publicacion = new Publicacion();
        ModelMapper modelMapper = new ModelMapper();
        publicacion = modelMapper.map(publicacionDto, Publicacion.class);

        publicacionRepository.save(publicacion);

        return publicacionDto.getTitulo();
    }
}
