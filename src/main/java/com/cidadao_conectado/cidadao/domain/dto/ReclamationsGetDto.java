package com.cidadao_conectado.cidadao.domain.dto;

import java.util.UUID;

public class ReclamationsGetDto {

    private UUID id;

    private String title;
    private String text;
    public ReclamationsGetDto(UUID id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
