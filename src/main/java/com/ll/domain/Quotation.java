package com.ll.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Quotation {
    int id;
    @Setter
    String content;
    @Setter
    String authorName;

    public Quotation(int id, String content, String authorName) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }
}