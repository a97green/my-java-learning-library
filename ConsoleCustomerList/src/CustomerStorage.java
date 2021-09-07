import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException("Не верный формат ввода строки!");
        }

        String name = components[0] + " " + components[1];
        String email = components[2];
        String phone = components[3];

        if (!name.matches("\\D+\\s+\\D+")) {
            throw new IllegalArgumentException("Не верный формат имени!");
        }
        if (!email.matches("\\w+@\\D+.\\D+")) {
            throw new IllegalArgumentException("Не верный формат E-mail адреса!");
        }
        if (!phone.matches("^7\\d+")) {
            throw new IllegalArgumentException("Не верный формат номера телефона!");
        }
        if (isPhone(phone)) {
            throw new IllegalArgumentException("Номер телефона уже есть в списке!");
        }

        storage.put(name, new Customer(name, phone, email));
        System.out.println("Покупатель добавленв список!");
    }

    public void listCustomers()
    {
        if (!(storage.keySet().size() != 0)) {
            throw new NullPointerException("Список пуст!");
        }
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if (!storage.containsKey(name)) {
            throw new ArrayIndexOutOfBoundsException("Не существующий элемент!");
        }
        storage.remove(name);
        System.out.println("Элемент удалён из списка");
    }

    public int getCount()
    {
        return storage.size();
    }

    public boolean isPhone(String phone) {
        for (String key : storage.keySet()) {
            Customer customer = storage.get(key);
            if (customer.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
}