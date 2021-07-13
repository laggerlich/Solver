package Third;

import java.text.SimpleDateFormat;
import java.util.*;

public class PersonAddress {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Person[] human = new Person[7];

        human[0] = new Person("Vladimir", "Mikhailov");
        human[0].setAddress(new Address("Volokolamskaya", "4k24", "324"));
        human[0].setDate("13/07/1959");

        human[1] = new Person("Eugeniy", "Vitomskiy");
        human[1].setAddress(new Address("Volokolamskaya", "4k24", "326"));
        human[1].setDate("15/05/1971");

        human[2] = new Person("Vladimir", "Putin");
        human[2].setAddress(new Address("Kremlin", "1", "1"));
        human[2].setDate("07/10/1952");

        human[3] = new Person("Ivan", "Petrov");
        human[3].setAddress(new Address("Leninskiy", "95", "123"));
        human[3].setDate("26/11/1982");

        human[4] = new Person("Petr", "Ivanov");
        human[4].setAddress(new Address("Verkhniye Polya", "35k2", "14"));
        human[4].setDate("26/04/1986");

        human[5] = new Person("Denis", "Borisov");
        human[5].setAddress(new Address("Volokolamskaya", "287", "354"));
        human[5].setDate("27/05/1985");

        human[6] = new Person("Boris", "Denisov");
        human[6].setAddress(new Address("Verkhniye Polya", "31/4", "24"));
        human[6].setDate("26/09/1984");

        PersonSearcher findMe = new PersonSearcher(human);
//        System.out.println("Search by last name, enter last name");
//        System.out.println(findMe.getPersonByLastName(in.next()));
//
//        System.out.println("Search by address attribute, enter a/s/h and parameter");
//        System.out.println(findMe.getPersonByAddress(in.next(), in.next()));
//
//         System.out.println("Search between dates, enter yy, mm, dd and yy, mm, dd");
//        findMe.getPersonsBetweenDates(new Date(in.nextInt(), in.nextInt()-1, in.nextInt()), new Date(in.nextInt(), in.nextInt()-1, in.nextInt()));
//
//        System.out.println("Let`s find the most young person");
//        findMe.getYoungest();

        System.out.println("Let`s find the most old person");
        findMe.getOldest();

        System.out.println("Who lives at the same street?");
        findMe.getSameStreet();
    }

}

class PersonSearcher {
    Person[] persons;

    public PersonSearcher(Person[] persons) {
        this.persons = persons;
    }

    public Person getPersonByLastName(String lastName) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getLastName().toLowerCase().equals(lastName.toLowerCase())) {
                return persons[i];
            }
        }
        return null;
    }

    public Person getPersonByAddress(String addressAttribute, String input) {
        switch (addressAttribute) {
            case "s":
                for (int i = 0; i < persons.length; i++) {
                    if (persons[i].getAddress().getStreet().toLowerCase().equals(input.toLowerCase())) {
                        return persons[i];
                    }
                }
                break;
            case "a":
                for (int i = 0; i < persons.length; i++) {
                    if (persons[i].getAddress().getApt().toLowerCase().equals(input.toLowerCase())) {
                        return persons[i];
                    }
                }
                break;
            case "h":
                for (int i = 0; i < persons.length; i++) {
                    if (persons[i].getAddress().getHouse().toLowerCase().equals(input.toLowerCase())) {
                        return persons[i];
                    }
                }
                break;
            default:
                System.out.println("Wrong attribute");
                return null;
        }
        return null;
    }

    public void getPersonsBetweenDates(Date date1, Date date2) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getDate().compareTo(date1) == 1 && persons[i].getDate().compareTo(date2) == -1) {
                System.out.println(persons[i]);
            }
        }
    }

    public void getYoungest() {
        Date initialDate = new Date(00, 1, 1);
        int iYoungest = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getDate().compareTo(initialDate) == 1) {
                iYoungest = i;
            }
        }
        System.out.println(persons[iYoungest]);
    }

    public void getOldest() {
        Date initialDate = new Date(121, 6, 13);
        int iOldest = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getDate().compareTo(persons[iOldest].getDate()) == -1) {
                iOldest = i;
            }
        }
        System.out.println(persons[iOldest]);
    }

    public void getSameStreet() {
        for (int i = 0; i < persons.length; i++) {
            for (int j = 0; j < persons.length; j++) {
                if (i == j) continue;
                if (persons[i].getAddress().getStreet().equals(persons[j].getAddress().getStreet())) {
                    System.out.println("Person " + persons[i].getFirstName() + " " + persons[i].getLastName() + " lives at the same street as " + persons[j].getFirstName() + " " + persons[j].getLastName());
                }
            }
        }
    }


}

class Address {
    private String street;
    private String house;
    private String apt;

    public Address(String street, String house, String apt) {
        this.street = street;
        this.house = house;
        this.apt = apt;
    }

    @Override
    public String toString() {
        return "Street " + street + ", house " + house + ", apartment " + apt;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getApt() {
        return apt;
    }
}

class Person {
    private String firstName;
    private String lastName;
    private Address address;
    private Date date;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, Address address, Date date) {
        this(firstName, lastName);
        this.address = address;
        this.date = date;
    }

    public void setDate(String input) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
            this.date = date;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + address + ", " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
    }
}
