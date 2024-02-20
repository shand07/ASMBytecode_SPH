import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;
import static utils.Utilities.writeFile;

public class gen7 
{
   
    public static void main(String []args)
    {
   
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
    cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program7", null, "java/lang/Object",null);
        
    MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        /*
         * While loop
         */

        {
           mv.visitCode();
           
           Label myLabel = new Label(); 
           mv.visitLabel(myLabel);

           mv.visitInsn(Opcodes.ICONST_1);

           mv.visitJumpInsn(Opcodes.IFNE, myLabel);

           mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
           mv.visitLdcInsn("Inside the loop");
           mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

           mv.visitJumpInsn(Opcodes.GOTO, myLabel);

        }

        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(3,3);
        mv.visitEnd();

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program7.class");
        
        System.out.println("Done!");
    }//end main 
}

