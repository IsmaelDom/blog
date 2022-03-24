package com.rest.blog.controller;

import com.rest.blog.dto.PublicacionDto;
import com.rest.blog.service.IPublicacionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publicaciones")
@Api(value = "PublicacionController", tags = {"PublicacionController"})//, description = "Servicios REST de Publicaciones")
@Tag(name = "PublicacionController", description = "Servicios REST de Publicaciones")
public class PublicacionController {

    @Autowired
    private IPublicacionService publicacionService;

    @PostMapping
    @ApiOperation(
            value = "guardarPublicacion",
            notes = "Guarda las publicaciones con los datos ingresados por el usuario"
    )
    //Operation(security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<String> guardarPublicacion(@RequestBody PublicacionDto publicacionDto) {
        return new ResponseEntity<>(publicacionService.crarPublicacion(publicacionDto), HttpStatus.CREATED);
    }
}
