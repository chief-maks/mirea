package Lab_1516.customer;

public class Address {              //класс адреса клиента
    private String cityName;        //город
    private int zipCode;            //почтовый индекс
    private String streetName;      //улица
    private int buildingNumber;     //номер дома
    private char buildingLetter;    //корпус дома
    private int apartmentNumber;    //номер квартиры

    /* константный пустой адрес */
    public static final Address EMPTY_ADDRESS = new Address("default", 111111, "default", 0, 0 );

    /* перегруженные конструкторы */
    public Address(String cityName, int zipCode, String streetName, int buildingNumber, int apartmentNumber) {
        this(cityName, zipCode, streetName, buildingNumber, ' ', apartmentNumber);
    }
    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;               //присвоение полям значений параметров
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.buildingLetter = buildingLetter;
    }

    public String getCityName() { return cityName; }                //методы получения значений полей
    public int getZipCode() { return zipCode; }
    public String getStreetName() { return streetName; }
    public int getBuildingNumber() { return buildingNumber; }
    public char getBuildingLetter() { return buildingLetter; }
    public int getApartmentNumber() { return apartmentNumber; }
}