package ru.kpfu.itis.model;

import ru.kpfu.itis.model.enums.RoleEnumeration;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles", schema = "public", catalog = "postgres")
public class Role {
    public Role() {
    }

    public RoleEnumeration getName() {
        return name;
    }

    public void setName(RoleEnumeration name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Id
    @Enumerated(EnumType.STRING)

    private RoleEnumeration name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<User> users;

    public Role(RoleEnumeration name) {
        this.name = name;
    }

}

