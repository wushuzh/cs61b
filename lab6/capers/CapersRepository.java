package capers;

import jdk.jshell.execution.Util;

import java.io.File;
import java.io.IOException;

import static capers.Utils.*;

/** A repository for Capers 
 * @author TODO
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = Utils.join(CWD, ".capers");

    static final File STORY_FILE = Utils.join(CAPERS_FOLDER, "story");

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        if (!Dog.DOG_FOLDER.exists() && !Dog.DOG_FOLDER.mkdirs()) {
            exitWithError("Failed to create folder: " + Dog.DOG_FOLDER);
        }

        if (!STORY_FILE.exists()) {
            try {
                STORY_FILE.createNewFile();
            } catch (IOException e) {
                exitWithError("Fail to create file: " + STORY_FILE);
            }
        }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        String storyContent = Utils.readContentsAsString(STORY_FILE);
        storyContent += text + "\n";
        System.out.println(storyContent);
        Utils.writeContents(STORY_FILE, storyContent);
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, String age) {
        Dog newDog = new Dog(name, breed, Integer.valueOf(age));
        newDog.saveDog();
        System.out.println(newDog);
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        Dog birthdayDog = Dog.fromFile(name);
        birthdayDog.haveBirthday();
        birthdayDog.saveDog();
    }
}
