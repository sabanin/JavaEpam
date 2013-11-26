/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.redBlackTree;

/**
 *
 * @author Евгений
 */
public class RedBlackElement<T extends Comparable>{
        
    protected boolean color; // red == true; black == false;
    protected RedBlackElement parent = null;
    protected RedBlackElement rightChild = null;
    protected RedBlackElement leftChild = null;
    protected T value;
    
    RedBlackElement(T value){
        this.value = value;
    }
    
    public int compareTo(RedBlackElement t) {
            return this.value.compareTo(t.getValue());
     }
    
    public T getValue(){
        return value;
    }
    
    public void setColor(boolean color) {
        this.color=color;
    }
    
    public boolean getColor(){
        return color;
    }

    public RedBlackElement getLeftChild() {
        return this.leftChild;
    }
    
    public void setLeftChild(RedBlackElement leftChild){
        this.leftChild = leftChild;
    }

    public RedBlackElement getRightChild() {
        return this.rightChild;
    }
    
    public void setRightChild(RedBlackElement leftChild){
        this.leftChild = leftChild;
    }

    public RedBlackElement getParent() {
        return this.parent;
    }
    
    public void setParent(RedBlackElement leftChild){
        this.leftChild = leftChild;
    }
    
    public RedBlackElement getGrandParent() {
        if (this.parent != null){
            return this.getParent().getParent();
        } else {
            return null;
        }
    }
    
    public RedBlackElement getUncle(){
        RedBlackElement grandParent = this.getGrandParent();
        if (grandParent == null){
            return null;
        }
        if (this.getParent() == grandParent.getLeftChild()){
            return grandParent.getRightChild();
        } else {
            return grandParent.getLeftChild();
        }
    }
    
    public RedBlackElement getSibling(){
        if (this.getParent() != null){
            if (this == this.getParent().getLeftChild()){
                return this.getParent().getRightChild();
            }
            else{
                return this.getParent().getLeftChild();
            }
        }
        return null;
    }
}
