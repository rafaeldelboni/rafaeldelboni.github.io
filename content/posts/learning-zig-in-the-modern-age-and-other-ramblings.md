---
title: "Learning Zig in the Modern Age and Other Ramblings"
date: 2026-07-15T00:19:39Z
slug: learning-zig-in-the-modern-age-and-other-ramblings
tags: [study, thoughts, zig]
---

### 9–12 minutes to read  


_Just a little context: I've been working with Clojure since 2019 as my main programming language, and these are my thoughts on learning a somewhat niche low-level language using LLM as mentor in the process._

I decided I wanted to learn something new, something outside my comfort zone, and a natural choice for me is usually ~procrastinate and go back to Clojure or play video games~
think about my biggest gap in my career, which is the lack of knowing a low-level language well.

I've tried before with C and Rust, and for each of those I had some big problem or opinion that didn't make me love the language and keep studying it, so I usually do a big/medium project
in the lang and introspect over the project and decide my next step, and for those I decided that I didn't want to keep pushing on those.

Well, I've been voyeur-ing Zig for a while, but after [reading this article](https://pure-systems.org/posts/2026-04-29-functional-programmers-need-to-take-a-look-at-zig.html) and watching [this interview](https://www.youtube.com/watch?v=iqddnwKF8HQ) with the language creator I decided to give it a try, mostly because we
matched ideals and worldviews for many things he said in the video. You should go there and watch it; it's a one-hour-long video that feels like 15 minutes.

Initially, I really liked the developer experience and some functionalities, like you can assign the result of an if or switch to a variable _(very Clojuresque)_. I liked that memory management has an
"easy mode," where you can just create an arena at the beginning of your app and defer the deinit of it just one time and not need to keep remembering to do so in every allocator usage.
The type system has a lot of good inferences, so you don't end up with something super verbose.

I hit some walls, but mostly it was me being dumb. First, the error messages and propagation system took me a while to understand. Like, look at this:
```zig
run
└─ run exe stabilis
   └─ compile exe stabilis Debug native 1 errors
src/main.zig:140:12: error: error union type '@typeInfo(@typeInfo(@TypeOf(main.readConfig)).@"fn".return_type.?).error_union.error_set!models.Config' does not support field access
        cfg.base_url = override;
        ~~~^~~~~~~~~
src/main.zig:140:12: note: consider using 'try', 'catch', or 'if'
```

I know the last line is exactly saying what to do to solve your issue, but the problem was when I defined `cfg` in the example; I forgot to handle the error with `try`:
```zig
var cfg = try readConfig(arena, io, opts.source_dir);
```
But I was in despair enough when I read `error union type '@typeInfo(@typeInfo(@TypeOf(main.readConfig)).@"fn".return_type.?).error_union.error_set!models.Config' does not support field access
` that I didn't manage to reach the next two lines to see how to solve it, and copying and pasting this in Kagi _(or in Google for the ones that don't care much about privacy)_ didn't return anything useful.

