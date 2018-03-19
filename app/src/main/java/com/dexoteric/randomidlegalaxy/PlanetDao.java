package com.dexoteric.randomidlegalaxy;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PlanetDao {

    @Query("SELECT * FROM planets")
    List<Planet> getAllPlanets();


    @Insert
    void insertPlanet(Planet... planets);

    @Update
    void updatePlanet(Planet... planets);

    @Delete
    void deletePlanet(Planet planet);

    @Query("DELETE FROM planets")
    void  deleteAllPlanets();

}
