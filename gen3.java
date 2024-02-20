import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import static utils.Utilities.writeFile;

public class gen3 
{
   
    public static void main(String []args)
    {
   
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
    cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program3", null, "java/lang/Object",null);
        
    MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        
        /**
         * Division for Ints
         */

        {
            mv.visitCode();
            mv.visitLdcInsn((int)10);
            mv.visitVarInsn(Opcodes.ISTORE,1);
            mv.visitLdcInsn((int)5);
            mv.visitVarInsn(Opcodes.ISTORE,3);
            mv.visitVarInsn(Opcodes.ILOAD,1);
            mv.visitVarInsn(Opcodes.ILOAD,3);
            mv.visitInsn(Opcodes.IDIV);
            mv.visitVarInsn(Opcodes.ISTORE,5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
             
        }
        /**
         * Division for Longs
         */
        {
            mv.visitCode();
            mv.visitLdcInsn((long)20);
            mv.visitVarInsn(Opcodes.LSTORE,1);
            mv.visitLdcInsn((long)5);
            mv.visitVarInsn(Opcodes.LSTORE,3);
            mv.visitVarInsn(Opcodes.LLOAD,1);
            mv.visitVarInsn(Opcodes.LLOAD,3);
            mv.visitInsn(Opcodes.LDIV);
            mv.visitVarInsn(Opcodes.LSTORE,5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            
        }
        /**
         * Division for Doubles
         */
        {
            mv.visitCode();
            mv.visitLdcInsn((double)30.0);
            mv.visitVarInsn(Opcodes.DSTORE,1);
            mv.visitLdcInsn((double)5.0);
            mv.visitVarInsn(Opcodes.DSTORE,3);
            mv.visitVarInsn(Opcodes.DLOAD,1);
            mv.visitVarInsn(Opcodes.DLOAD,3);
            mv.visitInsn(Opcodes.DDIV);
            mv.visitVarInsn(Opcodes.DSTORE,5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
            
        }

        /**
         * Division for Floats
         */
        {
            mv.visitCode();
            mv.visitLdcInsn((float)40);
            mv.visitVarInsn(Opcodes.FSTORE,1);
            mv.visitLdcInsn((float)5);
            mv.visitVarInsn(Opcodes.FSTORE,3);
            mv.visitVarInsn(Opcodes.FLOAD,1);
            mv.visitVarInsn(Opcodes.FLOAD,3);
            mv.visitInsn(Opcodes.FDIV);
            mv.visitVarInsn(Opcodes.FSTORE,5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
            
        }

        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(3,3);
        mv.visitEnd();

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program3.class");
        
        System.out.println("Done!");
    }//end main 
}

