package com.service.music_circle_backend.entities.playlist;

import com.service.music_circle_backend.entities.audio_file.AudioFile;
import com.service.music_circle_backend.entities.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class PlaylistUnitTest {
    @TestConfiguration
    static class AlbumTestConfig{
        @Bean
        public Playlist newPlaylist(){ return new Playlist("Test Playlist Name", getUser().getUsername()); }
        @Bean
        User getUser(){ return Mockito.mock(User.class); }
        @Bean
        AudioFile newAudioFile(){ return Mockito.mock(AudioFile.class); }
    }
    @Autowired
    private User creator;
    @Autowired
    private AudioFile song;
    @Autowired
    private Playlist playlist;

    @Test
    public void testPlaylist(){
        Mockito.when(creator.getUsername()).thenReturn("Test Artist Username");
        Mockito.when(song.getFilename()).thenReturn("Test/AudioFile/Filename");
        List<AudioFile> mockSongs = new ArrayList<AudioFile>();
        mockSongs.add(song);
        List<String> mockListeners = new ArrayList<String>();
        mockListeners.add(creator.getUsername());

        Assert.assertEquals("Test Playlist Name", playlist.getName());
        Assert.assertEquals("Test Artist Username", playlist.getcreatorUsername());
        Assert.assertEquals(1, playlist.getListeners().size());
        Assert.assertEquals(true, playlist.getSongs().isEmpty());
        playlist.setName("Test Playlist Name 2");
        Assert.assertEquals("Test Playlist Name 2", playlist.getName());
        User creator2 = Mockito.mock(User.class);
        playlist.setcreatorUsername(creator2.getUsername());
        Assert.assertEquals(false, (creator.getUsername() == playlist.getcreatorUsername()));
        Assert.assertEquals(creator2, playlist.getcreatorUsername());
        mockListeners.add(creator2.getUsername());
        playlist.setListeners(mockListeners);
        Assert.assertEquals(2, playlist.getListeners().size());
        AudioFile song2 = Mockito.mock(AudioFile.class);
        mockSongs.add(song2);
        playlist.setSongs(mockSongs);
        Assert.assertEquals(mockSongs, playlist.getSongs());
    }

}
