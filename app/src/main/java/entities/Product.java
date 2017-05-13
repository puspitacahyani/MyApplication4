package entities;

import java.io.Serializable;
import java.util.*;
import java.util.jar.Attributes;

public class Product implements Serializable {
    private String id;
    private String name;
    private int photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public Product(String id , String name , int photo){
        this.id=id;
        this.name=name;
        this.photo=photo;

    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name=name;
    }
}
