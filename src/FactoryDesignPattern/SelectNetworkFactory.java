package FactoryDesignPattern;

public class SelectNetworkFactory {
  
  public CellularPlan getPlan(String planType) {
    if(planType == null) {
      return null;
    } else if(planType.equalsIgnoreCase("abcnetwork")) {
      return new ABCNetwork();
    } else if(planType.equalsIgnoreCase("pqrnetwork")) {
      return new PQRNetwork();
    } else if(planType.equalsIgnoreCase("xyznetwork")) {
      return new XYZNetwork();
    }
    return null;
  }

}
