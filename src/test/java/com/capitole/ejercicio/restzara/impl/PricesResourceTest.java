package com.capitole.ejercicio.restzara.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capitole.ejercicio.restzara.repository.models.PriceEntity;
import com.capitole.ejercicio.restzara.service.PricesService;
import com.capitole.ejercicio.restzara.web.api.model.Price;

@ExtendWith(EasyMockExtension.class)
class PricesResourceTest extends EasyMockSupport {
	
	@TestSubject
	PricesResource pricesResource;
	
	@Mock
	PricesService pricesService;

	@Test
	void getPricesTestOK() {
		LocalDateTime fecha = LocalDateTime.now();
		String idProducto = "12345";
		Integer idCadena = 1;
		
		EasyMock.expect(pricesService.getPrices(fecha, idProducto, idCadena)).andReturn(getPriceEntity());
		replayAll();
		
		ResponseEntity<Price> response = pricesResource.getPrices(fecha, idProducto, idCadena);
		verifyAll();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Price price = response.getBody();
		assertThat(price.getBrandId()).isEqualTo(1);
		assertThat(price.getCurr()).isEqualTo("EUR");
		assertThat(price.getEndDate()).isAfter(price.getStartDate());
		assertThat(price.getPrice()).isEqualTo(Float.parseFloat("35.25"));
		assertThat(price.getPriceList()).isEqualTo(1);
		assertThat(price.getPriority()).isEqualTo(1);
		assertThat(price.getProductId()).isEqualTo("12345");
		
	}

	private PriceEntity getPriceEntity() {
		PriceEntity priceEntity = new PriceEntity();
		priceEntity.setStartDate(LocalDateTime.now());
		priceEntity.setBrandId(1);
		priceEntity.setCurr("EUR");
		priceEntity.setPrice(Float.parseFloat("35.25"));
		priceEntity.setPriceList(1);
		priceEntity.setPriority(1);
		priceEntity.setProductId("12345");
		priceEntity.setEndDate(priceEntity.getStartDate().plusDays(10));
		return priceEntity;
	}

}
