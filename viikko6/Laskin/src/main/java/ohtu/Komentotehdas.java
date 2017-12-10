/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import ohtu.komento.*;

import java.util.HashMap;

public class Komentotehdas {
    private HashMap<String, Komento> komennot;

    public Komentotehdas() {
        komennot = new HashMap<>();
        komennot.put("+", new Summa());
        komennot.put("-", new Miinus());
        komennot.put("Z", new Nollaa());
        komennot.put("undo", new Peru());
        komennot.put("tuntematon", new Tuntematon());
    }

    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
            komento = komennot.get("tuntematon");
        }
        return komento;
    }
}
