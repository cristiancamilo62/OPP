package com.camilo.twitch.domain;

import java.util.List;

public class Subscriber {
    public Person person;
    public List<Streamer> streamersSubscribe;

    public Subscriber(Person person) {
        this.person = person;
    }

    public void AddStreamersSubscribe(Streamer name){
        streamersSubscribe.add(name);
        System.out.println("Successful subscription");
    }
    public void showStreamersSubscribe(){
        for (Streamer f:streamersSubscribe){
            int numStreamerSubscribers = 1;
            System.out.println("Streamer: "+ numStreamerSubscribers);
            System.out.println("Name: "+ f.person.name+ " Id: "+f.person.id);
        }
    }
}
