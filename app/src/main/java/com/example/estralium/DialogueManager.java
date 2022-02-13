package com.example.estralium;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogueManager {

/**   To show a level up dialog pass through the current activity your in, the level of the skill,
 * the name of the skill in UPPERCASE and the desired position of the dialog box In UPPERCASE
 * ex: player.Show(this, player.getWoodCuttingLevel(), "Woodcutting", "Bottom")
 */

    public void Show(Activity activity, int level, String nameOfSkill, String pos) {

        //The default message with the name of the skill and the level passed through the function
        String levelUpMessageString = nameOfSkill + " level up! \nYou are now level " + level + ".";

        /** Every 5 levels the skill gains an extra boost to gather rate
         *   If the passed through level is a multiple of 5 & is not the player level then edit the
         *  level up string to indicate the increase to gather rate */

        if (level % 5 == 0 && nameOfSkill != "You") {
            levelUpMessageString += "\n2x more xp per click!";
        }


        //Creating a new dialog with the passed activity
        Dialog dialog = new Dialog(activity);

        //Setting the dialog to the level_message.xml in Layout
        dialog.setContentView(R.layout.level_message);

        //Setting levelUpMessage to the textview in level_message.xml
        TextView levelUpMessage = dialog.findViewById(R.id.textViewLevelUp);
        //The textview is where the level up text will be
        levelUpMessage.setText(levelUpMessageString);

        //Checking which position was passed in and setting the dialog to that position
        switch (pos) {
            case "Bottom":
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                break;
            case "Center":
            case "Middle":
                dialog.getWindow().setGravity(Gravity.CENTER);
                break;
            case "Top":
                dialog.getWindow().setGravity(Gravity.TOP);
                break;
            default:
                break;
        }

        //Checking which skill was passed and setting the dialog image to the skill icon
        if (nameOfSkill == "Woodcutting"){
            ImageView img = dialog.findViewById(R.id.imageViewIcon);
            img.setImageResource(R.drawable.wood_cutting_icon);
        }
        else if (nameOfSkill == "You"){
            ImageView img = dialog.findViewById(R.id.imageViewIcon);
            img.setImageResource(R.drawable.player);
        }
        else {
            ImageView img = dialog.findViewById(R.id.imageViewIcon);
            img.setImageResource(R.drawable.ic_launcher_background);
        }

        //Displaying the custom dialog
        dialog.show();
    }

}
