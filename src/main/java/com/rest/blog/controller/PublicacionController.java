package com.rest.blog.controller;

import com.rest.blog.dto.PublicacionDto;
import com.rest.blog.service.IPublicacionService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(
            value = "Obtiene todas publicaciones",
            notes = "Muestra las publicaciones existentes"
    )
    public ResponseEntity<PublicacionDto> guardarPublicacion(@RequestBody PublicacionDto publicacionDto) {
        return new ResponseEntity<>(publicacionService.crarPublicacion(publicacionDto), HttpStatus.CREATED);
    }
}
