package com.somoadd.importador.respository;

import com.somoadd.importador.entity.DataSetCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataSetCategoryRepository extends JpaRepository<DataSetCategory,Long>{

	
}
