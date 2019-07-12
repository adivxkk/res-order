package vo;

public class Caidan {
  private int id;
  private int cus_id;
  private String c_name;
  private float price;
  private int quantity;
  private float money;
  private String clss;
  private String picture;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setCus_id(int cus_id) {
    this.cus_id = cus_id;
  }

  public int getCus_id() {
    return cus_id;
  }

  public void setC_name(String c_name) {
    this.c_name = c_name;
  }

  public String getC_name() {
    return c_name;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public float getPrice() {
    return price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setMoney(float money) {
    this.money = money;
  }

  public float getMoney() {
    return money;
  }

  public void setClss(String clss) {
    this.clss = clss;
  }

  public String getClss() {
    return clss;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getPicture() {
    return picture;
  }

}
