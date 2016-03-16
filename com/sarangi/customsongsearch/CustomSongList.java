package com.sarangi.customsongsearch;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.ArtistParams;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.Params;
import com.echonest.api.v4.Song;
import com.echonest.api.v4.Track;
import com.echonest.api.v4.SongParams;

import java.util.List;
import java.util.ArrayList;

import com.sarangi.customsongsearch.CustomSong;

/**
 *
 * Collection of Custom Songs
 * 
 * @author Bijay Gurung
 *
 */

public class CustomSongList {

        public List<CustomSong> allSongs;

        public CustomSongList() {
            allSongs = new ArrayList<CustomSong>();
        }

        /**
         *
         * This method returns a CustomSong object built using a Song echonest object
         * 
         * @param echonestSong An echonest object
         * @return The corresponding CustomSong 
         *
         */

        public CustomSong generateCustomSong(Song echonestSong) throws EchoNestException {
                CustomSong customSong = new CustomSong();

                customSong.title = echonestSong.getTitle();
                customSong.artist = echonestSong.getArtistName();
                customSong.danceability = echonestSong.getDanceability();
                customSong.energy = echonestSong.getEnergy();
                customSong.tempo = echonestSong.getTempo();

                return customSong;
        }

        public List<CustomSong> getAllSongs() {
                return allSongs;
        }

        public void addSong(Song echonestSong) throws EchoNestException {
                CustomSong customSong = generateCustomSong(echonestSong);
                allSongs.add(customSong);
        }

        public void listSongs() {
                for (CustomSong customSong: allSongs) {
                        customSong.display();
                }
        }

     
}
