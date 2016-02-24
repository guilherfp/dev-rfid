package br.com.devsource.rfid.api.module;

/**
 * @author Guilherme Pacheco
 */
public interface Antenna {

  int getNumber();

  int getTransmitPower();

  boolean isActive();

}
