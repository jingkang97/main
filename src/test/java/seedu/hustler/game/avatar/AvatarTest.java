package seedu.hustler.game.avatar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *  Test class for Avatar, contains the unit testing for Avatar.
 */
public class AvatarTest {

    /**
     * Checks if the name change is functional.
     */
    @Test
    public void checkNameChangeTest() {
        Avatar testAvatar = new Avatar();
        testAvatar.setName("test");
        assertEquals("test", testAvatar.getName());
    }

    /**
     * Checks if each Avatar are considered equal.
     */
    @Test
    public void equals() {
        Avatar avatar1 = new Avatar();
        Avatar avatar2 = new Avatar();
        Avatar avatar3 = new Avatar();

        // Returns true if they are the same object.
        assertEquals(avatar1, avatar1);

        // Returns true if they have the same 
        assertEquals(avatar1.getName(), avatar2.getName());

        // Different name -> returns false
        avatar3.setName("test");
        assertNotEquals(avatar3.getName(), avatar1.getName());
    }

}
