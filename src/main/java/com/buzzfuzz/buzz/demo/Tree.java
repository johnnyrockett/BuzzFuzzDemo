package com.buzzfuzz.buzz.demo;

import java.util.List;

public class Tree {
    private DataClass data;
    private List<Tree> children;
    
    // Private constructor that fuzzer is not intended to reach
    Tree() {
    	
    }
    
    // Constructor example
    public Tree(List<Tree> children, DataClass data) {
    		this.data = data;
    		this.children = children;
    }
    
    public Tree clone() {
    		Tree clone = new Tree();
    		
        clone.data = this.data; // BUG: Isn't creating a clone of the tree's data
        clone(this, clone);
        return clone;
    }
    
    private void clone(Tree root, Tree newNode) {
        if (root == null) {
            return;
        }
        for (Tree child : root.children) { // CRASH: Children could be null
        		Tree childClone = new Tree();
        		childClone.data = child.data;
        		newNode.children.add(childClone); // CRASH: newNode could be null
        		clone(child, childClone);
        }
    }
    
    public void alter() throws Exception {
    		this.data.alter();
    		for (Tree child : this.children) {
    			child.alter();
    		}
    }
    
    @Override
    public boolean equals(Object o) {
    		if (o instanceof Tree) {
    			Tree oTree = (Tree)o;
    			
    			boolean decision = true;
    			for (int i=0; i < children.size(); i++) { // CRASH: children may not be the same size
    				// Make sure that the children are equal
    				decision = decision && this.children.get(i).equals(oTree.children.get(i));
    			}
    			
    			// Make sure that the data we are holding also matches
    			return decision && this.data.equals(oTree.data); // CRASH: this.data could be null
    		} else return false;
    }
}
