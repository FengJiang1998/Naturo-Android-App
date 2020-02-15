package com.hfad.naruto;

import java.util.ArrayList;

/**
 * CharacterData.java - Finds out what character object is selected and returns the right stats
 *                      for said character.
 */
public class CharacterData {
    private ArrayList<Character> lstCharacter;

    public int getSize(){
        return lstCharacter.size();
    }

    public ArrayList<Character> getList()
    {
        return lstCharacter;
    }


    public Character getItem(int i)
    {
        if (i >=0 && i < lstCharacter.size()){
            return  lstCharacter.get(i);
        } else return null;
    }

    public CharacterData()
    {

        lstCharacter = new ArrayList<Character>();

        lstCharacter.add(new Character(0,"Naruto Uzumaki","Konohagakure",
                "Naruto Uzumaki is the annoying, pervy brat in the Naruto series, and he is the main character. ",R.drawable.naruto_uzumaki,110, 50, 50, 50));
        lstCharacter.add(new Character(1,"Sasuke Uchiha","Konohagakure",
                "Sasuke Uchiha (うちは サスケ Uchiha Sasuke) is Naruto's rival. He was designed by Kishimoto as " +
                        "the \"cool genius\" since he felt this was an integral part of an ideal rivalry.",R.drawable.sasuke_uchiha,110, 60, 40, 50));
        lstCharacter.add(new Character(2,"Sakura Haruno","Konohagakure",
                "Sakura Haruno (春野 サクラ Haruno Sakura) is a member of Team 7. While creating the character, Kishimoto has admitted " +
                        "that he had little perception of what an ideal girl should be like.",R.drawable.sakura_haruno,100, 60, 40, 30));
        lstCharacter.add(new Character(3,"Kakashi Hatake","Konohagakure",
                "Kakashi Hatake is the easygoing, smart leader of team 7, consisting of " +
                        "Naruto Uzumaki, Sasuke Uchiha, and Sakura Haruno.",R.drawable.kakashi_hatake,90, 40, 60, 60));
        lstCharacter.add(new Character(4,"Hinata Hyuga","Konohagakure","Hinata Hyuga (日向 ヒナタ Hyūga Hinata) is a" +
                " member of Team 8 who suffers from a lack of self-confidence.",R.drawable.hinata_hyuga,90, 50, 40, 60));


    }
}
