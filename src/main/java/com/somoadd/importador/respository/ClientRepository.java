package com.somoadd.importador.respository;


import com.somoadd.importador.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

	List<Client> findAll();

	@Query(value="SELECT c FROM Client c WHERE c.name = :name")
	Client findByName(@Param("name") String name);

	@Query(value="SELECT c FROM Client c WHERE c.email = :email")
	Client findByEmail(@Param("email") String email);

	@Query(value="SELECT c FROM Client c WHERE c.cpf = :cpf")
	Client findByCPF(@Param("cpf") String cpf);

	@Query(value="SELECT c FROM Client c WHERE c.cnpj = :cnpj")
	Client findByCNPJ(@Param("cnpj") String cnpj);

	@Query(value="SELECT uc FROM user_client uc WHERE uc.user_id = :userId",nativeQuery = true)
	Client findByUserId(@Param("userId") Long userId);

	@Query(value="select c.* from public.client c inner join public.user_client u on c.id = u.client_id	where u.user_id = :userId;",nativeQuery = true)
	Client findByUser(@Param("userId") Long userId);
}
