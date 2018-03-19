package com.dexoteric.randomidlegalaxy;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Planet.class}, version = 2)
public abstract class PlanetDatabase extends RoomDatabase {

    public abstract PlanetDao planetDao();


}
