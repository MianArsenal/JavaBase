package classloader;

public class HelloClassLoader {

    private String word;

    public HelloClassLoader() {
    }

    public HelloClassLoader(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "My word is " + this.word;
    }

    public static void main(String[] args) {
        HelloClassLoader helloClassLoader = new HelloClassLoader("test");
        System.out.println(helloClassLoader.toString());
    }
}
