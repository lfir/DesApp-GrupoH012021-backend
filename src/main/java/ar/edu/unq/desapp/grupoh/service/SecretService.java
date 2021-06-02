package ar.edu.unq.desapp.grupoh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.impl.TextCodec;

@Service
public class SecretService {
	@Autowired
	private Environment env;
	
	public byte[] getSecretBytes() {
        return TextCodec.BASE64.decode(env.getProperty("jwtsigningsecret"));
    }
}
