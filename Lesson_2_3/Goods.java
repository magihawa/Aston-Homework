public class Goods{
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean isReserved;
 
    public Goods(String name, String productionDate, String manufacturer, 
            String countryOfOrigin, int price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printGoodsInfo (){
        System.out.println("Название: " + name + 
        "; Дата производства: " + productionDate + 
        "; Производитель: " + manufacturer + 
        "; Страна происхождения: " + countryOfOrigin + 
        "; Цена: " + price + " руб." + 
        "; Зарезервировано:" + (isReserved ? " Да" : " Нет"));
    }

        public static void main(String[] args) {
       Goods[] goodsArray = new Goods[5];
        goodsArray[0] = new Goods("Samsung S25 Ultra", "01.02.2025",
               "Samsung Corp.", "Korea", 55990, true);
        goodsArray[1] = new Goods("Samsung S25", "01.02.2025",
               "Samsung Corp.", "Korea", 55000, true);
        goodsArray[2] = new Goods("Samsung S24 Ultra", "01.02.2024",
               "Samsung Corp.", "Korea", 50000, true);
        goodsArray[3] = new Goods("Samsung S24", "01.02.2024",
               "Samsung Corp.", "Korea", 49000, false);
        goodsArray[4] = new Goods("Samsung S23 Ultra", "01.02.2023",
               "Samsung Corp.", "Korea", 45000, false);

        for (Goods item : goodsArray) {
            item.printGoodsInfo();
        }
    }
}

