package edu.miu.cs.cs544.ether.auth.security.jwt;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.stream.Stream;

import edu.miu.cs.cs544.ether.auth.exception.MyResourceNotFoundException;
import edu.miu.cs.cs544.ether.auth.exception.UnauthorizedRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTUtils implements Serializable
{

 private static final long serialVersionUID = 1905122041950251207L;

 @Value("${key.private.loc}")
 private String privateKeyLocation;

 @Value("${key.public.loc}")
 private String publicKeyLocation;

 private static String publicKeyBeing = "-----BEGIN PUBLIC KEY-----";
 private static String publicKeyEnd = "-----END PUBLIC KEY-----";

 private static String privateKeyBegin = "-----BEGIN PRIVATE KEY-----\n";
 private static String pivateKeyEnd = "-----END PRIVATE KEY-----";

 public PrivateKey getPrivateKey() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
 {
  PrivateKey privateKey = null;
  String privateKeyContent = readKeyFromFile(privateKeyLocation);
  System.out.println(privateKeyContent);
  privateKeyContent = privateKeyContent.replace(privateKeyBegin, "");
  privateKeyContent = privateKeyContent.replace(pivateKeyEnd, "").replaceAll("\\s", "");
  byte[] encoded = Base64.getDecoder().decode(privateKeyContent.getBytes(StandardCharsets.UTF_8));

  KeyFactory kf = KeyFactory.getInstance("RSA");

  EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
  privateKey = kf.generatePrivate(keySpec);

  return privateKey;
 }

 public PublicKey parseRSAPublicKey() throws GeneralSecurityException, IOException
 {
  String pemPublicKey = readKeyFromFile(publicKeyLocation);
  try {
   String publicKeyString = pemPublicKey.replace(publicKeyBeing, "").replace(publicKeyEnd, "").replaceAll("\\s", "");
   byte[] keyBytes = Base64.getDecoder().decode(publicKeyString.getBytes(StandardCharsets.UTF_8));
   X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
   KeyFactory keyFactory = KeyFactory.getInstance("RSA");

   return keyFactory.generatePublic(spec);
  } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
   throw new UnauthorizedRequestException(e.getMessage());
  }
 }

 public String readKeyFromFile(String fileName) throws IOException
 {

  StringBuilder contentBuilder = new StringBuilder();

  try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
   stream.forEach(s -> contentBuilder.append(s).append("\n"));
  } catch (IOException e) {
   throw new MyResourceNotFoundException("Key file/Certificate not Found :" + e.getMessage());
  }
  return contentBuilder.toString();
 }
}
