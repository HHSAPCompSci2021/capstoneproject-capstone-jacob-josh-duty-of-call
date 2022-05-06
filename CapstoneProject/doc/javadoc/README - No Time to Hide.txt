No Time to Hide
Authors: Joshua Lee, Jacob Tang
Revision: 4/12/22


Introduction: 


The classic game of hide and seek tag but modified to accommodate the addition of unique superpowers. No Time to Hide is a multiplayer hide and seek tag game that consists of 5 rounds, which are 5 minutes each. The objective of the game is to end up with the most points at the end of the game. The point system is structured so that 50 points is awarded to hiders after each win and 100 points is awarded to seekers after each win. In terms of the layout, the game is played on a large map containing connecting walls that serve as boundaries and shape pathways for the players. Walls also block the vision of players on the other side of the wall and can only be vertical or horizontal (not diagonal). To go through a wall you have to open the door which takes 2 seconds delay. Additionally, there are several bushes across the map where players hide in, but can be seen if another player enters the bush. The seeker, clearly at a disadvantage, is given faster movement than the hiders. The game first starts with 1 seeker and 4 hiders. The seeker is chosen at random before each round and hiders die immediately when tagged. Tagging refers to your character touching/intersecting another character. The hiders, whose objective is to survive until the time limit is up, are given special powers that can be used once per round. Special powers include invisibility that can be used for 5 seconds once every minute, taser stun that can be used for 3 seconds every 45 seconds, speed boost that can be used for 5 seconds every minute, and phasing through walls once every minute. Each hider is given a different power as the powers are distributed randomly. Only hiders have super powers.


Instructions:
Use the WASD keys to move around. Use the mouse to aim special powers at others. Click space to activate special abilities, and the goal as hider is to not get tagged by the seeker. Goal as a seeker is to tag the hiders before time is up. If hider gets tagged, they die immediately and sit out the rest of the round.


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
*  Map/grid that the players are able to play on with a maximum of 5 players in the map. The map serves as the foundation of the game as the game can’t be played without it.
*  Special ability powers that are able to be used and work in the game include:
   * Invisibility: Seeker can still see player, but is unable to tag them for a limited amount of time
   * Taser Stun: Stuns nearby seeker temporarily stopping their movement
   * Speed Boost: Temporarily double speeds of player
   * Wall Phase: Player can phase through wall into another pathway with no delay
* Local network multiplayer: servers are created that allow multiple players to participate in the same game.
* Intro screen/menu in which players can choose the lobby they want to join and play in. (Local network multiplayer)
* Timer on top left of the screen which indicates how much time left in each round.
* Death feature where the hider is unable to play after they get tagged until the next round.


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
*  Spectate mode when there is too many people in the lobby, and they want to watch the game
*  Multiple superpowers for each player
*  Multiple maps with special gadgets/unique features such as lava or acid
*  Play with CPU at different difficulties
*  Multiple game modes such as toilet tag, free for all/regular tag, and capture the flag.


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
*  Difficulty levels with seeker having increasing amounts of speed
* Allowing players to have ability to revive their teammates if they stand on them for a certain amount of time
*  Random events in the game like weather that either helps or destroys you




Class List:


Package: Grid
* DrawingSurface - graphical interface that game is played on
* Main - PApplet that can runs the whole program
* MenuScreen - explains instructions of game and holds graphics for the intro screen
* AliveScreen - holds graphics for gameplay when player is alive
* DeadScreen - holds graphics and features of screen that appears when hider dies
* Map - contains the boundaries and layout of the game while also including bushes to hide in
Package: Gameplay Elements
* Sprite - stores basic features of a character
* Hider - stores qualities and abilities of hider
* SpecialPowers - describes the special powers of the hiders
* Invisibility - subclass of SpecialPowers
* WallPhase - subclass of SpecialPowers
* TaserStun - subclass of SpecialPowers
* SpeedBoost - subclass of SpecialPowers
* Seeker - stores qualities and abilities of seeker
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]


Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* Jacob: Main, DrawingSurface, DeadScreen, MenuScreen, Seekers, SpecialPowers, Invisibility, WallPhase, work on stylistic components and accessibility of game for players, GUI
* Josh: Main, DrawingSurface, AliveScreen, Hiders, Sprite, TaserStun, SpeedBoost, create the local network multiplayer, GUI