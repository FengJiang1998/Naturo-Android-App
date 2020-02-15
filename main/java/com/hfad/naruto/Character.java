package com.hfad.naruto;

/**
 * Character.java - Constructor for a character object.
 */
public class Character {

    private int Id;
    private String Name;
    private String Country;
    private String Description;
    private int Attack;
    private int Defense;
    private int Speed;
    private int Health;
    private int Thumbnail;

    public Character() {

    }

    public Character(int id, String name, String country, String description, int thumbnail,int health, int attack, int defense, int speed) {
        Id = id;
        Name = name;
        Country= country;
        Description = description;
        Thumbnail = thumbnail;
        Health = health;
        Attack = attack;
        Defense = defense;
        Speed = speed;

    }

    public int getId(){return Id;}

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public String getDescription() {
        return Description;
    }

    public int getHealth() {return Health;}

    public int getAttack() {return Attack;}

    public int getDefense() {return Defense;}

    public int getSpeed() {return Speed;}

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setName(String name) { Name = name; }

    public void setCountry(String country) {
        Country = country;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public void setHealth(int health) {Health = health;}

    public void setAttack(int attack) {Attack = attack;}

    public void setDefense(int defense) {Defense = defense;}

    public void setSpeed(int speed) {Speed = speed;}
}
