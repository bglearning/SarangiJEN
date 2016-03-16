package com.sarangi.customsongsearch;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.reflect.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Type;

import com.sarangi.customsongsearch.CustomSong;
import com.sarangi.customsongsearch.CustomSongList;

/**
 *
 * Reads the data for the CustomSong object from JSON files.
 *
 * Uses Google's GSON library.
 *
 * @author Bijay Gurung
 *
 */

public class CustomSongListReader {

        /**
         *
         * This methods reads in the song details from the given file.
         *
         * @param filename The name of the file to read the data from
         * @return List/Collection of CustomSong objects.
         *
         */

        public static List<CustomSong> readSongListFromFile(String filename) 
                throws FileNotFoundException, IOException {

                Gson gson = new Gson();
                JsonReader json = new JsonReader(new FileReader(filename));

                Type listType = new TypeToken<List<CustomSong>>(){}.getType();
                List<CustomSong> allSongs = gson.fromJson(json,listType);

                return allSongs;
        }

        /**
         *
         * The entry point for the FileReader.
         *
         * Expects the filename to be provided as a command line argument.
         * (Defaults to using "sarangi.json" as the filename.
         *
         * @param args Command line argument: arg[0] representing the filename
         *
         */

        public static void main(String[] args) throws FileNotFoundException, IOException {
                String filename = "sarangi.json";
                if (args.length == 1) {
                        filename = args[0];
                }

                List<CustomSong> allSongs = CustomSongListReader.readSongListFromFile(filename);

                for (CustomSong cs:allSongs) {
                        cs.display();
                }

        }

}
