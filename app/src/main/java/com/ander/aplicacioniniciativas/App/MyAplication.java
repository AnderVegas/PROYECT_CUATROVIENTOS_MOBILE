package com.ander.aplicacioniniciativas.App;

import android.app.Application;
import com.ander.aplicacioniniciativas.Models.Iniciativa;
import java.util.concurrent.atomic.AtomicInteger;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyAplication extends Application {
    public static AtomicInteger iniciativaID= new AtomicInteger();

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        if (results.size()>0){
            return new AtomicInteger(results.max("id").intValue());
        }else{
            return  new AtomicInteger(0);
        }
    }

    public void onCreate() {
        super.onCreate();
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        iniciativaID = getIdByTable(realm, Iniciativa.class);
        realm.close();
    }

    private void setUpRealmConfig() {
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);
    }

}
