public class Agent extends Team{
    private StMediator mediator;
//    private String name;
    private String secret;
//
    public Agent(String name, String secret, StMediator m){
        super(name, secret, m);
        this.mediator = m;
        this.secret = secret;
    }
//
//    public void setStatus(StMediator m) {
//        this.mediator = m;
//    }
//
    public void statusChange() {
        mediator.statusChanged(this);
    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setSecret(String secret){
//        this.secret = secret;
//    }
//    @Override
//    public String  getSecret() {
//        return secret;
//    }
//
//    public String toString(){
//        if(this.mediator == null){
//            return null;
//        }
//        return this.name + " " + this.secret;
//    }
}
