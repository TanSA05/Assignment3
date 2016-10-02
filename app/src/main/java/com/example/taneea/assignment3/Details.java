package com.example.taneea.assignment3;

/**
 * Created by Taneea on 02-10-2016.
 */
public class Details {
    String _email;
    String _name;
    String _gender;
    String _age;

    public Details(){
    }

    public Details(String email, String name, String gender, String age){
        this._email = email;
        this._name = name;
        this._gender = gender;
        this._age = age;
    }

    public Details(String email, String gender, String age){
        this._email = email;
        this._gender = gender;
        this._age = age;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getEmail(){
        return this._email;
    }

    public void setEmail(String email){
        this._email = email;
    }

    public String getAge(){
        return this._age;
    }

    public void setAge(String age){
        this._age = age;
    }

    public String getGender(){
        return this._gender;
    }

    public void setGender(String gender){
        this._gender = gender;
    }


}
