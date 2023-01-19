import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Persona> family = new ArrayList<>();
        Persona ivan = new Persona("Иван", Gender.MALE, null, null);
        Persona elena = new Persona("Елена", Gender.FEMALE, null, null);
        ivan.partner = elena;
        elena.partner = ivan;
        Persona peter = new Persona("Пётр", Gender.MALE, ivan, elena);
        Persona mary = new Persona("Мария", Gender.FEMALE, ivan, elena);
        Persona alex = new Persona("Алексей", Gender.MALE, mary, null);
        ivan.addChild(peter);
        ivan.addChild(mary);
        elena.addChild(peter);
        elena.addChild(mary);
        mary.addChild(alex);
        Persona vladimir = new Persona("Владимир", Gender.MALE, null, null);
        mary.partner = vladimir;
        vladimir.partner = mary;
        vladimir.addChild(alex);
        family.add(ivan);
        family.add(elena);
        family.add(peter);
        family.add(mary);
        family.add(alex);
        family.add(vladimir);

        int inputOption;
        boolean shouldContinue = true;

        Scanner scanner = new Scanner(System.in);

        while (shouldContinue) {
            System.out.println("Введите цифру:\n" +
                    "0 - меню;\n" +
                    "1 - вывести список всех людей;\n" +
                    "2 - вывести дерево для определенного человека;\n" +
                    "3 - чтобы завершить программу.");
            do {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                }
                inputOption = scanner.nextInt();
            } while (!Input.isValidOption(inputOption));

            scanner.nextLine();

            switch (inputOption) {
                case 0:
                    break;
                case 1:
                    String message = "";
                    for (Persona itemPersona : family) {
                        message += itemPersona.name + "\n";
                    }
                    prettyPrint(message);
                    break;
                case 2:
                    String rootName;
                    Persona root = null;
                    System.out.println("Введите имя: ");
                    do {
                        rootName = scanner.nextLine();
                    } while (!Input.isValidOption(inputOption));
                    for (Persona itemPersona : family) {
                        String name = itemPersona.name;
                        if (name.equalsIgnoreCase(rootName)) {
                            root = itemPersona;
                        }

                    }
                    if (root == null) {
                        prettyPrint("В семье нет человека с таким именем!");
                    } else {
                        System.out.println();
                        System.out.println("====================");
                        ViewTree.view(root, 0);
                        System.out.println("====================");
                        System.out.println();
                    }
                    break;
                case 3:

                    prettyPrint("Выход!");

                    shouldContinue = false;
                    break;
            }
        }

        scanner.close();
        System.exit(0);

    }

    private static void prettyPrint(String message) {
        System.out.println();
        System.out.println("====================");
        System.out.println(message);
        System.out.println("====================");
        System.out.println();
    }

}
