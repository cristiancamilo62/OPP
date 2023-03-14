package com.camilo.twitch.domain;

import java.util.List;

public class Streamer {
    public Person person;
    public int amountFollowers;
    public int amountSubscribers;
    public List <Follower> follower;
    public List <Subscriber> subscriber;

    public Streamer(Person person) {
        this.person = person;
    }

    public void showFollowers(){
        System.out.println("The list of Followers name is:\n");
        for (Follower f:follower){
                System.out.println(f.person.name);
            }
        }
    public void showSubscribers(){
        System.out.println("The list of Subscribers name is:\n");
        for (Subscriber f:subscriber){
                System.out.println(f.person.name);
        }
    }

    public void setAmountFollowers(int amountFollowers) {
        this.amountFollowers = amountFollowers;
    }

    public void setAmountSubscribers(int amountSubscribers) {
        this.amountSubscribers = amountSubscribers;
    }
}
