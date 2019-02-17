package com.buzzfuzz.buzz.demo;

import java.util.List;

public class Tree {
    private DataClass data;
    private List<Tree> children;
    
    // Constructor example
    public Tree(DataClass data, List<Tree> children) {
    		this.data = data;
    		this.children = children;
    }
    
    @Override
    public boolean equals(Object o) {
    		if (o instanceof Tree) {
    			Tree oTree = (Tree)o;
    			
    			boolean decision = true;
    			for (int i=0; i < children.size(); i++) {
    				// Make sure that the children are equal
    				decision = decision && this.children.get(i).equals(oTree.children.get(i));
    			}
    			
    			// Make sure that the data we are holding also matches
    			return decision && this.data.equals(oTree.data);
    		} else return false;
    }
}
