package Agents2;

public class Train extends Vehicule {


    public Train(int dist) {
        super(dist);
    }

    @Override
    public String toString() {
        String s = "";
        if(this.dist >= 0)
            s += " (Le train n'a pas encore depasse les barrieres)";
        else
            s += " (Le train a depasse les barrieres)";
        return ">>>>> Distance du train : " + this.dist + s;
    }

}