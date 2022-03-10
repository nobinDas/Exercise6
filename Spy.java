public class Spy implements CoordinatedAsset{
    private StMediator mediator;
    private String name;
    private String secret;
    private int clearance;

    public Spy(String name, String secret, int clearance, StMediator m){
        this.name = name;
        this.secret = secret;
        this.clearance = clearance;
        setStatus(m);
    }

    public StMediator getMediator(){ return mediator;}

    public void setStatus(StMediator m) {
        this.mediator = m;
    }

    public void statusChange() {
        mediator.statusChanged(this);
    }

    public void setSecret(String secret){
        this.secret = secret;
    }

    void setClearance(int clr){
        this.clearance = clr;
    }


    public String getName() {
        return name;
    }

    @Override
    public String getSecret() {
        return secret;
    }

    public int getClearance() {
        return clearance;
    }

    public String toString(){
        if(this.mediator == null){
            return null;
        }
        return this.name + " " + this.secret + " and my clearance " + this.clearance;
    }
}
