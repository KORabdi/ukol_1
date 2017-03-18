/*
 * File name: Start.java
 * Date:      2014/09/04 12:34
 * Author:    @author
 */

package cz.cvut.fel.pjv;

import java.util.Locale;

public class Start {

   public static void main(String[] args) {
	  Locale.setDefault(new Locale("en", "US"));
      Lab01 lab = new Lab01();
      lab.start(args);
   }

}
