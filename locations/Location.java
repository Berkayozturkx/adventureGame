package MaceraOyunu;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String locationName;
    protected Scanner input = new Scanner(System.in);

    public Location(Player player, String locationName){
        this.player = player;
        this.locationName = locationName;
    }

    public Player getPlayer(){ return this.player;}
    public void setPlayer(Player player){this.player = player;}

    public String getLocationName(){return this.locationName;}
    public void setLocationName(String locationName){this.locationName = locationName;}

    public abstract boolean onLocation();

}
