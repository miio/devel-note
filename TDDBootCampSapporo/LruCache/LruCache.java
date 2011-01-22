package LruCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class LruCache {
	
	private HashMap<String, String> map = new HashMap<String, String>();
	private TreeMap<Integer,Integer> times= new TreeMap<Integer,Integer>();
	private ArrayList<String> order = new ArrayList<String>();
	private int max;
	
	public LruCache(int max){
		this.max = max;
	}
	public String get(String key){

		if(map.containsKey(key)){
			order.remove(key);
		}
		order.add(key);
		
		return map.get(key);
	}
	
	public void put(String key,String value){
		//�L�[������΍Ō�Ɉړ�
		if(map.containsKey(key)){
			map.remove(key);
			order.remove(key);
		}
		map.put(key, value);
		order.add(key);
		deleteOld();
		
	}
	
	public void deleteOld(){
		if(max < map.size()){

			//��ԌÂ��L�[�̃f�[�^���폜
			map.remove(searchOldKey());
			order.remove(searchOldKey());

		}
	}

	
	private String searchOldKey() {
		//��ԌÂ��L�[��T��
			return order.get(0);
	}
	
	public int getOrder(String key){
		try{
			return order.indexOf(key);
		}catch(Exception e){
			return -1;
		}
		
	}
}
