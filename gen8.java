import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static utils.Utilities.writeFile;

public class gen8 
{
   
    public static void main(String []args)
    {
   
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
    cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program8", null, "java/lang/Object",null);
        
    MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        /**
         * If, else statement
         */

        {
            mv.visitCode();

            mv.visitIntInsn(Opcodes.BIPUSH, 5);

            mv.visitIntInsn(Opcodes.BIPUSH, 10);

            Label elseLabel = new Label();
            Label endLabel = new Label();
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, elseLabel);

            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Condition is true");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitJumpInsn(Opcodes.GOTO, endLabel);
           

            
            mv.visitLabel(elseLabel);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Condition is false");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            mv.visitLabel(endLabel);


        }

        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(3,3);
        mv.visitEnd();

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program8.class");
        
        System.out.println("Done!");
    }//end main 
}

