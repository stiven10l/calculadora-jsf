/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softhk.recursos;
import java.io.Serializable;

/**
 *
 * @author Registro01
 */
public class Carater implements Serializable{
    
    private String nom_carater;
    private String valor_carater;

    public Carater() {
    }

    public Carater( String valor_carater,String nom_carater) {
        this.nom_carater = nom_carater;
        this.valor_carater = valor_carater;
    }
    

    public String getNom_carater() {
        return nom_carater;
    }

    public void setNom_carater(String nom_carater) {
        this.nom_carater = nom_carater;
    }

    public String getValor_carater() {
        return valor_carater;
    }

    public void setValor_carater(String valor_carater) {
        this.valor_carater = valor_carater;
    }
    
     
}
