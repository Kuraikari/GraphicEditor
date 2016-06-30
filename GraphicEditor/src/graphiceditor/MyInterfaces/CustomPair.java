/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiceditor.MyInterfaces;

/**
 *
 * @author vmadmin
 * @param <L> First Object Mostly Path
 * @param <R> Second Object Mostly Item
 */
public final class CustomPair<L, R> {
    
    L l;
    R r;
    
    public CustomPair(L l, R r){
        this.l = l;
        this.r = r;
    }
    
    public static <L, R> CustomPair<L, R> createPair(L element0, R element1) {
        return new CustomPair<>(element0, element1);
    }
    
    public L getL(){ return l;}
    public R getR(){ return r;}
    public void setL(L l){ this.l = l;}
    public void setR(R r){ this.r = r;}
    
}
