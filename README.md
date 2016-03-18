#Sarangi-jEN

Song data collector for the [Sarangi](https://github.com/lazymahendrathapa/Sarangi) Project using the Echonest API.

##Tools Used
* [jEN](https://github.com/echonest/jEN) - Java Client for the Echonest API
* [GSON](https://github.com/google/gson) - A Java serialization library that can convert Java Objects into JSON and back.

##Classes
* `CustomSong` :- Represents a song
* `CustomSongList` :- Represents a collection of songs
* `CustomSongListGenerator` :- Generates a CustomSongList with song details and stores as json
* `CustomSongListReader` :- Reads in the json file to get the CustomSongList
* `CustomSongSearch` :- Searches the EchoNest database for the details of the given song

* `TrackAnalysisExample` :- Example where a local mp3 file is uploaded to and analyzed by the EchoNest

### Compiling 

```
mkdir bin
javac -cp .:jEN.jar:gson-2.6.2.jar -d bin/ com/sarangi/{customsongsearch,trackanalysis}/*.java
```
### Running the programs

Run from the `bin` directory with the classpath for the two jar files specified.

The `CustomSongListGenerator` outputs the json string to the standard output. (Redirecting to a file is recommended)

The `CustomSongListReader` expects the json filename to be supplied as a command line argument.

```
cd bin/
java -cp .:../jEN.jar:../gson-2.6.2.jar com.sarangi.customsongsearch.CustomSongListGenerator > output.json
java -cp .:../jEN.jar:../gson-2.6.2.jar com.sarangi.customsongsearch.CustomSongListReader output.json
```

The TrackAnalysis Program expects the filename to be supplied as a command line argument.

```
java -cp .:../jEN.jar:../gson-2.6.2.jar com.sarangi.trackanalysis.TrackAnalysisExample song.mp3
```

