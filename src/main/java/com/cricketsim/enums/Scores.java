package com.cricketsim.enums;

public enum Scores {

	DOT(0), ONERUN(1), TWORUNS(2),THREERUNS(3), FOUR(4), FIVERUNS(5),SIXER(6),OUT(7); 
	
	private Integer score;
	
	public Integer getAction() 
    { 
        return this.score; 
    } 
  
    private Scores(Integer action) 
    { 
        this.score = action; 
    } 
}
