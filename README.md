# AurebeshHelper

## General
In the Star Wars universe most text is displayed using the Aurebesh transliteration. It's bascially a different alphabet that displays english text. This app is for those of you who want to translate or practise Aurebesh.

## Installation
- #### Executable Download
  soon

- #### Compile it your self
- This app runs on [Java 21](https://www.oracle.com/de/java/technologies/downloads/#jdk21-windows)
- Clone the repository to your PC
- Windows: `./gradlew :shadowJar -Pplatform=windows` to compile
- MacOs: `./gradlew :shadowJar -Pplatform=macos-aarch64`
- Linux: `./gradlew :shadowJar -Pplatform=linux`
- Run `java -jar .\build/libs/DeansDilemma.jar` to start the game

## Features
These Features are currently implemented:
- #### Transliterate Aurebesh to Latin Alphabet
  Use buttons to write a word in Aurebesh and instantly see it's transliteration

- #### Transliterate Latin Alphabet to Aurebesh
  Write a word using your keyboard and instantly see it's transliteration to Aurebesh

- #### Practise Reading Aurebesh
  Train your Aurebesh skills by reading words in Aurebesh and transliterating them to the Latin Alphabet

- #### Practise Writing Aurebesh (in progress)
  Train your Aurebesh skills by writing a given words in Aurebesh
