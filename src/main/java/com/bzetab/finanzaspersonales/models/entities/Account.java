package com.bzetab.finanzaspersonales.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    private String bank;
    private Double balance;
    @Column(nullable = false)
    private Boolean isActive;

    //Log
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateModified;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference("account_owner")
    private Set<AccountDetail> owner = new HashSet<>();
}
