package com.spring.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    public String full, sprite, group;
    public int x, y, w, h;
}