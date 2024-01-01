/**
 * 
 */
package com.practice.firstassignment;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
/**
 * @author Shrikant_Bhadgaonkar
 * 9.JSON
 */
public class JsonPractice {

	public static void main(String[] args) throws IOException, ParseException {
		JSONObject obj= new JSONObject();
		obj.put("name","Shrikant");
		obj.put("age",Integer.valueOf(20));
		ArrayList<String>hobbies=new ArrayList<String>();
		hobbies.add("Guitar");
		hobbies.add("Volleyball");
		hobbies.add("Games");
		obj.put("hobbies",hobbies);
//		Json object: 
		System.out.println(obj);
		StringWriter out = new StringWriter();		
	    obj.writeJSONString(out); 
//	    Json text string output:
	    String jsonText = out.toString();
	    System.out.println(jsonText);
	    JSONParser parser = new JSONParser();
	    Object ob=parser.parse(jsonText);
//	    Decoded Json:
	    System.out.println(ob);
	}

}
