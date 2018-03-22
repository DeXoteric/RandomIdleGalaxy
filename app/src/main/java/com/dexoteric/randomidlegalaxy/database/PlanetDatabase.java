package com.dexoteric.randomidlegalaxy.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Planet.class}, version = 2)
public abstract class PlanetDatabase extends RoomDatabase {


    private static PlanetDatabase INSTANCE;

    public abstract PlanetDao planetDao();

    public static PlanetDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, PlanetDatabase.class, "planet_database")
//                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
            INSTANCE.addCapitalPlanet();

        }
        return INSTANCE;
    }

    private void addCapitalPlanet() {
        // dodaje stolicę do bazy danych jeśli ta jest pusta (po resecie gry)
        if (planetDao().count() == 0) {
            planetDao().addPlanet(new Planet("Capital", "Capital", "Capital", "Capital"));
        }
    }

    public static void destroyDatabaseInstance() {
        INSTANCE = null;
    }
}
