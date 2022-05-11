/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package REGISTER;

/**
 *
 * @author ACER
 */
public class Register {

    public static void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String name,kelas,place,date,gender;
    private int nim;
    
    
    /**
     * Return the name
     */
    //ENCAPSULATION
    public String getName(){
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName (String name){
        this.name = name;
    }
    
    /**
     * Return the nim
     */
    public int getNim (){
        return nim;
    }
    
    /**
     * @param nim the nim to set
     */
    public void setNim (int nim) {
        this.nim = nim;
    }
    
    /**
     * Return the class
     */
    public String getKelas(){
        return kelas;
    }
    
    /**
     * @param Kelas the Kelas to set
     */
    public void setKelas (String Kelas){
        this.kelas = kelas;
    }
    
    /**
     * Return the place
     */
    public String getPlace(){
        return place;
    }
    
    /**
     * @param place the place to set
     */
    public void setPlace (String place){
        this.place = place;
    }
    
    /**
     * Return the date 
     */
    public String getDate(){
        return date;
    }
    
    /**
     * @param date the date to set
     */
    public void setDate (String date){
        this.date = date;
    }
    
    /**
     * Return gender
     */
    public String getGender(){
        return gender;
    }
    
    /**
     * @param gender the gender to set
     */
    public void setGender (String gender){
        this.gender = gender;
    }

    public void show() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
