package com.example.estralium;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogueManager {

    public void Show(Activity activity, int level, String nameOfSkill){

        String levelUpMessageString = nameOfSkill + " level up! \nYou are now level " + level + ".";
        if (level % 5 == 0){
            levelUpMessageString += "\n2x more xp per click!";
        }
        Dialog dialog = new Dialog(activity);


        dialog.setContentView(R.layout.level_message);
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        TextView levelUpMessage = dialog.findViewById(R.id.textViewLevelUp);
        levelUpMessage.setText(levelUpMessageString);


        if (nameOfSkill == "Woodcutting"){
            ImageView img = dialog.findViewById(R.id.imageViewIcon);
            img.setImageResource(R.drawable.wood_cutting_icon);
        }
        if (nameOfSkill == "Player"){
            ImageView img = dialog.findViewById(R.id.imageViewIcon);
            img.setImageResource(R.drawable.player);
        }
        else {

        }


        dialog.show();
    }

}
