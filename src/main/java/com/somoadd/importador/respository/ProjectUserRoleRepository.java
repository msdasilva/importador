package com.somoadd.importador.respository;

import com.somoadd.importador.entity.ProjectUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProjectUserRoleRepository extends JpaRepository<ProjectUserRole, Integer> {

    @Query("Select new ProjectUserRole(p.user.id,p.user.username,p.user.email,p.role) from ProjectUserRole  p where p.project.id = :projectId")
    List<ProjectUserRole> getAssociatedGuests(@Param("projectId") long projectId);

    @Transactional
    void deleteByProjectId(Long projectId);
}
