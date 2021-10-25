package com.apiwp.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class EncryptionUtils {
	  
	  private static final String ENCRYPT_TEMPLATE = "To encrypt: %s -> encrypted: %s";
	  private static final String ENV_NAME = "CUCUMBER_MASTER";
	protected EncryptionUtils() {
		super();
	}

  public static String decrypt(String target) {
    return stringEncryptor().decrypt(target);
  }

  private static String encrypt(String target) {
    return String.format(ENCRYPT_TEMPLATE, target, stringEncryptor().encrypt(target));
  }
  
  public static StringEncryptor stringEncryptor() {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
    config.setPasswordEnvName(ENV_NAME);
    config.setAlgorithm("PBEWITHSHA256AND256BITAES-CBC-BC");
    config.setKeyObtentionIterations("1000");
    config.setProvider(new BouncyCastleProvider());
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    config.setStringOutputType("base64");
    encryptor.setConfig(config);
    return encryptor;
  }

}
