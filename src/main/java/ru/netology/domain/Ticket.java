package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int timePath;

    public Ticket(int id, int price, String airportFrom, String airportTo, int timePath) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.timePath = timePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public int getTimePath() {
        return timePath;
    }

    public void setTimePath(int timePath) {
        this.timePath = timePath;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        }
        return 0;
    }
}
