import ExampleClasses.ChampionReward;
import ExampleClasses.GemReward;
import ExampleClasses.SkinReward;

public class Main {

    public static void main(String [] args){

        //Probability manager
        ProbabilityManager pm = new ProbabilityManager();

        //Items for random selection according to probability
        SkinReward s = new SkinReward(20);
        ChampionReward c = new ChampionReward(80);
        GemReward g = new GemReward(100);

        //Adding the items to the Probability Manager
        pm.addItem(s);
        pm.addItem(c);
        pm.addItem(g);

        //Output
        System.out.println(pm);

        //Test set new weight
        pm.setItemWeight(0,50);
        pm.setItemWeight(1,100);
        pm.setItemWeight(2,50);

        //Output
        System.out.println(pm);

    }
}
