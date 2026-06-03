Fox plugin thing for paper, AI ported this to paper in about 30 minutes :3

If you get any errors, <a href="https://github.com/SeanOMik/TamableFoxes/issues/new">create an issue!</a><br><br>

Have you ever wanted to tame foxes? Well, now you can! <b>Use chicken to tame</b> and sweet berries to breed them!<br><br>

## Features:
* 33% Chance of taming
* Breeding
* Wild foxes pick berry bushes
* Leaping on targets
* Tamed foxes sleep when their owner does
* Foxes follow owner
* You can shift + right-click to let the fox hold items
* Right-click to make the fox sit
* Shift Right-click with an empty hand to make the fox sleep
* If the fox is holding a totem of undying, the fox will consume it and be reborn.
* Foxes attack the owner's target
* Foxes attack the thing that attacked the owner.
* Foxes are automatically spawned inside the world. (Same areas as vanilla foxes)
* Foxes attack chickens and rabbits.
* Snow and red foxes.
* Language.yml
* Message when a tamed fox dies
* /givefox command to give foxes to other players.
* Disabling certain gameplay messages
  * You can do this by changing certain fields in `language.yml` to "disabled". The fields that can be disabled are:
    * `taming-tamed-message`
    * `taming-asking-for-name-message`
    * `taming-chosen-name-perfect`
    * `fox-doesnt-trust`

## Commands:
* /spawntamablefox [red/snow]: Spawns a tamable fox at the players' location.
* /tamablefoxes reload: Reloads
* /givefox [player name]: Give a fox to another player.

## Permissions:
* `tamablefoxes.reload`: Reloads the plugin config. Default: `op`
* `tamablefoxes.spawn`: Gives permission to run the command /spawntamablefox. Default: `op`
* `tamablefoxes.tame`: Gives the player the ability to tame a fox. Default: `Everybody`
* `tamablefoxes.tame.unlimited`: Lets players bypass the tame limit. Default: `op`
* `tamablefoxes.tame.anywhere`: Lets players bypass the banned worlds in config.yml (so they can tame in any world). Default: `op`
* `tamablefoxes.givefox.give.others`: Allows the player to give another players fox to a player with /givefox. This will ignore if the other receiving has the `tamablefoxes.givefox.receive` permission. Default: `op`
* `tamablefoxes.givefox.give`: Gives the player the ability to give foxes to other players with /givefox. Default: `Everybody`
* `tamablefoxes.givefox.receive`: Gives the player the ability to receive foxes from other players from /givefox. Default: `Everybody`
