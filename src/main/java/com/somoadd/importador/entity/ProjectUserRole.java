package com.somoadd.importador.entity;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProjectUserRole")
public class ProjectUserRole extends AbstractBaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
    private Project project;

    @OneToOne
    private User user;

    @OneToOne
    private Role role;

    public ProjectUserRole(){

    }

    public ProjectUserRole(long userId, String userName, String email,Role role) {
        this.user = new User(userId,userName,email);
        this.user.setRole(role.getName().name());
    }

    public ProjectUserRole(Project project, User user, Role role) {
        this.project = project;
        this.user = user;
        this.role = role;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
