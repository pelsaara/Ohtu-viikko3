/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.komento;

import java.util.Stack;

public class Nollaa implements Komento {

    @Override
    public int suorita(Stack<Integer> historia, int alkup, int luku) {
        historia.add(alkup);
        return 0;
    }
}
