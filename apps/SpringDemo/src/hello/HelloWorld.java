package hello;

public class HelloWorld {

    private String name;

    public HelloWorld() {
        System.out.println("default constructor");
    }

    public HelloWorld(String name) {
        this.name = name;
        System.out.println("parametric constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " + this.name);
    }
}
