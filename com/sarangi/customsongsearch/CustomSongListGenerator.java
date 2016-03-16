package com.sarangi.customsongsearch;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.ArtistParams;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.Params;
import com.echonest.api.v4.Song;
import com.echonest.api.v4.Track;
import com.echonest.api.v4.SongParams;

import com.google.gson.Gson;

import java.util.List;
import java.util.ArrayList;

import com.sarangi.customsongsearch.CustomSong;
import com.sarangi.customsongsearch.CustomSongList;
import com.sarangi.customsongsearch.CustomSongSearch;

/**
 *
 * This program makes use of the CustomSongSearch Class to 
 * search the data for the given songs and display the results
 * obtained as json.
 *
 * It uses the Echonest jEN java client and Google's GSON library.
 *
 * @author Bijay Gurung
 *
 */

public class CustomSongListGenerator {

        private static final String API_KEY = "NEFFTRKGOVG4J2JLD";

        public static void main(String[] args) throws EchoNestException {

                // The Song List/Collection
                CustomSongList csl = new CustomSongList();

                // The Searcher
                CustomSongSearch cs = new CustomSongSearch(API_KEY);

                // The Temporary Array of "candidate" songs
                CustomSong[] candidateSongs = new CustomSong[20];

                // Pop Songs
                candidateSongs[0] = new CustomSong("Thriller","Michael Jackson");
                candidateSongs[1] = new CustomSong("I want it that way","Backstreet Boys");
                candidateSongs[2] = new CustomSong("Billie Jean","Michael Jackson");
                candidateSongs[3] = new CustomSong("Poker Face","Lady Gaga");
                candidateSongs[4] = new CustomSong("Firework","Katy Perry");

                // Rock Songs
                candidateSongs[5] = new CustomSong("Smells Like Teen Spirit","Nirvana");
                candidateSongs[6] = new CustomSong("Hotel California","The Eagles");
                candidateSongs[7] = new CustomSong("Numb","Linkin Park");
                candidateSongs[8] = new CustomSong("Hey Jude","The Beatles");
                candidateSongs[9] = new CustomSong("Dream On","Aerosmith");

                // Hiphop Songs
                candidateSongs[10] = new CustomSong("Lose Yourself","Eminem");
                candidateSongs[11] = new CustomSong("Changes","2pac");
                candidateSongs[12] = new CustomSong("One Mic","Nas");
                candidateSongs[13] = new CustomSong("N.Y.State of Mind","Nas");
                candidateSongs[14] = new CustomSong("In Da Club","50 Cent");

                // Jazz Songs
                candidateSongs[15] = new CustomSong("Take Five","Dave Brubeck");
                candidateSongs[16] = new CustomSong("So What","Miles Davis");
                candidateSongs[17] = new CustomSong("Jazz Carnival","Azymuth");
                candidateSongs[18] = new CustomSong("Strange Fruit","Nina Simone");
                candidateSongs[19] = new CustomSong("My Favorite Things","Dave Brubeck");

                /* The EchoNest API only allows 20 requests per minute. Run this separately 
                candidateSongs[0] = new CustomSong("Ode to Joy","Beethoven");
                candidateSongs[1] = new CustomSong("Symphony 5","Beethoven");
                candidateSongs[2] = new CustomSong("Hallelujah Chorus","Handel");
                candidateSongs[3] = new CustomSong("William Tell Overture","Rossini");
                candidateSongs[4] = new CustomSong("Ride of the Valkyries","Richard Wagner");
                */

                for (CustomSong candidate: candidateSongs) {

                        Song echonestSong = cs.searchSongsByTitleArtist(candidate.title, candidate.artist);

                        if (echonestSong!=null ) {
                                csl.addSong(echonestSong);
                        }

                }

                // Output the song details as JSON

                Gson gson = new Gson();
                String json = gson.toJson(csl.getAllSongs());

                System.out.printf("%s",json);

        }

}
