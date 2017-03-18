package cz.cvut.fel.pjv;

import java.util.Scanner;

public class Lab01 {
	private Scanner scanner = new Scanner(System.in);
	private int operator = 0;
	final static String[] SIGN_OPERATOR ={"+","-","*","/"};
	final static String[][] NAME_VALUE={{"scitanec","mensenec","cinitel","delenec"},{"scitanec","mensitel","cinitel","delitel"}};
	private double[] hodnoty = {0,0};
	private int size;
	
   public void homework(){
	  this.setIOOperator();
	  this.setIOValues(0);
	  this.setIOValues(1);
	  this.setIOSize();
	  this.print(this.getVysledekArr()[this.operator]);
   }
	
   public void start(String[] args) {
	   this.homework();
   }
   
   private void setIOOperator(){
	   System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
	   operator = scanner.nextInt();
	   if (operator<1 || operator>4){
		   System.err.println("Chybna volba!");
		   System.exit(1);
	   }
	   this.operator--;
   }
   
   private void setIOSize(){
	   System.out.println("Zadej pocet desetinnych mist: ");
	   size = scanner.nextInt();
	   if (size < 0){
		   System.err.println("Chyba - musi byt zadane kladne cislo!");
		   System.exit(1);		   
	   }
   }
   
   private void setIOValues(int index){
	   System.out.println("Zadej "+NAME_VALUE[index][operator]+": ");
	   hodnoty[index] = scanner.nextDouble();
	   if(index == 1 && operator==3 && hodnoty[1]==0){
		   System.err.println("Pokus o deleni nulou!");
		   System.exit(1);
	   }
   }
   
   private double[] getVysledekArr(){
	   double[] vysledek = {this.hodnoty[0] + this.hodnoty[1],this.hodnoty[0] - this.hodnoty[1],this.hodnoty[0] * this.hodnoty[1],this.hodnoty[0] / this.hodnoty[1]};
	   return vysledek;
   }
   
   private void print(double vysledek){
	   System.out.format("%."+size+"f %s %."+size+"f = %."+size+"f\n",hodnoty[0],SIGN_OPERATOR[operator],hodnoty[1],vysledek);
   }
}