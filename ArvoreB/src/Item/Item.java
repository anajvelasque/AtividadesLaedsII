/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

/**
 *
 * @author Ana Julia Velasque
 */
public class Item {
    private int chave;
    public Item(int chave) {
        this.chave = chave;
    }
    public int compara(Item it) {
        Item item = it;
        if (this.chave < item.getChave())
            return -1;
        else if (this.chave > item.getChave())
            return 1;
        return 0;
    }
    public int getChave() {
        return chave;
    }
}
