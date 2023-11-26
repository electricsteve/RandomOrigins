execute as @s rotated as @s positioned 0 0 0 align xyz run summon minecraft:armor_stand ^ ^ ^1 {Invulnerable:1b,NoGravity:1b,Tags:["aim"]}

execute at @s run summon arrow ~ ~1.5 ~ {Color:16776960,Tags:["spectral_arrow"],custom_potion_effects:[{id:"minecraft:glowing",amplifier:1b,duration:300,show_particles:0b},{id:"minecraft:unluck",amplifier:1b,duration:1,show_particles:0b}],Potion:"minecraft:empty"}

execute at @s positioned ~ ~1.5 ~ as @e[distance=..1,tag=spectral_arrow,limit=1,sort=nearest] positioned 0 0 0 store result score @s MotionX run data get entity @e[tag=aim,limit=1] Pos[0] 5000
execute at @s positioned ~ ~1.5 ~ as @e[distance=..1,tag=spectral_arrow,limit=1,sort=nearest] positioned 0 0 0 store result score @s MotionY run data get entity @e[tag=aim,limit=1] Pos[1] 5000
execute at @s positioned ~ ~1.5 ~ as @e[distance=..1,tag=spectral_arrow,limit=1,sort=nearest] positioned 0 0 0 store result score @s MotionZ run data get entity @e[tag=aim,limit=1] Pos[2] 5000

kill @e[tag=aim]

execute store result score @s Uuid1 run data get entity @s UUID[0]
execute store result score @s Uuid2 run data get entity @s UUID[1]
execute store result score @s Uuid3 run data get entity @s UUID[2]
execute store result score @s Uuid4 run data get entity @s UUID[3]

execute as @s run tag @s add owner

execute at @s run data modify entity @e[tag=spectral_arrow,limit=1,sort=nearest] Owner set from entity @s UUID

execute as @s run tag @s remove owner

execute as @e[tag=spectral_arrow,limit=1,sort=nearest] store result entity @s Motion[0] double 0.001 run scoreboard players get @s MotionX
execute as @e[tag=spectral_arrow,limit=1,sort=nearest] store result entity @s Motion[1] double 0.001 run scoreboard players get @s MotionY
execute as @e[tag=spectral_arrow,limit=1,sort=nearest] store result entity @s Motion[2] double 0.001 run scoreboard players get @s MotionZ