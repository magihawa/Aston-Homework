public class Product{
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean isReserved;
 
    public Product(String name, String productionDate, String manufacturer, 
            String countryOfOrigin, int price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printProductInfo (){
        System.out.println("Название: " + name + 
        "; Дата производства: " + productionDate + 
        "; Производитель: " + manufacturer + 
        "; Страна происхождения: " + countryOfOrigin + 
        "; Цена: " + price + " руб." + 
        "; Зарезервировано: " + (isReserved ? "Да" : "Нет"));
    }
}


