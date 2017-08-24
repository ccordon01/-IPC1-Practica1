/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Loscordonhdez
 */
public class Modulos {
    boolean playerw;

    public Modulos(boolean playerw) {
        this.playerw = playerw;
    }
    
    public boolean isPlayerw() {
        return playerw;
    }

    public void setPlayerw(boolean playerw) {
        this.playerw = playerw;
    }
    public boolean verint(String a){
        boolean estatus= false;
        for(int i=0;i<10000;i++){
        if(a.equals(String.valueOf(i))){
        estatus=true;
        }
        }
        return estatus;
    }
    public void mostrar(String[][] matriz,int tmn) {
    String l="|";
    String n="";
    String sshow="";
    for(int i=0;i<tmn;i++){
    String show="";
    String s="- ";
    sshow="";
    for(int j=0;j<tmn;j++){
    show=show+matriz[i][j]+l;
    }
    for(int k=0;k<=tmn;k++){
    sshow=s+sshow;
    }
    n=n+"\n"+sshow+"\n"+l+show;
    }
    n=n+"\n"+sshow;
        System.out.println(n);
    }
    protected void winner(int x, int y, String z,String[][] m,int tmn) {
    int c=0,c1=0,c2=0,c3=0;
    for(int i=0;i<tmn;i++){
        if(m[x-1][i]==z){
            c++;
        }
        if(m[i][y-1]==z){
            c1++;
        }
    }
    if(c==tmn || c1==tmn){
    setPlayerw(true);
    }
    else{
    for(int j=0;j<tmn;j++){
        if(m[j][j]==z){
        c2++;
        }
        if(m[(tmn-1)-j][j]==z){
        c3++;
        }
    }
    if(c2==tmn || c3==tmn){
    setPlayerw(true);
    }
    else{
    setPlayerw(false);
    }
    }
    
    }
    public boolean verstring(String n,String m,String[][] o,int p){
    boolean estatus=false;
    if(n.length()==5 || n.length()==7){
    if((String.valueOf(n.charAt(0)).equalsIgnoreCase("(") && verint(String.valueOf(n.charAt(1)))
            && String.valueOf(n.charAt(2)).equalsIgnoreCase(",") && verint(String.valueOf(n.charAt(3)))
            && String.valueOf(n.charAt(4)).equalsIgnoreCase(")")) || 
            (String.valueOf(n.charAt(0)).equalsIgnoreCase("(") && verint(String.valueOf(n.charAt(1)))
            && verint(String.valueOf(n.charAt(2))) && String.valueOf(n.charAt(3)).equalsIgnoreCase(",") && verint(String.valueOf(n.charAt(4)))
            && verint(String.valueOf(n.charAt(5))) && String.valueOf(n.charAt(6)).equalsIgnoreCase(")"))){
        try{
        if(insertar(Integer.parseInt(String.valueOf(n.charAt(1))),Integer.parseInt(String.valueOf(n.charAt(3))),m,o,p)){
    estatus=true;
    winner(Integer.parseInt(String.valueOf(n.charAt(1))),Integer.parseInt(String.valueOf(n.charAt(3))),m,o,p);
        }
        }
        catch(Exception e){
        
        if(insertar(Integer.parseInt(String.valueOf(n.charAt(1))+String.valueOf(n.charAt(2))),Integer.parseInt(String.valueOf(n.charAt(4))+String.valueOf(n.charAt(5))),m,o,p)){
    estatus=true;
    winner(Integer.parseInt(String.valueOf(n.charAt(1))+String.valueOf(n.charAt(2))),Integer.parseInt(String.valueOf(n.charAt(4))+String.valueOf(n.charAt(5))),m,o,p);
        }
        }
    }
    }
    return estatus;
    }
    public boolean insertar(int x, int y, String z,String[][] m,int tmn){
        boolean estatus=false;
        if(x>=1 && x<=tmn && y>=1 && y<=tmn){
            if(m[x-1][y-1].equals(" ")){
                m[x-1][y-1]=z;
                estatus=true;
            }
        }
    return estatus;
    }
    public void opcioninvalida(){
            System.out.println("Opcion invalida");
            System.out.println("*****************");
    }

