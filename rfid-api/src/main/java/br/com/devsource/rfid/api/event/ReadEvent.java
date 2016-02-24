package br.com.devsource.rfid.api.event;

import org.apache.commons.lang3.Validate;

import br.com.devsource.rfid.api.ReaderConf;
import br.com.devsource.rfid.api.tag.Tag;

/**
 * @author Guilherme Pacheco
 */
public class ReadEvent {

  private final Tag tag;
  private final int antena;
  private final ReaderConf conf;

  public ReadEvent(Tag tag, ReaderConf conf, int antena) {
    Validate.notNull(conf);
    Validate.notNull(tag);
    this.conf = conf;
    this.antena = antena;
    this.tag = tag;
  }

  public ReaderConf getConf() {
    return conf;
  }

  public int getAntena() {
    return antena;
  }

  public Tag getTag() {
    return tag;
  }

  @Override
  public String toString() {
    return String.format("Reader: %s, antenna: %s, %s", configString(), antena, tag);
  }

  private String configString() {
    return String.format("%s:%s", conf.getHostname(), conf.getPort());
  }

}
