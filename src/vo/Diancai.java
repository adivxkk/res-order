package vo;

public class Diancai {
  private int id;
  private int c_id;
  private String ordertime;
  private int quantity;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setC_id(int c_id) {
    this.c_id = c_id;
  }

  public int getC_id() {
    return c_id;
  }

  public void setOrdertime(String ordertime) {
    this.ordertime = ordertime;
  }

  public String getOrdertime() {
    return ordertime;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

}
