package co.edu.uptc.model;

public class Land {
  private String address;
  private int area;
  private int status;
  private String use;
  private int CadastreNumber;
  private double cadastralValue;

  public Land( int area, int status, String use, int cadastreNumber, double cadastralValue) {
    this.area = area;
    this.status = status;
    this.use = use;
    this.CadastreNumber = cadastreNumber;
    this.cadastralValue = cadastralValue;
  }

  public int getCadastreNumber() {
    return CadastreNumber;
  }

  public String getAddress() {
    return address;
  }

  public int getArea() {
    return area;
  }

  public int getStatus() {
    return status;
  }

  public String getUse() {
    return use;
  }

  public double getCadastralValue() {
    return cadastralValue;
  }

}
