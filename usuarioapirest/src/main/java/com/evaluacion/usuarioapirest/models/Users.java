package com.evaluacion.usuarioapirest.models;

import com.evaluacion.usuarioapirest.dtos.UsersDTO;
import com.evaluacion.usuarioapirest.dtos.PhonesDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "modified", nullable = false)
    private LocalDateTime modified;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "token")
    private String token;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Phones> phones;

    public Users(UsersDTO user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.isActive = user.isActive();
        this.created = user.getCreated();
        this.modified = user.getModified();
        this.lastLogin = user.getLastLogin();
        this.token = user.getToken();

        this.phones = Optional.ofNullable(
                user
                        .getPhones())
                        .map(list ->
                                list
                                        .stream()
                                        .map(Phones::new)
                                        .collect(Collectors.toList()))
                                        .orElse(null);
    }
}