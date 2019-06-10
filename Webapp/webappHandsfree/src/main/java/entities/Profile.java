/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Carolina
 */
public class Profile {
    
    private int id;
    
    private String nome;

    public Profile(){};
    
    public Profile(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    

    
}
