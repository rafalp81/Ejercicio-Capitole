package com.capitole.ejercicio.restzara.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capitole.ejercicio.restzara.repository.PricesRepository;
import com.capitole.ejercicio.restzara.repository.models.PriceEntity;


@Service
public class PricesService {

	
	private PricesRepository pricesRepository;

	public PricesService(PricesRepository pricesRepository) {
		super();
		this.pricesRepository = pricesRepository;
	}
	
	public PriceEntity getPrices(LocalDateTime fecha, String idProducto, Integer idCadena){
		
		Optional<PriceEntity> price = this.pricesRepository.findOnePrice(fecha, idProducto, idCadena);
		if(price.isPresent()) {
			return price.get(); 
		}
		return null;
		
	}
	
	

	
	
}
