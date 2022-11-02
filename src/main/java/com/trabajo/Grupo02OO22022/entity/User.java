package com.trabajo.Grupo02OO22022.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@RequiredArgsConstructor
public class User extends Persona implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String username;

    @Column(columnDefinition = "tinyint(1) default 1", nullable = false)
    private boolean enabled;

    @NotEmpty
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
