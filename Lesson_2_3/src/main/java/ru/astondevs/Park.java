public class Park {
    private String name;
    private Attraction[] attractions;

    public Park(String name, Attraction[] attractions) {
        this.name = name;
        this.attractions = attractions;
    }

    public void printParkInfo() {
        System.out.println("\nПарк: " + name);
        for (Attraction a : attractions) {
            a.printAttractionInfo();
        }
    }

    public static class Attraction {
        private String description;
        private String workHours;
        private int price;

        public Attraction(String description, String workHours, int price) {
            this.description = description;
            this.workHours = workHours;
            this.price = price;
        }

        public void printAttractionInfo() {
            System.out.println("Аттракцион: " + description +
                    "; " + "Время работы: " + workHours +
                    "; " + "Стоимость: " + price + " руб.");
        }
    }
}