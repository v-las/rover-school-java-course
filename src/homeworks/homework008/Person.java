package homeworks.homework008;

public class Person {
    //    Задача №1
    //    Необходимо создать класс homeworks.homework008.Person с полями: имя, возраст, пол.
    //    Класс должен иметь метод - getName, метод возвращает имя с префиксом “Mr. ”
    //    если пол указан как мужской и префикс “Mrs. ” если женский.
    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    String name;
    int age;
    String gender;

    String getName() {
        if (gender.equals("male")) {
            return "Mr. " + name;
        } else if (gender.equals("female")) {
            return "Mrs. " + name;
        } else {
            return "Can be 'male' or 'female'";
        }
    }
}
