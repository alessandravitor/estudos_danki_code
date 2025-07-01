package br.com.estudos.dankicode.pizzariadankicode.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriptografiaSenha {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encode(String senha) {
        return encoder.encode(senha);
    }

}
