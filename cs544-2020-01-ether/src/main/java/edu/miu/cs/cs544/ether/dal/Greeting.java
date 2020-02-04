package edu.miu.cs.cs544.ether.dal;

public class Greeting {
    private String greeting;
    private Fortune fortune;

    public Greeting() {
    }

    public Greeting(String greeting, Fortune fortune) {
        this.greeting = greeting;
        this.fortune = fortune;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Fortune getFortune() {
        return fortune;
    }

    public void setFortune(Fortune fortune) {
        this.fortune = fortune;
    }
}
