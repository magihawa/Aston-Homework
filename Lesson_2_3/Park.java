public class Park{
    private String name;
    private Attraction[] attractions;

    public Park (String name, Attraction[] attractions){
        this.name = name;
        this.attractions = attractions;
    }

    public void printParkInfo(){
        System.out.println("Парк: " + name);
        for (Attraction a : attractions){
            a.printAttractionInfo();
        }
    }

    private static class Attraction{
        private String description;
        private String workHours;
        private int price;

        public Attraction(String description, String workHours, int price){
            this.description = description;
            this.workHours = workHours;
            this.price = price;
        }

        public void printAttractionInfo(){
            System.out.println("Аттракцион: " + description + 
            "; " + "Время работы: " + workHours +
            "; " + "Стоимость: " + price + "руб.");
        }
    }
        public static void main(String[] args) {
            Attraction carousel = new Attraction("Карусель с лошадками", "09:00-17:00", 300);
            Attraction roadhouse = new Attraction("Автодром", "09:00-17:00", 400);

            Park park = new Park("Центральный парк", new Attraction[]{carousel, roadhouse});
            park.printParkInfo();
    }
}
