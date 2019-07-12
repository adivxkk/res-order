package vo;

public class Card {
  private String card_id;
  private int cus_id;
  private int level;
  private float discount;
  private int point;
  private float money;
  private int y_id;

  public void setCard_id(String card_id) {
    this.card_id = card_id;
  }

  public String getCard_id() {
    return card_id;
  }

  public void setCus_id(int cus_id) {
    this.cus_id = cus_id;
  }

  public int getCus_id() {
    return cus_id;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }

  public void setDiscount(float discount) {
    this.discount = discount;
  }

  public float getDiscount() {
    return discount;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  public int getPoint() {
    return point;
  }

  public void setMoney(float money) {
    this.money = money;
  }

  public float getMoney() {
    return money;
  }

  public void setY_id(int y_id) {
    this.y_id = y_id;
  }

  public int getY_id() {
    return y_id;
  }
}