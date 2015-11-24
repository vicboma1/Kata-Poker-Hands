package domian.helper.impl;

import domian.helper.api.HelperCard;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by vicboma on 24/11/15.
 */
public class HelperCardImpl implements HelperCard {


    private Map<String,Integer> map;

    public static HelperCard Create(){
        return new HelperCardImpl(mapNum());
    }

    private static Map<String,Integer> mapNum() {
        return new Hashtable(){
            {
                put("2",1);
                put("3",2);
                put("4",3);
                put("5",4);
                put("6",5);
                put("7",6);
                put("8",7);
                put("9",8);
                put("T",9);
                put("J",10);
                put("Q",11);
                put("K",12);
                put("A",13);
            }
        };
    }

    public HelperCardImpl(Map<String, Integer> serializerMap) {
        this.map = serializerMap;
    }

    public Integer num(String key){
        return this.map.get(key);
    }
}