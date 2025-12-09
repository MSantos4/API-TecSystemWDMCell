package com.wdmcell.TecSystem.DTO.Response;

import java.time.LocalDateTime;

public class Response<T> {
    private String status;
    private String messagem;
    private LocalDateTime timestamp;
    private T data;

    public Response(String status, String messagem, LocalDateTime timestamp, T data) {
        this.status = status;
        this.messagem = messagem;
        this.timestamp = timestamp;
        this.data = data;
    }

    public Response(String status, String messagem, LocalDateTime timestamp) {
        this.status = status;
        this.messagem = messagem;
        this.timestamp = timestamp;
    }
}
