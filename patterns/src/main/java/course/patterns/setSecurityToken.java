package course.patterns;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.common.io.BaseEncoding;



public class setSecurityToken {

    private static byte[] applyChallenge(byte[] encrypted, byte[] challenge) {
        byte[] strResult = null;
        byte[] KEY_CHALLENGE_SEPARATOR = "".getBytes();
        MessageDigest sha512;
        try {
            sha512 = MessageDigest.getInstance("SHA-512");
            ByteBuffer buffer = ByteBuffer.allocate(encrypted.length + challenge.length + KEY_CHALLENGE_SEPARATOR.length);
            buffer.put(encrypted);
            buffer.put(KEY_CHALLENGE_SEPARATOR);
            buffer.put(challenge);
            buffer.compact();
            strResult = sha512.digest(buffer.array());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return strResult;
    }

    public static String returnHashPin(String SPIN,String challenge){
        BaseEncoding BASE16 = BaseEncoding.base16();

        byte[] _challenge = BASE16.decode(challenge.toUpperCase());
        byte[] _SPIN = BASE16.decode(SPIN.toUpperCase());
        byte[] answer;
        answer = applyChallenge(_SPIN, _challenge);
        return BASE16.encode(answer).toUpperCase();
    }

    public static void main(String[] args) {
        String s = setSecurityToken.returnHashPin("1234", "123123");
        System.out.println("s = " + s);
    }
}