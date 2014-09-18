package br.com.efb.testeefb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class MovieView {
     
    private List<String> movieList;
     
    public List<String> getStringList() {
        return movieList;
    }
     
    @PostConstruct
    public void init() {
        movieList = new ArrayList<String>();
        
        movieList.add("Isso");  
        movieList.add("Isso");  
        movieList.add("Isso");  
        movieList.add("Isso");  
        movieList.add("Isso");
         
    }
   
}
