import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static utils.Utilities.writeFile;

public class gen4 
{
   
    public static void main(String []args)
    {
   
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
    cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program4", null, "java/lang/Object",null);
        
    MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        
        /**
         * Comparing two Ints
         */

        {
            mv.visitCode();
            mv.visitLdcInsn((int)10);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitLdcInsn((int)5);
            mv.visitVarInsn(Opcodes.ISTORE,3);
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,3);
            Label labelOne = new Label();
            Label labelTwo = new Label();

            mv.visitJumpInsn(Opcodes.IF_ICMPGE, labelOne);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitJumpInsn(Opcodes.GOTO, labelTwo);
            mv.visitLabel(labelOne);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitLabel(labelTwo);

            mv.visitVarInsn(Opcodes.ISTORE, 5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
             
        }
        /**
         * Comparing two Longs
         */
        {
            mv.visitCode();
            mv.visitLdcInsn((long)15);
            mv.visitVarInsn(Opcodes.LSTORE,1);
            mv.visitLdcInsn((long)30);
            mv.visitVarInsn(Opcodes.LSTORE,3);
            mv.visitVarInsn(Opcodes.LLOAD,1);
            mv.visitVarInsn(Opcodes.LLOAD,3);
            mv.visitInsn(Opcodes.LCMP);
            Label labelOne = new Label();
            Label labelTwo = new Label();

            mv.visitJumpInsn(Opcodes.IFGE, labelOne);
            mv.visitVarInsn(Opcodes.LLOAD, 3);
            mv.visitJumpInsn(Opcodes.GOTO, labelTwo);
            mv.visitLabel(labelOne);
            mv.visitVarInsn(Opcodes.LLOAD, 1);
            mv.visitLabel(labelTwo);

            mv.visitVarInsn(Opcodes.LSTORE, 5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            
        }
        /**
         * Comparing two Shorts
         */
        {
          
            mv.visitCode();
            mv.visitLdcInsn((short)100);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitLdcInsn((short)10);
            mv.visitVarInsn(Opcodes.ISTORE,3);
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,3);
            Label labelOne = new Label();
            Label labelTwo = new Label();

            mv.visitJumpInsn(Opcodes.IF_ICMPGE, labelOne);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitJumpInsn(Opcodes.GOTO, labelTwo);
            mv.visitLabel(labelOne);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitLabel(labelTwo);

            mv.visitVarInsn(Opcodes.ISTORE, 5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
             
            
        }

        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(3,3);
        mv.visitEnd();

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program4.class");
        
        System.out.println("Done!");
    }//end main 
}

