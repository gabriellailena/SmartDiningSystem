package com.lakj.comspace.simpletextclient;

public class Info {
    private int tableno;
    private int price;
    private String order;
    private int timetaken;
    public Integer getTime(){
        return timetaken;
    }
    public Integer getTableno() {
        return tableno;
    }
    public String getOrder(){
        return order;
    }
    public void setTime(Integer tt){
        timetaken=tt;
    }
    public void setOrder(String Order){
        order=Order;
    }

    public void setTableno(Integer tablenob) {

        tableno=tablenob;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer tprice) {
        price = tprice;
    }

    public Info() {

    }
}
