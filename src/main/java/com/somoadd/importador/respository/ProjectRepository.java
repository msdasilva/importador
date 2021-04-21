package com.somoadd.importador.respository;

import java.util.List;

import com.somoadd.importador.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


	@Query(nativeQuery = true,value = "SELECT p FROM projects p where p.client_Id = :clientId and p.excluded=false")
	List<Project> GetProjectsByClient(long clientId) ;

	@Query(nativeQuery=true,value="SELECT FROM projects WHERE ProjectKey = :projectKey")
	List<Project> FindProjectByKey(String projectKey);

	@Query("SELECT new Project (p.id,p.name,p.description,p.type,p.active,p.createdAt,p.updatedAt) from Project p where p.id = :projectId")
	Project GetProjectById(@Param("projectId") long projectId);

	Project getByName(String name);

	@Query(nativeQuery = true,value = "SELECT id, created_at, updated_at, name, project_id, user_id FROM project_user_role p WHERE user_id = :userId")
	List<Project> GetProjectsRolesByUser(long userId) ;

	@Query("SELECT new Project (p.id,p.name,p.description,p.type,p.active,p.createdAt,p.updatedAt) from Project p where p.client.id = :clientId and p.excluded=false")
	List<Project> GetAllProjectsFromClient(@Param("clientId") long clientId);

	@Query("SELECT new Project (p.id) from Project p where p.name =:projectName and p.client.id = :clientId")
	Project ExistProjectClient(@Param("projectName") String projectName, @Param("clientId") long clientId);
	 
}
