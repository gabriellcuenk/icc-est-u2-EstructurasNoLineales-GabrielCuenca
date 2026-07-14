package collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Maps {
    public Map<String, Integer> construirHashMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("A",10);
        map.put("B",20);
        map.put("C",30);
        map.put("A",50);

        System.out.println(map.size());
        System.out.println(map);

        for(int i=0; i<map.size();i++){
            System.out.println(map.values().toArray()[i]);
        }

        for(String key: map.keySet()){
            System.out.println(key);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        return map;
    }

    public LinkedHashMap<String, Integer> coLinkedHashMap(){
        LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
        lMap.put("A", 10);
        lMap.put("B", 20);
        lMap.put("C", 30);
        lMap.put("A", 50);
        lMap.put("A", 2);
        lMap.put("B", 3);
        lMap.put("A", 5);
        lMap.put("C", 50);
        lMap.put("D", 5);
        lMap.put("F", 3);
        lMap.put("G", 8);
        lMap.put("H", 85);
        lMap.put("I", 5);
        System.out.println(lMap);
        System.out.println(lMap.entrySet());



        return lMap;
    }

    public Map<String, Integer> cTreeMap(){
        Map<String, Integer> lMap = new TreeMap<>();
        lMap.put("A", 10);
        lMap.put("B", 20);
        lMap.put("C", 30);
        lMap.put("A", 50);
        lMap.put("A", 2);
        lMap.put("B", 3);
        lMap.put("A", 5);
        lMap.put("C", 50);
        lMap.put("D", 5);
        lMap.put("F", 3);
        lMap.put("G", 8);
        lMap.put("H", 85);
        lMap.put("I", 5);
        System.out.println(lMap);
        System.out.println(lMap.entrySet());



        return lMap;
    }
}