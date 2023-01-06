package com.example.myapp;


import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;


public class AccesLocal {

    private String nomeBase = "Myapp.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;
    public AccesLocal(Context context){
        accesBD = new MySQLiteOpenHelper(context,nomeBase, null,versionBase);
    }

    public  void ajout(Sign_in sign_in){
        bd = accesBD.getWritableDatabase();
        String req ="insert into sign_in (Email, Password";
        req += "(\""+sign_in.getEmail+"\","+sign_in.getPassword+")";
        bd.execSQL(req);
    }
    public Sign_in recupDernier(){
        bd = accesBD.getReadableDatabase();
        Sign_in sign_in=null;
        String req ="select * from Sign_in";
       Cursor curseur =bd.rawQuery(req, null);
       curseur.moveToLast();
        Sign_in Sign_in = new Sign_in();
        if(!curseur.isAfterLast()){
           Integer Email = curseur.getInt( 1);
           Integer Password = curseur.getInt(2);
           Integer ConformPassword =curseur.getInt(3);
           Sign_in = new Sign_in(Email, Password,ConformPassword);
       }curseur.close();
       return Sign_in;
    }
}
