package br.com.devsource.rfid.bri;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

import org.apache.commons.lang3.mutable.MutableInt;

import com.intermec.datacollection.rfid.GPITrigger;

import br.com.devsource.rfid.api.gpio.GpioStatus;

/**
 * @author Guilherme Pacheco
 */
class GpiStates {

  private GpiStates() {
    super();
  }

  private static Map<Integer, BiPredicate<Integer, GpioStatus>> STATES;

  static {
    STATES = new HashMap<>();
    STATES.put(GPITrigger.GPILineStates.INPUT_1_LOW, build(1, GpioStatus.ON));
    STATES.put(GPITrigger.GPILineStates.INPUT_1_HIGH, build(1, GpioStatus.OFF));
    STATES.put(GPITrigger.GPILineStates.INPUT_2_LOW, build(2, GpioStatus.ON));
    STATES.put(GPITrigger.GPILineStates.INPUT_2_HIGH, build(2, GpioStatus.OFF));
    STATES.put(GPITrigger.GPILineStates.INPUT_3_LOW, build(3, GpioStatus.ON));
    STATES.put(GPITrigger.GPILineStates.INPUT_3_HIGH, build(3, GpioStatus.OFF));
    STATES.put(GPITrigger.GPILineStates.INPUT_4_LOW, build(4, GpioStatus.ON));
    STATES.put(GPITrigger.GPILineStates.INPUT_4_HIGH, build(4, GpioStatus.OFF));
  }

  private static BiPredicate<Integer, GpioStatus> build(int numero, GpioStatus status) {
    return (i, s) -> i == numero && status == s;
  }

  public static int lineState(int number, GpioStatus status) {
    MutableInt value = new MutableInt(0);
    STATES.entrySet().stream().filter(e -> e.getValue().test(number, status)).findFirst()
      .ifPresent(e -> value.setValue(e.getKey()));
    return value.getValue();
  }

}
