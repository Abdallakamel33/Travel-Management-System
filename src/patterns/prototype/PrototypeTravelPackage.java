/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns.prototype;

/**
 *
 * @author Lenovo
 */
public abstract class PrototypeTravelPackage implements Cloneable {
    public abstract String getDescription();

    @Override
    public PrototypeTravelPackage clone() throws CloneNotSupportedException {
        return (PrototypeTravelPackage) super.clone();
    }
}