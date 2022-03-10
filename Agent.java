public class Agent implements Status{
    private StMediator mediator;
    private String name;
    private String secret;

    public Agent(String name, String secret, StMediator m){
        this.name = name;
        this.secret = secret;
        setStatus(m);
    }

    public void setStatus(StMediator m) {
        this.mediator = m;
    }

    public void statusChange() {
        mediator.statusChanged(this);
    }


    public String getName() {
        return name;
    }

    void setSecret(String secret){
        this.secret = secret;
    }
    @Override
    public String  getSecret() {
        return secret;
    }

    public String toString(){
        if(this.mediator == null){
            return null;
        }
        return this.name + " " + this.secret;
    }
}
