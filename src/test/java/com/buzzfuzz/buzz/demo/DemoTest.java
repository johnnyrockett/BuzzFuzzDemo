package com.buzzfuzz.buzz.demo;

import java.util.List;

import com.buzzfuzz.buzztools.Fuzz;

/**
 * Fuzz tests for demo
 */
public class DemoTest
{

	@Fuzz
    public static void treeTest( Tree tree ) throws Exception
    {
		Tree clone = tree.clone(); // CRASH: tree could be null
		
		// Check to make sure that a clone actually creates the same data structure
		if (!tree.equals(clone))
			throw new Exception("Trees should be equal");
		
		tree.alter();
    		if (tree.equals(clone))
    			throw new Exception("Altered tree shouldn't be equal");
    }
    
    
    @Fuzz
    public static void listTest( List<DataClass> list ) throws Exception {
    		for (DataClass dc: list) { // CRASH: list could be null
    			dc.alter();
    		}
    }
}
