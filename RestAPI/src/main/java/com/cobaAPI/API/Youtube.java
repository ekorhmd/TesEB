package com.cobaAPI.API;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Youtube{


    private String channelId;
    private String title;
    private String channelName;
    private String publishedAt;    

    public Youtube(String channelId, String title, String channelName, String publishedAt) {
        this.channelId = channelId;
        this.title = title;
        this.channelName = channelName;
        this.publishedAt = publishedAt;
    }

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public String getChannelId() {
        return channelId;
    }

    public String getTitle() {
        return title;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}