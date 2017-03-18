package cz.cvut.fel.pjv;

import java.util.Scanner;

public class Lab01 {
	private Scanner scanner = new Scanner(System.in);
	private int operator = 0;
	private String[] operatorSign ={
		"+",
		"-",
		"*",
		"/"
	};
	final String[][] olist={{
			"scitanec",
			"mensenec",
			"cinitel",
			"delenec"
		},
		{
			"scitanec",
			"mensitel",
			"cinitel",
			"delitel"
		}};
	private double[] hodnoty = {0,0};
	private int size;
	
   public void homework(){
	  this.setOperator();
	  this.setHodnoty(0);
	  this.setHodnoty(1);
	  this.setSize();
	  this.vypis(this.getVysledek());
   }
	
   public void start(String[] args) {
	   this.homework();
   }
   
   private void setOperator(){
	   System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
	   operator = scanner.nextInt();
	   if (operator<1 || operator>4){
		   System.err.println("Chybna volba!");
		   System.exit(1);
	   }
	   this.operator--;
   }
   
   private void setSize(){
	   System.out.println("Zadej pocet desetinnych mist: ");
	   size = scanner.nextInt();
	   if (size < 0){
		   System.err.println("Chyba - musi byt zadane kladne cislo!");
		   System.exit(1);		   
	   }
   }
   
   private void setHodnoty(int index){
	   System.out.println(
			   "Zadej "
			   +olist[index][operator]
			   +": "
			   );
	   hodnoty[index] = scanner.nextDouble();
	   if(index == 1 && operator==3 && hodnoty[1]==0){
		   System.err.println("Pokus o deleni nulou!");
		   System.exit(1);
	   }
   }
   
   private double getVysledek(){
	   switch(this.operator){
		   case 0:
			   return this.hodnoty[0] + this.hodnoty[1];
		   case 1:
			   return this.hodnoty[0] - this.hodnoty[1];
		   case 2:
			   return this.hodnoty[0] * this.hodnoty[1];
		   case 3:
			   return this.hodnoty[0] / this.hodnoty[1];
		   default:
			   System.err.println("Spatny operator!");
			   System.exit(1);
			   	break;
	   }
	   return 0;
   }
   
   private void vypis(double vysledek){
	   System.out.format("%."+size+"f %s %."+size+"f = %."+size+"f\n",hodnoty[0],operatorSign[operator],hodnoty[1],vysledek);
   }
}