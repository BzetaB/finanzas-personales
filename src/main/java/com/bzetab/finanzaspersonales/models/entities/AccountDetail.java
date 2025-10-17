package com.bzetab.finanzaspersonales.models.entities;

import com.bzetab.finanzaspersonales.models.entities.key.AccountOwnerId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accountDetail")
public class AccountDetail {
    @EmbeddedId
    private AccountOwnerId id;
    private Boolean isActive;
    //Log
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateModified;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    @JsonBackReference("account_owner")
    private Account account;

    @ManyToOne
    @MapsId("ownerId")
    @JoinColumn(name = "owner_id")
    @JsonBackReference("owner_account")
    private Owner owner;

}
