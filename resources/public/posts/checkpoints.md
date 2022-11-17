# Checkpoints

### 3 minutes to read  

_Life is a Sine wave of emotions with checkpoints that give us time to reflect on our decisions._

From the beginning of the year to now I've been passing through some difficult times
that I'm not going to list all here since that is not the point of writing this, but this is 
the overall scenario: **pandemics, career changes, big financial decisions, lost some
important people and follow up with my post-cancer checkups.**

So with this I always had something to be worried about, I never had my mind free of
problems and anxieties for even a second, my feeling was that my brain was just tracking
what would be the next big problem for him made me think about, there wasn't meditative 
state during this phase all that I did in my free time was try to kill time and do 
activities that kept my mind busy to not start worrying about something.

My therapist that these kinds of crazy moments are the chaos that naturally rules the life and world
and as humans, we tend to organize stuff, even the natural chaos that surrounds us all the time.
So when I "lost control" of all the surrounding chaos the tendency is to get anxious and all
the motivations surrounding are focused on trying to organize the chaos.

And the chaos comes and goes like a sine wave, the more we fight against is more lifetime 
lost not enjoying the little stuff or doing creative work, because  I can't do creative work
when passing through chaos, I need to be bored to trigger my creative motivation and
interestingly (or not) I just discovered this fact about me with my therapist in the recent days
and is quite controversial for me because I hate to be bored (like most millennials out there).

This is what my year looked like:  
![sine-wave](/img/sine-wave.png)

Now I will enter a descendant in direction of boredom (I hope) and usually what I do about this
is search for problems to get out of this state, a career change, maybe learn something new 
and ridiculously hard, maybe just promote a small problem to a big problem (my brain loves this one).

But actually what I need to do is find peace in boredom and don't deep dive into chaos, maybe a better
sine wave would look like this:  
![ideal-sine-wave](/img/ideal-sine-wave.png)

A good balance between chaos and boredom, enough to not settle down and challenge me to seek
new challenges and enough boredom to trigger my creative impulse and start doing things I'm proud of.

The most important thing I want to learn about all of this is to find peace and be happy in boredom
and try don't swim to much time in the sea of chaos I do have the natural tendency to try to fix
and organize all things this is super consuming and there is something that we can't do anything
about it.

_Fun fact: I did the drawings above using `clojure` and `java.awt.Graphics2D` and the function 
to calc the sine waves stand out super simple and pretty (at least for me hahaha)._

```clojure
(defn sine-wave-calc
  [size amplitude frequency]
  (map (fn [t]
         {:x t
          :y (* amplitude (Math/sin (* 2 Math/PI frequency t)))})
       (range size)))
```

_You can check the entire code to generate the pngs here https://github.com/rafaeldelboni/sine-waves_
