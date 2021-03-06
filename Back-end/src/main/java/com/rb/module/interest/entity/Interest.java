package com.rb.module.interest.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Interest {
    @Id
    private String id;

    private String interestName;
    private List<String> contents;
    private Calendar lastTimeUpdated;
    private Calendar lastTimeAsked;
    private boolean asked;
    private int hashCode;
    private long lastTweetID;

    public Interest() {}

    public Interest(String interestName) {
        this.interestName = interestName;
        this.contents = new ArrayList<>();
        this.lastTimeUpdated = Calendar.getInstance();
        this.lastTimeUpdated.add(Calendar.MONTH,-12);//Inicializo con fecha vieja para que el cron actualice inmediatamente.
        this.lastTimeAsked = Calendar.getInstance();
        this.asked = true;
        this.lastTweetID = -1;
    }

    public String getInterestName() {
        return interestName;
    }

    public List<String> getContents(){
        return contents;
    }
    public List<String> getContents(int count){
        if(this.contents.size()>count) {
            return this.contents.subList(0,count);
        }
        return this.contents;
    }
    public void setContents(List<String> contents) {
        this.contents = contents;
    }
    public void addContents(List<String> contents) {
        this.contents.addAll(0, contents);
    }
    public void limitContents(int maxNumber) {
        if (this.contents.size()>maxNumber){
            this.contents.subList(maxNumber, this.contents.size());
        }
    }

    public int getHashCode() {return this.hashCode; }

    public void setHashCode() {
        this.hashCode = calculateHashCode(this.contents);
    }

    public int calculateHashCode(List<String> contents) {
        //TODO calculate with contents.
        return 0;
    }

    public Calendar getLastTimeUpdated(){
        return this.lastTimeUpdated;
    }

    public Calendar getLastTimeAsked(){
        return this.lastTimeAsked;
    }

    public void setUpdated(){
        this.lastTimeUpdated = Calendar.getInstance();
        this.asked = false;
    }

    public void setAsked(){
        this.lastTimeAsked = Calendar.getInstance();
        this.asked = true;
    }

    public void setLastTweetID(long lastTweetID) {
        this.lastTweetID = lastTweetID;
    }

    public long getLastTweetID() {
        return this.lastTweetID;
    }

    public int lastTimeUpdatedMinutesAgo() {
        return (int)((Calendar.getInstance().getTimeInMillis()-this.lastTimeUpdated.getTimeInMillis())/60000);
    }
}
