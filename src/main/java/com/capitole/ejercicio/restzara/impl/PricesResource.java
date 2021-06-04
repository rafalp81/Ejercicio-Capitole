/**
 * 
 */
package com.capitole.ejercicio.restzara.impl;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.ejercicio.restzara.web.api.PricesApi;
import com.capitole.ejercicio.restzara.web.api.model.Price;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Laura
 *
 */
@RestController
@RequestMapping("/v1")
public class PricesResource implements PricesApi {
	
	@Override
	@ApiOperation(value = "Obtiene el precio según los parámetros pasados", nickname = "getPrices", notes = "", response = Price.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Price.class),
        @ApiResponse(code = 404, message = "Not found") })
    @RequestMapping(value = "/prices",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
	public ResponseEntity<Price> getPrices(@NotNull @ApiParam(value = "Fecha de aplicación", required = true) @Valid @RequestParam(value = "fecha", required = true) LocalDateTime fecha,@NotNull @ApiParam(value = "Identificador del producto", required = true) @Valid @RequestParam(value = "idProducto", required = true) Integer idProducto,@NotNull @ApiParam(value = "Identificador de la cadena", required = true) @Valid @RequestParam(value = "idCadena", required = true) String idCadena) {
        
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
	
	

}
