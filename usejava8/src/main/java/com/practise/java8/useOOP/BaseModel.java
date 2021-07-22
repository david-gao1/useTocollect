package com.practise.java8.useOOP;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class BaseModel  {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    private static final long serialVersionUID = 2901501802314796451L;


    protected Long modifiedUserId;


    protected Date modifiedTime;


    protected Long creationUserId;


    protected Date creationTime;


    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getCreationUserId() {
        return creationUserId;
    }

    public void setCreationUserId(Long creationUserId) {
        this.creationUserId = creationUserId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}