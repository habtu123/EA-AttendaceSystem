/**
 * 
 */
package edu.miu.cs.cs544.ether.exception;

/**
 * @author Luigi Salvatore Galluzzi
 *
 */
public final class UnauthorizedRequestException extends RuntimeException
{
 private static final long serialVersionUID = 1L;

 public UnauthorizedRequestException(final String message)
 {
  super(message);
 }
}