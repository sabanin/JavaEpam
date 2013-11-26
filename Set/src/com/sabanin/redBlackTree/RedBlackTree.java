/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.redBlackTree;

import com.sabanin.containers.Container;
/**
 *
 * @author Евгений
 */
public class RedBlackTree<T extends Comparable> implements Container<T>{
    
    private static final boolean BLACK = false;
    private static final boolean RED = true;
    
    RedBlackElement root = null;
        
    RedBlackTree(T root){
        this.root = new RedBlackElement(root);
        this.root.setColor(BLACK);
    }
    
    RedBlackTree(RedBlackTree redBlackTree){
        this.root = redBlackTree.getRoot();
    }
    
    @Override
    public void add(T value){
        RedBlackElement element = new RedBlackElement(value);
        element.setColor(RED);
        RedBlackElement pointer = root;
        RedBlackElement follower = null;
        while (pointer != null){
            follower = pointer;
            if (element.compareTo(pointer)>=0){
                pointer = pointer.getRightChild();
            } else {
                pointer = pointer.getLeftChild();
            }
        }       
        element.setParent(follower);
        if (element.compareTo(follower)>=0){
                follower.setRightChild(element);
            } else {
                follower.setLeftChild(element);
            }       
        addCase1(element);
    }

    @Override
    public void remove(T element) {
        
    }

    @Override
    public boolean in(T value) {
        RedBlackElement element = new RedBlackElement(value);
        RedBlackElement pointer = root;
        while (pointer != null){
            if (element.compareTo(pointer)>0){
                pointer = pointer.getRightChild();
            }
            else if (element.compareTo(pointer)<0){
                pointer = pointer.getLeftChild();
            }
            else if (element.compareTo(pointer)==0){
                return true;
            }
        }
        return false;
    }
    
    public RedBlackElement getRoot(){
        return this.root;
    }
    
    protected void addCase1(RedBlackElement element){
        if (element.getParent() == null){
            element.setColor(BLACK);
            this.root = element;
        }else{
            addCase2(element);
        }
    }
    
    protected void addCase2(RedBlackElement element){
        if(element.getParent().getColor() == RED){
            addCase3(element);
        }
    }
    
    protected void addCase3(RedBlackElement element){
        RedBlackElement uncle = element.getUncle();
        if((uncle != null) && (uncle.getColor() == RED) && (element.getParent().getColor() == RED)){
            element.getParent().setColor(BLACK);
            uncle.setColor(BLACK);
            RedBlackElement grandParent = element.getGrandParent();
            grandParent.setColor(RED);
            addCase1(grandParent);
        }else{
            addCase4(element);
        }
    }
    
    protected void addCase4(RedBlackElement element){
        RedBlackElement grandParent = element.getGrandParent();
        if ((element == element.getParent().getRightChild()) && (element.getParent() == grandParent.getLeftChild())){
                rotateLeft(element.getParent());
                element = element.getLeftChild();
        } else if ((element == element.getParent().getLeftChild()) && (element.getParent() == grandParent.getRightChild())){
                rotateRight(element.getParent());
                element = element.getRightChild();
        }
        addCase5(element);
    }
    
    protected void addCase5(RedBlackElement element){
        RedBlackElement grandParent = element.getGrandParent();
        element.getParent().setColor(BLACK);
        grandParent.setColor(RED);
        if ((element == element.getParent().getLeftChild()) && (element.getParent() == grandParent.getLeftChild())){
            rotateRight(grandParent);
        }else{
            rotateLeft(grandParent);
        }
    }
    
    protected void rotateLeft(RedBlackElement element){
        RedBlackElement parent = element.getParent();
        RedBlackElement rotatingChild = element.getRightChild();
        if(parent != null){
            parent.setRightChild(rotatingChild);
        }
        rotatingChild.setParent(parent);
        element.setRightChild(rotatingChild.getLeftChild());
        if (element.getRightChild() != null){
            element.getRightChild().setParent(element);
        }
        rotatingChild.setLeftChild(element);
    }
    
    protected void exchangeChildrens(RedBlackElement element){
        RedBlackElement buffer = element.getLeftChild();
        element.setLeftChild(element.getRightChild());
        element.setRightChild(buffer);
    }
    
    protected void rotateRight(RedBlackElement element){
        exchangeChildrens(element);
        exchangeChildrens(element.getRightChild());
        rotateLeft(element);
        exchangeChildrens(element);
        exchangeChildrens(element.getParent());
    }
}
