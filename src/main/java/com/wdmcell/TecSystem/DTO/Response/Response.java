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

    public Response() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
