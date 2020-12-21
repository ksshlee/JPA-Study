package com.study.jpa.projection;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentProjectionByClass {
    private String content;

    private Long likeCount;

    private Long disLikeCount;

    public String getTotalReactions(){
        return this.likeCount + " "+ this.disLikeCount;
    }
}
