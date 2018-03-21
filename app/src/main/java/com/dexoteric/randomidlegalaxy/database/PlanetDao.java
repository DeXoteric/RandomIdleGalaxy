package com.dexoteric.randomidlegalaxy.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PlanetDao {

    @Query("SELECT * FROM planets")
    List<Planet> getAllPlanets();


    @Insert
    void insertPlanet(Planet... planets);


    @Query("DELETE FROM planets")
    void  deleteAllPlanets();

}
