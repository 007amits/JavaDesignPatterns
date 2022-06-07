package FactoryDesignPattern;

import java.util.Scanner;

public class PhoneBill {

  public static void main(String[] args) {
    SelectNetworkFactory planFactory = new SelectNetworkFactory();
    System.out.println("Enter the name of network for which the bill will be generated: ");
    Scanner sc =new Scanner(System.in);
    String networkName = sc.next();
    System.out.println("Enter the number of minutes for bill will be calculated: ");
    int minutes = sc.nextInt();
    CellularPlan p = planFactory.getPlan(networkName);
    System.out.println("Bill amount for "+networkName+" of "+minutes+" units is: ");
    p.getRate();
    p.processBill(minutes);

  }

}
