package com.study.jpa.projection;

public interface CommentProjectionByInterface {
    String getContent();

    int getLikeCount();

    int getDisLikeCount();

    default String getTotalReactions(){
        return getLikeCount() + " " + getDisLikeCount();
    }

}
