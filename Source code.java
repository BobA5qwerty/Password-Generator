package Main.java;

import org.apache.commons.lang3.RandomStringUtils;

import java.nio.file.Files;
import java.nio.file.Path;

public class PWD_GENERATOR{

    public void pwd() throws Exception {
        String home = System.getProperty("user.home");
        if (home == null) {
            home = System.getenv("HOME");
        }
        int f = 1;
        String pwd;
        Path dirs = Path.of(home + "\\Password Generator\\logs");
        Path flog = Path.of(home + "\\Password Generator\\logs\\flog");
        Path pwd_Path = Path.of(home + "\\Password Generator\\password" + f + ".txt");
        if (!Files.exists(dirs)) {
            Files.createDirectories(dirs);
        }
        if(!Files.exists(flog))
        {
            Files.createFile(flog);
            Files.writeString(flog, Integer.toString(f));
        }
        if(Files.exists(flog))
        {

            f = Integer.parseInt(Files.readString(flog));
        }



        pwd_Path = Path.of(home + "\\Password Generator\\password" + f + ".txt");

        Files.writeString(pwd_Path,
                RandomStringUtils.randomAlphabetic(3)
                     + RandomStringUtils.randomNumeric(3)
                     + RandomStringUtils.randomPrint(4));
        pwd = Files.readString(pwd_Path);
        System.out.println(pwd);
        System.out.println(System.getProperty("user.name") + ", нe забудьте переименовать файл " + pwd_Path + " в нужное имя!");
        f++;
        Files.writeString(flog,Integer.toString(f));
    }
}
