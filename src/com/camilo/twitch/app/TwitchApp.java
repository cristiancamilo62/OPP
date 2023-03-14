package com.camilo.twitch.app;

import com.camilo.twitch.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwitchApp {
    static Twitch allData = new Twitch();
    static Scanner enterDate=new Scanner(System.in);
    static ArrayList<Streamer> listStreamer=new ArrayList<Streamer> ();
    static ArrayList<Person> listPerson=new ArrayList<Person> ();
    static ArrayList<Subscriber> listSubscriber=new ArrayList<Subscriber>();
    static ArrayList<Follower> listFollower=new ArrayList<Follower>();
    static int id;
    static String name;
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        boolean finish=false;
        do {
            System.out.println("\tMENU");
            System.out.println("1. for create account streamer");
            System.out.println("2. for create account subscriber");
            System.out.println("3. for create account follower");
            System.out.println("4. for subscribe to a streamer");
            System.out.println("5. for show streamers");
            System.out.println("6. for show subscribers de un streamer");
            System.out.println("Enter finish to close program");
            // System.out.println("Option");
            String option = enterDate.nextLine();
            switch(option) {
                case "1":
                    createStreamer();
                    enterDate.nextLine();

                    break;
                case "2":
                    createSubscriber();
                    enterDate.nextLine();
                    break;
                case "5":
                    allData.getSubscribers();
                    break;
                case "finish":
                    System.out.println("program finished");
                    finish=true;
                    break;
            }
        } while(!finish);
    }
    public static void createStreamer(){
        System.out.println("Enter the streamer name");
        name=enterDate.nextLine();
        System.out.println("Enter the streamer id");
        id=enterDate.nextInt();
        Person person1=new Person(name,id);
        Streamer streamer1=new Streamer(person1);
        listStreamer.add(streamer1);
        allData.setStreamers(listStreamer);
        System.out.println("create successful");
    }
    public static void createSubscriber(){
        System.out.println("Enter the Subscriber name");
        name=enterDate.nextLine();
        System.out.println("Enter the Subscriber id");
        id=enterDate.nextInt();
        Person person1=new Person(name,id);
        Subscriber subscriber1=new Subscriber(person1);
        listSubscriber.add(subscriber1);
        allData.setSubscribers(listSubscriber);
        System.out.println("create successful");
    }
    public static void createFollower(){
        System.out.println("Enter the Follower name");
        name=enterDate.nextLine();
        System.out.println("Enter the Follower id");
        id=enterDate.nextInt();
        Person person1=new Person(name,id);
        Follower follower1=new Follower(person1);
        listFollower.add(follower1);
        allData.setFollowers(listFollower);
        System.out.println("create successful");
    }
    public static void searchStreamer(List<Streamer> streamers, String name){
        for (Streamer s: streamers){
            if(s.person.name == name){

            }
        }
    }
}




