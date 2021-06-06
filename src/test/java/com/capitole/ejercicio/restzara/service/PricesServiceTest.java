package com.capitole.ejercicio.restzara.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Optional;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.capitole.ejercicio.restzara.repository.PricesRepository;
import com.capitole.ejercicio.restzara.repository.models.PriceEntity;
import com.capitole.ejercicio.restzara.utils.PricesUtils;

@ExtendWith(EasyMockExtension.class)
class PricesServiceTest extends EasyMockSupport{

	@TestSubject
	PricesService pricesService;
	
	@Mock
	PricesRepository pricesRepository;

	@Test
	void testGetPrices_when_price_found_then_ok() {
		
		LocalDateTime fecha = LocalDateTime.now();
		String idProducto = PricesUtils.PRODUCT_ID_VALUE;
		Integer idCadena = PricesUtils.BRAND_ID_VALUE;
		
		EasyMock.expect(this.pricesRepository.findOnePrice(fecha, idProducto, idCadena)).andReturn(Optional.of(PricesUtils.getPriceEntity()));
		replayAll();
		
		PriceEntity priceEntity = pricesService.getPrices(fecha, idProducto, idCadena);
		verifyAll();
		
		assertThat(priceEntity.getBrandId()).isEqualTo(PricesUtils.BRAND_ID_VALUE);
		assertThat(priceEntity.getCurr()).isEqualTo(PricesUtils.CURR_VALUE);
		assertThat(priceEntity.getEndDate()).isAfter(priceEntity.getStartDate());
		assertThat(priceEntity.getPrice()).isEqualTo(Float.parseFloat(PricesUtils.PRICE_VALUE));
		assertThat(priceEntity.getPriceList()).isEqualTo(PricesUtils.PRICE_LIST_VALUE);
		assertThat(priceEntity.getPriority()).isEqualTo(PricesUtils.PRIORITY_VALUE);
		assertThat(priceEntity.getProductId()).isEqualTo(PricesUtils.PRODUCT_ID_VALUE);	
	}
	
	@Test
	void testGetPrices_when_price_not_found_then_null() {
		
		LocalDateTime fecha = LocalDateTime.now();
		String idProducto = PricesUtils.PRODUCT_ID_VALUE;
		Integer idCadena = PricesUtils.BRAND_ID_VALUE;
		
		EasyMock.expect(this.pricesRepository.findOnePrice(fecha, idProducto, idCadena)).andReturn(Optional.empty());
		replayAll();
		
		PriceEntity priceEntity = pricesService.getPrices(fecha, idProducto, idCadena);
		verifyAll();
		
		assertThat(priceEntity).isNull();
			
	}
}
