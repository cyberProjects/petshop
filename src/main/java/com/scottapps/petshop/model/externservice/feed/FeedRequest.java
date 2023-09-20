package com.scottapps.petshop.model.externservice.feed;

public class FeedRequest {
    private String feed = "Default FeedRequest";

    public FeedRequest() {
    }

    public String getFeed() {
        return feed;
    }

    @Override
    public String toString() {
        return "FeedRequest{" +
                "feed='" + feed + '\'' +
                '}';
    }
}
