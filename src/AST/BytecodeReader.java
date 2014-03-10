
package AST;
import java.util.HashSet;import java.util.LinkedHashSet;import java.io.File;import java.util.*;import beaver.*;import java.util.ArrayList;import java.util.zip.*;import java.io.*;import java.io.FileNotFoundException;import java.util.Collection;

public interface BytecodeReader {
    // Declared in ClassPath.jrag at line 16

    CompilationUnit read(InputStream is, String fullName, Program p) throws FileNotFoundException, IOException;

}
