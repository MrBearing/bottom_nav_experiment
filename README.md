# bottom_nav_experiment
BottomNavigationBarを使用してフラグメントを切り替えるアプリのサンプル



## 幾つかハマった場所のメモ

* Framgmentの切り替え問題
  * 自動生成されたonCreateViewメソッドの第三引数savedInstanceState: BundleがNullableになっていないために、例外を吐いていた
  * savedInstanceState: Bundle?としてNullableにすることで対応

* Fragmentの描画が残る
  * →各Fragmentに背景色を追加して透過しないようにして無理やり対応
