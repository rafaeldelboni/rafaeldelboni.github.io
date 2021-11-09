# [rafael.delboni.cc](http://rafael.delboni.cc/)

My personal page/blog using [nota](https://github.com/rafaeldelboni/nota) as template

# Prerequisites
Things you need installed to use this repository

- [nodejs](https://nodejs.dev/download)
- [clojure](https://clojure.org/guides/getting_started)
- [babashka](https://github.com/babashka/babashka#installation)

# Developers
Commands and alias for tooling while developing nota.

## Install dependencies
```bash
npm install
```

## Commands

### Local build
Start shadow-cljs watching and serving main in [`localhost:8000`](http://localhost:8000)
```bash
npm run watch
```

### Tests
Start shadow-cljs watching and serving tests in [`localhost:8022`](http://localhost:8022)
```bash
npm run watch:tests
```

Run **Karma** tests targeted for running CI tests with *Headless Chrome Driver*
```bash
npm run ci-tests
```

Run **Babashka** script tests
```bash
bb tests
```

### Deploy
Build the release package to production deploy
```bash
npm run release
```

# CLI Commands
For more information on optional arguments or how to use the commands you can always add an `-h` at the end of the command. (Eg. `bb del:post -h`)

## Posts
Commands to manage posts markdown files and it's entry in the "database".

### New Post
```bash
bb new:post "Hello World" -d "Such hello, much world" -t "first markdown"
```
The following prompt will be shown:
```bash
New:
{:post/name "Hello World",
 :post/description "Such hello, much world",
 :post/timestamp 1635110961351,
 :post/path "posts/hello-world.md",
 :post/tags #{"markdown" "first"},
 :slug/id "hello-world"}

Create? (Y/n):
```
This will **create** the file `resources/public/posts/hello-world.md` and add an entry in the database `src/data.edn`.

### Delete Post
```bash
bb del:post hello-world
```
The following prompt will be shown:
```bash
Delete:
{:post/name "Hello World",
 :post/description "Such hello, much world",
 :post/timestamp 1635101110744,
 :post/path "posts/hello-world.md",
 :post/tags #{"markdown" "first"}}

Are you sure? (y/N):
```
This will **delete** the file `resources/public/posts/hello-world.md` and remove the entry in the database `src/data.edn`.

## Pages
Commands to manage pages markdown files and it's entry in the "database".

### New Page
```bash
bb new:page "About me" -s about
```
The following prompt will be shown:
```bash
New:
{:page/name "About me", :page/path "pages/about.md", :slug/id "about"}

Create? (Y/n):
```
This will **create** the file `resources/public/pages/about.md` and add an entry in the database `src/data.edn`.

Since `-s` (slug) is optional this command could be
```bash
bb new:page "About me"
# =>
New:
{:page/name "About me",
 :page/path "pages/about-me.md",
 :slug/id "about-me"}

Create? (Y/n):
```
Or even
```bash
bb new:page About
# =>
New:
{:page/name "About", :page/path "pages/about.md", :slug/id "about"}

Create? (Y/n):
```
> Is possible to create "hidden" pages adding `--hide` to the command, this will filter the page from pages list resolver, but anyone will stil be able to access it via url/slug.

### Delete Page
```bash
bb del:page about
```
The following prompt will be shown:
```bash
Delete:
{:page/name "About", :page/path "pages/about.md"}

Are you sure? (y/N):
```
This will **delete** the file `resources/public/posts/hello-world.md` and remove the entry in the database `src/data.edn`.

## Tags
Tags aren't required to nota work, but you can override it's default behaviour (capitalize tag) to customize the name that will be shown.

### New Tags
```bash
bb new:tag clojure "Clojure Stuff"
```
The following prompt will be shown:
```bash
New:
{:tag/name "Clojure Stuff", :slug/id "clojure"}

Create? (Y/n):
```

### Delete Tags
```bash
bb del:tag clojure
```
```bash
Delete:
{:tag/name "Clojure Stuff"}

Are you sure? (y/N):
```

# License
This is free and unencumbered software released into the public domain.  
For more information, please refer to <http://unlicense.org>
