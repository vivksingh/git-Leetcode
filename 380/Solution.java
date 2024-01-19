import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int last = list.get(list.size()-1);
        int indx = map.get(val);

        list.set(indx,last);
        map.put(last, indx);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(0, list.size()));
    }
}
