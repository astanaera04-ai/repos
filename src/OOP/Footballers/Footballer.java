package OOP.Footballers;

public class Footballer {
    int id ;
    String name;
    String surname;
    public Footballer(int id , String name , String surname){//конструктор
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    //Method
    public void getinfo(){
        System.out.println("id = "+id);
        System.out.println("name = " + name);
        System.out.println("surname = " + surname);
    }

}
