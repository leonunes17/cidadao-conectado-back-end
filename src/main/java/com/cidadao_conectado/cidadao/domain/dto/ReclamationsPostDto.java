package com.cidadao_conectado.cidadao.domain.dto;

import java.util.UUID;

public class ReclamationsPostDto {

    private UUID Id;

    private String title;
    private String text;

    public ReclamationsPostDto( String title, String text, UUID id) {
        this.title = title;
        this.text = text;
        Id = id;
    }
    public UUID getId() {
        return Id;
    }
    public void setId(UUID id) {
        this.Id = id;
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
