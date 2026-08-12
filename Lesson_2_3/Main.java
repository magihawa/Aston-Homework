public class Main{
    public static void main(String[] args) {
        Product[] goodsArray = new Product[5];
        goodsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 55990, true);
        goodsArray[1] = new Product("Samsung S25", "01.02.2025",
                "Samsung Corp.", "Korea", 55000, true);
        goodsArray[2] = new Product("Samsung S24 Ultra", "01.02.2024",
                "Samsung Corp.", "Korea", 50000, true);
        goodsArray[3] = new Product("Samsung S24", "01.02.2024",
                "Samsung Corp.", "Korea", 49000, false);
        goodsArray[4] = new Product("Samsung S23 Ultra", "01.02.2023",
                "Samsung Corp.", "Korea", 45000, false);

        for (Product item : goodsArray) {
            item.printProductInfo();
        }

        Park.Attraction carousel = new Park.Attraction("Карусель с лошадками", "09:00-17:00", 300);
        Park.Attraction roadhouse = new Park.Attraction("Автодром", "09:00-17:00", 400);

        Park park = new Park("Центральный парк", new Park.Attraction[]{carousel, roadhouse});
        park.printParkInfo();
    }
}