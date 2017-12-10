/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.Stack;

public class QueryBuilder {
    Stack<Matcher> pino;
    
    public QueryBuilder(){
        pino = new Stack();
    }
    
    public QueryBuilder Or(Matcher... matchers){
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category){
        pino.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder playsIn(String team){
        pino.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category){
        pino.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        pino.add(new Or(m1, m2));
        return this;
    }

    public Matcher build() {
        Matcher[] matchers = new Matcher[pino.size()];
        for (int i = 0; i < pino.size(); i++) {
            matchers[i] = pino.get(i);
        }
        pino.clear();
        return new And(matchers);
    }
    
}
