/**
 * 
 */
package com.capitole.ejercicio.restzara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitole.ejercicio.restzara.repository.models.PriceEntity;



/**
 * @author Laura
 *
 */
@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Integer> {

}
