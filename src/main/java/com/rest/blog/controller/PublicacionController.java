package com.rest.blog.controller;

import com.rest.blog.dto.PublicacionDto;
import com.rest.blog.service.IPublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private IPublicacionService publicacionService;

    @PostMapping
    public ResponseEntity<PublicacionDto> guardarPublicacion(@RequestBody PublicacionDto publicacionDto) {
        return new ResponseEntity<>(publicacionService.crarPublicacion(publicacionDto), HttpStatus.CREATED);
    }
}
