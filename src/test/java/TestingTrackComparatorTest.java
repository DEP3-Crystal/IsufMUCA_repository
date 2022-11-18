import models.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestingTrackComparatorTest {

    @Test
    void shouldReturn0AndBeEqualUsingNameComparator() {
        Track track1 = new Track("Alumina", 200, "path");
        Track track2 = new Track("Alumina", 200, "path");
        Assertions.assertEquals(0, track1.compareTo((Object) track2));
    }

    @Test
    void shouldReturnBiggerThan0UsingNameComparator() {
        Track track1 = new Track("Blob", 200, "path");
        Track track2 = new Track("Alumina", 200, "path");
        Assertions.assertTrue(track1.compareTo((Object) track2) > 0);
    }

    @Test
    void shouldReturnLessThan0UsingNameComparator() {
        Track track1 = new Track("Alumina", 190, "path");
        Track track2 = new Track("Blob", 200, "path");
        Assertions.assertTrue(track1.compareTo((Object) track2) < 0);
    }

    @Test
    void shouldReturn0AndBeEqualUsingLengthComparator() {
        Track track1 = new Track("Alumina", 200, "path");
        Track track2 = new Track("Alumina", 200, "path");
        Assertions.assertEquals(0, track1.compareTo(track2));
    }

    @Test
    void shouldReturnBiggerThan0UsingLengthComparator() {
        Track track1 = new Track("Alumina", 200, "path");
        Track track2 = new Track("Blob", 190, "path");
        Assertions.assertTrue(track1.compareTo(track2) > 0);
    }

    @Test
    void shouldReturnLessThan0UsingLengthComparator() {
        Track track1 = new Track("Blob", 190, "path");
        Track track2 = new Track("Alumina", 200, "path");
        Assertions.assertTrue(track1.compareTo(track2) < 0);
    }
}
