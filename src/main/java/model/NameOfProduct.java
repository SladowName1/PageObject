package model;

public enum NameOfProduct {
    bicycleRed("Карты Bicycle Standart (красные)"),
    bicycleBlue("Карты Bicycle Standart (синие)"),
    fournuerRed("Карты Bee без пчелы (красные)"),
    fournierBlue("Карты Bee без пчелы (синие)"),
    bicycleStargazer("Карты Bicycle Stargazer");

    private final String nameOfProduct;

    NameOfProduct(String nameOfProduct){this.nameOfProduct=nameOfProduct;}

    public String getNameOfProduct(){return nameOfProduct;}
}
