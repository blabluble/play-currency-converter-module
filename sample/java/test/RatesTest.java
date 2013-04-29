package test;

import org.fest.assertions.Assertions;
import org.junit.Test;

import utils.Rates;

public class RatesTest {

  @Test
  public void should_return_zero_when_currency_code_is_not_valid() {
    Assertions.assertThat(Rates.convert(1.0, "brl", "some")).isEqualTo(0.0);
  }

  @Test
  public void returned_rates_should_be_transitive() {
    Double brl_usd = Rates.convert(1.0, "brl", "usd");
    Double usd_eur = Rates.convert(1.0, "usd", "eur");
    Double brl_eur = Rates.convert(1.0, "brl", "eur");

    Assertions.assertThat(Math.round(brl_usd * usd_eur * 100)).isEqualTo(Math.round(brl_eur * 100));
  }

  @Test
  public void returned_rates_should_be_simetric() {
    Double brl_usd = Rates.convert(1.0, "brl", "usd");
    Double usd_brl = Rates.convert(1.0, "usd", "brl");

    Assertions.assertThat(Math.round(brl_usd * 100)).isEqualTo(Math.round(100 / usd_brl));
  }

}