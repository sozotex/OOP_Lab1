package Trading.Exceptions;

public class EmptySameCoffee extends Exception {
    public EmptySameCoffee() {
        super("There Is no such coffee anymore is empty");
    }
}
