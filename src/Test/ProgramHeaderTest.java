package Test;

import com.gumuluo.diself.ElfHeader;
import com.gumuluo.diself.ElfMacroDefinition;
import com.gumuluo.diself.FileDispose;
import com.gumuluo.diself.ProgramHeader;

import java.io.IOException;

public class ProgramHeaderTest {
    public static void main(String args[]) {
        ElfHeader ehdr = null;
        try {
            ehdr = new ElfHeader(new FileDispose("C:\\Users\\liuya\\Desktop\\libGameMain.so"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long offset = ehdr.getE_phoff();
        for (int i = 0; i < ehdr.getE_phnum(); i++) {
            try {
                System.out.print("count:"+i+"\n");
                ProgramHeader phdr = new ProgramHeader(new FileDispose("C:\\Users\\liuya\\Desktop\\libGameMain.so"),
                        offset + i * ehdr.getE_phentsize(),
                        ehdr.getE_ident()[(int) ElfMacroDefinition.EI_CLASS.getValue()] == ElfMacroDefinition.ELFCLASS32.getValue());
                System.out.print(phdr.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
