# [rafael.delboni.cc](http://rafael.delboni.cc)

My personal page/blog built with [stabilis](https://github.com/rafaeldelboni/stabilis), a static site generator written in Zig.

## Usage

Install [stabilis](https://github.com/rafaeldelboni/stabilis), then from this repo:

```bash
stabilis build        # build to public/
stabilis build -c     # build and clear destination first
stabilis serve        # local dev server with watcher
stabilis serve -o     # serve and open browser

stabilis new post "Hello World" -d "A short description" -t "tag1,tag2"
stabilis new page "About me" -s about -m main
```

## License

This is free and unencumbered software released into the public domain.
For more information, please refer to <http://unlicense.org>
