package Test;
import com.gumuluo.diself.ElfHeader;
import com.gumuluo.diself.FileDispose;
import java.io.IOException;

public class ElfHeaderTest {
    public static void main(String args[]) {
        try {
            ElfHeader elfHeader = new ElfHeader(new FileDispose("C:\\Users\\liuya\\Desktop\\libGameMain.so"));
            System.out.print(elfHeader.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
