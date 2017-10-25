import Interfaces.IProbabilityItem;

import java.util.ArrayList;
import java.util.Random;

public class ProbabilityManager {

    private ArrayList<IProbabilityItem> listOfItems;

    private int totalWeight;

    public ProbabilityManager(){

        listOfItems = new ArrayList<>();
        totalWeight = 0;

    }

    /**
     * Adds an item to the  list of items to be drawn
     * @param item IProbabilityItem interface extending object
     */
    public void addItem(IProbabilityItem item){
        listOfItems.add(item);
        totalWeight += item.getWeight();
    }

    /**
     * Removes an item to the  list of items to be drawn
     * @param item IProbabilityItem interface extending object
     * @return true if item was found and removed
     */
    public boolean removeItem(IProbabilityItem item){
        if(!listOfItems.contains(item)){
            return false;
        } else {
          listOfItems.remove(item);
          totalWeight -= item.getWeight();
          return true;
        }
    }

    /**
     * Returns a randomly drawn object
     * @return IProbabilityItem interface extending object
     */
    public IProbabilityItem getRandom(){

        Random generator = new Random();
        int val = generator.nextInt(totalWeight) + 1;

        int acc = 0;

        for (int i = 0; i < listOfItems.size(); i++){
            IProbabilityItem it = listOfItems.get(i);
            acc += it.getWeight();

           if(val <= acc)
               return it;
        }

        System.out.println(val);

        return null;
    }

    /**
     * Sets the weight of the specified item
     * @param index The item's index
     * @param newWeight The item's new weight
     * @return true if index and new weight providade were valid
     */
    public boolean setItemWeight(int index, int newWeight){

        //Check index and new weight for validity
        if(index > listOfItems.size() || totalWeight < 0)
            return false;

        //Update the item's weight
        IProbabilityItem it = listOfItems.get(index);
        it.setWeight(newWeight);

        //Update the total summed weight
        int newTotalWeight = it.getWeight() - newWeight;
        totalWeight += newTotalWeight;

        return true;
    }

    @Override
    public String toString() {
        if(listOfItems.isEmpty()){
            return "List is empty.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("TOTAL WEIGHT: " + totalWeight + "\n");

        int index = 0;
        for (IProbabilityItem item : listOfItems) {

            int wght = item.getWeight();
            double prcnt = (wght / (double) totalWeight) * 100;

            sb.append(index + ". " + item.getClass().getSimpleName() + " <> " + wght + " <> " + prcnt + "%\n");
            index++;
        }

        return sb.toString();
    }
}
