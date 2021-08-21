# SoundBootMod

minecraft mod

Play music when the title of the game is displayed.
It runnable both fabric and forge.

[Confirmed version file](./ENVIRONMENT.md)

Maybe 1.16.4 ~ 1.16.5 will work(Java8)


マイクラタイトルが表示されたときに音楽を再生します。FabricとForgeの両方で実行可能です。

[動作確認済バージョンのファイル](./ENVIRONMENT.md)

多分1.16.4 ~ 1.16.5なら動作します。(Java8)


## Introduction(導入方法)
1. Put in mods folder
2. A sound_boot folder will be created in the game folder(game run)
3. Put the .wav file in the sound_boot folder
4. finish

If there are multiple .wav files, only one will be played randomly.

1. modsフォルダに入れる
2. Minecraftを起動するとゲームフォルダにsound_bootフォルダが生成される
3. .wavファイルをsound_bootフォルダに配置する
4. 終わり

.wavファイルが複数ある場合はランダムに1曲だけ再生されます。

## Attention(注意)

.wav files larger than 1GB will not be played and will throw an IllegalArgumentException.

Since .wav files are just containers, you can also store .mp3s, but this mod probably won't play them. Place the .wav file that contains the uncompressed PCM.

1GB以上の.wavファイルは再生されず、IllegalArgumentExceptionを送出します。

.wavファイルは単なるコンテナなので、理論上は.mp3とかも格納できたはずですが、多分このmodでは再生できないので、非圧縮PCM(LPCM)で格納された.wavファイルを配置してください。(一般的に.wavが付くファイルで圧縮系コーデックが使われていることはあまりないとは思いますが...)

<br>
動作確認はボイスロイドの.wavで行いました。(VOICEROID2 紲星あかり 認証済)


## Operation confirmed environment(動作確認済バージョン)
<hr>

### Forge(Java8)

#### Forge 1.16.4

- ClientSide
    - 1.16.4-forge-35.1.37.jar
    - architectury-1.20.29-forge.jar

#### Forge 1.16.5

- ClientSide
  - 1.16.5-forge-36.2.0.jar
  - architectury-1.20.29-forge.jar

<hr>

### Fablic(Java8)

#### Fablic 1.16.4

- ClientSide
  - fabric-loader-0.11.6-1.16.4.jar
  - fabric-api-0.37.2+1.16.jar
  - architectury-1.20.29-fabric.jar
