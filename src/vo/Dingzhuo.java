package vo;

import java.sql.Date;

public class Dingzhuo {
  private int cus_id;
  private int id;
  private Date dinnertime;

  public void setCus_id(int cus_id) {
    this.cus_id = cus_id;
  }

  public int getCus_id() {
    return cus_id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setDinnertime(Date dinnertime) {
    this.dinnertime = dinnertime;
  }

  public Date getDinnertime() {
    return dinnertime;
  }
}
