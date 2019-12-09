package hello;

public class HelloWorld {

    private String name;
    private Party party;

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
        sayYes();
        party.sayNo();
    }

    public void sayYes() {
        System.out.println("hello world says yes!!!!!");
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}
