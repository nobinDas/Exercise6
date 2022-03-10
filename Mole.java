public class Mole extends Team{
    private StMediator mediator;
    private String secret;

    public Mole(String name, String secret, StMediator m){
        super(name, secret, m);
        this.mediator = m;
        this.secret = secret;
    }
    public void statusChange() {
        mediator.statusChanged(this);
    }
//    public void setSecret(String secret){
//        this.secret = secret;
//    }
}
