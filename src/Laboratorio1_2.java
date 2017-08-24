/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Carlos Eduardo Cordon
 */
public class Laboratorio1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int c=0;
        int winner=0;
        int tm=0;
        int cj=0;
        String op1="";
        boolean r1=true;
        boolean r2=true;
        Scanner e=new Scanner(System.in);
        Modulos v= new Modulos(false);
        do{do{
        do{
        System.out.println("Seleccione su opcion de juego");
        System.out.println("(1) 2 Jugadores");
        System.out.println("(2) 3 Jugadores");
        System.out.println("(3) 4 Jugadores");
        String op=e.next(); 
        switch(op){
            case "1":
                r1=false;
                tm=2;
                cj=2;
                System.out.println("***************************");
                System.out.println("Seleccione tablero de juego");
                System.out.println("(1) 3x3");
                System.out.println("(2) 4x4");
                op1=e.next();
                if(v.verint(op1)){
                if(Integer.parseInt(op1)>=3){
                r1=true;
                }
                }
                break;
            case "2":
                r1=false;
                tm=4;
                cj=3;
                System.out.println("***************************");
                System.out.println("Seleccione tablero de juego");
                System.out.println("(1) 5x5");
                System.out.println("(2) 6x6");
                System.out.println("(3) 7x7");
                op1=e.next();
                break;
            case "3":
                r1=false;
                tm=7;
                cj=4;
                System.out.println("***************************");
                System.out.println("Seleccione tablero de juego");
                System.out.println("(1) 8x8");
                System.out.println("(2) 9x9");
                System.out.println("(3) 10x10");
                op1=e.next();
                break;
            default:
                v.opcioninvalida();
                r1=true;
                break;
        }
        }while(r1);
        if(v.verint(op1)){
            if((Integer.parseInt(op1)>=1 && Integer.parseInt(op1)<=3)){
            tm=tm+Integer.parseInt(op1);
            r1=false;
            r2=false;
            }
            else{
            r2=true;
            v.opcioninvalida();
            }
        }
        else{
            r2=true;
            v.opcioninvalida();
        }
        }while(r2);
        }while(r1);
        //ASIGNACION NOMBRE Y CARACTER ESPECIAL
        String[] nombre= new String[cj];
        String[] caracter= new String[cj];
        boolean re1=false;
        boolean re12=true;
        for(int i=0;i<cj;i++){
            System.out.print("Jugador "+(i+1)+": ");
                do{
                 re1=false;
                 re12=true;
                    String s=e.next();
            for(int j=0;j<cj;j++){
                if(String.valueOf(nombre[j]).equalsIgnoreCase(s)){
                    re12=false;
            }
            }
            if(re12){
            nombre[i]=s;
            re1=false;
            }
            else{
                System.out.print("Ingrese nombre de nuevo: ");
                re1=true;
            }
            }while(re1);
            System.out.print("Caracter Jugador "+(i+1)+": ");
            do{
                 re1=false;
                 re12=true;
                    char s=e.next().charAt(0);
            for(int j=0;j<cj;j++){
                if(String.valueOf(caracter[j]).equalsIgnoreCase(String.valueOf(s))){
                    re12=false;
            }
            }
            if(re12){
            caracter[i]=String.valueOf(s);
            re1=false;
            }
            else{
                System.out.print("Ingrese caracter de nuevo: ");
                re1=true;
            }
            }while(re1);
        }
        //CREACION DEL TABLERO[MATRIZ]
        String[][] matriz= new String[tm][tm];
        for(int i=0;i<tm;i++){
        for(int j=0;j<tm;j++){
        matriz[i][j]=" ";
        }
        }
        v.mostrar(matriz,tm);
        //INICIO ACCION DE JUGADORES
        do{
            boolean ver1=false;
            // INICIO JUGADOR
            for(int j=0;j<cj;j++){
                if(!v.isPlayerw()){
            do{
            System.out.print(nombre[j]+": ");
            String j1=e.next();
            if(v.verstring(j1,caracter[j],matriz,tm)){
            c++;
            ver1=false;
            if(v.isPlayerw()){
            winner=j;
            }
            v.mostrar(matriz, tm);
            }
            else{
                System.out.println("Ingrese su posicion de nuevo");
                ver1=true;
            }
            }while(ver1);}
            if(c==(tm*tm)){
            j=cj;
            }
            }
        }while(v.isPlayerw()==false && c<(tm*tm));
        // NOTIFICACION JUGADOR GANADOR Y/O EMPATE
        if(v.isPlayerw()){
            System.out.println("Jugador Ganador: "+nombre[winner]);
            System.out.println("Jugador Ganador Caracter : "+caracter[winner]);
            String h="Jugadores: ";
            for(int i=0;i<nombre.length;i++){
                h=h+ nombre[i]+" ";
            }
            Date n = new Date();
            String save=h+"- Dimensiones Tablero: "+tm+" - Jugador Ganador: "+nombre[winner]+" - Simbolo: "+caracter[winner]+" - Fecha: "+n.getDate()+"/"+(n.getMonth()+1)+"/"+(n.getYear()-100)+" -Hora: "+(n.getHours())+":"+n.getMinutes();
            v.registro(save);
        }
        else{
            System.out.println("Juego finalizado en empate");
        }
    }
}