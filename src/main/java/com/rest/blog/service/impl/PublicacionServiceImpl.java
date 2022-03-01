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
    public PublicacionDto crarPublicacion(PublicacionDto publicacionDto) {
        Publicacion publicacion = new Publicacion();
        PublicacionDto publicacionResp = new PublicacionDto();
        ModelMapper modelMapper = new ModelMapper();
        publicacion = modelMapper.map(publicacionDto, Publicacion.class);

        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);
        publicacionResp = modelMapper.map(nuevaPublicacion, PublicacionDto.class);

        return publicacionResp;
    }
}
