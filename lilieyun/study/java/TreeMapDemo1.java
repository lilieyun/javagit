package lilieyun.study.java;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeMap treeMap=new TreeMap();
        treeMap.put("1", "demo1");
        treeMap.put("2", "demo2");
        treeMap.put("3", "demo3");
        //
        //
        System.out.println("1��public Map.Entry<K,V> ceilingEntry(K key):����ָ����Key���ڻ���ڵ���Сֵ��Ԫ�أ����û�У��򷵻�null");
        Entry entry=treeMap.ceilingEntry("2.5");
        System.out.println(entry.getKey()+"="+entry.getValue());
        
        entry=treeMap.ceilingEntry("4");
        System.out.println(entry);
        System.out.println();
 
        System.out.println("2�� public Object clone():���ؼ��ϵĸ���");
        Object obj=treeMap.clone();
        System.out.println("treeMap����������Ԫ��:"+treeMap);
        System.out.println("treeMap����:"+obj);
        TreeMap tm=(TreeMap)obj;
        System.out.println(tm.get("2"));
        
	}

}
