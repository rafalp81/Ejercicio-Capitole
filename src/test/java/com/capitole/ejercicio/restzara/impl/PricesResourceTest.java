package com.capitole.ejercicio.restzara.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capitole.ejercicio.restzara.exceptions.PricesException;
import com.capitole.ejercicio.restzara.service.PricesService;
import com.capitole.ejercicio.restzara.utils.PricesUtils;
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
		
		EasyMock.expect(pricesService.getPrices(fecha, idProducto, idCadena)).andReturn(PricesUtils.getPriceEntity());
		replayAll();
		
		ResponseEntity<Price> response = pricesResource.getPrices(fecha, idProducto, idCadena);
		verifyAll();
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Price price = response.getBody();
		assertThat(price.getBrandId()).isEqualTo(PricesUtils.BRAND_ID_VALUE);
		assertThat(price.getCurr()).isEqualTo(PricesUtils.CURR_VALUE);
		assertThat(price.getEndDate()).isAfter(price.getStartDate());
		assertThat(price.getPrice()).isEqualTo(Float.parseFloat(PricesUtils.PRICE_VALUE));
		assertThat(price.getPriceList()).isEqualTo(PricesUtils.PRICE_LIST_VALUE);
		assertThat(price.getPriority()).isEqualTo(PricesUtils.PRIORITY_VALUE);
		assertThat(price.getProductId()).isEqualTo(PricesUtils.PRODUCT_ID_VALUE);
		
	}
	
	@Test
	void getPricesTestKO() {
		LocalDateTime fecha = LocalDateTime.now();
		String idProducto = "12345";
		Integer idCadena = 1;
		
		EasyMock.expect(pricesService.getPrices(fecha, idProducto, idCadena)).andReturn(null);
		replayAll();
				
		assertThrows(PricesException.class, () -> {
			pricesResource.getPrices(fecha, idProducto, idCadena);
		  });
		
		verifyAll();
	}

	

}
