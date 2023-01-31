# COMP55GroupProject
Overview:
The project will add a feature to the fight screen of the application Go Click Go!.
Currently, the game displays the statistics like monster health and the hit messages in the Eclipse console. The player is only able to play this game correctly if they have all the code present which is bad. 
This feature will implement faster updates to the fight screen, display monster voice lines, and hit messeges.

Pseudocode:
Read the code to where the JPanel display is updated
Create border to display the monster voiceline
Create border to display the user voiceline
grab the monster and user health
When the monster is clicked:
  display the monster hp from the monster voiceline border

To create a random character dialogue to display when damaged:
Create a list of random dialogues
Randomly return a dialogue
When the character hp decreases:
  grab the randomly returned dialogue
  display onto the screen

For Testing:
1) Run the application
2) On the main menu, click on fight on the bottom middle of the screen to enter the fight screen
3) Click in the middle of the screen to play the game
4) In the top right of the screen the Character health, monster health, and monster dialogue should automatically update with every click
  

