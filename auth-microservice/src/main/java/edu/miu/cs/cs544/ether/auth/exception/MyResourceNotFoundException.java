/**
 * 
 */
package edu.miu.cs.cs544.ether.auth.exception;

/**
 * @author Luigi Salvatore Galluzzi
 *
 */
public final class MyResourceNotFoundException extends RuntimeException
{
 private static final long serialVersionUID = 1L;

 public MyResourceNotFoundException(final String message)
 {
  super(message);
 }
}