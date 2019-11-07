# hitori-twitter

ClojureScript + React (Reagent) でひとりツイッターをつくるよ。

Ref. https://sbfl.net/blog/2019/02/20/react-only-tutorial/

## 動かしかた

まずは CSS をビルドするよ。
[garden](https://github.com/noprompt/garden)を使ってるから、これをやらないと CSS がなくて困るよ。

    lein garden once

次に JavaScript をビルドして、サーバを立ち上げるよ。
デフォルトでは `localhost:9500` で待ち受けるはずだよ。

    lein fig:build

ブラウザで開くと Twitter と似て非なるものが出てくるので、
ツイートするなどして遊んでみるとよいです。

## License

Copyright © 2019 sandmark

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
