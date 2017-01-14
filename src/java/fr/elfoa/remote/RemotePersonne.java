/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.elfoa.remote;

import java.util.List;

/**
 *
 * @author mathieu
 * @param <T>
 */
public interface RemotePersonne<T> {
    public T get(int id);
    
    public List<T> get();
    
    public T create(String name, String firstName);
    
    public T update(int id, String name, String firstName);
    
    public void delete(int id);
}
