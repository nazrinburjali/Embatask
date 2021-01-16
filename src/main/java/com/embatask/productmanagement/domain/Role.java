package com.embatask.productmanagement.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleID")
    private int id;
    @Column(name = "roleName")
    private String roleName;
    @Column(name="defaultPage")
    private String defaultPage;
    @ToString.Exclude
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", defaultPage='" + defaultPage + '\'' +
                '}';
    }
}
