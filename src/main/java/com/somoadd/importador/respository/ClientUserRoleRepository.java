package com.somoadd.importador.respository;


import com.somoadd.importador.entity.Client;
import com.somoadd.importador.entity.ClientUserRole;
import com.somoadd.importador.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientUserRoleRepository extends JpaRepository<ClientUserRole, Long> {

    @Query("Select new ClientUserRole(c.client, c.role) from ClientUserRole c where c.user.id = :userId")
    List<ClientUserRole> GetRolesForUser(@Param("userId") long userId);

    List<ClientUserRole> getAllByUser(User user);

    @Query("Select new ClientUserRole (c.user) from ClientUserRole c where c.client.id = :clientId")
    List<ClientUserRole>getAllUsersFromClient(@Param("clientId") long clientId);

    @Query("Select new ClientUserRole(c.user.id, c.user.username, c.user.email, c.user.active, c.role.id, c.role.name, c.client) from ClientUserRole c where c.client.id = :clientId")
    List<ClientUserRole>getAllUsersWithoutAdministratorRole(@Param("clientId") long clientId);

    @Query("Select new ClientUserRole(c.user.id, c.user.username, c.user.email, c.user.active, c.role.id, c.role.name, c.client) from ClientUserRole c ")
    List<ClientUserRole>getUsers();

    ClientUserRole findByUser(User user);

    ClientUserRole findByClientAndUser(Client client, User user);
}
