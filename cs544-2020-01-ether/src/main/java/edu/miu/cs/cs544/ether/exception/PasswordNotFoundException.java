/**
 * 
 */
package edu.miu.cs.cs544.ether.exception;

/**
 * @author Luigi Salvatore Galluzzi
 *
 */
public final class PasswordNotFoundException extends RuntimeException
{
 private static final long serialVersionUID = 1L;

 public PasswordNotFoundException(final String message)
 {
  super(message);
 }
}