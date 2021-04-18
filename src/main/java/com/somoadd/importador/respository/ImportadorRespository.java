package com.somoadd.importador.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somoadd.importador.model.Importador;

@Repository
public interface ImportadorRespository extends JpaRepository<Importador, Long> {

}
