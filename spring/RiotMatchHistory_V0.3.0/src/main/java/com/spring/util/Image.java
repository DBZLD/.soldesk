package com.spring.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    public String full;		//�̹��� �̸�
    public String sprite;	//��������Ʈ �̸�
    public String group;	//�̹��� ����
    public int x;			//��������Ʈ x ��ġ
    public int y;			//��������Ʈ y ��ġ
    public int w;			//��������Ʈ �ʺ�
    public int h;			////��������Ʈ ����
}