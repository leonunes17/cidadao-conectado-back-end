package com.cidadao_conectado.cidadao.domain.dto;

import java.util.UUID;

public class UserDelete {
    private UUID Id;

    public UserDelete(UUID id) {
        Id = id;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }
}
