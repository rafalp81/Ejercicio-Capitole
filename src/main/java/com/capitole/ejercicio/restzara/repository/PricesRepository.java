/**
 * 
 */
package com.capitole.ejercicio.restzara.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capitole.ejercicio.restzara.repository.models.PriceEntity;



/**
 * @author Laura
 *
 */
@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, Integer> {
	
	@Query(value = "select * from prices p where p.product_id = :idProducto AND p.brand_id = :idCadena AND p.start_date <= :fecha AND p.end_date > :fecha order by p.priority desc limit 1", nativeQuery = true)
	public Optional<PriceEntity> findOnePrice(@Param("fecha")LocalDateTime fecha, @Param("idProducto")String idProducto, @Param("idCadena")Integer idCadena);

}
