package Utils;

import Models.Customer;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class CustomerUtils {
    private static final String[] cities = {
            "São Paulo", "Rio de Janeiro", "Belo Horizonte", "Porto Alegre", "Curitiba",
            "Salvador", "Fortaleza", "Recife", "Brasília", "Manaus", "Belém", "Goiânia",
            "Vitória", "Natal", "Campinas", "São Bernardo do Campo", "Osasco", "Santo André",
            "Caxias do Sul", "Guarulhos"
    };

    private static final String[] states = {
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
            "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
            "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    };

    private static final String[] countries = {
            "Brasil", "Estados Unidos", "Canadá", "Alemanha", "Japão",
            "China", "Austrália", "França", "Itália", "Índia",
            "Argentina", "México", "Espanha", "Portugal", "Suíça",
            "Chile", "Colômbia", "Reino Unido", "Suécia", "Holanda"
    };


    public static Customer generateRandomCustomer() {
        String name = RandomStringUtils.randomAlphabetic(10);
        String lastName = RandomStringUtils.randomAlphabetic(10);
        String contactFirstName = RandomStringUtils.randomAlphabetic(10);
        String phone = generateRandomPhoneNumber();
        String city = generateRandomCityName();
        String state = generateRandomStateCode();
        String postalCode = generateRandomPostalCode();
        String country = generateRandomCountryName();
        String creditLimit = RandomStringUtils.randomNumeric(5);

        return new Customer(
                name,
                lastName,
                contactFirstName,
                phone,
                city,
                state,
                postalCode,
                country,
                creditLimit
        );
    }

    private static String generateRandomPhoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    private static String generateRandomCityName() {
        int citiesArrayLength = cities.length;
        int randomIndex = RandomUtils.nextInt(0, citiesArrayLength);
        return cities[randomIndex];
    }

    private static String generateRandomStateCode() {
        int estadosArrayLength = states.length;
        int randomIndex = RandomUtils.nextInt(0, estadosArrayLength);
        return states[randomIndex];
    }

    private static String generateRandomPostalCode() {
        return RandomStringUtils.randomNumeric(5);
    }

    private static String generateRandomCountryName() {
        int paisesArrayLength = countries.length;
        int randomIndex = RandomUtils.nextInt(0, paisesArrayLength);
        return countries[randomIndex];
    }
}