# How keep the motivation on a very long and useless project

### 17 minutes to read  

_I decided to make a 3D game and took the hard route just for fun._

I always wanted to make games. Like many developers who like video games, I wanted to make something in this area.
And when we think about making a game, the first reaction is to make our dream game-the final combination of all genres
and gameplay styles that we like, but usually this is the worst decision when starting to make games because you should never start with
complex stuff.

So for a long while, I’ve been flirting with the idea of making games, but my main source of procrastination was finding the best
engine/framework/workflow to do so. You can see in this list that I’ve been procrastinating over this subject for a while now (more than 11 years).
- [libgdx-ashley-box2d-topdown (java)](https://github.com/rafaeldelboni/libgdx-ashley-box2d-topdown)
- [phaser3-es6-webpack4 (javascript)](https://github.com/rafaeldelboni/phaser3-es6-webpack4)
- [phaser-grave (javascript)](https://github.com/rafaeldelboni/phaser-grave)
- [phaser-dungeon (javascript)](https://github.com/rafaeldelboni/phaser-dungeon)
- [unity3d-topdown-game (unity)](https://github.com/rafaeldelboni/unity3d-topdown-game)
- [raylib-ode-fps (c)](https://github.com/rafaeldelboni/raylib-ode-fps)
- [raylib-cpp-bullet3 (c)](https://github.com/rafaeldelboni/raylib-cpp-bullet3)
- [raylib-pixelated-fps (c)](https://github.com/rafaeldelboni/raylib-pixelated-fps)
- [ggez-specs-hello-world (rust)](https://github.com/rafaeldelboni/ggez-specs-hello-world)
- [ggez-specs-nphysics-hello-world (rust)](https://github.com/rafaeldelboni/ggez-specs-nphysics-hello-world)
- [ggez-specs-rhusics-hello-world (rust)](https://github.com/rafaeldelboni/ggez-specs-rhusics-hello-world)
- [ggez-dungeon (rust)](https://github.com/rafaeldelboni/ggez-dungeon)
- [BevyJam2022-2 (rust)](https://github.com/rafaeldelboni/BevyJam2022-2)
- [libdgx-sample (clj)](https://github.com/rafaeldelboni/libdgx-sample)
- [john-lemon-haunted-house (unity)](https://github.com/rafaeldelboni/john-lemon-haunted-house)
- [godot-2d-context-steering-behavior (godot)](https://github.com/rafaeldelboni/godot-2d-context-steering-behavior)
- [godot-brackeys-plataformer (godot)](https://github.com/rafaeldelboni/godot-brackeys-plataformer)
- [feles-tales-godot (godot)](https://github.com/rafaeldelboni/feles-tales-godot)
- [cljs-vs-phaser (cljs)](https://github.com/rafaeldelboni/cljs-vs-phaser)
- [zero-to-hero (cljs)](https://github.com/rafaeldelboni/zero-to-hero)
- [cljs-babylon-havok (cljs)](https://github.com/rafaeldelboni/cljs-babylon-havok)
- [cljs-threejs-rapier (cljs)](https://github.com/rafaeldelboni/cljs-threejs-rapier)
- [cljs-threejs-rapier-recast (cljs)](https://github.com/rafaeldelboni/cljs-threejs-rapier-recast)
- [squint-threejs-rapier-recast (squint)](https://github.com/rafaeldelboni/squint-threejs-rapier-recast)
- [feles-tales (squint-cljs)](https://github.com/rafaeldelboni/feles-tales)

My biggest complaint was the workflow. I wanted something similar to what I had when coding backend/frontend projects,
where a text editor and an auto-refresh in the browser were more than enough, or a test watcher in the backend, or a live REPL after I met Clojure.

So the clearest path was using JavaScript or a game framework to do the job, right? But naturally, when making games in anything other than a game engine,
you need a strong base: which math to use for getting the distance between vectors, how to calculate, or what the function is called to get the direction from
one vector to another, or even which algorithm to use for AI pathfinding. It can be exhausting, even if you just want to make the goddamn game.

So I tested some engines, did some tutorials and POCs, but my main problem with engines is that when you first open one, it feels like an airplane cockpit:
To many buttons and functions and panels and things to fuck around with, there are many ways to solve problems in engines, and you can always do everything with scripts,
but there are also in-house solutions, some try to limit your text editor to something embedded in the engine (this was back in the day, today Unity and Godot don’t have this problem),
and having to use the mouse to click to create/modify anything was sluggish to me and I hated the meta files stored in my git, which kept changing in nonhuman ways.

Anyway, I recognize that I was procrastinating on doing the actual thing. From all those projects listed, only 3 are "full-blown" games (with gameplay of a mater of minutes haha), and one was just
me literally reimplementing 1:1 a game that I saw had its assets open: [grave](https://uheartbeast.itch.io/grave)

But the other 2 I managed to do, and this is a recent fact. So what changed? Basically three things:
1. I allowed myself to do only ONE side project at a time and understood that a side project, in my rules, is a broad concept, so learning something new or playing a video game is also considered a side project.
2. I also allowed myself to give up projects without feeling like a failure (this one was super hard, but combined with the first rule, if the project wasn’t fun and I wanted to play a video game instead, I could just drop the project and move on, or drop the project for some time and continue if I felt like it).
3. I decided to just grab something and do it in a timebox. For the zero-to-hero project, I gave myself 100 nonconsecutive hours. It was an interesting experience-like a one-man game jam. The worst part was keeping track of the time, but it worked. In 66 nonconsecutive hours, I managed to have a full game implemented, and I even drew the main character animations. So in the next project, I gave myself one year to do it (which I failed and had to add an extra month to finish because of a main distraction called Silk Song).

I’m writing this to remind myself what worked in the last two projects so whenever I feel I’m spiraling too much, I can come back here and remember what I did to make it work.

Curiously, I started the last project I just finished before creating rules 2 and 3, so this is how it happened:

I decided that I wanted to make a small game and upload it to my itch.io account no matter what, read and watched videos about gamedev and procrastination, and created a small GDD (Game Design Document)
with the game rules and scope. The main goal was to make a Metal Gear Solid: VR Missions–like game, and to make it fit in the timebox, I decided to simplify the gameplay a lot by
just stealthy evasion and item collection, I wanted to do everything I could-3D models, level design, and code-but I allowed myself to use assets for SFX and fonts and to use Mixamo for animating
the characters.

After I had this idea, I decided to go with Godot, I had played around with Unity and other frameworks, but my focus was not the ergonomics of a nice workflow-it was JUST DO THE FUCKING GAME.
I started using C# because I have a friend who knows a lot about gamedev and was having a nice experience with Godot + C# and offered some mentorship on the project.

With this idea, [feles-tales-godot](https://github.com/rafaeldelboni/feles-tales-godot) was born, and I kept working on it steadily for 3 months, but after a while, I felt I wasn’t having fun doing it,
and the invasive thoughts started: maybe it was because of the engine, maybe I just don’t like gamedev, and I should just give up on the idea.
I reached a point where I was hating the development loop, so based on my only rule at the time, I could just stop that project and move on. But this time I tried to think about what made me finish [phaser-grave](https://github.com/rafaeldelboni/phaser-grave)
back in the day, and I remembered it was the feeling of having full command of the language I was using (at the time, I was working a lot with Node), and I decided to copy a game in JavaScript.
So all my tooling that I used in my day job happened to work on the side project, and that was cool. I only had to learn stuff for the game and the framework I was using at the time, Phaser.
In that direction, I allowed myself to do something in parallel and started (yet another game POC), but this one was focused on recreating the feeling I had when doing phaser-grave, so I made a POC: [cljs-vs-phaser](https://github.com/rafaeldelboni/cljs-vs-phaser),
where I sanity-checked that the idea of using Clojure, my main language as of this post, for gamedev would work, and I felt good at the end of it. But it wasn’t meant for 3D games, and I ended up feeling that
I wanted to do more with that stack, so I created rules 2 and 3. I dropped the Godot game and started an even smaller game with a time constraint and decided to make most of the assets I could in that timebox.
So I created the [zero-to-hero](https://github.com/rafaeldelboni/zero-to-hero) game jam, and after 66 nonconsecutive hours, I had a full game, and it felt amazing. But I didn’t like some aspects of the current state of the Phaser engine,
like the default physics engine-it’s horrible-and there were other aspects that I didn’t like about the engine that I don’t really remember now. But I liked the idea of using ClojureScript to write games.
It felt right. I could release web games on itch.io “fast” and prove game ideas, so that made me think of feles-tales again.

After finishing zero-to-hero, I decided to take some time and play video games as a “side project” and allowed myself to do some POCs in the direction of “could I use CLJS to write a 3D game?” After some POCs ([cljs-babylon-havok](https://github.com/rafaeldelboni/cljs-babylon-havok), [cljs-threejs-rapier](https://github.com/rafaeldelboni/cljs-threejs-rapier), [squint-threejs-rapier-recast](https://github.com/rafaeldelboni/squint-threejs-rapier-recast), [squint-threejs-rapier-recast](https://github.com/rafaeldelboni/squint-threejs-rapier-recast)),
I [decided](https://github.com/rafaeldelboni/cljs-vs-squint-threejs) to go with Squint instead of CLJS at the time because the compilation artifacts in Squint generated a much smaller and more optimized
JS, and the integration with WebAssembly libraries with Vite was super simple as well. Another aspect I was experimenting with was how to edit levels, because in zero-to-hero I had [Tiled](https://www.mapeditor.org/), a
perfect level editor where I could draw my level, add custom properties (layers), and later in-game conditionally render stuff as I wanted. I decided to play with Blender as a level editor and use custom properties to
define physics, and I ended up with a “nice” [workflow](https://github.com/rafaeldelboni/feles-tales/blob/main/docs/workflow/readme.md) for level design. I used quotes around “nice” because Blender isn’t a
level design tool, so defining textures, moving objects, and scaling wasn’t great. But in the end, it was nice because it obliged me to learn Blender-knowledge that I used later to model the game characters-so OK.
If I were starting a new project today, I’d probably choose a different tool for level editing, like [TrenchBroom](https://trenchbroom.github.io/), Quake levels have all I like in aesthetics and functionalities
for 3D games, so I think that would be the way in the future. But then again, I learned the basics of Blender with my decision, so not a big loss. Another possibility is using some plugin to ease Blender’s
default problems in game design, but at the time, Blender itself was so overwhelming that I just decided to keep it vanilla.

With all the stack decided, I remembered the most important rule that made zero-to-hero possible-rule number 3-and created a timebox. Since I had to learn Blender and I wanted to do most of the 3D assets and level
design, I gave myself a year starting from March 2025, but I ended the project in April 2026 with a very good excuse for that: I had to pause game development for a month because of the Silk Song release in September 2025.
![Commits Over Time](https://raw.githubusercontent.com/rafaeldelboni/feles-tales/refs/heads/main/docs/analysis/release/commits_over_time.png)

So after one year (and a month) making a game, what did I learn?

- I still procrastinate a lot. Over 50% of the commits related to feles-tales were refactorings or code maintenance, which means I still spend a lot of time on details instead of focusing on the gameplay loop.
It took me until late January 2026 (9 months into development) to have a first playable version of the game that I could hand to a friend so he could give me feedback on whether the idea was fun. In my defense,
I was trying to mimic the best I learned from CLJS + Phaser development in a 3D workflow with three.js + Rapier + Recast navmesh, but that alone almost took away my will to continue making the game. After
I handed the game to someone else to play, that gave me a boost in confidence that I could finish the project. As you can see in the chart above, my commit numbers were decreasing fast.

- I spent a huge chunk of time doing the enemy AI. It was super complex, which led me to create an FSM engine (that I used in nearly all the rest of the game), and syncing the FSM with enemy data and sending commands to its agent to
navigate the mesh was hard, but in the end worth it. Using an FSM proved a super useful tool, and late decisions like SFX or score management were super easy to implement because of this early decision (that I took in my mentorship back in the Godot project).

- For me, it appears that the tools I use are super important for keeping me motivated. Squint is super similar to Clojure, so I didn’t have to stop to think about syntax or how to split code. It was more like
reading documentation of the three (and huge) libraries I chose and implementing wrappers and wiring back to the game.
I do have my negatives about three.js, like the lighting system and its flaws, but the overall experience was great. The Vite hot reload was incredibly fast, and I could see changes I made in the game
in a matter of microseconds, and even when editing the Blender level files, after exporting to GLB, I could test the new level by pressing refresh in the browser.

- Combining modelling in Blender and painting in iPad's Procreate was incredibly fun and fast.

- Keeping a [GDD](https://github.com/rafaeldelboni/feles-tales/blob/main/docs/gdd/readme.md) and a [TODO](https://github.com/rafaeldelboni/feles-tales/blob/main/docs/todo.md) list updated and easily accessible helped me focus on where to work next and gave me the feeling of completeness on a long, ending task.

I fed all feles-tales data to GLM 5.1 and asked it for some analysis and charts. If you’re curious, you can see the result of its work [here](https://github.com/rafaeldelboni/feles-tales/blob/main/docs/analysis/readme.md).

I would like also to say thanks to all my friends, but specially to [Lucas Teles](https://github.com/lucasteles) for the mentorship and [Lucas Bertin](https://github.com/lucascebertin) for being the first player and moral improver, nothing of this post would happen without your support.

Btw, you can play the game here:
https://rafaeldelboni.itch.io/feles-tales

It’s not super well balanced, and I don’t find it super fun, but I’m proud of the end result and where it ended.