    public void registro(String save) {
        String show="";
        File fichero = new File("fichero_escritura.txt");
		Scanner s = null;
		try {
			// Leemos el contenido del fichero
			s = new Scanner(fichero);
			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				show=show+"\n"+linea;           // Imprimimos la linea
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
    FileWriter fichero1 = null;
		try {

			fichero1 = new FileWriter("fichero_escritura.txt");
                        save= save+"\n"+show;
                        fichero1.write(save);
			fichero1.close();

		} 
                catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
    }
    public String registroshow(){
        String show="";
    File fichero = new File("fichero_escritura.txt");
		Scanner s = null;
		try {
			// Leemos el contenido del fichero
			s = new Scanner(fichero);
			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				show=show+"\n"+linea;           // Imprimimos la linea
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
                return show;
    }

    void clearegistro() {
      FileWriter fichero1 = null;
		try {

			fichero1 = new FileWriter("fichero_escritura.txt");
                        fichero1.write("");
			fichero1.close();

		} 
                catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}}
    public String pc(String[][]  m,String r,String c){
    String pos="";
    int nf=-1;
    int nc=-1;
    int contador=0;
    for(int i=0;i<3;i++){
        contador=0;
    for(int j=0;j<2;j++){
        if(m[i][j]==r){
        contador++;
        }
    }
    if(m[i][contador]==" " && contador==2){
       nf=i;
       nc=contador;
       i=3;
    }
    }
    for(int i=0;i<3;i++){
        contador=0;
    for(int j=2;j<0;j--){
        if(m[i][j]==r){
        contador++;
        }
    }
    if(m[i][2-contador]==" " && contador==2){
       nf=i;
       nc=2-contador;
       i=3;
    }
    }
    for(int i=0;i<3;i++){
        contador=0;
    for(int j=0;j<2;j++){
        if(m[j][i]==r){
        contador++;
        }
    }
    if(m[contador][i]==" " && contador==2){
       nc=i;
       nf=contador;
       i=3;
    }
    }
    for(int i=0;i<3;i++){
        contador=0;
    for(int j=2;j<0;j--){
        if(m[j][i]==r){
        contador++;
        }
    }
    if(m[2-contador][i]==" " && contador==2){
       nc=i;
       nf=2-contador;
       i=3;
    }
    }
    for(int i=0;i<2;i++){
        contador=0;
        if(m[i][i]==r){
        contador++;
        }
    if(m[contador][contador]==" " && contador==2){
       nf=contador;
       nc=contador;
       i=3;
    }
    }
    for(int i=2;i<0;i--){
        contador=0;
        if(m[i][i]==r){
        contador++;
        }
    if(m[2-contador][2-contador]==" " && contador==2){
       nf=2-contador;
       nc=2-contador;
       i=3;
    }
    }
    for(int i=0;i<2;i++){
        contador=0;
        if(m[2-i][i]==r){
        contador++;
        }
    if(m[2-contador][contador]==" " && contador==2){
       nf=2-contador;
       nc=contador;
       i=3;
    }
    }
    for(int i=0;i<2;i++){
        contador=0;
        if(m[i][2-i]==r){
        contador++;
        }
    if(m[contador][2-contador]==" " && contador==2){
       nf=contador;
       nc=2-contador;
       i=3;
    }
    }
    if(nf==-1 && nc==-1){
        boolean check=false;
    Random numf=new Random ();
    Random numc=new Random ();
    do{ 
        nf=numf.nextInt(3);
        nc=numc.nextInt(3);
        if(m[nf][nc]==" "){
            check=false;
        }
        else{
            nf=-1;
            nc=-1;
            check=true;
        }
    }while(check);
    }
    pos="("+(nf+1)+","+(nc+1)+")";
    return pos;
    }
}