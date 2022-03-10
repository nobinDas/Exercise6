import java.util.ArrayList;

public class Team implements CoordinatedAsset{
    private StMediator mediator;
    private String name;
    private String secret;

    public Team(ArrayList<CoordinatedAsset> members){
        for(CoordinatedAsset child: members){
            this.name = child.getName();
            this.secret = child.getSecret();
            setStatus(child.getMediator());
        }
    }

    public Team(String name, String secret, StMediator m){
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

    public StMediator getMediator(){ return mediator;}

    public String getName() {
        return name;
    }

    public void setSecret(String secret){
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
