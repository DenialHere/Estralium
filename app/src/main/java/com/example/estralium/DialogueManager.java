package com.example.estralium;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogueManager {

/**   To show a level up dialog pass through the current activity your in,
 *    the name of the skill in with the first letter in UPPERCASE, the picture
 *    you wish to be displayed, the level of the skill and the desired position of the dialog box
 *    ex: dm.Show(this, "Woodcutting", R.drawable.wood_cutting_icon, player.getWoodCuttingLevel(), Gravity.BOTTOM);
 */

    public void Show(Activity activity, String nameOfSkill, int skillPicture, int level, int position) {

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

        //Setting the position of the dialog box
        dialog.getWindow().setGravity(position);

        //Setting the icon image of the skill from the image passed
        ImageView img = dialog.findViewById(R.id.imageViewIcon);
        img.setImageResource(skillPicture);


        //Displaying the custom dialog
        dialog.show();
    }

}
