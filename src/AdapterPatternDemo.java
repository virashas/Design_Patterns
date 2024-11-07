class OldSystem {
    public void oldMethod() {
        System.out.println("Old system method");
    }
}


interface NewSystem {
    void newMethod();
}


class Adapter implements NewSystem {
    private OldSystem oldSystem;

    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void newMethod() {
        oldSystem.oldMethod();
    }
}


public class AdapterPatternDemo {
    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        NewSystem adapter = new Adapter(oldSystem);
        adapter.newMethod(); // Outputs "Old system method"
    }
}