That's where I decided to lose all the possible chances of being friends with Mr. Kelley and booted up my `opencode` pointing to a cloud GLM 5.2 cheap subscription, and the model just fixed the "bug"
for me with no f*cking explanation and no permission to edit the code (well, the default behavior of most harnesses is just to go and solve the user's issue), so I decided to create an AGENTS.md file stating
that the model should play the role of mentor and not of code editor, and that worked okay-ish. Most of the time it just spat the correct code on the screen without explanation, and I ended up with this sentence
in my AGENTS.md that started to help me more:
```
# CRITICAL: Agent Role
**You are a code mentor in a pair-programming session. You answer questions and explain concepts. You NEVER write, edit, or modify code unless the user explicitly asks you to. The user writes all code himself.**
## Zig Version
All questions about Zig are related to version 0.16 onwards.
```

_Is it just me that feels very awkward writing this shit? And telling my tool to role-play with me?_

So I got to the point I understood more and more of the lang on things like why banging my type would lead me to need a `try` when calling the fn, how to handle optional fields, and when to use pointers instead of a clone.

But I came from the comfortable and peaceful land of functional programming using a dynamic language, and handling all that strange ptr yada yada in my code was leading to a huge and horrible spaghetti
mentored by an LLM bot _(that is possibly a distillation of another one)._

So I decided to step back and do the cringiest thing I always see people do when they start learning Clojure _(Yes, I'm looking at you Uncle Bob and that bizarre testing suite you insist on working on)_. I decided to not follow what the community is doing and go with my own biased, out-of-place, and not-backed architectural decisions.

And I refactored my code to use ports & adapters-more specifically, this [Ploeh's take of it](https://blog.ploeh.dk/2016/03/18/functional-architecture-is-ports-and-adapters/) _(please read it is a nice article, and there is a 
[video version](https://www.youtube.com/watch?v=US8QG9I1XW0) as well)._ I've been working on systems in this architecture long enough that this is my home and comfort, so why not?

And it worked quite okay. The logic and adapters were pure in the sense that you give one input and you will have the same output always, but sometimes I allowed some mutable arguments here and there, 
because why not? And ports were all the fns that had to do IO, and with the new IO interface it's super similar to what I have in Ports & Adapters, where the mutable components are passed via arguments (I mean, 
visually, right? It receives an argument called IO that, for me, is like a mutable component, but I don't have a single idea of what is going on inside the IO implementation or what my "juicy main" is giving me).

My key pain points that I really struggled to understand in Zig were: comptime, types _(more importantly WHERE THE FUCK WAS THE STRING TYPE)_, error handling, IO, and async.

I think for all of those, **comptime** took a while to grasp _(maybe "grasp" is a big statement here)_, but I wanted to get good enough to solve issues using it.
At that moment, I was hand-rolling a manual version of a CLI argument parser, and I was thinking how boring, ugly, and repetitive it would be to do the work to print the help messages based on user input
vs. expected input types, so I asked my _distilled_ mentor if that would be a good case for comptime and to create a playground where he would progressively add challenges to it that in the end would cover
my already working hand-rolled CLI, but using comptime. You can see the progression in the [commits of this PR](https://github.com/rafaeldelboni/stabilis/pull/10). In the end, I made this code its own library,
not that I want the world to use it, just because my next project will be in Zig and will need a CLI parser, so I designed it to be independent, and after I finished Stabilis I moved it to its own repo,
[vexillum](https://github.com/rafaeldelboni/vexillum) _(and yes I like Latin words, and no, I don't know or have a specific reason why)._
The resulting comptime code is horrible _(not much different from the rest of my Zig code, though)_, but it's less horrible than Clojure macros _(and sorry to my pseudo-mentor that every time I tried to understand comptime using
Clojure macros as an analogy he got super upset, but still there are some similarities to me because both produce code in the end)_.

Another pain point is a side effect of the lack of stability of the language. When searching for examples you will almost always hit some example that doesn't work on 0.16+. The LLM model that I used always had to burn some extra
tokens reading the std to be sure the examples would work in the new version (and even then some didn't, and I had to ask kindly for it to fix the example to work on 0.16).

Also, outside of using an LLM, you don't have many sources of information other than reading the std yourself, some old posts on ziggit.dev or reddit/r/Zig, and there are a lot of outdated examples on GitHub and blog posts.

I didn't use async/await. It's in my plans to make part of the code of Stabilis run in parallel, since there is some file processing that could benefit from that, but a minor research showed that there aren't 
many examples for processing an entire list in parallel and awaiting all being done (something like [pmap](https://clojuredocs.org/clojure.core/pmap)).

I wish there were an agent harness that would be a pair-coding session instead of a code generator-something, that would keep track of file changes, suggest tests, and find bugs and improvements via a chat interface,
like a person watching you pilot a pair session-and a mentor mode that doesn't give you the f*cking answer right away, but plans how to study a difficult feature. _(Since everybody is building up their own tools
that might be a good next project tho)._

I think it's really hard for people to understand that an LLM is just a tool, and you can modulate the level of interaction and delegation to it. It doesn't need to be all or nothing; you can set internally where it can go 
or which tasks it can take. Or let me rephrase: you can decide what context you're giving up to have in exchange for a speedup in something. Every time I decided I would let the LLM do the task, I felt bad later,
because I lost something of the context in that piece of the code or the ownership of the reward of doing that task.

Regardless, you can learn stuff with these new tools if you know how to use them _(and maybe you can get dumber if you don't)._

I wish we had a Clojure dialect that could be ~blazing~ fast like these low-level languages, because I wrote a poor Zig SSG that can process my entire blog _(it's not huge, though, but you get my point)_ in just 15 ms. That's
not even the [startup time of the GraalVM](https://readmedium.com/using-graalvm-to-reduce-startup-time-cdbb7e5b9185). I know [jank](https://jank-lang.org/) is a good promise on this, but it's not there yet as of the time I'm writing this.

I will keep pushing in Zig. I hope I will learn it someday and be fluent and make a 3d video game in it, using [Box3D](https://github.com/erincatto/box3d) compiled to the web using WASM. _(Is that wish too much? Maybe)_.

Did I say Zig is super fast? And the test suite is nice, the tooling is super cool.
