package Interfaces;

/**
 * This class describes the bare necessities of an object to be randomsly selected
 */
public interface IProbabilityItem {

    /**
     * Returns the weight of the specified object
     * @return int number refering to the weight of this object
     */
    public int getWeight();

    /**
     * Sets a new weight for the specified object
     * >>> SHOULD ONLY BE VALLED BY ProbabilityManager.setItemWeight(int index, int newWeight) <<<
     * @return
     */
    public void setWeight(int newWeight);

}
