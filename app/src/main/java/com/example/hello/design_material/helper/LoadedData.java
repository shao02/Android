package com.example.hello.design_material.helper;

import com.example.hello.design_material.domain.BroadcastMsg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xu_s on 3/18/17.
 */

public class LoadedData {
    static public List<BroadcastMsg> broadcastMsg = new ArrayList<>(Arrays.asList(
            new BroadcastMsg("I am a basketball superstar, wanna play ball together?",
            "2 hours ago",
            "Kevin Garnett",
            "profile","M"),
            new BroadcastMsg("i am miss hong kong, i am 25 years old" +
                             ", i want to visit new york,where can i go, i am boring, very very boring, new to this nice app",
                             "1 hours ago",
                             "Lai ik",
                             "pic1","F"),
            new BroadcastMsg("i want to go for a party",
                                     "1 hours ago",
                                     "wong lee",
                                     "pic2","F"),
            new BroadcastMsg("i want to walk around...",
                    "30 mins ago",
                    "kevin wang",
                    "pic3","M"),
            new BroadcastMsg("What is 34th street...",
                    "30 mins ago",
                    "kevin wang",
                    "pic4","M"),
            new BroadcastMsg("Cool Day",
                    "30 mins ago",
                    "kevin wang",
                    "pic5","F"),
            new BroadcastMsg("want to enjoy the sunny day.",
                    "30 mins ago",
                    "kevin wang",
                    "pic6","F")));

    static public List<BroadcastMsg> getPopularList(){
        List<BroadcastMsg> rt = new ArrayList<>();
        for(BroadcastMsg cur : broadcastMsg){
            if(cur.getGender().equals("F")){
                rt.add(cur);
            }
        }
        return rt;
    }

    static public List<BroadcastMsg> getMyList(){
        List<BroadcastMsg> rt = new ArrayList<>();
        for(BroadcastMsg cur : broadcastMsg){
            if(cur.getUserName().equals("lee")){
                rt.add(cur);
            }
        }
        return rt;
    }
}
