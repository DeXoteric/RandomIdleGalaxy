package com.dexoteric.randomidlegalaxy;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "planets")
public class Planet {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "room_planet_id")
    private int roomPlanetId;
    @ColumnInfo(name = "room_planet_name")
    private String roomPlanetName;
    @ColumnInfo(name = "room_planet_type")
    private String roomPlanetType;
    @ColumnInfo(name = "room_planet_size")
    private String roomPlanetSize;
    @ColumnInfo(name = "room_planet_quality")
    private String roomPlanetQuality;

    public Planet() {
    }

    public Planet(String roomPlanetName, String roomPlanetType, String roomPlanetSize, String roomPlanetQuality) {
        this.roomPlanetName = roomPlanetName;
        this.roomPlanetType = roomPlanetType;
        this.roomPlanetSize = roomPlanetSize;
        this.roomPlanetQuality = roomPlanetQuality;
    }

    public int getRoomPlanetId() {
        return roomPlanetId;
    }

    public void setRoomPlanetId(int roomPlanetId) {
        this.roomPlanetId = roomPlanetId;
    }

    public String getRoomPlanetName() {
        return roomPlanetName;
    }

    public void setRoomPlanetName(String roomPlanetName) {
        this.roomPlanetName = roomPlanetName;
    }

    public String getRoomPlanetType() {
        return roomPlanetType;
    }

    public void setRoomPlanetType(String roomPlanetType) {
        this.roomPlanetType = roomPlanetType;
    }

    public String getRoomPlanetSize() {
        return roomPlanetSize;
    }

    public void setRoomPlanetSize(String roomPlanetSize) {
        this.roomPlanetSize = roomPlanetSize;
    }

    public String getRoomPlanetQuality() {
        return roomPlanetQuality;
    }

    public void setRoomPlanetQuality(String roomPlanetQuality) {
        this.roomPlanetQuality = roomPlanetQuality;
    }
}
