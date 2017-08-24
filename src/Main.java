/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Loscordonhdez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Laboratorio1_2 start = new Laboratorio1_2();
        vrspc vrs= new vrspc();
        String[] a=new String[1];
        boolean r1=true;
        Scanner e=new Scanner(System.in);
        Modulos v= new Modulos(false);
        do{
        System.out.println("Bienvenido a Totito");
        System.out.println("(1) Historial");
        System.out.println("(2) Jugar");
        System.out.println("(3) Borrar Historial");
        System.out.println("(4) Contra Computador");
        String op=e.next();
        switch(op){
            case "1":
                r1=false;
                System.out.println("*************HISTORIAL*************");
                System.out.println(v.registroshow());
                break;
            case "2":
                r1=false;
                System.out.println("*************TOTITO*************");
            start.main(a);
                break;
            case "3":
                r1=false;
                v.clearegistro();
                System.out.println("*************HISTORIAL VACIO*************");
                break;
            case "4":
                r1=false;
                System.out.println("*************VRS PC*************");
                vrs.pc();
                break;
            default:
                v.opcioninvalida();
                break;
        }
            System.out.println("¿Desea repetir ese menu? S/N");
            String opr=e.next();
                    if(opr.equalsIgnoreCase("s")){
                    r1=true;
                    };
        }while(r1);
    }
}
