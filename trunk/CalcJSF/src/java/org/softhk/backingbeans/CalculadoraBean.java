/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.softhk.backingbeans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.softhk.recursos.Carater;

/**
 *
 * @author Registro01
 */
@ManagedBean(name = "calcbean")
@SessionScoped
public class CalculadoraBean implements Serializable {

    private ArrayList<Carater> listaCarter;
    private String valorEntrada;
    private String valorSalida;
    private String Operador;
    private int resultado;
    private boolean activo;
    private String IGUAL;

    public CalculadoraBean() {
        listaCarter = new ArrayList<Carater>();

        Carater btn1 = new Carater("MC", "MC");
        Carater btn2 = new Carater("MR", "MR");
        Carater btn3 = new Carater("CE", "CE");
        Carater btn4 = new Carater("C", "C");

        Carater btn5 = new Carater("7", "7");
        Carater btn6 = new Carater("8", "8");
        Carater btn7 = new Carater("9", "9");
        Carater btn8 = new Carater("/", "D");

        Carater btn9 = new Carater("4", "4");
        Carater btn10 = new Carater("5", "5");
        Carater btn11 = new Carater("6", "6");
        Carater btn12 = new Carater("*", "M");

        Carater btn13 = new Carater("1", "1");
        Carater btn14 = new Carater("2", "2");
        Carater btn15 = new Carater("3", "3");
        Carater btn16 = new Carater("-", "R");

        Carater btn17 = new Carater("0", "0");
        Carater btn18 = new Carater(".", "PUNTO");
        Carater btn19 = new Carater("+", "S");
        Carater btn20 = new Carater("=", "IGUAL");

        listaCarter.add(btn1);
        listaCarter.add(btn2);
        listaCarter.add(btn3);
        listaCarter.add(btn4);
        listaCarter.add(btn5);
        listaCarter.add(btn6);
        listaCarter.add(btn7);
        listaCarter.add(btn8);
        listaCarter.add(btn9);
        listaCarter.add(btn10);
        listaCarter.add(btn11);
        listaCarter.add(btn12);
        listaCarter.add(btn13);
        listaCarter.add(btn14);
        listaCarter.add(btn15);
        listaCarter.add(btn16);
        listaCarter.add(btn17);
        listaCarter.add(btn18);
        listaCarter.add(btn19);
        listaCarter.add(btn20);
        valorEntrada = "";
        Operador = "";
    }

    public String getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(String valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public String getValorSalida() {
        return valorSalida;
    }

    public void setValorSalida(String valorSalida) {
        this.valorSalida = valorSalida;
    }

    public ArrayList<Carater> getListaCarter() {
        return listaCarter;
    }

    public void setListaCarter(ArrayList<Carater> listaCarter) {
        this.listaCarter = listaCarter;
    }

    public void MiEvento(ActionEvent evt) {
        String btnAction = evt.getComponent().getId().replaceFirst("_", "");

        if (btnAction.equalsIgnoreCase("M")) {
            Operador = "MULTIPLICACION";
            if (valorEntrada.equals("")) {
                return;
            }
            activo = true;
        } else if (btnAction.equalsIgnoreCase("D")) {
            activo = true;
            Operador = "DIVISION";
        } else if (btnAction.equalsIgnoreCase("R")) {
            activo = true;
            Operador = "RESTA";
        } else if (btnAction.equalsIgnoreCase("S")) {
            activo = true;
            Operador = "SUMA";
        } else if (btnAction.equalsIgnoreCase("IGUAL")) {
            activo = true;
            IGUAL = "IGUAL";
        } else if (btnAction.equalsIgnoreCase("C")) {
            activo = true;
            Operador = "C";
        } else {
            valorEntrada += btnAction;
        }


        if (Operador.equals("MULTIPLICACION") && activo == true) {
            if (resultado == 0) {
                resultado = 1;
            }
            activo = false;
            resultado = resultado * Integer.parseInt(valorEntrada);
            valorEntrada = "";
            valorSalida = String.valueOf(resultado);

        } else if (Operador.equals("DIVISION") && activo == true) {

            if (resultado == 0) {
                resultado = Integer.parseInt(valorEntrada);
            } else {

                resultado = resultado / Integer.parseInt(valorEntrada);
            }
            valorEntrada = "";
            activo = false;
            valorSalida = String.valueOf(resultado);
        } else if (Operador.equals("RESTA") && activo == true) {
            if (resultado == 0) {
                resultado = Integer.parseInt(valorEntrada);
            } else {
                resultado = resultado - Integer.parseInt(valorEntrada);
            }
            valorEntrada = "";
            activo = false;
            valorSalida = String.valueOf(resultado);
        } else if (Operador.equals("SUMA") && activo == true) {
            resultado = resultado + Integer.parseInt(valorEntrada);
            valorEntrada = "";
            activo = false;
            valorSalida = String.valueOf(resultado);

        } else if (btnAction.equalsIgnoreCase("IGUAL")) {

            if (Operador.equals("MULTIPLICACION")) {
                if (resultado == 0) {
                    resultado = 1;
                }
                resultado = resultado * Integer.parseInt(valorEntrada);
                valorEntrada = "";
                valorSalida = String.valueOf(resultado);
                Operador = "";
            } else if (Operador.equals("DIVISION")) {

                if (resultado == 0) {
                    resultado = Integer.parseInt(valorEntrada);
                } else {

                    resultado = resultado / Integer.parseInt(valorEntrada);
                }
                Operador = "";
                valorEntrada = "";
                valorSalida = String.valueOf(resultado);
            } else if (Operador.equals("RESTA")) {
                if (resultado == 0) {
                    resultado = Integer.parseInt(valorEntrada);
                } else {
                    resultado = resultado - Integer.parseInt(valorEntrada);
                }
                valorEntrada = "";
                Operador = "";
                valorSalida = String.valueOf(resultado);
            } else if (Operador.equals("SUMA")) {
                resultado = resultado + Integer.parseInt(valorEntrada);
                valorEntrada = "";

                valorSalida = String.valueOf(resultado);
            }

            valorEntrada = "";
            Operador = "";
            valorSalida = String.valueOf(resultado);
        } else if (btnAction.equalsIgnoreCase("C")) {
            Operador = "";
            valorEntrada = "";
            valorSalida = "";
            resultado = 0;

        }




    }
}
