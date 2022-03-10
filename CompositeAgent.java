import java.util.ArrayList;
import java.util.Arrays;

public class CompositeAgent extends Team {
    protected ArrayList<CoordinatedAsset> children = new ArrayList<>();

    public CompositeAgent(ArrayList<CoordinatedAsset> members) {
        super(members);
        add(members);
    }

    public void statusChange() {
        for(CoordinatedAsset child: children) {
            child.statusChange();
        }
    }

    public void setSecret(String secret){
        for(CoordinatedAsset child: children) {
            child.setSecret(secret);
        }
    }

    public void add(CoordinatedAsset member){
        children.add(member);
    }

    public void remove(CoordinatedAsset member){
        children.remove(member);
    }

    public void add(ArrayList<CoordinatedAsset> members){
        children.addAll(members);
    }

    public void remove(ArrayList<CoordinatedAsset> members){
        children.removeAll(members);
    }

    public CoordinatedAsset getChild(int i) {
        return (CoordinatedAsset)children.get(i);
    }

    public void clear() {
        children.clear();
    }

    public String toString(){
        String result = "Team: \n";
        for(CoordinatedAsset child: children) {
            result += (String) (child.getName() + " " + child.getSecret() +"\n");
        }
        return result;
    }

}
