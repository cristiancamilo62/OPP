package com.camilo.twitch.domain;

import java.util.List;

public class Twitch {
    public List<Streamer> streamers;
    public List<Follower> followers;
    public List<Subscriber> subscribers;

    public void getStreamers() {
        int numStreamer = 1;
        for(Streamer st : streamers){
            System.out.println("Follower: "+ numStreamer);
            System.out.println("Name: " + st.person.name + " Id: "+ st.person.id);
            numStreamer++;
        }
    }

    public void setStreamers(List<Streamer> streamers) {
        this.streamers = streamers;
    }

    public void getFollower () {
        int numFollower = 1;
        for(Follower f : followers){
            System.out.println("Follower: "+ numFollower);
            System.out.println("Name: " + f.person.name + " Id: "+ f.person.id);
            numFollower++;
        }
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    public void getSubscribers() {
        int numSubscriber = 1;
        for (Subscriber s: subscribers){
            System.out.println("Subscriber: "+ numSubscriber);
            System.out.println("Name: " + s.person.name + " Id: "+ s.person.id);
            numSubscriber++;
        }
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
