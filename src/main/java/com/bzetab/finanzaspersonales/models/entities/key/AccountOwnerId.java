package com.bzetab.finanzaspersonales.models.entities.key;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class AccountOwnerId implements Serializable {
    private Integer accountId;
    private Integer ownerId;
}
