/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Julio
 */

public class vrspc {
    public void pc(){
        int c=0;
        int winner=0;
        int tm=3;
        int cj=2;
        String op1="";
        boolean r1=true;
        boolean r2=true;
        Scanner e=new Scanner(System.in);
        Modulos v= new Modulos(false);
    //ASIGNACION NOMBRE Y CARACTER ESPECIAL
        String[] nombre= new String[cj];
        String[] caracter= {"X","O"};
        Random num=new Random ();
        nombre[num.nextInt(2)]="Computadora";
        boolean re1=false;
        boolean re12=true;
        for(int i=0;i<cj;i++){
            if(!String.valueOf(nombre[i]).equalsIgnoreCase("Computadora")){
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
        }}
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
            String j1="";
            if(!nombre[j].equalsIgnoreCase("computadora")){
            j1=e.next();
            }
            else{
            int cp=0;
            if(j==0){
               cp=1;
            }
            j1=v.pc(matriz,caracter[cp],caracter[j]);
                System.out.println(j1);
            }
            if(v.verstring(j1,caracter[j],matriz,tm)){
            c++;
            ver1=false;
            if(v.isPlayerw()){
            winner=j;
                System.out.println(winner);
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
