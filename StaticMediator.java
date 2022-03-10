import java.util.ArrayList;
import java.util.Arrays;

public class StaticMediator {

    private Spy s1, s2, s3, s4;
    private Agent a1, c1;
    private Mole m1;
    //step 2
    //private Agent a2, a3;
    //private Mole m2, m3;
    //private CompositeAgent duo;

    public void createSpyTeam () {

        s1 = new Spy("spy1 ", "secret 1 ", 10, this);
        s2 = new Spy("spy2 ", "secret 2 ", 5, this);
        s3 = new Spy("spy3 ", "secret 3 ", 2, this);
        s4 = new Spy("spy4 ", "secret 4 ", 20, this);
        a1 = new Agent("a1 ", "ultra secret 1 ",this);
        m1 = new Mole("m1 ", "deep secret 1 ", this);
        c1 = new Agent("cleaner ", " no secret ",this);

        //step2
        //a2 = new Agent("a2 ", " ultra secret 2 ",this);
        //m2 = new Mole("m2 ", " deep secret 2 ", this);
        //a3 = new Agent("a3 ", " ultra secret 3 ",this);
        //m3 = new Mole("m3 ", " deep secret 3 ", this);
        //duo = new CompositeAgent (new ArrayList<CoordinatedAsset>(Arrays.asList(a2, m2)));


    }

    public StaticMediator() {
        createSpyTeam();
    }

    public void runScenario1 () {
        System.out.println("Initial set up");
        printStatus();
        s4.statusChange();
        s1.statusChange();
        s2.statusChange();
        s3.statusChange();
        s4.statusChange();
        a1.statusChange();
        m1.statusChange();
        c1.statusChange();
    }

    public void runScenario2 () {
        System.out.println("Initial set up");
        printStatus();
        duo.statusChange();
        a3.statusChange();
        m3.statusChange();
    }

    private void printStatus() {
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(a1);
        System.out.println(m1);
        System.out.println(c1);
        //Step 2
        //System.out.println(duo);
    }

   //missing code

}