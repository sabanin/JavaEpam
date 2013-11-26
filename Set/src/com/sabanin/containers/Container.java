/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.containers;

import com.sabanin.redBlackTree.RedBlackElement;

/**
 *
 * @author Евгений
 */
public interface Container<T> {
    void add(T element);
    void remove(T element);
    boolean in(T element);
}
