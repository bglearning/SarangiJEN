package com.sarangi.customsongsearch;

/**
 * 
 * The Custom Song Class representing a song.
 *
 * @author Bijay Gurung
 * 
 *
 */

public class CustomSong {

        public String title;
        public String artist;

        // A number that ranges from 0 to 1, representing how danceable 
        // The Echo Nest thinks this song is.
        public double danceability;

        // A number that ranges from 0 to 1, representing how energetic 
        // The Echo Nest thinks this song is.
        public double energy;

        public double tempo;

        public CustomSong() { 
        }

        public CustomSong(String title, String artist) {

                this.title = title;
                this.artist = artist;

        }

        public void display() {
            System.out.printf("%s\n", title);
            System.out.printf("   artist: %s\n", artist);
            System.out.printf("   Danceability   : %.3f\n", danceability);
            System.out.printf("   Energy   : %.3f\n", energy);
            System.out.printf("   Tempo   : %.3f\n", tempo);
        }
}
