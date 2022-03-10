import java.util.ArrayList;
import java.util.Arrays;

public class StaticMediator implements StMediator{

    private Spy s1, s2, s3, s4;
    private Agent a1, c1;
    private Mole m1;
    //step 2
    private Agent a2, a3;
    private Mole m2, m3;
    private CompositeAgent duo;

    public void createSpyTeam () {

        s1 = new Spy("spy1 ", "secret 1 ", 10, this);
        s2 = new Spy("spy2 ", "secret 2 ", 5, this);
        s3 = new Spy("spy3 ", "secret 3 ", 2, this);
        s4 = new Spy("spy4 ", "secret 4 ", 20, this);
        a1 = new Agent("a1 ", "ultra secret 1 ",this);
        m1 = new Mole("m1 ", "deep secret 1 ", this);
        c1 = new Agent("cleaner ", " no secret ",this);

        //step2
        a2 = new Agent("a2 ", " ultra secret 2 ",this);
        m2 = new Mole("m2 ", " deep secret 2 ", this);
        a3 = new Agent("a3 ", " ultra secret 3 ",this);
        m3 = new Mole("m3 ", " deep secret 3 ", this);
        duo = new CompositeAgent (new ArrayList<CoordinatedAsset>(Arrays.asList(a2, m2)));


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
        System.out.println("team status changed");
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
        System.out.println(duo);
    }

    @Override
    public void statusChanged(CoordinatedAsset status) {
        String temp;
        if(status == s1){
            System.out.println("s1 status update:");
            temp = s2.getSecret();
            s2.setSecret(s1.getSecret());
            s1.setSecret(temp);
            temp = null;
        }else if(status == s2){
            System.out.println("s2 status update:");
            s2.setSecret(s2.getSecret().concat(s3.getSecret()));
        }else if(status == s3){
            System.out.println("s3 status update:");
            s3.setClearance(s1.getClearance()+ s2.getClearance());
            s4.setClearance(0);
        }else if(status == s4){
            System.out.println("s4 status update:");
            if(s4.getClearance() > 0){
                s1.setClearance(s4.getClearance());
                s2.setClearance(s3.getClearance());
            }
        }else if(status == a1){
            System.out.println("a1 status update:");
            a1.setSecret(s3.getSecret());
            m1.setSecret("forgotten");
        }else if(status == m1){
            System.out.println("m1 status update:");
            temp = m1.getSecret();
            m1.setSecret(s4.getSecret());
            s4.setSecret(temp);
            temp = null;
        }else if(status == c1){
            System.out.println("cleaner status update:");
            a1.setStatus(null);
            m1.setStatus(null);
        }else if(status == a2){
            System.out.println("a2 status update:");
            s1.setClearance(77);
            a2.setSecret(a1.getSecret().concat(m1.getSecret()));
        }else if(status == m2){
            System.out.println("m2 status update:");
            temp = m2.getSecret();
            m2.setSecret(s1.getSecret());
            m2.setSecret(s1.getSecret());
            s1.setSecret(temp);
            temp = null;
        }else if(status == a3){
            System.out.println("a3 status update:");
            duo.setSecret(a1.getSecret().concat(m2.getSecret()));
            a3.setSecret(s1.getSecret());
            m3.setSecret("forgotten");
        }else if(status == m3){
            System.out.println("m3 status update:");
            temp = duo.getSecret();
            duo.setSecret(m1.getSecret());
            m1.setSecret(temp);
            temp = null;
        }
        printStatus();
    }

    //missing code

}