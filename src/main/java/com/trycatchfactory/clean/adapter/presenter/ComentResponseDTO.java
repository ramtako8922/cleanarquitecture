package com.trycatchfactory.clean.adapter.presenter;

public class ComentResponseDTO {
    private String id;
    private String title;
    private  String content;

    public ComentResponseDTO(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
