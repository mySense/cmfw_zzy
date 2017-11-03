package com.baizhi.zzy.entity;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Chapter {
    private String id;
    private String name;
    private String download;
    private Double size;
    private String status;
    //音频时长
    private String duration;
    private Album album;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Chapter() {
    }

    public Chapter(String id, String name, String download, Double size, String status, String duration, Album album) {
        this.id = id;
        this.name = name;
        this.download = download;
        this.size = size;
        this.status = status;
        this.duration = duration;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", download='" + download + '\'' +
                ", size=" + size +
                ", status='" + status + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
