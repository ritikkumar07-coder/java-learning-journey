import java.util.*;
public class PlayListManager {
    public static void main(String[] args) {
        List<String> playList = new ArrayList<>();

        playList.add("Song 1");
        playList.add("Song 2");
        playList.add("Song 3");
        playList.add("Song 4");
        playList.add("Song 5");

        System.out.println("PlayList: " + playList);

        // insert at index
        playList.set(0, "Song 8");
        System.out.println("After set: " + playList);

        // first and last song
        playList.get(0);
        playList.get(playList.size()-1);
        
        System.out.println("First song: " + playList.get(0));
        System.out.println("Last song: " + playList.get(playList.size()-1));

        // shuffle
        Collections.shuffle(playList);
        System.out.println("After shuffle: " + playList);

        // reverse
        Collections.reverse(playList);
        System.out.println("After reverse: " + playList);

        // remove any song by name
        playList.remove("Song 8");
        System.out.println("After remove: " + playList);

    }
}
