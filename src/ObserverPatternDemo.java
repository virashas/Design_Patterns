import java.util.ArrayList;
import java.util.List;

// Subject
class Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Observer
abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

// Concrete Observer
class ConcreteObserver extends Observer {
    public ConcreteObserver(Subject subject) {
        ConcreteObserver aThis = this;
        aThis.subject = subject;
        aThis.subject.attach(aThis);
    }

    @Override
    public void update() {
        System.out.println("State changed to: " + subject.getState());
    }
}

// Client code
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();


        subject.setState(1); // Outputs "State changed to: 1"
        subject.setState(2); // Outputs "State changed to: 2"
    }
}