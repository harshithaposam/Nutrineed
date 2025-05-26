package com.example.firebaseauth2;

class model
{
    String food_name;
    String food_prepared;
    String quantity;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String url;

    public String getPrice() {
        return ("Rs. " + price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    String price;

    public String getPhone() {
        return ("Phone : " + phone);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String phone;

    public String getAddress() {
        return ("Address : " + address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address;
//    double quantity;

    public String getRest_name() {
        return ("Restaurant : " + rest_name);
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    String rest_name;

    public String getCategory() {
        return ("Category : " + category);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    String category;
    String purl;
    model()
    {

    }
    public model(String food_name, String food_prepared, String quantity, String category, String rest_name, String address, String phone, String price, String url, String purl) {
        this.food_name= food_name;
        this.food_prepared = food_prepared;
        this.quantity = quantity;
        this.category = category;
        this.rest_name = rest_name;
        this.address = address;
        this.phone = phone;
        this.price = price;
        this.url = url;
        this.purl = purl;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_prepared() {
        return ("Food prepared in the " + food_prepared);
    }

    public void setFood_prepared(String food_prepared) {
        this.food_prepared = food_prepared;
    }

    public String getQuantity() {
        return ("Quantity : " + quantity);
    }

//    public String getQuantity() {
//        return ("Quantity : " + Double.toString(quantity));
//    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
