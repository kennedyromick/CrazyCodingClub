### Group 10, T03
# ASTROBLAST!
ASTROBLAST! is a single player platform animation side scroller game (gameplay is viewed from a side-view camera angle). The player moves through various platforms, while avoiding objects, to complete an objective. The application asks the user for input on the player’s move and responds appropriately to that movement, as well as checking if any obstacles have been hit/not overcome. Progression to the next level or failure is determined by successful passage of all obstacles to reach the end of the level.

## Foundations
### Class Diagram 
! [Class Diagram] (https://github.com/kennedyromick/CrazyCodingClub/blob/master/Astroblast%20UML.png)

## Getting Started
Follow the instructions below to set up the game and rules/directions for gameplay.

### Installing
1. On the main page of the repository, click **Clone or download**.
2. Copy the https:// link provided.
3. Open the terminal, change the directory to the one you would like the files to be cloned to. 
4. Type `git clone` and paste the URL copied in step 2. Then press **Enter** to create a local clone.
  > `git clone https://github.com/<your-username>/<your-repository>`
5. Launch **Eclipse** workspace, create a **New JavaFX Project**, create a **new package** called FinalProject, import the **src** from the cloned repository into the FinalProject package. Run the GameGUI class as a Java Application.

### Instructions
The objective of the game is to complete each level without dying by touching the floor (FEATURE COMING SOON) or colliding into any enemies where they are present. 
##### Controls
Use the keyboard arrows to control motion: ">" right and "<" left. The up and down arrow keys reverse gravity. There is no jump feature, reverse gravity is in effect, so your avatar will move in the direction (up or down) you choose to send it using the up and down arrow keys, and will switch direction according to the keys or stop moving once it hits a platform. For example, if you press the "up" key once, the avatar will continue to float upwards until you change direction using the "down" key or it hits a platform.
##### Level One
Player cannot die. No enemies are presented, only white platforms and walls (obstacles). This level is an opportunity to get use to the movement of the avatar for future levels. To complete the level move right until the final vertical wall is hit, this will bring you to level 2.
##### Level Two
Player can now die by colliding into moving enemies (red). Same movement and objective as level one, however with the addition of avoiding enemies.
##### Level Three
Player can die by colliding with moving enemies (red), being hit by meteors (brown) or falling into gaps on the floor and ceiling.

## Contributors
Kennedy Romick,
Anastasiia Slobodianyk,
Justine Leslie,
Sean Anselmo
