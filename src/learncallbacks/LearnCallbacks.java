/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learncallbacks;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hanif
 */
public class LearnCallbacks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OmegaPrinterInterface printer = new Printer();
        printer.setPrintCallback(new PrintCallBack() {

            @Override
            public void onPrintFinished() {
                System.out.println("Print finished");
                goToNextPage();
            }
        });
        printer.printing();
    }
    
    private static void goToNextPage() {
        System.out.println("Go to next page");
    }
    


public static abstract class PrintCallBack {
    public abstract void onPrintFinished();
}

public static class Printer implements OmegaPrinterInterface {
  	private PrintCallBack callback;
  
	@Override
  	public void printing(){
              try {
                  System.out.println("Printing");
                  Thread.sleep(10000);
              } catch (InterruptedException ex) {
                  Logger.getLogger(LearnCallbacks.class.getName()).log(Level.SEVERE, null, ex);
              }
              
              callback.onPrintFinished();
        };
  
  	@Override
  	public void setPrintCallback(PrintCallBack callback) {
            this.callback = callback;
  	}
}

public static interface OmegaPrinterInterface{
	public void printing();
  	public void setPrintCallback(PrintCallBack callback);
}
    
}
