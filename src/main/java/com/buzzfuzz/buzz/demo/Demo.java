package com.buzzfuzz.buzz.demo;

import java.util.List;

import com.buzzfuzz.buzztools.Fuzz;
import com.google.gson.Gson;

/**
 * Demo for the buzzfuzz engine
 * @author Johnny Rockett
 *
 */
public class Demo 
{
    public static void main( String[] args )
    {
        // What the program actually does doesn't matter.
    		// We just care about its structure.
    }
    
    @Fuzz
    public static void treeTest( Tree initial )
    {
    		Gson gson = new Gson();
    		String json = gson.toJson(initial);
    		Tree serialized = gson.fromJson(json, Tree.class);
    		
    		assert(initial.equals(serialized));
    }
    
    
    @Fuzz
    public static void listTest( List<? extends DataClass> initial ) {
    		Gson gson = new Gson();
		String json = gson.toJson(initial);
		
		@SuppressWarnings("unchecked")
		List<? extends DataClass> serialized = gson.fromJson(json, List.class);
		
		assert(initial.equals(serialized));
    }
}
