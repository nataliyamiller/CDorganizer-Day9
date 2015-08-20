import java.time.LocalDateTime;
import java.util.ArrayList;

public class CDorganizer {
  private static ArrayList<CDorganizer> instances = new ArrayList<CDorganizer>();
  private String mTitle;
  private String mArtist;
  private int mId;


  public CDorganizer (String title, String artist) {
    mTitle = title;
    mArtist = artist;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public String getArtist() {
    return mArtist;
  }

  public boolean isEmpty() {
    return CDorganizer.all().size() == 0;
  }

  public static ArrayList<CDorganizer> all() {
    return instances;
  }

  public int getId() {
    return mId;
  }

  public static CDorganizer find(int id) {
    try {
      return instances.get(id-1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

    public static void clear() {
      instances.clear();
    }

}
