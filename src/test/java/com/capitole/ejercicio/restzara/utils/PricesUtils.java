package com.capitole.ejercicio.restzara.utils;

import java.time.LocalDateTime;

import com.capitole.ejercicio.restzara.repository.models.PriceEntity;

public class PricesUtils {

	public static final int DAYS_VALUE = 10;

	public static final String PRODUCT_ID_VALUE = "12345";

	public static final int PRIORITY_VALUE = 1;

	public static final int PRICE_LIST_VALUE = 1;

	public static final String PRICE_VALUE = "35.25";

	public static final String CURR_VALUE = "EUR";

	public static final int BRAND_ID_VALUE = 1;
	
	public static PriceEntity getPriceEntity() {
		PriceEntity priceEntity = new PriceEntity();
		priceEntity.setStartDate(LocalDateTime.now());
		priceEntity.setBrandId(BRAND_ID_VALUE);
		priceEntity.setCurr(CURR_VALUE);
		priceEntity.setPrice(Float.parseFloat(PRICE_VALUE));
		priceEntity.setPriceList(PRICE_LIST_VALUE);
		priceEntity.setPriority(PRIORITY_VALUE);
		priceEntity.setProductId(PRODUCT_ID_VALUE);
		priceEntity.setEndDate(priceEntity.getStartDate().plusDays(DAYS_VALUE));
		return priceEntity;
	}

}
