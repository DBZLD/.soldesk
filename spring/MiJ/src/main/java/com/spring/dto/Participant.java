package com.spring.dto; 
import java.util.ArrayList;
public class Participant{
    public Companion companion;
    public int gold_left;
    public int last_round;
    public int level;
    public Missions missions;
    public int placement;
    public int players_eliminated;
    public String puuid;
    public String riotIdGameName;
    public String riotIdTagline;
    public double time_eliminated;
    public int total_damage_to_players;
    public ArrayList<Trait> traits;
    public ArrayList<Unit> units;
    public boolean win;
}
