package ExampleClasses;

import Interfaces.IProbabilityItem;

/**
 * Dummy file to test the Probability Manager
 */
public class SkinReward implements IProbabilityItem {

    private int weight;

    public SkinReward(int weight){
        this.weight = weight;
    }


    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int newWeight) {
        weight = newWeight;
    }
}
