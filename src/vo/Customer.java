package vo;

public class Customer {
  /*
   * @cus_id int,
   * 
   * @card_id varchar(50),
   * 
   * @cus_name varchar(50),
   * 
   * @cus_phone varchar(50)
   */
  private int cus_id;
  private String card_id;
  private String cus_name;
  private String cus_phone;

  public void setCus_id(int cus_id) {
    this.cus_id = cus_id;
  }

  public int getCus_id() {
    return cus_id;
  }

  public void setCard_id(String card_id) {
    this.card_id = card_id;
  }

  public String getCard_id() {
    return card_id;
  }

  public void setCus_name(String cus_name) {
    this.cus_name = cus_name;
  }

  public String getCus_name() {
    return cus_name;
  }

  public void setCus_phone(String cus_phone) {
    this.cus_phone = cus_phone;
  }

  public String getCus_phone() {
    return cus_phone;
  }

}
