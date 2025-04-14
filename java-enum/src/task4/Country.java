package task4;

public enum Country {

    COOUNTRY_A(1000, "ABC"), COUNTRY_B(2000, "DEF"), COUNTRY_C(3000, "GHI");

    private long population = 0;
    private String currency = "";

    Country(long population, String currency) {
        this.population = population;
        this.currency = currency;
    }

    public long changePopulation(int delta) {
        this.population += delta;
        return this.population;
    }

    public void printDetails() {
        String startName = this.name().substring(0, 1);
        String endName = this.name().toLowerCase().substring(1);
        String prettyName = startName.concat(endName);
        System.out.printf("The country name is %s, its population is %d, and the currency is %s.%n", prettyName, this.population, this.currency);
    }

}
