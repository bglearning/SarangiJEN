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

/**
 *
 * Represents the searcher of songs. 
 *
 * @author Bijay Gurung
 *
 */

public class CustomSongSearch {

    private EchoNestAPI en;

    /**
     *
     * Constructor for the class
     * 
     * @param key the String representing the API Key for Echonest
     *
     */

    public CustomSongSearch(final String key) throws EchoNestException {
        en = new EchoNestAPI(key);
        en.setTraceSends(false);
        en.setTraceRecvs(false);
    }

    /**
     *
     * Searches for songs by the given artist with the given title
     * 
     * @param title String representing the title of the song
     * @param artistName String representing the name of the artist of the song
     * @return Echonest Song object found. 
     *
     */

    public Song searchSongsByTitleArtist(String title, String artistName)
            throws EchoNestException {
        SongParams p = new SongParams();
        p.setArtist(artistName);
        p.setTitle(title);
        p.setResults(1);
        p.includeAudioSummary();
        List<Song> songs = en.searchSongs(p);
        if (songs.size() > 0) {

                // If multiple songs are found, only the first one is returned.
                return songs.get(0);
        } else {
                return null;
        }
    }

}
