
package com.practice.firstassignment;
import java.util.*;
/**
 * @author Shrikant_Bhadgaonkar
 * 7.Collections-List,Set,Map and operations
 */
public class CollectionsPractice {
	
	public static void main(String[] args) {

//		-----------------------ArrayList-------------------------------------------
//		Primitive Datatype
		ArrayList<Integer>intAlist=new ArrayList<>();
//		intAlist.add(null); Collections.sort can't handle null values
		intAlist.add(5);
		intAlist.add(5);
		intAlist.add(2,3);
		System.out.print("Printing Integer ArrayList elements: ");
		for(Integer i:intAlist)if(i==null)System.out.print("null ");else System.out.print(i+" ");
		System.out.println();
//		Custom Datatype
		ArrayList<Zoo>zooAlist=new ArrayList<>();
		zooAlist.add(new Zoo(4));
//		zooAlist.add(null);
		zooAlist.add(new Zoo(23));
		zooAlist.add(1,new Zoo(10));
		System.out.print("Printing Zoo ArrayList elements: ");
		for(Zoo i:zooAlist)if(i==null)System.out.print("null ");else System.out.print(i.getNumberOfCells()+" ");
		System.out.println();
//		Sorting primitive arraylist
		Collections.sort(intAlist);
		System.out.print("Printing sorted integer arraylist: ");
		for(Integer i:intAlist)if(i==null)System.out.print("null ");else System.out.print(i+" ");
		System.out.println();
//		-----------------Sorting custom arraylist-----------------
//		1.using Comparable
		Collections.sort(zooAlist);
		System.out.print("Printing sorted zoo arraylist: ");
		for(Zoo i:zooAlist)if(i==null)System.out.print("null ");else System.out.print(i.getNumberOfCells()+" ");
		System.out.println();
//		2.using Comparator
		System.out.print("Printing reverse sorted zoo arraylist: ");
		RevCompare obj= new RevCompare();
		Collections.sort(zooAlist,obj);
		for(Zoo i:zooAlist)if(i==null)System.out.print("null ");else System.out.print(i.getNumberOfCells()+" ");
		System.out.println();
//		-------------------------------Set---------------------------------------------
//		1.ḤashSet
		HashSet<Integer> intHSet=new HashSet<>();
		intHSet.add(1);
		intHSet.add(1);
		intHSet.add(2);
		intHSet.add(null);
		Iterator<Integer> it=intHSet.iterator();
		System.out.print("Printing elements of integer hashset: ");
		while(it.hasNext()) {
			Integer k=it.next();
			System.out.print(k==null?"null ":k+" ");
		}
		System.out.println();
//		2.TreeSet
		TreeSet<Zoo> zooTSet=new TreeSet<>();
		zooTSet.add(new Zoo(4));
		zooTSet.add(new Zoo(14));
		zooTSet.add(new Zoo(3));
		Iterator<Zoo> it1= zooTSet.iterator();
		System.out.print("Printing elements of zoo treeset: ");
		while(it1.hasNext()) {
			Zoo k=it1.next();
			System.out.print(k==null?"null ":k.getNumberOfCells()+" ");
		}
		System.out.println();

//	-------------------------------------Maps--------------------------------------------
//	1.HashMap
		HashMap<Integer, String> intStrHashMap = new HashMap<>();
        intStrHashMap.put(1, "Hola!");
        intStrHashMap.put(2, "Namaskar");
        intStrHashMap.put(1, "Hello");
        intStrHashMap.put(null, "Konnichiwa");

        // Iterator for HashMap
        Iterator<Integer> it11 = intStrHashMap.keySet().iterator();
        System.out.print("Printing elements of integer-string hashmap: ");
        while (it11.hasNext()) {
            Integer key = it11.next();
            System.out.print( key + "=" + intStrHashMap.get(key) + " ");
        }
        System.out.println();
//	2.TreeMap
        TreeMap<Zoo, String> zooStrTreeMap = new TreeMap<>();
        zooStrTreeMap.put(new Zoo(4), "Tigers");
        zooStrTreeMap.put(new Zoo(14), "Bears");
        zooStrTreeMap.put(new Zoo(3), "Elephants");

        // Iterator for TreeMap
        Iterator<Zoo> it2 = zooStrTreeMap.keySet().iterator();
        System.out.print("Printing elements of zoo-string treemap: ");
        while (it2.hasNext()) {
            Zoo key = it2.next();
            System.out.print(key.getNumberOfCells() + "=" + zooStrTreeMap.get(key) + " ");
        }
        System.out.println();
	}
}
//comparator class which sorts zoo objects in reverse order of their numberOfCells
class RevCompare implements Comparator<Zoo>{

	@Override
	public int compare(Zoo o1, Zoo o2) {
		if(o1==o2)
		return 0;
		else if(o1.getNumberOfCells()<o2.getNumberOfCells())return 1;
		return -1;
	}
	
}
