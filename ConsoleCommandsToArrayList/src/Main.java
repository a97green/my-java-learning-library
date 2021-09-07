import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String LIST = "^LIST\\s*$";
    private static String ADD = "^ADD\\s+\\S+\\s*$";
    private static String DELETE = "^DELETE\\s+\\d+\\s*$";
    private static String ADD_INDEX = "^ADD\\s+\\d+\\s+\\S+\\s*$";
    private static String EDIT = "^EDIT\\s+\\d+\\s+\\S+\\s*$";
    private static String EXIT = "^EXIT\\s*$";

    private ArrayList<String> todoList = new ArrayList<>();

    public void list() {
        if (todoList.size() > 0) {
            System.out.println(todoList);
        } else {
            System.out.println("Этот список пуст!");
        }
    }
    public void add(String todo) {
        todoList.add(todo);
        System.out.println("Дело добавлено в список!");
    }
    public void add(String todo, int indexTodo) {
        if (todoList.size() > indexTodo) {
            todoList.add(indexTodo, todo);
            System.out.println("Дело добавлено в список!");
        } else {
            System.out.println("Номер дела выходит за пределы списка!");
            todoList.add(todo);
            System.out.println("Дело добавлено в конец списка!");
        }
    }
    public void edit(String todo, int indexTodo){
        if (todoList.size() > indexTodo) {
            todoList.set(indexTodo, todo);
            System.out.println("Дело в списке заменено!");
        } else {
            System.out.println("Номер дела выходит за пределы списка!");
            todoList.add(todo);
            System.out.println("Дело добавлено в конец списка!");
        }
    }
    public void delete(int indexTodo) {
        if (todoList.size() > indexTodo) {
            todoList.remove(indexTodo);
            System.out.println("Дело №" + indexTodo + " удалено из списка!");
        } else {
            System.out.println("Дела нет в списке!");
        }
    }
    public void splitCommand(String commandConsole) {
        String[] command = commandConsole.split(" ");
        if (commandConsole.matches(LIST)) {
            list();
        }
        else if (commandConsole.matches(ADD)) {
            add(command[1]);
        }
        else if (commandConsole.matches(DELETE)) {
            int indexTodo = Integer.parseInt(command[1]);
            delete(indexTodo);
        }
        else if (commandConsole.matches(ADD_INDEX)) {
            int indexTodo = Integer.parseInt(command[1]);
            add(command[2], indexTodo);
        }
        else if (commandConsole.matches(EDIT)) {
            int indexTodo = Integer.parseInt(command[1]);
            edit(command[2], indexTodo);
        }
        else if (commandConsole.matches(EXIT)){
            System.exit(0);
        }
        else {
            System.out.println("Ошибка! Неверная команда!");
        }
    }

    public static void main(String[] args) {
        Main play = new Main();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду...");
            String command = scanner.nextLine();
            play.splitCommand(command);
        }

    }
}
